package com.comodin.basic.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

@SuppressWarnings({"unused", "WeakerAccess"})
public class AddImportPackage {

    public static void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addAnnotation("@SuppressWarnings(\"unused\")");
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.javaxPersistencePackage))) {
            topLevelClass.addImportedType(PluginsUtils.javaxPersistencePackage);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.javaValidationConstraintsPackage))) {
            topLevelClass.addImportedType(PluginsUtils.javaValidationConstraintsPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.hibernateValidatorConstraintsPackage))) {
            topLevelClass.addImportedType(PluginsUtils.hibernateValidatorConstraintsPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.customizeValidatorConstraintsPackage))) {
            topLevelClass.addImportedType(PluginsUtils.customizeValidatorConstraintsPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.customizeValidatorBaseValidGroupPackage))) {
            topLevelClass.addImportedType(PluginsUtils.customizeValidatorBaseValidGroupPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.dateUtilPackage))) {
            topLevelClass.addImportedType(PluginsUtils.dateUtilPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.getConstantPackage()))) {
            topLevelClass.addImportedType(PluginsUtils.getConstantPackage() + ".*");
        }
    }
}
