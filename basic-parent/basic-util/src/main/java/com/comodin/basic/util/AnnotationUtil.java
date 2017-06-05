package com.comodin.basic.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationUtil {


    public static String getBeanPrimarykeyFieldName(Class<?> beanClazz) throws ClassNotFoundException {
        Field field = getBeanPrimarykeyField(beanClazz);
        if (field != null) {
            return field.getName();
        }
        return "";
    }

    public static Class<?> getBeanPrimarykeyFieldType(Class<?> beanClazz) throws ClassNotFoundException {
        Field field = getBeanPrimarykeyField(beanClazz);
        if (field != null) {
            return field.getType();
        }
        return null;
    }

    public static Field getBeanPrimarykeyField(Class<?> beanClazz) throws ClassNotFoundException {
        return getField("javax.persistence.Id", beanClazz);
    }

    public static Field getField(String annotationTypeNameStr, Class<?> beanClazz) throws ClassNotFoundException {
        for (Field field : Class.forName(beanClazz.getName()).getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotationTypeNameStr.equals(annotation.annotationType().getName())) {
                    return field;
                }
            }
        }
        return null;
    }

    public static Field getField(Class<? extends Annotation> annotationClazz, Class<?> beanClazz) throws ClassNotFoundException {
        for (Field field : Class.forName(beanClazz.getName()).getDeclaredFields()) {
            if (field.isAnnotationPresent(annotationClazz)) {
                return field;
            }
        }
        return null;
    }
}
