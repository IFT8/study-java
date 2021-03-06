package com.comodin.basic.util.excel;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = ValidExcelRepeat.Validator.class) //具体的实现
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface ValidExcelRepeat {

    String DEFAULT_MESSAGE = "{com.comodin.basic.util.excel.ValidExcelRepeat.message}";
    //不能含有重复数据
    String NOT_REPEAT_DEFAULT_MESSAGE = "Can not contain duplicate data.";
    //数据重复次数不能大于3次
    String ALLOW_REPEAT_NUMBER_DEFAULT_MESSAGE = "The number of data repetitions can not be greater than {allowRepeatNumber} times.";
    String ALLOW_ONLY_ONE_DEFAULT_MESSAGE = "Only one data is allowed.";

    /**
     * 需要配置，唯一标识；目前因技术有限，无法获取对应的Bean字段名，来区别。
     *
     * @return //
     */
    String uniqueKey();

    /**
     * 默认为:false，即代表Excel列中的数据，数据不能有重复；空Null也似为一种；若要忽略Null值，即ignoreEmpty 设置为:true
     * 设置为:true， 即代表Excel列中的数据，数据可以重复；
     * 设置为:true， 即代表Excel列中的数据，数据可以重复；若配置了：allowRepeatNumber =3，即代表每种数据最多允许出现3次。
     * 设置为:true， 即代表Excel列中的数据，数据可以重复；若配置了：onlyOne = true，即代表该列的数据，只能有一种数据，不能出现多种。
     *
     * @return //
     */
    boolean repeat() default false;

    /**
     * 默认为:0，即代表数据在该列在最大出现次数。【注意：只有配置repeat为：true，才能有效果，只有为正整数，设置为负数，即直接过滤掉】
     *
     * @return //
     */
    int allowRepeatNumber() default 0;

    /**
     * 只能一种数据
     * 默认为：false，不对，即代表Excel列中的数据，进行检查，是否唯一
     * 设置为：true，需要与repeat=true进行配合使用，且会忽略 allowRepeatNumber 配置。
     *
     * @return //
     */
    boolean onlyOne() default false;

    /**
     * 是否忽略Null，默认为:false，即代表Null也会计算，是否重复。
     *
     * @return //
     */
    boolean ignoreEmpty() default false;

    /**
     * 提示信息,可以写死,可以填写国际化的key
     *
     * @return //
     */
    String message() default NOT_REPEAT_DEFAULT_MESSAGE;

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @SuppressWarnings({"Duplicates", "WeakerAccess"})
    class Validator implements ConstraintValidator<ValidExcelRepeat, Object> {
        public static ThreadLocal<Map<String, Set<Object>>> notRepeatSetContainer = new ThreadLocal<>();
        public static ThreadLocal<Map<String, Set<Object>>> onlyOneSetContainer = new ThreadLocal<>();
        public static ThreadLocal<Map<String, Map<Object, Integer>>> allowRepeatNumberMapContainer = new ThreadLocal<>();

        String uniqueKey;
        boolean repeat;
        int allowRepeatNumber;
        boolean ignoreEmpty;
        boolean onlyOne;

        public static void clear() {
            notRepeatSetContainer.remove();
            onlyOneSetContainer.remove();
            allowRepeatNumberMapContainer.remove();
        }

        @Override
        public void initialize(ValidExcelRepeat constraintAnnotation) {
            uniqueKey = constraintAnnotation.uniqueKey();
            repeat = constraintAnnotation.repeat();
            allowRepeatNumber = constraintAnnotation.allowRepeatNumber();
            ignoreEmpty = constraintAnnotation.ignoreEmpty();
            onlyOne = constraintAnnotation.onlyOne();
        }

        @Override
        public boolean isValid(Object propertyValue, ConstraintValidatorContext constraintContext) {
            //repeat=true   且 allowRepeatNumber=0 或者 allowRepeatNumber<1 直接路过
            //repeat=true   且 allowRepeatNumber=3 即使用Map<property,Map<propertyValue,num>>
            //repeat=false  即使用Map<property,Set<Object>>
            if (repeat && !onlyOne && allowRepeatNumber == 0) return true;
            if (repeat && !onlyOne && allowRepeatNumber < 0) return true;
            if (ignoreEmpty && propertyValue == null) return true;

            if (!repeat) {

                if (notRepeatSetContainer == null || notRepeatSetContainer.get() == null) {
                    notRepeatSetContainer.set(new HashMap<>());
                }

                Set<Object> objects = notRepeatSetContainer.get().computeIfAbsent(uniqueKey, k -> new HashSet<>());
                if (!objects.contains(propertyValue)) {
                    notRepeatSetContainer.get().get(uniqueKey).add(propertyValue);
                    return true;
                } else {
                    ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                    Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                    if (ValidExcelRepeat.NOT_REPEAT_DEFAULT_MESSAGE.equals(message.toString())) {
                        constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                        constraintContext//重新添加错误提示语句
                                .buildConstraintViolationWithTemplate(String.format("%s The current value: %s", ValidExcelRepeat.NOT_REPEAT_DEFAULT_MESSAGE, (propertyValue != null ? propertyValue.toString() : null)))
                                .addConstraintViolation();
                    }
                    notRepeatSetContainer.remove();
                    return false;
                }
            } else {
                if (onlyOne) {//只能一种数据
                    if (onlyOneSetContainer == null || onlyOneSetContainer.get() == null) {
                        onlyOneSetContainer.set(new HashMap<>());
                    }

                    Set<Object> objects = onlyOneSetContainer.get().computeIfAbsent(uniqueKey, k -> new HashSet<>());
                    if (objects.isEmpty()) {
                        onlyOneSetContainer.get().get(uniqueKey).add(propertyValue);
                        return true;
                    } else if (objects.contains(propertyValue)) {
                        return true;
                    } else {
                        ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                        Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                        if (ValidExcelRepeat.ALLOW_REPEAT_NUMBER_DEFAULT_MESSAGE.equals(message.toString()) || ValidExcelRepeat.NOT_REPEAT_DEFAULT_MESSAGE.equals(message.toString())
                                || ValidExcelRepeat.ALLOW_ONLY_ONE_DEFAULT_MESSAGE.equals(message.toString())) {
                            constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                            constraintContext//重新添加错误提示语句
                                    .buildConstraintViolationWithTemplate(String.format("%s Already existing data: %s, The current value: %s", ValidExcelRepeat.ALLOW_ONLY_ONE_DEFAULT_MESSAGE, objects.toString(), (propertyValue != null ? propertyValue.toString() : null)))
                                    .addConstraintViolation();
                        }
                        onlyOneSetContainer.remove();
                        return false;
                    }
                } else {
                    if (allowRepeatNumberMapContainer == null || allowRepeatNumberMapContainer.get() == null) {
                        allowRepeatNumberMapContainer.set(new HashMap<>());
                    }

                    Map<Object, Integer> objectIntegerMap = allowRepeatNumberMapContainer.get().computeIfAbsent(uniqueKey, k -> new HashMap<>());

                    if (objectIntegerMap.isEmpty()) {
                        objectIntegerMap.put(propertyValue, 1);
                        allowRepeatNumberMapContainer.get().put(uniqueKey, objectIntegerMap);
                        return true;
                    } else {
                        Integer cumulativeNumberTimes = objectIntegerMap.get(propertyValue);
                        cumulativeNumberTimes = ++cumulativeNumberTimes;
                        if (cumulativeNumberTimes > allowRepeatNumber) {

                            ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                            Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                            if (ValidExcelRepeat.ALLOW_REPEAT_NUMBER_DEFAULT_MESSAGE.equals(message.toString()) || ValidExcelRepeat.NOT_REPEAT_DEFAULT_MESSAGE.equals(message.toString())) {
                                constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                                constraintContext//重新添加错误提示语句
                                        .buildConstraintViolationWithTemplate(String.format("%s The current value: %s", ValidExcelRepeat.ALLOW_REPEAT_NUMBER_DEFAULT_MESSAGE, (propertyValue != null ? propertyValue.toString() : null)))
                                        .addConstraintViolation();
                            }
                            allowRepeatNumberMapContainer.remove();
                            return false;
                        } else {
                            objectIntegerMap.put(propertyValue, cumulativeNumberTimes);
                            return true;
                        }
                    }
                }
            }
        }
    }
}