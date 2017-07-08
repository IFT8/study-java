package com.comodin.basic.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 按照字段对集合进行排序
 *
 * @author huangcanjia
 * @create 2017-04-01 10:41
 */
public class SortUtil<E> {

    /**
     * 对filedName字段进行排序
     * @param list
     * @param filedName         E对象里的字段名
     * @param reverseFlag      true:升序， false:降序
     */
    public static<E> void sortByFiledName(List<E> list, String filedName, boolean reverseFlag){

        String methodName = "get" + filedName.substring(0,1).toUpperCase()+filedName.substring(1,filedName.length());

        sortByMethodName(list,methodName,reverseFlag);

    }


    /**
     * 对指定的method进行排序
     * @param list
     * @param methodName
     * @param reverseFlag
     */
    public static<E> void sortByMethodName(List<E> list,String methodName,boolean reverseFlag){
        Collections.sort(list, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {

                int result = 0;//0表示相等，负数表示o2大，正数代表o1大

                try {
                    Method method1 = o1.getClass().getMethod(methodName, null);
                    Method method2 = o2.getClass().getMethod(methodName, null);
                    //通过字段拿到在o1,o2中的值
                    Object filedValue1 = method1.invoke(o1, null);
                    Object filedValue2 = method2.invoke(o2, null);

                    //接下来对两个值进行判断
                    if (filedValue1 instanceof String) {
                        result = filedValue1.toString().compareTo(filedValue2.toString());
                    }else if(filedValue1 instanceof Date){
                        result = compareLong(((Date) filedValue1).getTime(),((Date) filedValue2).getTime());
                    }else if(filedValue1 instanceof  Long){
                        result = compareLong((long)filedValue1,(long)filedValue2);
                    }else if(filedValue1 instanceof Integer){
                        result = (Integer)filedValue1 - (Integer)filedValue2;
                    }else{
                        //其他类型对象直接转换成string进行比较
                        result = filedValue1.toString().compareTo(filedValue2.toString());
                    }

                    return result;
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e ) {
                    throw new RuntimeException("sort list error!");
                }


            }
        });
    }


    private static int compareLong(long o1, long o2){
        long l = o1 - o2;
        if (l == 0) {
            return 0;
        }
        return  l > 0 ? 1 : -1;
    }

}
