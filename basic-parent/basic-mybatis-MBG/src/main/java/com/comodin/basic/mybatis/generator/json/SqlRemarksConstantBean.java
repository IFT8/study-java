package com.comodin.basic.mybatis.generator.json;

/**
 * @author supeng
 */
public class SqlRemarksConstantBean {

    private String key;
    private String desc;

    public SqlRemarksConstantBean(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return (key == null) ? null : key.trim();
    }

    public void setKey(String key) {
        this.key = (key == null) ? null : key.trim();
    }

    public String getDesc() {
        return (desc == null) ? null : desc.trim();
    }

    public void setDesc(String desc) {
        this.desc = (desc == null) ? null : desc.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SqlRemarksConstantBean)) {
            return false;
        }

        SqlRemarksConstantBean that = (SqlRemarksConstantBean) o;

        return getKey() != null ? getKey().equals(that.getKey()) : that.getKey() == null;
    }

    @Override
    public int hashCode() {
        return getKey() != null ? getKey().hashCode() : 0;
    }
}