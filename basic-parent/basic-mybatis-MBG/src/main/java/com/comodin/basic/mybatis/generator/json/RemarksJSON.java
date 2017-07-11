package com.comodin.basic.mybatis.generator.json;

import java.util.Set;

public class RemarksJSON {
    private Integer min;
    private Integer max;
    private String pattern;
    private Boolean isEmail;
    private Set<String> dataList;

    public Integer getMin() {
        return min;
    }

    public RemarksJSON setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public RemarksJSON setMax(Integer max) {
        this.max = max;
        return this;
    }

    public String getPattern() {
        return (pattern == null) ? null : pattern.trim();
    }

    public RemarksJSON setPattern(String pattern) {
        this.pattern = (pattern == null) ? null : pattern.trim();
        return this;
    }

    public Boolean getEmail() {
        return isEmail;
    }

    public RemarksJSON setEmail(Boolean email) {
        isEmail = email;
        return this;
    }

    public Set<String> getDataList() {
        return dataList;
    }

    public RemarksJSON setDataList(Set<String> dataList) {
        this.dataList = dataList;
        return this;
    }
}
