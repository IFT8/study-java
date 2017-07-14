package com.comodin.basic.mybatis.generator.plugins;

import com.alibaba.fastjson.JSON;
import com.comodin.basic.mybatis.generator.json.RemarksJSON;
import com.comodin.basic.util.MyStringUtils;
import com.comodin.basic.util.freemarker.EntityProperty;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.config.Context;

import java.util.*;

@SuppressWarnings({"WeakerAccess", "unused"})
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

    public static String getConstantBeanClassName(String javaBeanName) {
        return String.format("%s%s%s", constantFileNamePrefix, javaBeanName, constantFileNameSuffix);
    }

    public static String getGenerateConstantFileDir() {
        return String.format("%s/%s", beanDir, constantPackage.replace('.', '/'));
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
}
