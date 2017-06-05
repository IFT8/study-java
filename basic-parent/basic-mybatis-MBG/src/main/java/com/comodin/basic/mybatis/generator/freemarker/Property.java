package com.comodin.basic.mybatis.generator.freemarker;


/**
 * 实体对应的属性类
 */
public class Property {
    private String javaType;// 属性数据类型
    private String propertyName;// 属性名称
    private PropertyEnumType propertyEnumType;

    public String getJavaType() {
        return (this.javaType == null) ? null : this.javaType.trim();
    }

    public Property setJavaType(String javaType) {
        this.javaType = (javaType == null) ? null : javaType.trim();
        return this;
    }

    public String getPropertyName() {
        return (this.propertyName == null) ? null : this.propertyName.trim();
    }

    public Property setPropertyName(String propertyName) {
        this.propertyName = (propertyName == null) ? null : propertyName.trim();
        return this;
    }

    public PropertyEnumType getPropertyEnumType() {
        return this.propertyEnumType;
    }

    public Property setPropertyEnumType(PropertyEnumType propertyEnumType) {
        this.propertyEnumType = propertyEnumType;
        return this;
    }
}