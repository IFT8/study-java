package com.comodin.basic.mybatis.generator.plugins;

import java.util.Set;

public class SQLCommentJSON {
    private Integer min;
    private Integer max;
    private String pattern;
    private Boolean isEmail;
    private Set<String> dataList;

    public Integer getMin() {
        return min;
    }

    public SQLCommentJSON setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public SQLCommentJSON setMax(Integer max) {
        this.max = max;
        return this;
    }

    public String getPattern() {
        return (pattern == null) ? null : pattern.trim();
    }

    public SQLCommentJSON setPattern(String pattern) {
        this.pattern = (pattern == null) ? null : pattern.trim();
        return this;
    }

    public Boolean getEmail() {
        return isEmail;
    }

    public SQLCommentJSON setEmail(Boolean email) {
        isEmail = email;
        return this;
    }

    public Set<String> getDataList() {
        return dataList;
    }

    public SQLCommentJSON setDataList(Set<String> dataList) {
        this.dataList = dataList;
        return this;
    }
}
