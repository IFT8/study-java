package com.comodin.basic.mybatis.generator.freemarker;

import java.util.List;

/**
 * 实体类
 */
public class Entity {
    private String javaPackage;// 实体所在的包名
    private String className;// 实体类名
    private String superClass;// 父类名
    List<Property> propertyList;// 属性集合
    private boolean constructors;    // 是否有构造函数

    public String getJavaPackage() {
        return javaPackage;
    }

    public Entity setJavaPackage(String javaPackage) {
        this.javaPackage = (javaPackage == null) ? null : javaPackage.trim();
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Entity setClassName(String className) {
        this.className = (className == null) ? null : className.trim();
        return this;
    }

    public String getSuperClass() {
        return superClass;
    }

    public Entity setSuperClass(String superClass) {
        this.superClass = (superClass == null) ? null : superClass.trim();
        return this;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public Entity setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
        return this;
    }

    public boolean isConstructors() {
        return constructors;
    }

    public Entity setConstructors(boolean constructors) {
        this.constructors = constructors;
        return this;
    }
}