package com.comodin.basic.validation.constraints;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = ValidNumber.Validator.class) //具体的实现
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface ValidNumber {
    String DEFAULT_MESSAGE = "{com.comodin.basic.validation.constraints.ValidNumber.message}";
    //"":整数 "0+":非负整数 "+":正整数 "-0":非正整数 "-":负整数
    String TYPE_INTEGER = "";
    String INTEGER_DEFAULT_MESSAGE = "Can only be an integer.";
    String TYPE_NON_NEGATIVE_INTEGER = "0+";
    String NON_NEGATIVE_INTEGER_DEFAULT_MESSAGE = "Can only be a non-negative integer.";
    String TYPE_POSITIVE_INTEGERS = "+";
    String POSITIVE_INTEGERS_DEFAULT_MESSAGE = "Only for positive integers.";
    String TYPE_NON_POSITIVE_INTEGERS = "-0";
    String NON_POSITIVE_INTEGERS_DEFAULT_MESSAGE = "Only for non-positive integers.";
    String TYPE_NEGATIVE_INTEGER = "-";
    String NEGATIVE_INTEGER_DEFAULT_MESSAGE = "Can only be a negative integer.";

    /**
     * "":整数 "0+":非负整数 "+":正整数 "-0":非正整数 "-":负整数
     *
     * @return //
     */
    String type() default "";

    String message() default DEFAULT_MESSAGE; //提示信息,可以写死,可以填写国际化的key

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @SuppressWarnings("Duplicates")
    class Validator implements ConstraintValidator<ValidNumber, Object> {

        private static final Map<String, String> typeToMessageMapContainer = new HashMap<>();

        static {
            typeToMessageMapContainer.put(TYPE_INTEGER, INTEGER_DEFAULT_MESSAGE);
            typeToMessageMapContainer.put(TYPE_NON_NEGATIVE_INTEGER, NON_NEGATIVE_INTEGER_DEFAULT_MESSAGE);
            typeToMessageMapContainer.put(TYPE_POSITIVE_INTEGERS, POSITIVE_INTEGERS_DEFAULT_MESSAGE);
            typeToMessageMapContainer.put(TYPE_NON_POSITIVE_INTEGERS, NON_POSITIVE_INTEGERS_DEFAULT_MESSAGE);
            typeToMessageMapContainer.put(TYPE_NEGATIVE_INTEGER, NEGATIVE_INTEGER_DEFAULT_MESSAGE);
        }

        String type;

        @Override
        public void initialize(ValidNumber constraintAnnotation) {
            if (!typeToMessageMapContainer.containsKey(constraintAnnotation.type())) {
                throw new RuntimeException(String.format("type value error, Only as follows: %s", typeToMessageMapContainer.keySet().toString()));
            }
            this.type = constraintAnnotation.type();
        }

        @Override
        public boolean isValid(Object propertyValue, ConstraintValidatorContext constraintContext) {
            if (propertyValue == null || "".equals(propertyValue.toString().trim())) {
                return true;
            }

            boolean isValid = validNumber(String.valueOf(propertyValue), type);
            if (!isValid) {
                ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                if (ValidNumber.DEFAULT_MESSAGE.equals(message.toString())) {
                    constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                    constraintContext//重新添加错误提示语句
                            .buildConstraintViolationWithTemplate(String.format("%s The current value: %s", typeToMessageMapContainer.get(type), propertyValue.toString()))
                            .addConstraintViolation();
                }
            }
            return isValid;
        }

        /**
         * 检查整数
         *
         * @param num  //
         * @param type "":整数 "0+":非负整数 "+":正整数 "-0":非正整数 "-":负整数
         *
         * @return //
         */
        @SuppressWarnings("Duplicates")
        private static boolean validNumber(String num, String type) {
            if (num == null || "".equals(num)) {
                return false;
            }
            String eL = "^-?\\d+$";//整数;
            if (Objects.equals("0+", type)) {
                eL = "^\\d+$";//非负整数
            } else if (Objects.equals("+", type)) {
                eL = "^\\d*[1-9]\\d*$";//正整数
            } else if (Objects.equals("-0", type)) {
                eL = "^((-\\d+)|(0+))$";//非正整数
            } else if (Objects.equals("-", type)) {
                eL = "^-\\d*[1-9]\\d*$";//负整数
            }
            Pattern p = Pattern.compile(eL);
            Matcher m = p.matcher(num);
            return m.matches();
        }
    }
}
