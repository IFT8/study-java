package com.comodin.basic.util;

import com.comodin.basic.exception.BusinessLogicException;
import com.comodin.basic.exception.ParameterException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("Duplicates")
public abstract class Assert {

    public static void isNotEquals(Object actual, Object expected, String message) {
        Assert.isNull(actual, " actual is null");
        Assert.isNull(expected, " expected is null");
        if (expected instanceof String) {
            if (!expected.toString().equals(actual.toString())) {
                throw new BusinessLogicException(message);
            }
        } else {
            if (!Objects.equals(expected, actual)) {
                throw new BusinessLogicException(message);
            }
        }
    }

    public static void isEquals(Object actual, Object expected, String message) {
        Assert.isNull(actual, " actual is null");
        Assert.isNull(expected, " expected is null");
        if (expected instanceof String) {
            if (expected.toString().equals(actual.toString())) {
                throw new BusinessLogicException(message);
            }
        } else {
            if (Objects.equals(expected, actual)) {
                throw new BusinessLogicException(message);
            }
        }
    }

    public static void isEmpty(String str, String message) {
        if (StringUtils.isEmpty(str)) {
            throw new ParameterException(message);
        }
    }

    public static void isNull(Object o, String message) {
        if (Objects.isNull(o)) {
            throw new ParameterException(message);
        }
    }

    public static void isEmpty(Object[] array, String message) {
        if ((array == null || array.length == 0)) {
            throw new ParameterException(message);
        }
    }


    public static void isEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ParameterException(message);
        }
    }

    public static void isEmpty(Map<?, ?> map, String message) {
        if (map == null || map.isEmpty()) {
            throw new ParameterException(message);
        }
    }

    public static void isNullElements(Object[] array, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new ParameterException(message);
                }
            }
        }
    }

}
