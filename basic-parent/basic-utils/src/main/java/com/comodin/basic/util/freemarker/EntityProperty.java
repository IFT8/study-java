package com.comodin.basic.util.freemarker;


import java.util.List;

/**
 * 实体对应的属性类
 */
public class EntityProperty {

    private String name;// 属性名称
    private String value;// 属性值
    private EntityPropertyType type;
    private List<String> remarks;

    public EntityProperty() {
    }

    public EntityProperty(String name, String value, List<String> remarks) {
        this.name = name;
        this.value = value;
        this.remarks = remarks;
    }

    public EntityProperty(String name, String value, EntityPropertyType type, List<String> remarks) {
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

    public List<String> getRemarks() {
        return remarks;
    }

    public EntityProperty setRemarks(List<String> remarks) {
        this.remarks = remarks;
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

        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}