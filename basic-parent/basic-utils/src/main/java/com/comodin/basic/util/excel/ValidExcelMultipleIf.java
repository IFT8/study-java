package com.comodin.basic.util.excel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.annotation.ElementType.TYPE;

@Documented
@Constraint(validatedBy = ValidExcelMultipleIf.Validator.class) //具体的实现
@Target({TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface ValidExcelMultipleIf {

    //String DEFAULT_MESSAGE = "{com.comodin.basic.util.excel.ValidExcelMultipleIf.message}";
    String DEFAULT_MESSAGE = "The all data is empty or Not empty.";    //所有数据为空或不为空。

    String[] propertyNameArray() default {};

    String message() default DEFAULT_MESSAGE; //提示信息,可以写死,可以填写国际化的key

    /**
     * 出错，对外提供的错误代码
     *
     * @return //
     */
    String errorCode();

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @SuppressWarnings("Duplicates")
    class Validator implements ConstraintValidator<ValidExcelMultipleIf, Object> {
        private final Log log = LogFactory.getLog(this.getClass());
        String[] propertyNameArray;

        @Override
        public void initialize(ValidExcelMultipleIf constraintAnnotation) {
            propertyNameArray = constraintAnnotation.propertyNameArray();
        }

        @Override
        public boolean isValid(Object beanObject, ConstraintValidatorContext constraintContext) {
            if (beanObject == null) {
                return true;
            }
            boolean isValid = false;

            //遍历，注解【propertyNameArray】声明的校验属性字段，在当前实例化bean是的属性值；
            // 有数据且不为空，写入临时容器 mapPropertyNameToValueNotEmpty
            // 数据为空，写入临时容器 mapPropertyNameToValueIsEmpty
            // 若 mapPropertyNameToValueIsEmpty 和 mapPropertyNameToValueNotEmpty 都有数据，即代表所声明的校验属性字段
            Map<String, Object> mapPropertyNameToValueIsEmpty = new HashMap<>();
            Map<String, Object> mapPropertyNameToValueNotEmpty = new HashMap<>();
            for (String propertyName : propertyNameArray) {
                String propertyValue = null;
                try {
                    propertyValue = BeanUtils.getProperty(beanObject, propertyName);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    log.error(String.format("@interface ValidExcelMultipleIf implements class: Validator ==> Get bean property: %s value, exception", propertyName), e);
                }
                if (propertyValue == null || "".equals(propertyValue.trim())) {
                    mapPropertyNameToValueIsEmpty.put(propertyName, propertyValue);
                } else {
                    mapPropertyNameToValueNotEmpty.put(propertyName, propertyValue);
                }
            }
            //
            if (mapPropertyNameToValueIsEmpty.size() > 0 && mapPropertyNameToValueNotEmpty.size() > 0) {
                isValid = false;
            } else {
                if (mapPropertyNameToValueIsEmpty.size() == 0 && mapPropertyNameToValueNotEmpty.size() == propertyNameArray.length) {
                    isValid = true;
                } else if (mapPropertyNameToValueNotEmpty.size() == 0 && mapPropertyNameToValueIsEmpty.size() == propertyNameArray.length) {
                    isValid = true;
                }
            }


            if (!isValid) {
                Map<String, Object> mapAllPropertyNamePropertyValue = new HashMap<>();
                mapAllPropertyNamePropertyValue.putAll(mapPropertyNameToValueNotEmpty);
                mapAllPropertyNamePropertyValue.putAll(mapPropertyNameToValueIsEmpty);

                Map<String, Object> mapBeanPropertyToExcelTitle = new HashMap<>();
                mapAllPropertyNamePropertyValue.forEach((propertyName, propertyValueObj) -> {
                    try {
                        Field propertyDeclaredField = beanObject.getClass().getDeclaredField(propertyName);
                        if (propertyDeclaredField.isAnnotationPresent(ExcelResources.class)) {
                            String title = propertyDeclaredField.getAnnotation(ExcelResources.class).title();
                            mapBeanPropertyToExcelTitle.put(title, propertyValueObj);
                        }
                    } catch (NoSuchFieldException e) {
                        log.error(String.format("@interface ValidExcelMultipleIf implements class: Validator ==> Get bean property: %s @ExcelResources, exception", propertyName), e);
                    }
                });

                ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");

                if (ValidExcelMultipleIf.DEFAULT_MESSAGE.equals(message.toString())) {
                    String msg = ExcelUtils.getMessageByRowColumn(beanObject, mapBeanPropertyToExcelTitle.keySet(),
                            String.format("%s The current value: %s", ValidExcelMultipleIf.DEFAULT_MESSAGE, mapBeanPropertyToExcelTitle.toString()));
                    constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                    constraintContext//重新添加错误提示语句
                            .buildConstraintViolationWithTemplate(msg)
                            .addConstraintViolation();
                }
            }
            return isValid;
        }
    }
}