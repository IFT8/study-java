package com.comodin.basic.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.util.StringUtility;

@SuppressWarnings({"unused", "WeakerAccess"})
public class AddRemark {

    public static void fieldAddRemark(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * <pre>");
            field.addJavaDocLine(" * DB remark: " + introspectedColumn.getRemarks());
            field.addJavaDocLine(String.format(" * DB column: %s\t%s(%d)\t<--->\t%s\t%s", introspectedColumn.getActualColumnName(), introspectedColumn.getJdbcTypeName(), introspectedColumn.getLength(), introspectedColumn.getJavaProperty(), introspectedColumn.getFullyQualifiedJavaType().getFullyQualifiedName()));
            field.addJavaDocLine(" * DB is  Nullable: " + introspectedColumn.isNullable());
            field.addJavaDocLine(" * DB defaultValue: " + introspectedColumn.getDefaultValue());
            field.addJavaDocLine(" * </pre>");
            field.addJavaDocLine(" */");
        }
    }

    /**
     * getter方法注释
     * <p>
     * Adds the getter comment.
     *
     * @param method             the method
     * @param introspectedTable  the introspected table
     * @param introspectedColumn the field to db column
     */
    public static void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        method.addJavaDocLine("/**");
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            method.addJavaDocLine(" * 获取 " + introspectedColumn.getRemarks());
        }
        method.addJavaDocLine(" *");
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            method.addJavaDocLine(" * @return " + introspectedColumn.getActualColumnName() + " - " + introspectedColumn.getRemarks());
        } else {
            method.addJavaDocLine(" * @return " + introspectedColumn.getActualColumnName());
        }
        method.addJavaDocLine(" */");
    }

    /**
     * setter方法注释
     * <p>
     * Adds the setter comment.
     *
     * @param method             the method
     * @param introspectedTable  the introspected table
     * @param introspectedColumn the field to db column
     */
    public static void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        method.addJavaDocLine("/**");
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            method.addJavaDocLine(" * 设置 " + introspectedColumn.getRemarks());
        }
        method.addJavaDocLine(" *");
        if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
            method.addJavaDocLine(" * @param " + method.getParameters().get(0).getName() + " - " + introspectedColumn.getRemarks());
        } else {
            method.addJavaDocLine(" * @param " + method.getParameters().get(0).getName() + " - ");
        }
        method.addJavaDocLine(" */");
    }
}
