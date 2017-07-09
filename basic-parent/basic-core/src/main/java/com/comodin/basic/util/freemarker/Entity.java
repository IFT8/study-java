package com.comodin.basic.util.freemarker;

import java.util.Set;

/**
 * 生成 实体类 模版
 */
public class Entity {
    private String packageName;            // 实体所在的包名
    private Set<String> importPackageSet;       // 导入包列表

    private EntityType classType;               // java文件类型，即是class 还是 接口
    private String className;                   // java文件名，也即类名
    private Set<String> classAnnotationSet;

    private String superClass;                  //父类
    private Set<String> implementsInterfaceClassSet;     //需要实现的接口

    private boolean generatedConstructors;               // 是否有构造函数
    private boolean generatedGetSetMethod;      // 是否有构造函数

    private Set<EntityProperty> staticPropertySet;    // 类静态属性集合
    private Set<EntityProperty> entityPropertySet;          // 属性集合

    private Set<String> temporaryMethodBodySet;

    public Entity(EntityType classType) {
        this.classType = classType;
    }

    public String getPackageName() {
        return (packageName == null) ? null : packageName.trim();
    }

    public Entity setPackageName(String packageName) {
        this.packageName = (packageName == null) ? null : packageName.trim();
        return this;
    }

    public Set<String> getImportPackageSet() {
        return importPackageSet;
    }

    public Entity setImportPackageSet(Set<String> importPackageSet) {
        this.importPackageSet = importPackageSet;
        return this;
    }

    public EntityType getClassType() {
        return classType;
    }

    public Entity setClassType(EntityType classType) {
        this.classType = classType;
        return this;
    }

    public String getClassName() {
        return (className == null) ? null : className.trim();
    }

    public Entity setClassName(String className) {
        this.className = (className == null) ? null : className.trim();
        return this;
    }

    public Set<String> getClassAnnotationSet() {
        return classAnnotationSet;
    }

    public Entity setClassAnnotationSet(Set<String> classAnnotationSet) {
        this.classAnnotationSet = classAnnotationSet;
        return this;
    }

    public String getSuperClass() {
        return (superClass == null) ? null : superClass.trim();
    }

    public Entity setSuperClass(String superClass) {
        this.superClass = (superClass == null) ? null : superClass.trim();
        return this;
    }

    public Set<String> getImplementsInterfaceClassSet() {
        return implementsInterfaceClassSet;
    }

    public Entity setImplementsInterfaceClassSet(Set<String> implementsInterfaceClassSet) {
        this.implementsInterfaceClassSet = implementsInterfaceClassSet;
        return this;
    }

    public boolean isGeneratedConstructors() {
        return generatedConstructors;
    }

    public Entity setGeneratedConstructors(boolean generatedConstructors) {
        this.generatedConstructors = generatedConstructors;
        return this;
    }

    public boolean isGeneratedGetSetMethod() {
        return generatedGetSetMethod;
    }

    public Entity setGeneratedGetSetMethod(boolean generatedGetSetMethod) {
        this.generatedGetSetMethod = generatedGetSetMethod;
        return this;
    }

    public Set<EntityProperty> getStaticPropertySet() {
        return staticPropertySet;
    }

    public Entity setStaticPropertySet(Set<EntityProperty> staticPropertySet) {
        this.staticPropertySet = staticPropertySet;
        return this;
    }

    public Set<EntityProperty> getEntityPropertySet() {
        return entityPropertySet;
    }

    public Entity setEntityPropertySet(Set<EntityProperty> entityPropertySet) {
        this.entityPropertySet = entityPropertySet;
        return this;
    }

    public Set<String> getTemporaryMethodBodySet() {
        return temporaryMethodBodySet;
    }

    public Entity setTemporaryMethodBodySet(Set<String> temporaryMethodBodySet) {
        this.temporaryMethodBodySet = temporaryMethodBodySet;
        return this;
    }
}