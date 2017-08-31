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
@Constraint(validatedBy = ValidLength.Validator.class) //具体的实现
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface ValidLength {
    //String DEFAULT_MESSAGE = "{com.comodin.basic.validation.constraints.ValidLength.message}";
    String DEFAULT_MESSAGE = "data length must be between {min} and {max} bit.";

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default DEFAULT_MESSAGE; //提示信息,可以写死,可以填写国际化的key

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @SuppressWarnings("Duplicates")
    class Validator implements ConstraintValidator<ValidLength, Object> {
        int min;
        int max;

        @Override
        public void initialize(ValidLength constraintAnnotation) {
            this.min = constraintAnnotation.min();
            this.max = constraintAnnotation.max();
        }


        @Override
        public boolean isValid(Object propertyValue, ConstraintValidatorContext constraintContext) {
            boolean isValid = false;

            if (propertyValue == null && min == 0) {
                isValid = true;
            } else {
                if (propertyValue != null && propertyValue.toString().trim().length() >= min && propertyValue.toString().trim().length() <= max) {
                    isValid = true;
                }
            }

            if (!isValid) {

                ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                if (ValidLength.DEFAULT_MESSAGE.equals(message.toString())) {
                    constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                    constraintContext//重新添加错误提示语句
                            .buildConstraintViolationWithTemplate(String.format("%s The current value: %s", ValidLength.DEFAULT_MESSAGE, (propertyValue != null ? propertyValue.toString() : null)))
                            .addConstraintViolation();
                }
            }
            return isValid;
        }
    }
}
