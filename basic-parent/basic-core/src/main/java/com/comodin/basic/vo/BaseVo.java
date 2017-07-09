package com.comodin.basic.vo;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@SuppressWarnings("unused")
public class BaseVo<T extends Serializable> {
    //通用，
    private Integer draw;
    private Integer start;//通用，从第多少条开始
    private Integer length;//通用，取多少条

    private String orderColumn;//通用，排序的字段
    private String orderDir;//通用，排序的方式，只能为：ASC DESC

    private String complexSearch;                   //通用，复合条件查询

    private String searchDateTimeStr;               //通用，搜索日期，单日期【格式：yyyy-MM-dd】
    private Long searchDateTimestamp;
    private String searchDateTimeStartStr;          //通用，搜索日期，双日期的，开始时间【格式：yyyy-MM-dd HH:mm:ss】
    private Long searchDateTimestampStart;          //通用，搜索日期，双日期的，结束时间【格式：yyyy-MM-dd HH:mm:ss】
    private String searchDateTimeEndStr;
    private Long searchDateTimestampEnd;

    private T bean;

    public Integer getDraw() {
        return draw;
    }

    public BaseVo setDraw(Integer draw) {
        this.draw = draw;
        return this;
    }

    public Integer getStart() {
        return start;
    }

    public BaseVo setStart(Integer start) {
        this.start = start;
        return this;
    }

    public Integer getLength() {
        return length;
    }

    public BaseVo setLength(Integer length) {
        this.length = length;
        return this;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public BaseVo setOrderColumn(String orderColumn) {
        this.orderColumn = (orderColumn == null) ? null : orderColumn.trim();
        return this;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public BaseVo setOrderDir(String orderDir) {
        this.orderDir = (orderDir == null) ? null : orderDir.trim();
        return this;
    }

    public String getComplexSearch() {
        return complexSearch;
    }

    public BaseVo setComplexSearch(String complexSearch) {
        this.complexSearch = (complexSearch == null) ? null : complexSearch.trim();
        return this;
    }

    public String getSearchDateTimeStr() {
        return searchDateTimeStr;
    }

    public BaseVo setSearchDateTimeStr(String searchDateTimeStr) {
        this.searchDateTimeStr = (searchDateTimeStr == null) ? null : searchDateTimeStr.trim();
        return this;
    }

    public Long getSearchDateTimestamp() {
        return searchDateTimestamp;
    }

    public BaseVo setSearchDateTimestamp(Long searchDateTimestamp) {
        this.searchDateTimestamp = searchDateTimestamp;
        return this;
    }

    public String getSearchDateTimeStartStr() {
        return searchDateTimeStartStr;
    }

    public BaseVo setSearchDateTimeStartStr(String searchDateTimeStartStr) {
        this.searchDateTimeStartStr = (searchDateTimeStartStr == null) ? null : searchDateTimeStartStr.trim();
        return this;
    }

    public Long getSearchDateTimestampStart() {
        return searchDateTimestampStart;
    }

    public BaseVo setSearchDateTimestampStart(Long searchDateTimestampStart) {
        this.searchDateTimestampStart = searchDateTimestampStart;
        return this;
    }

    public String getSearchDateTimeEndStr() {
        return searchDateTimeEndStr;
    }

    public BaseVo setSearchDateTimeEndStr(String searchDateTimeEndStr) {
        this.searchDateTimeEndStr = (searchDateTimeEndStr == null) ? null : searchDateTimeEndStr.trim();
        return this;
    }

    public Long getSearchDateTimestampEnd() {
        return searchDateTimestampEnd;
    }

    public BaseVo setSearchDateTimestampEnd(Long searchDateTimestampEnd) {
        this.searchDateTimestampEnd = searchDateTimestampEnd;
        return this;
    }

    public T getBean() {
        return bean;
    }

    public BaseVo setBean(T bean) {
        this.bean = bean;
        return this;
    }

    /**
     * Java中没法得到泛型参数化类型，因为在编译期没法确定泛型参数化类型，也就找不到对应的类字节码文件，自然就不行了
     * 泛型反射的关键是获取 ParamType ，再调用它的getActualTypeArguments()方法获得实际绑定的类型。
     * 但注意public class BookManager<Book>是不能被反射的，因为擦拭法的缘故。
     * 只有在Superclass 或者成员变量(Field.getGenericType())等有函数返回 ParamType 的时候才能成功反射，
     *
     * @return //
     */
    @SuppressWarnings("unchecked")
    private Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}