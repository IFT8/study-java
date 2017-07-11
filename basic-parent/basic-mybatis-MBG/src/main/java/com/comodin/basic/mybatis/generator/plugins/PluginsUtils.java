package com.comodin.basic.mybatis.generator.plugins;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.mybatis.generator.json.RemarksJSON;
import com.comodin.basic.util.freemarker.EntityProperty;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.config.Context;

import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
public class PluginsUtils {

    private static Set<EntityProperty> entityI18nSet = new HashSet<>();
    private static Set<EntityProperty> entityConstantSet = new HashSet<>();

    public static String javaxPersistencePackage = "javax.persistence.*";
    public static String javaValidationConstraintsPackage = "javax.validation.constraints.*";
    public static String hibernateValidatorConstraintsPackage = "org.hibernate.validator.constraints.*";
    public static String customizeValidatorConstraintsPackage = "com.comodin.basic.validation.constraints.*";
    public static String customizeValidatorBaseValidGroupPackage = "com.comodin.basic.validation.IBaseValidGroup";
    public static String dateUtilPackage = "com.comodin.basic.util.date.DateUtil";

    private static String beanDir = "";
    private static String daoMappersDir = "";

    private static Set<String> daoInterfaceExtendsInterfaceSet = new HashSet<>();
    private static String dateFormat = "";
    private static String dateTimeFormat = "";
    private static String constantPackage = "";
    private static String constantFileNamePrefix = "";
    private static String constantFileNameSuffix = "";
    private static String serviceInterfacePackage = "";
    private static String serviceInterfaceFileNamePrefix = "";
    private static String serviceInterfaceFileNameSuffix = "";
    private static Set<String> serviceInterfaceExtendsInterfaceSet = new HashSet<>();
    private static String serviceImplementsPackage = "";
    private static String serviceImplementsFileNamePrefix = "";
    private static String serviceImplementsFileNameSuffix = "";
    private static String serviceImplementsExtendsSubClass = "";
    private static String controllerPackage = "";
    private static String controllerFileNamePrefix = "";
    private static String controllerFileNameSuffix = "";
    private static String controllerExtendsSubClass = "";
    private static Set<String> i18nLanguageSet = new HashSet<>();
    private static String i18nDir = "";
    private static String i18nFileNamePrefix = "";
    private static String i18nFileNameSuffix = "";

    public static void initCfg(Context context, Properties properties) {

        beanDir = context.getJavaModelGeneratorConfiguration().getTargetProject().trim();
        daoMappersDir = context.getSqlMapGeneratorConfiguration().getTargetProject().trim();

        if (StringUtils.isNotBlank(properties.getProperty("daoInterfaceExtendsInterfaces"))) {
            daoInterfaceExtendsInterfaceSet.clear();
            Collections.addAll(daoInterfaceExtendsInterfaceSet, properties.getProperty("daoInterfaceExtendsInterfaces").trim().split(","));
        }

        if (StringUtils.isNotBlank(properties.getProperty("dateFormat"))) {
            dateFormat = properties.getProperty("dateFormat").trim();
        }
        if (StringUtils.isNotBlank(properties.getProperty("dateTimeFormat"))) {
            dateTimeFormat = properties.getProperty("dateTimeFormat").trim();
        }

        if (StringUtils.isNotBlank(properties.getProperty("constantPackage"))) {
            constantPackage = properties.getProperty("constantPackage").trim();
        }
        if (StringUtils.isNotBlank(properties.getProperty("constantFileNamePrefix"))) {
            constantFileNamePrefix = properties.getProperty("constantFileNamePrefix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("constantFileNameSuffix"))) {
            constantFileNameSuffix = properties.getProperty("constantFileNameSuffix");
        }


        if (StringUtils.isNotBlank(properties.getProperty("serviceInterfacePackage"))) {
            serviceInterfacePackage = properties.getProperty("serviceInterfacePackage");
        }
        if (StringUtils.isNotBlank(properties.getProperty("serviceInterfaceFileNamePrefix"))) {
            serviceInterfaceFileNamePrefix = properties.getProperty("serviceInterfaceFileNamePrefix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("serviceInterfaceFileNameSuffix"))) {
            serviceInterfaceFileNameSuffix = properties.getProperty("serviceInterfaceFileNameSuffix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("serviceInterfaceExtendsInterfaces"))) {
            serviceInterfaceExtendsInterfaceSet.clear();
            Collections.addAll(serviceInterfaceExtendsInterfaceSet, properties.getProperty("serviceInterfaceExtendsInterfaces").trim().split(","));
        }

        if (StringUtils.isNotBlank(properties.getProperty("serviceImplementsPackage"))) {
            serviceImplementsPackage = properties.getProperty("serviceImplementsPackage");
        }
        if (StringUtils.isNotBlank(properties.getProperty("serviceImplementsFileNamePrefix"))) {
            serviceImplementsFileNamePrefix = properties.getProperty("serviceImplementsFileNamePrefix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("serviceImplementsFileNameSuffix"))) {
            serviceImplementsFileNameSuffix = properties.getProperty("serviceImplementsFileNameSuffix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("serviceImplementsExtendsSubClass"))) {
            serviceImplementsExtendsSubClass = properties.getProperty("serviceImplementsExtendsSubClass");
        }

        if (StringUtils.isNotBlank(properties.getProperty("controllerPackage"))) {
            controllerPackage = properties.getProperty("controllerPackage");
        }
        if (StringUtils.isNotBlank(properties.getProperty("controllerFileNamePrefix"))) {
            controllerFileNamePrefix = properties.getProperty("controllerFileNamePrefix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("controllerFileNameSuffix"))) {
            controllerFileNameSuffix = properties.getProperty("controllerFileNameSuffix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("controllerExtendsSubClass"))) {
            controllerExtendsSubClass = properties.getProperty("controllerExtendsSubClass");
        }

        if (StringUtils.isNotBlank(properties.getProperty("i18nLanguages"))) {
            i18nLanguageSet.clear();
            Collections.addAll(i18nLanguageSet, properties.getProperty("i18nLanguages").trim().split(","));
        }
        if (StringUtils.isNotBlank(properties.getProperty("i18nDir"))) {
            i18nDir = properties.getProperty("i18nDir");
        }
        if (StringUtils.isNotBlank(properties.getProperty("i18nFileNamePrefix"))) {
            i18nFileNamePrefix = properties.getProperty("i18nFileNamePrefix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("i18nFileNameSuffix"))) {
            i18nFileNameSuffix = properties.getProperty("i18nFileNameSuffix");
        }
    }

    public static RemarksJSON extractRemarksJSON(IntrospectedColumn introspectedColumn) {
        String introspectedColumnRemarks = introspectedColumn.getRemarks();
        if (introspectedColumnRemarks == null || "".equals(introspectedColumnRemarks.trim())) {
            return null;
        }
        int indexOfPrefix = introspectedColumnRemarks.indexOf("{");
        int indexOfSuffix = introspectedColumnRemarks.indexOf("}");
        if (indexOfPrefix < 0 || indexOfSuffix < 0) {
            return null;
        }
        String extractSQLCommentJSONStr = introspectedColumnRemarks.substring(introspectedColumnRemarks.indexOf("{"), (introspectedColumnRemarks.indexOf("}") + 1));
        return JSON.parseObject(extractSQLCommentJSONStr, RemarksJSON.class);
    }

    public static String extractRemarksDescription(IntrospectedColumn introspectedColumn) {
        if (introspectedColumn == null || "".equals(introspectedColumn.getRemarks().trim())) {
            return "";
        }

        int indexOfPrefix = introspectedColumn.getRemarks().indexOf("{");
        if (indexOfPrefix < 0) {
            return introspectedColumn.getRemarks();
        } else {
            return introspectedColumn.getRemarks().substring(0, indexOfPrefix);
        }
    }

    public static String getConstantBeanClassName(String domainObjectName) {
        return String.format("%s%s%s", constantFileNamePrefix, domainObjectName, constantFileNameSuffix);
    }

    public static String getConstantBeanDir() {
        return String.format("%s/%s", beanDir, constantPackage.replace('.', '/'));
    }

    public static void setFieldI18nToEntityI18nSet(String i18nMessageKey, String i18nMessageValue, IntrospectedColumn introspectedColumn) {
        entityI18nSet.add(new EntityProperty().setName(i18nMessageKey).setValue(i18nMessageValue).setRemarks(PluginsUtils.extractRemarksDescription(introspectedColumn)));
    }

    public static String getConstantPackage() {
        return constantPackage;
    }

    public static Set<EntityProperty> getEntityConstantSet() {
        return entityConstantSet;
    }


    public static Set<EntityProperty> getEntityI18nSet() {
        return entityI18nSet;
    }
}
