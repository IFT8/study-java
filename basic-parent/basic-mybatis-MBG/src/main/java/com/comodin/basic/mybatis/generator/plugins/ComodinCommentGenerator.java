package com.comodin.basic.mybatis.generator.plugins;


import com.alibaba.fastjson.JSON;
import com.comodin.basic.mybatis.generator.freemarker.EntityProperty;
import com.comodin.basic.mybatis.generator.freemarker.EntityPropertyType;
import com.comodin.basic.util.MyStringUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.MessageFormat;
import java.util.*;

public class ComodinCommentGenerator implements CommentGenerator {

    //开始的分隔符，例如mysql为`，sqlServer为[
    private String beginningDelimiter = "";
    //结束的分隔符，例如mysql为`，sqlServer为]
    private String endingDelimiter = "";
    private FullyQualifiedJavaType javaValidationConstraintsPackage = new FullyQualifiedJavaType("javax.validation.constraints.*");
    private FullyQualifiedJavaType hibernateValidatorConstraintsPackage = new FullyQualifiedJavaType("org.hibernate.validator.constraints.*");
    private FullyQualifiedJavaType customizeValidatorConstraintsPackage = new FullyQualifiedJavaType("com.comodin.basic.validation.constraints.*");
    private FullyQualifiedJavaType applicationConstantPackage = new FullyQualifiedJavaType("com.comodin.fleet.constant.*");
    private FullyQualifiedJavaType customizeValidatorBaseValidGroup = new FullyQualifiedJavaType("com.comodin.basic.validation.IBaseValidGroup");
    private FullyQualifiedJavaType dateUtil = new FullyQualifiedJavaType("com.comodin.basic.util.date.DateUtil");

    private static Map<String, String> internationalizedMap = new HashMap<>();
    private static List<EntityProperty> applicationConstantMap = new ArrayList<>();

    /**
     * Adds properties for this instance from any properties configured in the
     * CommentGenerator configuration.
     * <p>
     * This method will be called before any of the other methods.
     *
     * @param properties All properties from the configuration
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        String beginningDelimiter = properties.getProperty("beginningDelimiter");
        if (StringUtility.stringHasValue(beginningDelimiter)) {
            this.beginningDelimiter = beginningDelimiter;
        }
        String endingDelimiter = properties.getProperty("endingDelimiter");
        if (StringUtility.stringHasValue(endingDelimiter)) {
            this.endingDelimiter = endingDelimiter;
        }
    }

    /**
     * 给字段添加数据库备注
     * <p>
     * This method should add a Javadoc comment to the specified field. The field is related to the specified table and
     * is used to hold the value of the specified column.
     * <p>
     * <p>
     * <b>Important:</b> This method should add a the nonstandard JavaDoc tag "@mbg.generated" to the comment. Without
     * this tag, the Eclipse based Java merge feature will fail.
     *
     * @param field              the field
     * @param introspectedTable  the introspected table
     * @param introspectedColumn the field to db column
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        fieldAddDataBaseRemark(field, introspectedTable, introspectedColumn);
        fieldAddHibernateValidatorAnnotation(field, introspectedTable, introspectedColumn);

        //添加注解
        if (field.isTransient()) {
            //@Column
            field.addAnnotation("@Transient");
        }
        for (IntrospectedColumn column : introspectedTable.getPrimaryKeyColumns()) {
            if (introspectedColumn == column) {
                field.addAnnotation("@Id");
                break;
            }
        }
        String column = introspectedColumn.getActualColumnName();
        if (StringUtility.stringContainsSpace(column) || introspectedTable.getTableConfiguration().isAllColumnDelimitingEnabled()) {
            column = introspectedColumn.getContext().getBeginningDelimiter()
                    + column
                    + introspectedColumn.getContext().getEndingDelimiter();
        }
        if (!column.equals(introspectedColumn.getJavaProperty())) {
            //@Column
            field.addAnnotation("@Column(name = \"" + getDelimiterName(column) + "\")");
        } else if (StringUtility.stringHasValue(beginningDelimiter) || StringUtility.stringHasValue(endingDelimiter)) {
            field.addAnnotation("@Column(name = \"" + getDelimiterName(column) + "\")");
        }
        if (introspectedColumn.isIdentity()) {
            if (introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement().equals("JDBC")) {
                field.addAnnotation("@GeneratedValue(generator = \"JDBC\")");
            } else {
                field.addAnnotation("@GeneratedValue(strategy = GenerationType.IDENTITY)");
            }
        } else if (introspectedColumn.isSequenceColumn()) {
            //在 Oracle 中，如果需要是 SEQ_TABLENAME，那么可以配置为 select SEQ_{1} from dual
            String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
            String sql = MessageFormat.format(introspectedTable.getTableConfiguration().getGeneratedKey().getRuntimeSqlStatement(), tableName, tableName.toUpperCase());
            field.addAnnotation("@GeneratedValue(strategy = GenerationType.IDENTITY, generator = \"" + sql + "\")");
        }
    }

    /**
     * Example使用
     * Adds the field comment.
     *
     * @param field             the field
     * @param introspectedTable the introspected table
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    /**
     * 对生成的javaBean 类进行操作
     * Adds a comment for a model class.  The Java code merger should
     * be notified not to delete the entire class in case any manual
     * changes have been made.  So this method will always use the
     * "do not delete" annotation.
     * <p>
     * Because of difficulties with the Java file merger, the default implementation
     * of this method should NOT add comments.  Comments should only be added if
     * specifically requested by the user (for example, by enabling table remark comments).
     *
     * @param topLevelClass     the top level class
     * @param introspectedTable the introspected table
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (!topLevelClass.getImportedTypes().contains(javaValidationConstraintsPackage)) {
            topLevelClass.addImportedType(javaValidationConstraintsPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(hibernateValidatorConstraintsPackage)) {
            topLevelClass.addImportedType(hibernateValidatorConstraintsPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(customizeValidatorBaseValidGroup)) {
            topLevelClass.addImportedType(customizeValidatorBaseValidGroup);
        }
        if (!topLevelClass.getImportedTypes().contains(customizeValidatorConstraintsPackage)) {
            topLevelClass.addImportedType(customizeValidatorConstraintsPackage);
        }
        if (!topLevelClass.getImportedTypes().contains(dateUtil)) {
            topLevelClass.addImportedType(dateUtil);
        }
        if (!topLevelClass.getImportedTypes().contains(applicationConstantPackage)) {
            topLevelClass.addImportedType(applicationConstantPackage);
        }
    }

    /**
     * Example使用
     * Adds the inner class comment.
     *
     * @param innerClass        the inner class
     * @param introspectedTable the introspected table
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    /**
     * Adds the inner class comment.
     *
     * @param innerClass        the inner class
     * @param introspectedTable the introspected table
     * @param markAsDoNotDelete //
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

    }

    /**
     * Adds the enum comment.
     *
     * @param innerEnum         the inner enum
     * @param introspectedTable the introspected table
     */
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

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
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
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
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
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

    /**
     * Adds the general method comment.
     *
     * @param method            the method
     * @param introspectedTable the introspected table
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    /**
     * This method is called to add a file level comment to a generated java file. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the Java file merge function in Eclipse
     * does not deal with this comment. If you run the generator repeatedly, you will only retain the comment from the
     * initial run.
     * <p>
     * <p>
     * The default implementation does nothing.
     *
     * @param compilationUnit the compilation unit
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    /**
     * xml中的注释
     * This method should add a suitable comment as a child element of the specified xmlElement to warn users that the
     * element was generated and is subject to regeneration.
     *
     * @param xmlElement the xml element
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        xmlElement.addElement(new TextElement("<!--"));
        xmlElement.addElement(new TextElement("  WARNING - " + MergeConstants.NEW_ELEMENT_TAG));
        xmlElement.addElement(new TextElement("-->"));
    }

    /**
     * This method is called to add a comment as the first child of the root element. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the XML file merge function does not deal
     * with this comment. If you run the generator repeatedly, you will only retain the comment from the initial run.
     * <p>
     * <p>
     * The default implementation does nothing.
     *
     * @param rootElement the root element
     */
    @Override
    public void addRootComment(XmlElement rootElement) {

    }

    @SuppressWarnings("StringBufferReplaceableByString")
    private String getDelimiterName(String name) {
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(beginningDelimiter);
        nameBuilder.append(name);
        nameBuilder.append(endingDelimiter);
        return nameBuilder.toString();
    }

    /**
     * 删除标记
     *
     * @param javaElement       //
     * @param markAsDoNotDelete //
     */

    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge");
        }
        javaElement.addJavaDocLine(sb.toString());
    }


    private void fieldAddDataBaseRemark(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
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

    private void fieldAddHibernateValidatorAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        //introspectedColumn.getActualColumnName()          数据库，字段名   client_id
        //introspectedColumn.getJdbcTypeName()              数据库，字段，类型   BIGINT
        //introspectedColumn.isNullable()                   是否为空，true: 可以为空，false 不能为空
        //introspectedColumn.getLength()                    长度
        //introspectedColumn.getRemarks()                   备注
        //introspectedColumn.getDefaultValue()              缺省值
        //introspectedColumn.getJavaProperty()              java 字段名      id
        //introspectedColumn.getFullyQualifiedJavaType()    java，字段，类型    java.lang.Long

        SQLCommentJSON sqlCommentJSON = extractSQLCommentJSON(introspectedColumn.getRemarks());
        String javaBeanNameByCamelToUnderline = MyStringUtils.camelToUnderline(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
        String fieldNameByCamelToUnderline = MyStringUtils.camelToUnderline(field.getName());

        processAnnotationValidAllowData(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, sqlCommentJSON, field, introspectedTable, introspectedColumn);
        processAnnotationEmail(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, sqlCommentJSON, field, introspectedTable, introspectedColumn);
        processAnnotationValidDateTimeFormat(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, sqlCommentJSON, field, introspectedTable, introspectedColumn);
        processAnnotationNotNullOrNotBlank(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, sqlCommentJSON, field, introspectedTable, introspectedColumn);
        processAnnotationLengthOrValidLength(javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, sqlCommentJSON, field, introspectedTable, introspectedColumn);
    }


    private void processAnnotationValidAllowData(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, SQLCommentJSON sqlCommentJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (sqlCommentJSON == null || sqlCommentJSON.getDataList() == null || sqlCommentJSON.getDataList().isEmpty()) {
            return;
        }

        String validAllowDataMessageKey = String.format("%s_%s_ALLOW_DATA", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String validAllowDataMessageVal = "Only as follows {allowDataArray}.";

        StringBuffer stringBuffer = new StringBuffer();
        sqlCommentJSON.getDataList().forEach(data -> {
            String constantBeanName = String.format("%s%s", introspectedTable.getFullyQualifiedTable().getDomainObjectName(), "Constant");
            String constantName = String.format("%s_%s_%s", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline, data).toUpperCase();

            stringBuffer.append(constantBeanName).append(".").append(constantName).append(",");
            if (EntityPropertyType.String.name().equals(field.getType().getShortName())) {
                EntityProperty entityProperty = new EntityProperty()
                        .setType(EntityPropertyType.String)
                        .setName(constantName)
                        .setValue(data)
                        .setRemarks(introspectedColumn.getRemarks());
                applicationConstantMap.add(entityProperty);
            }
        });
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        field.addAnnotation("@ValidAllowData(allowDataArray = {" + substring + "}, message = \"{" + validAllowDataMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
        internationalizedMap.put(validAllowDataMessageKey, validAllowDataMessageVal);
    }


    private void processAnnotationEmail(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, SQLCommentJSON sqlCommentJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (sqlCommentJSON == null || sqlCommentJSON.getEmail() == null || !sqlCommentJSON.getEmail()) {
            return;
        }
        String emailMessageKey = String.format("%s_%s_EMAIL", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String emailMessageVal = "not a well-formed email address.";
        field.addAnnotation("@Email(message = \"{" + emailMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
        internationalizedMap.put(emailMessageKey, emailMessageVal);
    }

    private void processAnnotationValidDateTimeFormat(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, SQLCommentJSON sqlCommentJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String pattern = sqlCommentJSON != null && sqlCommentJSON.getPattern() != null && "".equals(sqlCommentJSON.getPattern().trim()) ? sqlCommentJSON.getPattern().trim() : null;

        String dateTimeFormatMessageKey = String.format("%s_%s_DATE_TIME_FORMAT", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String dateTimeFormatMessageVal = "Invalid time or date format error. pattern: {pattern}.";

        if (Date.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            if ("TIMESTAMP".equals(introspectedColumn.getJdbcTypeName())) {
                field.addAnnotation("@ValidDateTimeFormat(pattern = " + (pattern != null ? "\"pattern\"" : "DateUtil.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS") + " , message = \"{" + dateTimeFormatMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
                internationalizedMap.put(dateTimeFormatMessageKey, dateTimeFormatMessageVal);
            } else if ("DATE".equals(introspectedColumn.getJdbcTypeName())) {
                field.addAnnotation("@ValidDateTimeFormat(pattern = " + (pattern != null ? "\"pattern\"" : "DateUtil.DATE_PATTERN_YYYY_MM_DD") + " , message = \"{" + dateTimeFormatMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
                internationalizedMap.put(dateTimeFormatMessageKey, dateTimeFormatMessageVal);
            }
        }
    }


    private void processAnnotationNotNullOrNotBlank(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, SQLCommentJSON sqlCommentJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        boolean isNullable = introspectedColumn.isNullable();
        if (isNullable) {
            return;
        }

        String notNullMessageKey = String.format("%s_%s_NOT_NULL", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String notNullMessageVal = "Can not contain empty.";
        String notBlankMessageKey = String.format("%s_%s_NOT_BLANK", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String notBlankMessageVal = "Can not contain empty.";

        if (Date.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@NotNull(message = \"{" + notNullMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(notNullMessageKey, notNullMessageVal);
        } else if (Integer.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@NotNull(message = \"{" + notNullMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(notNullMessageKey, notNullMessageVal);
        } else if (Long.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@NotNull(message = \"{" + notNullMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(notNullMessageKey, notNullMessageVal);
        } else if (String.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@NotBlank(message = \"{" + notBlankMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(notBlankMessageKey, notBlankMessageVal);
        }
    }

    private void processAnnotationLengthOrValidLength(String javaBeanNameByCamelToUnderline, String fieldNameByCamelToUnderline, SQLCommentJSON sqlCommentJSON, Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        Integer lengthMin = sqlCommentJSON != null && sqlCommentJSON.getMin() != null ? sqlCommentJSON.getMin() : null;
        Integer lengthMax = sqlCommentJSON != null && sqlCommentJSON.getMax() != null ? sqlCommentJSON.getMax() : introspectedColumn.getLength();

        String validLengthMessageKey = String.format("%s_%s_Length", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String validLengthMessageVal = "data length must be between {min} and {max} bit.";

        String lengthMessageKey = String.format("%s_%s_Length", javaBeanNameByCamelToUnderline, fieldNameByCamelToUnderline).toUpperCase();
        String lengthMessageVal = "data length must be between {min} and {max} bit.";

        if (Integer.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@ValidLength(" + (lengthMin != null ? "min = " + lengthMin + ", " : "") + "max = " + lengthMax + ", message = \"{" + validLengthMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(validLengthMessageKey, validLengthMessageVal);
        } else if (Long.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@ValidLength(" + (lengthMin != null ? "min = " + lengthMin + ", " : "") + "max = " + lengthMax + ", message = \"{" + validLengthMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(validLengthMessageKey, validLengthMessageVal);
        } else if (String.class.getTypeName().equals(field.getType().getFullyQualifiedName())) {
            field.addAnnotation("@Length(" + (lengthMin != null ? "min = " + lengthMin + ", " : "") + "max = " + lengthMax + ", message = \"{" + lengthMessageKey + "}\", groups = {IBaseValidGroup.Add.class, IBaseValidGroup.Update.class})");
            internationalizedMap.put(lengthMessageKey, lengthMessageVal);
        }
    }


    private SQLCommentJSON extractSQLCommentJSON(String introspectedColumnRemarks) {
        if (introspectedColumnRemarks == null || "".equals(introspectedColumnRemarks.trim())) {
            return null;
        }
        int indexOfPrefix = introspectedColumnRemarks.indexOf("{");
        int indexOfSuffix = introspectedColumnRemarks.indexOf("}");
        if (indexOfPrefix < 0 || indexOfSuffix < 0) {
            return null;
        }
        String extractSQLCommentJSONStr = introspectedColumnRemarks.substring(introspectedColumnRemarks.indexOf("{"), (introspectedColumnRemarks.indexOf("}") + 1));
        return JSON.parseObject(extractSQLCommentJSONStr, SQLCommentJSON.class);
    }

    public static Map<String, String> getInternationalizedMap() {
        return internationalizedMap;
    }

    public static List<EntityProperty> getApplicationConstantMap() {
        return applicationConstantMap;
    }
}
