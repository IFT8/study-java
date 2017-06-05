package com.comodin.basic.util.excel;

/**
 * 用来存储Excel标题的对象，通过该对象可以获取标题和方法的对应关系
 *
 * @author Administrator
 */
public class ExcelHeader implements Comparable<ExcelHeader> {
    /**
     * excel的标题名称
     */
    private String title;
    /**
     * 每一个标题的顺序
     */
    private int order;

    private Boolean required;

    private String pattern;

    private int errorCode;
    private int errorMsg;

    /**
     * 说对应方法名称
     */
    private String methodName;


    public int compareTo(ExcelHeader o) {
        return order > o.order ? 1 : (order < o.order ? -1 : 0);
    }

    public ExcelHeader(String title, int order, String methodName) {
        super();
        this.title = title;
        this.order = order;
        this.methodName = methodName;
    }

    public ExcelHeader(String title, int order, Boolean required, String pattern, String methodName) {
        this.title = title;
        this.order = order;
        this.required = required;
        this.pattern = pattern;
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return String.format("ExcelHeader [title=%s, order=%d, methodName=%s]", title, order, methodName);
    }

    public String getTitle() {
        return (title == null) ? null : title.trim();
    }

    public void setTitle(String title) {
        this.title = (title == null) ? null : title.trim();
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getPattern() {
        return (pattern == null) ? null : pattern.trim();
    }

    public void setPattern(String pattern) {
        this.pattern = (pattern == null) ? null : pattern.trim();
    }

    public String getMethodName() {
        return (methodName == null) ? null : methodName.trim();
    }

    public void setMethodName(String methodName) {
        this.methodName = (methodName == null) ? null : methodName.trim();
    }
}
