package com.comodin.basic.util.freemarker;


/**
 * 实体对应的属性类
 */
public class EntityProperty {

    private String name;// 属性名称
    private String value;// 属性值
    private EntityPropertyType type;
    private String remarks;

    public EntityProperty() {
    }

    public EntityProperty(String name, String value, String remarks) {
        this.name = name;
        this.value = value;
        this.remarks = remarks;
    }

    public EntityProperty(String name, String value, EntityPropertyType type, String remarks) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.remarks = remarks;
    }

    public String getName() {
        return (name == null) ? null : name.trim();
    }

    public EntityProperty setName(String name) {
        this.name = (name == null) ? null : name.trim();
        return this;
    }

    public String getValue() {
        return (value == null) ? null : value.trim();
    }

    public EntityProperty setValue(String value) {
        this.value = (value == null) ? null : value.trim();
        return this;
    }

    public EntityPropertyType getType() {
        return type;
    }

    public EntityProperty setType(EntityPropertyType type) {
        this.type = type;
        return this;
    }

    public String getRemarks() {
        return (remarks == null) ? null : remarks.trim();
    }

    public EntityProperty setRemarks(String remarks) {
        this.remarks = (remarks == null) ? null : remarks.trim();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityProperty)) {
            return false;
        }

        EntityProperty that = (EntityProperty) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
            return false;
        }
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null) {
            return false;
        }
        return getType() == that.getType() && (getRemarks() != null ? getRemarks().equals(that.getRemarks()) : that.getRemarks() == null);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getRemarks() != null ? getRemarks().hashCode() : 0);
        return result;
    }
}