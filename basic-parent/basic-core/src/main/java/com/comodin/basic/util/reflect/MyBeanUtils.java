package com.comodin.basic.util.reflect;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SuppressWarnings({"Duplicates", "unused", "Convert2Diamond"})
public class MyBeanUtils {
    private static Map<Class, MethodAccess> methodMap = new HashMap<Class, MethodAccess>();

    private static Map<String, Integer> methodIndexMap = new HashMap<String, Integer>();

    private static Map<Class, List<String>> fieldMap = new HashMap<Class, List<String>>();

    @SuppressWarnings("SpellCheckingInspection")
    public static void copyProperties(final Object dest, final Object orig) {
        MethodAccess descMethodAccess = methodMap.get(dest.getClass());
        if (descMethodAccess == null) {
            descMethodAccess = cache(dest);
        }
        MethodAccess origMethodAccess = methodMap.get(orig.getClass());
        if (origMethodAccess == null) {
            origMethodAccess = cache(orig);
        }

        List<String> fieldList = fieldMap.get(orig.getClass());
        for (String field : fieldList) {
            String getKey = orig.getClass().getName() + "." + "get" + field;
            String setKey = dest.getClass().getName() + "." + "set" + field;
            Integer setIndex = methodIndexMap.get(setKey);
            if (setIndex != null) {
                int getIndex = methodIndexMap.get(getKey);
                // 参数一需要反射的对象
                // 参数二class.getDeclaredMethods 对应方法的index
                // 参数对三象集合
                descMethodAccess.invoke(dest, setIndex, origMethodAccess.invoke(orig, getIndex));
            }
        }
    }

    public static void copyProperty(final Object bean, final String fieldName, final Object value) {
        MethodAccess beanMethodAccess = methodMap.get(bean.getClass());
        if (beanMethodAccess == null) {
            beanMethodAccess = cache(bean);
        }

        List<String> fieldList = fieldMap.get(bean.getClass());
        if (fieldList.contains(fieldName)) {
            String setKey = bean.getClass().getName() + "." + "set" + toUpperCaseFirstOne(fieldName);
            Integer setIndex = methodIndexMap.get(setKey);
            if (setIndex != null) {
                // 参数一需要反射的对象 // 参数二class.getDeclaredMethods 对应方法的index // 参数对三象集合
                beanMethodAccess.invoke(bean, setIndex, value);
            }
        }
    }

    // 单例模式
    private static MethodAccess cache(Object orig) {
        //noinspection SynchronizationOnGetClass
        synchronized (orig.getClass()) {
            MethodAccess methodAccess = MethodAccess.get(orig.getClass());
            Field[] fields = orig.getClass().getDeclaredFields();
            List<String> fieldList = new ArrayList<String>(fields.length);
            for (Field field : fields) {
                if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) { // 是否是私有的，是否是静态的
                    // 非公共私有变量
                    String fieldName = field.getName(); // 获取属性名称
                    String fieldGetMethodName = "get" + toUpperCaseFirstOne(fieldName);
                    String fieldSetMethodName = "set" + toUpperCaseFirstOne(fieldName);
                    int getIndex = methodAccess.getIndex(fieldGetMethodName); // 获取get方法的下标
                    int setIndex = methodAccess.getIndex(fieldSetMethodName); // 获取set方法的下标
                    methodIndexMap.put(orig.getClass().getName() + "." + fieldGetMethodName, getIndex); // 将类名get方法名，方法下标注册到map中
                    methodIndexMap.put(orig.getClass().getName() + "." + fieldSetMethodName, setIndex); // 将类名set方法名，方法下标注册到map中
                    fieldList.add(fieldName); // 将属性名称放入集合里
                }
            }
            fieldMap.put(orig.getClass(), fieldList); // 将类名，属性名称注册到map中
            methodMap.put(orig.getClass(), methodAccess);
            return methodAccess;
        }
    }


    //首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    //首字母转大写
    @SuppressWarnings("WeakerAccess")
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
