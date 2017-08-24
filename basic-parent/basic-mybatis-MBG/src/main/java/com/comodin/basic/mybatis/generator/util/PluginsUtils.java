package com.comodin.basic.mybatis.generator.util;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.mybatis.generator.json.RemarksJSON;
import com.comodin.basic.util.MyStringUtils;
import com.comodin.basic.util.freemarker.EntityProperty;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.config.Context;

import java.util.*;

@SuppressWarnings({"WeakerAccess", "unused", "MismatchedQueryAndUpdateOfCollection", "FieldCanBeLocal"})
public class PluginsUtils {

    private static Map<String, Set<EntityProperty>> entityI18nToMapByEntityBeanName = new HashMap<>();
    private static Map<String, Set<EntityProperty>> entityConstantToMapByEntityBeanName = new HashMap<>();

    public static final String PACKAGE_JAVAX_PERSISTENCE = "javax.persistence.*";
    public static final String PACKAGE_JAVA_VALIDATION_CONSTRAINTS = "javax.validation.constraints.*";
    public static final String PACKAGE_HIBERNATE_VALIDATOR_CONSTRAINTS = "org.hibernate.validator.constraints.*";
    public static final String PACKAGE_CUSTOMIZE_VALIDATOR_CONSTRAINTS = "com.comodin.basic.validation.constraints.*";
    public static final String PACKAGE_CUSTOMIZE_VALIDATOR_BASE_VALID_GROUP = "com.comodin.basic.validation.IBaseValidGroup";
    public static final String PACKAGE_DATE_UTIL = "com.comodin.basic.util.date.DateUtil";
    public static final String PACKAGE_BASE_VO = "com.comodin.basic.vo.BaseVo";
    public static final String PACKAGE_SPRING_ANNOTATION_SERVICE = "org.springframework.stereotype.Service";
    public static final String PACKAGE_SPRING_ANNOTATION_CONTROLLER = "org.springframework.stereotype.Controller";
    public static final String PACKAGE_SPRING_ANNOTATION_REQUEST_MAPPING = "org.springframework.web.bind.annotation.RequestMapping";
    public static final String PACKAGE_SPRING_DATE_TIME_FORMAT = "org.springframework.format.annotation.DateTimeFormat";

    private static String dateFormat = "yyyy-MM-dd";
    private static String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    private static String beanDir = "com.comodin.fleet.core.bean";

    private static String daoInterfacePackage = "com.comodin.fleet.core.mapper";
    private static String daoMappersDir = "sqlMapper";
    private static Set<String> daoInterfaceExtendsInterfaceSet = new HashSet<>();

    private static String constantPackage = "com.comodin.fleet.constant";
    private static String constantFileNamePrefix = "";
    private static String constantFileNameSuffix = "Constant";

    private static String i18nConstantPackage = "com.comodin.fleet.constant.i18n";
    private static String i18nConstantFileNamePrefix = "I18n";
    private static String i18nConstantFileNameSuffix = "Constant";

    private static String serviceInterfacePackage = "com.comodin.fleet.service";
    private static String serviceInterfaceFileNamePrefix = "I";
    private static String serviceInterfaceFileNameSuffix = "Service";
    private static Set<String> serviceInterfaceExtendsInterfaceSet = new HashSet<>();

    private static String serviceImplementsPackage = "com.comodin.fleet.service.impl";
    private static String serviceImplementsFileNamePrefix = "";
    private static String serviceImplementsFileNameSuffix = "Service";
    private static String serviceImplementsExtendsSubClass = "com.comodin.basic.service.AbstractBaseService";

    private static String controllerPackage = "com.comodin.fleet.controller";
    private static String controllerFileNamePrefix = "";
    private static String controllerFileNameSuffix = "Controller";
    private static String controllerExtendsSubClass = "com.comodin.basic.controller.AbstractBaseController";

    private static String i18nDir = "i18n";
    private static String i18nFileNamePrefix = "i18n-";
    private static String i18nFileNameSuffix = "";
    private static Set<String> i18nLanguageSet = new HashSet<>();

    static {
        i18nLanguageSet.add("");
        i18nLanguageSet.add("zh_CN");
        i18nLanguageSet.add("en_US");
        i18nLanguageSet.add("es_MX");
    }

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


        if (StringUtils.isNotBlank(properties.getProperty("i18nConstantPackage"))) {
            i18nConstantPackage = properties.getProperty("i18nConstantPackage").trim();
        }
        if (properties.getProperty("i18nConstantFileNamePrefix") != null) {
            i18nConstantFileNamePrefix = properties.getProperty("i18nConstantFileNamePrefix");
        }
        if (StringUtils.isNotBlank(properties.getProperty("i18nConstantFileNameSuffix"))) {
            i18nConstantFileNameSuffix = properties.getProperty("i18nConstantFileNameSuffix");
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

    public static RemarksJSON extractRemarksJSON(String columnRemarks) {
        if (columnRemarks == null || "".equals(columnRemarks.trim())) {
            return null;
        }
        int indexOfPrefix = columnRemarks.indexOf("【{");
        int indexOfSuffix = columnRemarks.indexOf("}】");
        if (indexOfPrefix < 0 || indexOfSuffix < 0) {
            return null;
        }
        String extractSQLCommentJSONStr = columnRemarks.substring((columnRemarks.indexOf("【{") + 1), (columnRemarks.indexOf("}】") + 1));
        return JSON.parseObject(extractSQLCommentJSONStr, RemarksJSON.class);
    }

    public static String extractRemarksDescription(String columnRemarks) {
        if (columnRemarks == null || "".equals(columnRemarks.trim())) {
            return "";
        }

        int indexOfPrefix = columnRemarks.indexOf("【{");
        if (indexOfPrefix < 0) {
            return columnRemarks;
        } else {
            return columnRemarks.substring(0, indexOfPrefix);
        }
    }

    public static String getGenerateConstantFileDir() {
        return String.format("%s/%s", beanDir, constantPackage.replace('.', '/'));
    }

    public static String getConstantBeanClassName(String javaBeanName) {
        return String.format("%s%s%s", constantFileNamePrefix, javaBeanName, constantFileNameSuffix);
    }

    public static String getGenerateI18nConstantFileDir() {
        return String.format("%s/%s", beanDir, i18nConstantPackage.replace('.', '/'));
    }

    public static String getI18nConstantBeanClassName(String javaBeanName) {
        return String.format("%s%s%s", i18nConstantFileNamePrefix, javaBeanName, i18nConstantFileNameSuffix);
    }

    public static void setFieldI18nToEntityI18nSet(String i18nMessageKey, String i18nMessageValue, IntrospectedColumn introspectedColumn) {
        String javaBeanName = introspectedColumn.getIntrospectedTable().getFullyQualifiedTable().getDomainObjectName();
        if (!entityI18nToMapByEntityBeanName.containsKey(javaBeanName)) {
            entityI18nToMapByEntityBeanName.put(javaBeanName, new HashSet<>());
        }
        entityI18nToMapByEntityBeanName.get(javaBeanName).add(new EntityProperty().setName(i18nMessageKey).setValue(i18nMessageValue).setRemarks(PluginsUtils.extractRemarksDescription(introspectedColumn.getRemarks())));
    }

    public static String getConstantPackage() {
        return constantPackage;
    }

    public static String getI18nConstantPackage() {
        return i18nConstantPackage;
    }

    public static Map<String, Set<EntityProperty>> getEntityConstantToMapByEntityBeanName() {
        return entityConstantToMapByEntityBeanName;
    }


    public static Map<String, Set<EntityProperty>> getEntityI18nToMapByEntityBeanName() {
        return entityI18nToMapByEntityBeanName;
    }

    public static String getGenerateI18nFileDir() {
        if (StringUtils.isNotBlank(i18nDir)) {
            return String.format("%s/%s", daoMappersDir, i18nDir.replace('.', '/'));
        } else {
            return daoMappersDir;
        }
    }

    public static Set<String> getI18nLanguageSet() {
        return i18nLanguageSet;
    }

    public static String getI18nFileNamePrefix() {
        return i18nFileNamePrefix;
    }

    public static String getI18nFileNameSuffix() {
        return i18nFileNameSuffix;
    }

    public static String getServiceInterfaceFileDir() {
        return String.format("%s/%s", beanDir, serviceInterfacePackage.replace('.', '/'));
    }

    public static String getServiceInterfaceClassName(String javaBeanName) {
        return String.format("%s%s%s", serviceInterfaceFileNamePrefix, javaBeanName, serviceInterfaceFileNameSuffix);
    }

    public static String getServiceInterfacePackage() {
        return serviceInterfacePackage;
    }

    public static Set<String> getServiceInterfaceExtendsInterfaceSet() {
        return serviceInterfaceExtendsInterfaceSet;
    }

    public static String getServiceImplementsFileDir() {
        return String.format("%s/%s", beanDir, serviceImplementsPackage.replace('.', '/'));
    }

    public static String getServiceImplementsClassName(String javaBeanName) {
        return String.format("%s%s%s", serviceImplementsFileNamePrefix, javaBeanName, serviceImplementsFileNameSuffix);
    }

    public static String getServiceImplementsExtendsSubClass() {
        return serviceImplementsExtendsSubClass;
    }

    public static String getServiceImplementsPackage() {
        return serviceImplementsPackage;
    }

    public static String getControllerFileDir() {
        return String.format("%s/%s", beanDir, controllerPackage.replace('.', '/'));
    }

    public static String getControllerClassName(String javaBeanName) {
        return String.format("%s%s%s", controllerFileNamePrefix, javaBeanName, controllerFileNameSuffix);
    }

    public static String getControllerExtendsSubClass() {
        return controllerExtendsSubClass.trim();
    }

    public static String getControllerPackage() {
        return (controllerPackage == null) ? null : controllerPackage.trim();
    }

    public static String getControllerRequestMappingModuleName(String javaBeanName) {
        return MyStringUtils.toLowerCaseFirstOne(javaBeanName.replace("Bean", ""));
    }

    public static String assemblyFieldValidatorAnnotationMessageKey(String javaBeanName, String validMessageKey) {
        String i18nConstantBeanClassName = PluginsUtils.getI18nConstantBeanClassName(javaBeanName);
        String messageKey = i18nConstantBeanClassName + "." + validMessageKey;
        return "\"{\" + " + messageKey + " + \"}\"";
    }

    public static String assemblyFieldValidatorAnnotationValidGroups(IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String validGroups = "{IBaseValidGroup.Add.class, IBaseValidGroup.Update.class}";
        for (IntrospectedColumn introspectedColumn1 : introspectedTable.getPrimaryKeyColumns()) {
            if (introspectedColumn == introspectedColumn1) {
                validGroups = "{IBaseValidGroup.Update.class}";
                break;
            }
        }
        return validGroups;
    }
}
