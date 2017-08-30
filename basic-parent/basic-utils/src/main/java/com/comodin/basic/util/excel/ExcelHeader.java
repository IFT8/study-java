package com.comodin.basic.util.excel;

/**
 * 用来存储Excel标题的对象，通过该对象可以获取标题和方法的对应关系
 *
 * @author Administrator
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ExcelHeader implements Comparable<ExcelHeader> {
    /**
     * 属性对应excel标题名称，无默认值，此参数必需设置。
     */
    private String title;

    /**
     * 在excel的顺序，默认为：-1，即代表对顺序没有限定
     */
    private int order;

    /**
     * 出错，对外提供的错误代码
     */
    private String errorCode;

    /**
     * 若是日期或时间类型，可提供单独的格式入口
     */
    private String pattern;

    /**
     * 说对应方法名称
     */
    private String propertyName;
    private Class<?> propertyType;
    private String propertyTypeName;

    private Class<?>[] validGroups;

    public ExcelHeader(String title, int order, String errorCode, String pattern, String propertyName, Class<?> propertyType, String propertyTypeName, Class<?>[] validGroups) {
        this.title = title;
        this.order = order;
        this.errorCode = errorCode;
        this.pattern = pattern;
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.propertyTypeName = propertyTypeName;
        this.validGroups = validGroups;
    }

    @SuppressWarnings("NullableProblems")
    public int compareTo(ExcelHeader o) {
        return order > o.order ? 1 : (order < o.order ? -1 : 0);
    }

    public String getTitle() {
        return (title == null) ? null : title.trim();
    }

    public ExcelHeader setTitle(String title) {
        this.title = (title == null) ? null : title.trim();
        return this;
    }

    public int getOrder() {
        return order;
    }

    public ExcelHeader setOrder(int order) {
        this.order = order;
        return this;
    }

    public String getErrorCode() {
        return (errorCode == null) ? null : errorCode.trim();
    }

    public ExcelHeader setErrorCode(String errorCode) {
        this.errorCode = (errorCode == null) ? null : errorCode.trim();
        return this;
    }

    public String getPattern() {
        return (pattern == null) ? null : pattern.trim();
    }

    public ExcelHeader setPattern(String pattern) {
        this.pattern = (pattern == null) ? null : pattern.trim();
        return this;
    }

    public String getPropertyName() {
        return (propertyName == null) ? null : propertyName.trim();
    }

    public ExcelHeader setPropertyName(String propertyName) {
        this.propertyName = (propertyName == null) ? null : propertyName.trim();
        return this;
    }

    public String getPropertyTypeName() {
        return (propertyTypeName == null) ? null : propertyTypeName.trim();
    }

    public ExcelHeader setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = (propertyTypeName == null) ? null : propertyTypeName.trim();
        return this;
    }

    public Class<?> getPropertyType() {
        return propertyType;
    }

    public ExcelHeader setPropertyType(Class<?> propertyType) {
        this.propertyType = propertyType;
        return this;
    }

    public Class<?>[] getValidGroups() {
        return validGroups;
    }

    public ExcelHeader setValidGroups(Class<?>[] validGroups) {
        this.validGroups = validGroups;
        return this;
    }
}
