package com.comodin.basic.mybatis.generator.json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author supeng
 */
public class SqlRemarksJSON {

    private Integer min;
    private Integer max;
    private String pattern;
    private Boolean isEmail;
    private List<SqlRemarksConstantBean> constantList = new ArrayList<>();

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getPattern() {
        return (pattern == null) ? null : pattern.trim();
    }

    public void setPattern(String pattern) {
        this.pattern = (pattern == null) ? null : pattern.trim();
    }

    public Boolean getEmail() {
        return isEmail;
    }

    public void setEmail(Boolean email) {
        isEmail = email;
    }

    public List<SqlRemarksConstantBean> getConstantList() {
        return constantList;
    }

    public void setConstantList(List<SqlRemarksConstantBean> constantList) {
        this.constantList = constantList;
    }

    public static void main(String[] args) {
        SqlRemarksJSON sqlRemarksJSON = new SqlRemarksJSON();
        sqlRemarksJSON.setMin(1);
        sqlRemarksJSON.setMax(10);
        sqlRemarksJSON.setEmail(true);
        sqlRemarksJSON.setPattern("");


        sqlRemarksJSON.getConstantList().add(new SqlRemarksConstantBean("TEST01_KEY", "TEST01 desc"));
        sqlRemarksJSON.getConstantList().add(new SqlRemarksConstantBean("TEST02_KEY", "TEST02 desc"));
        System.out.println(JSON.toJSONString(sqlRemarksJSON));
    }
}
