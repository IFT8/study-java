package com.comodin.basic.util.freemarker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 生成 实体类 模版
 * @author supeng
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
public class Entity {

    // 实体所在的包名
    private String packageName;

    // 导入包列表
    private Set<String> importPackageSet = new HashSet<>();

    // java文件类型，即是class 还是 接口
    private EntityType classType;

    // java文件名，也即类名
    private String className;

    private Set<String> classAnnotationSet = new HashSet<>();

    //父类
    private String superClass;

    //需要实现的接口
    private Set<String> implementsInterfaceClassSet = new HashSet<>();

    //模版生成是接口，即接口继承的接口集合
    private Set<String> interfaceSuperClassSet = new HashSet<>();

    // 是否有构造函数
    private boolean generatedConstructors;
    // 是否有构造函数
    private boolean generatedGetSetMethod;

    // 类静态属性集合
    private List<EntityProperty> staticPropertySet = new ArrayList<>();
    // 属性集合
    private List<EntityProperty> entityPropertySet = new ArrayList<>();

    private List<String> temporaryMethodBodySet = new ArrayList<>();

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

    @SuppressWarnings("SameParameterValue")
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

    public List<EntityProperty> getStaticPropertySet() {
        return staticPropertySet;
    }

    public Entity setStaticPropertySet(List<EntityProperty> staticPropertySet) {
        this.staticPropertySet = staticPropertySet;
        return this;
    }

    public List<EntityProperty> getEntityPropertySet() {
        return entityPropertySet;
    }

    public Entity setEntityPropertySet(List<EntityProperty> entityPropertySet) {
        this.entityPropertySet = entityPropertySet;
        return this;
    }

    public List<String> getTemporaryMethodBodySet() {
        return temporaryMethodBodySet;
    }

    public Entity setTemporaryMethodBodySet(List<String> temporaryMethodBodySet) {
        this.temporaryMethodBodySet = temporaryMethodBodySet;
        return this;
    }

    public Set<String> getInterfaceSuperClassSet() {
        return interfaceSuperClassSet;
    }

    public Entity setInterfaceSuperClassSet(Set<String> interfaceSuperClassSet) {
        this.interfaceSuperClassSet = interfaceSuperClassSet;
        return this;
    }
}