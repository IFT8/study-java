package com.comodin.basic.util.reflect;

import javax.persistence.Id;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class AnnotationUtil {


    public static String getBeanIdFieldName(Class<?> beanClazz) throws ClassNotFoundException {
        Field field = getField(Id.class, beanClazz);
        if (field != null) {
            return field.getName();
        }
        return "";
    }

    public static Class<?> getBeanIdFieldType(Class<?> beanClazz) throws ClassNotFoundException {
        Field field = getField(Id.class, beanClazz);
        if (field != null) {
            return field.getType();
        }
        return null;
    }

    public static Field getBeanIdField(Class<?> beanClazz) throws ClassNotFoundException {
        return getField(javax.persistence.Id.class, beanClazz);
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
