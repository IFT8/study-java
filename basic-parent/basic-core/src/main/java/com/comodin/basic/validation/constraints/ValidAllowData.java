package com.comodin.basic.validation.constraints;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = ValidAllowData.Validator.class) //具体的实现
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface ValidAllowData {

    //String DEFAULT_MESSAGE = "{com.comodin.basic.validation.constraints.ValidAllowData.message}";
    String DEFAULT_MESSAGE = "Only as follows {allowDataArray}.";

    String[] allowDataArray();

    boolean allowBlank() default false;

    String message() default DEFAULT_MESSAGE; //提示信息,可以写死,可以填写国际化的key

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    class Validator implements ConstraintValidator<ValidAllowData, Object> {
        boolean allowBlank;
        String[] allowDataArray;

        @Override
        public void initialize(ValidAllowData constraintAnnotation) {
            allowBlank = constraintAnnotation.allowBlank();
            allowDataArray = constraintAnnotation.allowDataArray();
        }

        @Override
        public boolean isValid(Object propertyValue, ConstraintValidatorContext constraintContext) {
            if (allowBlank && (propertyValue == null || "".equals(propertyValue))) {
                return true;
            }

            boolean isValid = false;
            for (String allowData : allowDataArray) {
                if (allowData.equals(propertyValue)) {
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {

                ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                if (ValidAllowData.DEFAULT_MESSAGE.equals(message.toString())) {
                    constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                    constraintContext//重新添加错误提示语句
                            .buildConstraintViolationWithTemplate(String.format("%s The current value: %s", ValidAllowData.DEFAULT_MESSAGE, propertyValue))
                            .addConstraintViolation();
                }
            }
            return isValid;
        }
    }
}
