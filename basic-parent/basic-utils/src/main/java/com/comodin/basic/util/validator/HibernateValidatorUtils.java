package com.comodin.basic.util.validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unused", "Duplicates"})
public class HibernateValidatorUtils {
    private static Validator validator;
    private static HibernateValidatorUtils instance = new HibernateValidatorUtils();

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private HibernateValidatorUtils() {
    }

    public static HibernateValidatorUtils getInstance() {
        return instance;
    }

    /**
     * 返回，指定属性，校验注解列表，所返回消息
     *
     * @param beanType     bean class
     * @param propertyName bean class,对应的属性
     * @param value        bean class,对应的属性，待写入的数据
     * @param groups       //支持按组进行校验
     * @param <T>          //支持按组进行校验
     *
     * @return 返回，指定属性，校验注解列表，所返回消息 Map[violationAnnotationSimpleName,message]
     */
    public <T> Map<String, String> validateValue(final Class<T> beanType, final String propertyName, final Object value, final Class<?>... groups) {
        Map<String, String> result = new HashMap<>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validateValue(beanType, propertyName, value, groups);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                result.put(constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(), constraintViolation.getMessage());
            }
        }
        return result;
    }

    /**
     * 返回，指定属性，校验注解列表，所返回消息
     *
     * @param object       bean的实例化对象
     * @param propertyName 对应的属性
     * @param groups       //支持按组进行校验
     * @param <T>          //支持按组进行校验
     *
     * @return 返回，指定属性，校验注解列表，所返回消息 Map[violationAnnotationSimpleName,message]
     */
    public <T> Map<String, String> validateProperty(final T object, final String propertyName, final Class<?>... groups) {
        Map<String, String> result = new HashMap<>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validateProperty(object, propertyName, groups);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                result.put(constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(), constraintViolation.getMessage());
            }
        }
        return result;
    }

    /**
     * 返回，指定多个属性，校验注解列表，所返回消息
     *
     * @param object          bean的实例化对象
     * @param propertyNameSet 对应的属性
     * @param groups          //支持按组进行校验
     * @param <T>             //支持按组进行校验
     *
     * @return 返回，指定多个属性，校验注解列表，所返回消息 Map[propertyName,[violationAnnotationSimpleName,message]]
     */
    public <T> Map<String, Map<String, String>> validatePropertys(final T object, final Set<String> propertyNameSet, final Class<?>... groups) {
        Map<String, Map<String, String>> result = new HashMap<>();
        propertyNameSet.forEach(propertyName -> {
            Map<String, String> mapValidateProperty = validateProperty(object, propertyName, groups);
            if (!mapValidateProperty.isEmpty()) {
                result.put(propertyName, mapValidateProperty);
            }
        });
        return result;
    }

    /**
     * 返回，整个bean，校验注解列表，所返回消息
     *
     * @param object bean的实例化对象
     * @param groups //支持按组进行校验
     * @param <T>    //支持按组进行校验
     *
     * @return 返回，整个bean，校验注解列表，所返回消息 Map[propertyName,Map[violationAnnotationSimpleName,message]]
     */
    public <T> Map<String, Map<String, String>> validateBean(final T object, final Class<?>... groups) {
        Map<String, Map<String, String>> result = new HashMap<>();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                String propertyName = constraintViolation.getPropertyPath().toString();
                if (!result.containsKey(propertyName)) {
                    result.put(propertyName, new HashMap<>());
                }
                result.get(propertyName).put(constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(), constraintViolation.getMessage());
            }
        }
        return result;
    }
}