package com.comodin.basic.mybatis.generator.plugins.support;

import com.comodin.basic.mybatis.generator.util.PluginsUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

@SuppressWarnings({"unused", "WeakerAccess"})
public class AddImportPackage {

    public static void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addAnnotation("@SuppressWarnings({\"unused\", \"SpringAutowiredFieldsWarningInspection\", \"StatementWithEmptyBody\", \"WeakerAccess\", \"DefaultAnnotationParam\"})");
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_JAVAX_PERSISTENCE))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_JAVAX_PERSISTENCE);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_JAVA_VALIDATION_CONSTRAINTS))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_JAVA_VALIDATION_CONSTRAINTS);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_HIBERNATE_VALIDATOR_CONSTRAINTS))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_HIBERNATE_VALIDATOR_CONSTRAINTS);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_CUSTOMIZE_VALIDATOR_CONSTRAINTS))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_CUSTOMIZE_VALIDATOR_CONSTRAINTS);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_CUSTOMIZE_VALIDATOR_BASE_VALID_GROUP))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_CUSTOMIZE_VALIDATOR_BASE_VALID_GROUP);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_DATE_UTIL))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_DATE_UTIL);
        }
        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.PACKAGE_SPRING_DATE_TIME_FORMAT))) {
            topLevelClass.addImportedType(PluginsUtils.PACKAGE_SPRING_DATE_TIME_FORMAT);
        }

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        if (PluginsUtils.getEntityConstantToMapByEntityBeanName().containsKey(javaBeanName)) {
            if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.getConstantPackage()))) {
                String constantBeanName = PluginsUtils.getConstantBeanClassName(javaBeanName);
                topLevelClass.addImportedType(PluginsUtils.getConstantPackage() + "." + constantBeanName);
            }
        }

        if (!topLevelClass.getImportedTypes().contains(new FullyQualifiedJavaType(PluginsUtils.getI18nConstantPackage()))) {
            String i18nConstantBeanName = PluginsUtils.getI18nConstantBeanClassName(javaBeanName);
            topLevelClass.addImportedType(PluginsUtils.getI18nConstantPackage() + "." + i18nConstantBeanName);
        }
    }
}
