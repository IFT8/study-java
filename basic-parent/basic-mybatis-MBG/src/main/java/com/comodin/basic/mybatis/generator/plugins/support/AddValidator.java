package com.comodin.basic.mybatis.generator.plugins.support;

import com.comodin.basic.mybatis.generator.json.RemarksJSON;
import com.comodin.basic.mybatis.generator.util.PluginsUtils;
import com.comodin.basic.util.MyStringUtils;
import com.comodin.basic.util.freemarker.EntityProperty;
import com.comodin.basic.util.freemarker.EntityPropertyType;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;

import java.util.Date;
import java.util.HashSet;

@SuppressWarnings({"unused", "WeakerAccess"})
public class AddValidator {

    public static void fieldAddHibernateValidatorAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        //introspectedColumn.getActualColumnName()          数据库，字段名   client_id
        //introspectedColumn.getJdbcTypeName()              数据库，字段，类型   BIGINT
        //introspectedColumn.isNullable()                   是否为空，true: 可以为空，false 不能为空
        //introspectedColumn.getLength()                    长度
        //introspectedColumn.getRemarks()                   备注
        //introspectedColumn.getDefaultValue()              缺省值
        //introspectedColumn.getJavaProperty()              java 字段名      id
        //introspectedColumn.getFullyQualifiedJavaType()    java，字段，类型    java.lang.Long

        RemarksJSON remarksJSON = PluginsUtils.extractRemarksJSON(introspectedColumn.getRemarks());
        String javaBeanNameByCamelToUnderline = MyStringUtils.camelToUnderline(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
        String fieldNameByCamelToUnderline = MyStringUtils.camelToUnderline(field.getName());

        processAnnotationValidAllowData(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, remarksJSON, field, introspectedTable, introspectedColumn);
        processAnnotationEmail(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, remarksJSON, field, introspectedTable, introspectedColumn);
        processAnnotationValidDateTimeFormat(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, remarksJSON, field, introspectedTable, introspectedColumn);
        processAnnotationNotNullOrNotBlank(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, remarksJSON, field, introspectedTable, introspectedColumn);
        processAnnotationLengthOrValidLength(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, remarksJSON, field, introspectedTable, introspectedColumn);
    }


    private static void processAnnotationValidAllowData(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, RemarksJSON remarksJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (remarksJSON == null || remarksJSON.getDataList() == null || remarksJSON.getDataList().isEmpty()) {
            return;
        }

        String javaBeanName = introspectedColumn.getIntrospectedTable().getFullyQualifiedTable().getDomainObjectName();
        if (!PluginsUtils.getEntityConstantToMapByEntityBeanName().containsKey(javaBeanName)) {
            PluginsUtils.getEntityConstantToMapByEntityBeanName().put(javaBeanName, new HashSet<>());
        }

        String validAllowDataMessageKey = String.format("%s_%s_ALLOW_DATA", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String validAllowDataMessageVal = "Only as follows {allowDataArray}.";

        StringBuffer stringBuffer = new StringBuffer();
        remarksJSON.getDataList().forEach(data -> {

            String constantBeanName = PluginsUtils.getConstantBeanClassName(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
            String constantName = String.format("%s_%s_%s", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, data).toUpperCase();
            stringBuffer.append(constantBeanName).append(".").append(constantName).append(",");

            //组装，生成每个类的常量变量，以便，待会使用freemarker生成，常量文件
            PluginsUtils.getEntityConstantToMapByEntityBeanName().get(javaBeanName)//
                    .add(new EntityProperty().setType(EntityPropertyType.valueOf(field.getType().getShortName())).setName(constantName).setValue(data).setRemarks(introspectedColumn.getRemarks()));
        });
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);

        String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, validAllowDataMessageKey);
        String validGroups = PluginsUtils.assemblyFieldValidatorAnnotationValidGroups(introspectedTable, introspectedColumn);

        field.addAnnotation("@ValidAllowData(allowDataArray = {" + substring + "}, message = " + messageKey + ", groups = " + validGroups + ")");
        PluginsUtils.setFieldI18nToEntityI18nSet(validAllowDataMessageKey, validAllowDataMessageVal, introspectedColumn);
    }


    private static void processAnnotationEmail(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, RemarksJSON remarksJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (remarksJSON == null || remarksJSON.getEmail() == null || !remarksJSON.getEmail()) {
            return;
        }

        String emailMessageKey = String.format("%s_%s_EMAIL", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String emailMessageVal = "not a well-formed email address.";

        String javaBeanName = introspectedColumn.getIntrospectedTable().getFullyQualifiedTable().getDomainObjectName();

        String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, emailMessageKey);
        String validGroups = PluginsUtils.assemblyFieldValidatorAnnotationValidGroups(introspectedTable, introspectedColumn);

        field.addAnnotation("@Email(message = " + messageKey + ", groups = " + validGroups + ")");
        PluginsUtils.setFieldI18nToEntityI18nSet(emailMessageKey, emailMessageVal, introspectedColumn);
    }


    private static void processAnnotationValidDateTimeFormat(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, RemarksJSON RemarksJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String pattern = RemarksJSON != null && RemarksJSON.getPattern() != null && "".equals(RemarksJSON.getPattern().trim()) ? RemarksJSON.getPattern().trim() : null;

        String dateTimeFormatMessageKey = String.format("%s_%s_DATE_TIME_FORMAT", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String dateTimeFormatMessageVal = "Invalid time or date format error. pattern: {pattern}.";

        String javaBeanName = introspectedColumn.getIntrospectedTable().getFullyQualifiedTable().getDomainObjectName();

        String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, dateTimeFormatMessageKey);
        String validGroups = PluginsUtils.assemblyFieldValidatorAnnotationValidGroups(introspectedTable, introspectedColumn);

        if (Date.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            if ("TIMESTAMP".equals(introspectedColumn.getJdbcTypeName())) {

                field.addAnnotation("@ValidDateTimeFormat(pattern = " + (pattern != null ? "\"pattern\"" : "DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS") + ", message = " + messageKey + ", groups = " + validGroups + ")");
                field.addAnnotation("@DateTimeFormat(pattern = " + (pattern != null ? "\"pattern\"" : "DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS") + ")");
                PluginsUtils.setFieldI18nToEntityI18nSet(dateTimeFormatMessageKey, dateTimeFormatMessageVal, introspectedColumn);

            } else if ("DATE".equals(introspectedColumn.getJdbcTypeName())) {

                field.addAnnotation("@ValidDateTimeFormat(pattern = " + (pattern != null ? "\"pattern\"" : "DateUtil.DATE_PATTERN_YYYY_MM_DD") + ", message = " + messageKey + ", groups = " + validGroups + ")");
                field.addAnnotation("@DateTimeFormat(pattern = " + (pattern != null ? "\"pattern\"" : "DateUtil.DATE_PATTERN_YYYY_MM_DD") + ")");
                PluginsUtils.setFieldI18nToEntityI18nSet(dateTimeFormatMessageKey, dateTimeFormatMessageVal, introspectedColumn);
            }
        }
    }

    private static void processAnnotationNotNullOrNotBlank(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, RemarksJSON RemarksJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        boolean isNullable = introspectedColumn.isNullable();
        if (isNullable) {
            return;
        }

        String notNullMessageKey = String.format("%s_%s_NOT_NULL", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String notNullMessageVal = "Can not contain empty.";
        String notBlankMessageKey = String.format("%s_%s_NOT_BLANK", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String notBlankMessageVal = "Can not contain empty.";

        String javaBeanName = introspectedColumn.getIntrospectedTable().getFullyQualifiedTable().getDomainObjectName();
        String validGroups = PluginsUtils.assemblyFieldValidatorAnnotationValidGroups(introspectedTable, introspectedColumn);

        if (Date.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, notNullMessageKey);
            field.addAnnotation("@NotNull(message = " + messageKey + ", groups = " + validGroups + ")");
            PluginsUtils.setFieldI18nToEntityI18nSet(notNullMessageKey, notNullMessageVal, introspectedColumn);

        } else if (Integer.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, notNullMessageKey);
            field.addAnnotation("@NotNull(message = " + messageKey + ", groups = " + validGroups + ")");
            PluginsUtils.setFieldI18nToEntityI18nSet(notNullMessageKey, notNullMessageVal, introspectedColumn);

        } else if (Long.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, notNullMessageKey);
            field.addAnnotation("@NotNull(message = " + messageKey + ", groups = " + validGroups + ")");
            PluginsUtils.setFieldI18nToEntityI18nSet(notNullMessageKey, notNullMessageVal, introspectedColumn);

        } else if (String.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, notBlankMessageKey);
            field.addAnnotation("@NotBlank(message = " + messageKey + ", groups = " + validGroups + ")");
            PluginsUtils.setFieldI18nToEntityI18nSet(notBlankMessageKey, notBlankMessageVal, introspectedColumn);

        }
    }


    private static void processAnnotationLengthOrValidLength(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, RemarksJSON remarksJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        Integer lengthMin = remarksJSON != null && remarksJSON.getMin() != null ? remarksJSON.getMin() : null;
        Integer lengthMax = remarksJSON != null && remarksJSON.getMax() != null ? remarksJSON.getMax() : introspectedColumn.getLength();

        String validLengthMessageKey = String.format("%s_%s_Length", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String validLengthMessageVal = "data length must be between {min} and {max} bit.";

        String lengthMessageKey = String.format("%s_%s_Length", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String lengthMessageVal = "data length must be between {min} and {max} bit.";

        String javaBeanName = introspectedColumn.getIntrospectedTable().getFullyQualifiedTable().getDomainObjectName();
        String validGroups = PluginsUtils.assemblyFieldValidatorAnnotationValidGroups(introspectedTable, introspectedColumn);

        if (Integer.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, validLengthMessageKey);
            field.addAnnotation("@ValidLength(" + (lengthMin != null ? "min = " + lengthMin + ", " : "") + "max = " + lengthMax + ", message = " + messageKey + ", groups = " + validGroups + ")");

            PluginsUtils.setFieldI18nToEntityI18nSet(validLengthMessageKey, validLengthMessageVal, introspectedColumn);

        } else if (Long.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, validLengthMessageKey);
            field.addAnnotation("@ValidLength(" + (lengthMin != null ? "min = " + lengthMin + ", " : "") + "max = " + lengthMax + ", message = " + messageKey + ", groups = " + validGroups + ")");

            PluginsUtils.setFieldI18nToEntityI18nSet(validLengthMessageKey, validLengthMessageVal, introspectedColumn);

        } else if (String.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {

            String messageKey = PluginsUtils.assemblyFieldValidatorAnnotationMessageKey(javaBeanName, lengthMessageKey);
            field.addAnnotation("@Length(" + (lengthMin != null ? "min = " + lengthMin + ", " : "") + "max = " + lengthMax + ", message = " + messageKey + ", groups = " + validGroups + ")");

            PluginsUtils.setFieldI18nToEntityI18nSet(lengthMessageKey, lengthMessageVal, introspectedColumn);
        }
    }
}
