package com.comodin.basic.validation.constraints;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = ValidDateTimeFormat.Validator.class) //具体的实现
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@SuppressWarnings("unused")
public @interface ValidDateTimeFormat {
    //String DEFAULT_MESSAGE = "{com.comodin.basic.validation.constraints.ValidDateTimeFormat.message}";
    String DEFAULT_MESSAGE = "Invalid time or date format error. pattern: {pattern}.";

    String pattern() default "";

    String message() default DEFAULT_MESSAGE; //提示信息,可以写死,可以填写国际化的key

    //下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    class Validator implements ConstraintValidator<ValidDateTimeFormat, Object> {
        String pattern;

        @Override
        public void initialize(ValidDateTimeFormat constraintAnnotation) {
            pattern = constraintAnnotation.pattern();
        }


        @Override
        public boolean isValid(Object propertyValue, ConstraintValidatorContext constraintContext) {
            if (pattern == null || "".equals(pattern.trim()) || propertyValue == null || "".equals(propertyValue.toString())) {
                return true;
            }

            boolean isValid = false;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                sdf.setLenient(false);// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01

                if (Date.class.getTypeName().equals(propertyValue.getClass().getTypeName())) {
                    sdf.parse(sdf.format((Date) propertyValue));
                } else if (Long.class.getTypeName().equals(propertyValue.getClass().getTypeName())) {
                    sdf.parse(sdf.format(new Date(Long.valueOf(propertyValue.toString()))));
                } else if (String.class.getTypeName().equals(propertyValue.getClass().getTypeName())) {
                    sdf.parse(propertyValue.toString());
                }
                isValid = true;
            } catch (Exception e) {
                // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            }

            if (!isValid) {

                ConstraintValidatorContextImpl constraintValidatorContextImpl = (ConstraintValidatorContextImpl) constraintContext;
                Object message = constraintValidatorContextImpl.getConstraintDescriptor().getAttributes().get("message");
                if (ValidDateTimeFormat.DEFAULT_MESSAGE.equals(message.toString())) {
                    constraintContext.disableDefaultConstraintViolation();//禁用默认的message的值
                    constraintContext//重新添加错误提示语句
                            .buildConstraintViolationWithTemplate(ValidDateTimeFormat.DEFAULT_MESSAGE + " The current value: " + propertyValue)
                            .addConstraintViolation();
                }
            }
            return isValid;
        }
    }
}
