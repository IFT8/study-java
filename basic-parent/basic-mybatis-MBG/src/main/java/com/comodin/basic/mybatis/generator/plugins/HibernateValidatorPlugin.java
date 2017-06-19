package com.comodin.basic.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.*;

public class HibernateValidatorPlugin extends PluginAdapter {

    private Set<String> mappers = new HashSet<String>();
    private boolean caseSensitive = false;
    //开始的分隔符，例如mysql为`，sqlserver为[
    private String beginningDelimiter = "";
    //结束的分隔符，例如mysql为`，sqlserver为]
    private String endingDelimiter = "";
    //数据库模式
    private String schema;
    //注释生成器
    private CommentGeneratorConfiguration commentCfg;

    private FullyQualifiedJavaType hibernateValidatorConstraints = new FullyQualifiedJavaType("org.hibernate.validator.constraints.*");
    private FullyQualifiedJavaType baseValid = new FullyQualifiedJavaType("com.comodin.basic.validation.IBaseValid");
    Map<String, String> map = new HashMap<>();
    private boolean generateDao = true;
    private String daoInterfacePackage = "";
    private String daoInterfaceImplPackage = "";

    private boolean generateService = true;
    private String serviceInterfacePackage = "";
    private String serviceInterfaceImplPackage = "";

    private boolean generateController = true;
    private String controllerPackage = "";

    private boolean generateI18n = true;
    private String generateI18nLanguages = "";
    private String i18nDir = "";

    private boolean generateJsp = true;
    private String jspDir = "";

    private boolean generateJs = true;
    private String jsDir = "";

    @Override
    public void setContext(Context context) {
        super.setContext(context);
        //设置默认的注释生成器
        commentCfg = new CommentGeneratorConfiguration();
        commentCfg.setConfigurationType(MyMapperCommentGenerator.class.getCanonicalName());
        context.setCommentGeneratorConfiguration(commentCfg);
        //支持oracle获取注释#114
        context.getJdbcConnectionConfiguration().addProperty("remarksReporting", "true");
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String mappers = this.properties.getProperty("mappers");
        if (StringUtility.stringHasValue(mappers)) {
            for (String mapper : mappers.split(",")) {
                this.mappers.add(mapper);
            }
        } else {
            throw new RuntimeException("Mapper插件缺少必要的mappers属性!");
        }
        String caseSensitive = this.properties.getProperty("caseSensitive");
        if (StringUtility.stringHasValue(caseSensitive)) {
            this.caseSensitive = caseSensitive.equalsIgnoreCase("TRUE");
        }
        String beginningDelimiter = this.properties.getProperty("beginningDelimiter");
        if (StringUtility.stringHasValue(beginningDelimiter)) {
            this.beginningDelimiter = beginningDelimiter;
        }
        commentCfg.addProperty("beginningDelimiter", this.beginningDelimiter);
        String endingDelimiter = this.properties.getProperty("endingDelimiter");
        if (StringUtility.stringHasValue(endingDelimiter)) {
            this.endingDelimiter = endingDelimiter;
        }
        commentCfg.addProperty("endingDelimiter", this.endingDelimiter);
        String schema = this.properties.getProperty("schema");
        if (StringUtility.stringHasValue(schema)) {
            this.schema = schema;
        }
    }

    public String getDelimiterName(String name) {
        StringBuilder nameBuilder = new StringBuilder();
        if (StringUtility.stringHasValue(schema)) {
            nameBuilder.append(schema);
            nameBuilder.append(".");
        }
        nameBuilder.append(beginningDelimiter);
        nameBuilder.append(name);
        nameBuilder.append(endingDelimiter);
        return nameBuilder.toString();
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 生成的Mapper接口
     *
     * @param interfaze
     * @param topLevelClass
     * @param introspectedTable
     *
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //获取实体类
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        //import接口
        for (String mapper : mappers) {
            interfaze.addImportedType(new FullyQualifiedJavaType(mapper));
            interfaze.addSuperInterface(new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
        }
        //import实体类
        interfaze.addImportedType(entityType);
        return true;
    }

    /**
     * 处理实体类的包和@Table注解
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //引入JPA注解
        topLevelClass.addImportedType("javax.persistence.*");
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
        //如果包含空格，或者需要分隔符，需要完善
        if (StringUtility.stringContainsSpace(tableName)) {
            tableName = context.getBeginningDelimiter()
                    + tableName
                    + context.getEndingDelimiter();
        }
        //是否忽略大小写，对于区分大小写的数据库，会有用
        if (caseSensitive && !topLevelClass.getType().getShortName().equals(tableName)) {
            topLevelClass.addAnnotation("@Table(name = \"" + getDelimiterName(tableName) + "\")");
        } else if (!topLevelClass.getType().getShortName().equalsIgnoreCase(tableName)) {
            topLevelClass.addAnnotation("@Table(name = \"" + getDelimiterName(tableName) + "\")");
        } else if (StringUtility.stringHasValue(schema)
                || StringUtility.stringHasValue(beginningDelimiter)
                || StringUtility.stringHasValue(endingDelimiter)) {
            topLevelClass.addAnnotation("@Table(name = \"" + getDelimiterName(tableName) + "\")");
        }
    }

    /**
     * 生成基础实体类
     *
     * @param topLevelClass
     * @param introspectedTable
     *
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 生成实体类注解KEY对象
     *
     * @param topLevelClass
     * @param introspectedTable
     *
     * @return
     */
    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 生成带BLOB字段的对象
     *
     * @param topLevelClass
     * @param introspectedTable
     *
     * @return
     */
    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return false;
    }

    //下面所有return false的方法都不生成。这些都是基础的CRUD方法，使用通用Mapper实现
    @Override
    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientSelectAllMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapSelectAllElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean providerApplyWhereMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean providerInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean providerUpdateByPrimaryKeySelectiveMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }
}


///**
// * 1、插件通过默认的构造函数创建
// * 2、setContext方法被调用
// * 3、setProperties方法被调用
// * 4、validate方法被调用。如果该方法返回false ，那么插件中的其他方法都不会再被调用。
// *
// * @param warnings
// *
// * @return
// */
//public boolean validate(List<String> warnings) {
//    return true;
//}
//
//
///**
// * 5.3 模型方法
// * 1.modelFieldGenerated, modelGetterMethodGenerated, modelSetterMethodGenerated for each field in the class
// *
// * @param field
// * @param topLevelClass
// * @param introspectedColumn
// * @param introspectedTable
// * @param modelClassType
// *
// * @return
// */
//@Override
//public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
//    addHibernateValidator(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
//    return true;
//}
//
//
////链式编程
//@Override
//public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
//    method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable().getDomainObjectName()));
//    method.addBodyLine("return this;");
//    return true;
//}
//
//@Override
//public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
//    //generateInternationalizedFile(introspectedTable);
//    generateDaoFile(introspectedTable);
//    //generateServiceFile(introspectedTable);
//    //generateControllerFile(introspectedTable);
//    //generateJspFile(introspectedTable);
//    //generateJsFile(introspectedTable);
//    return super.contextGenerateAdditionalJavaFiles(introspectedTable);
//}
//
//
//private void addHibernateValidator(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
//    if (!topLevelClass.getImportedTypes().contains(hibernateValidatorConstraints)) {
//        topLevelClass.addImportedType(hibernateValidatorConstraints);
//    }
//    if (!topLevelClass.getImportedTypes().contains(baseValid)) {
//        topLevelClass.addImportedType(baseValid);
//    }
//
//    //introspectedColumn.getActualColumnName()          数据库，字段名   client_id
//    //introspectedColumn.getJdbcTypeName()              数据库，字段，类型   BIGINT
//    //introspectedColumn.isNullable()                   是否为空，true: 可以为空，flase 不能为空
//    //introspectedColumn.getLength()                    长度
//    //introspectedColumn.getRemarks()                   备注
//    //introspectedColumn.getDefaultValue()              缺省值
//    //introspectedColumn.getJavaProperty()              java 字段名      id
//    //introspectedColumn.getFullyQualifiedJavaType()    java，字段，类型    java.lang.Long
//
//    String column = introspectedColumn.getActualColumnName();
//    if (StringUtility.stringContainsSpace(column) || introspectedTable.getTableConfiguration().isAllColumnDelimitingEnabled()) {
//        column = introspectedColumn.getContext().getBeginningDelimiter() + column + introspectedColumn.getContext().getEndingDelimiter();
//    }
//
//    //得到当前，表对应的Bean名称
//    String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
//    System.out.println(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
//
//    if (!column.equals(introspectedColumn.getJavaProperty())) {
//        boolean introspectedColumnNullable = introspectedColumn.isNullable();
//        int introspectedColumnLength = introspectedColumn.getLength();
//
//        if ("java.lang.Long".equals(field.getType().getFullyQualifiedName())) {
//            String messageKey = javaBeanName + "_" + field.getName() + "_Length";
//            String messageValue = javaBeanName + "_" + field.getName() + "{min}-{max}";
//            map.put(messageKey, messageValue);
//            field.addAnnotation("@Length(min = 0, max = " + introspectedColumnLength + ", message = \"{" + messageKey + "}\", groups = {IBaseValid" + ".Add.class})");
//
//        }
//
//        if ("java.lang.String".equals(field.getType().getFullyQualifiedName())) {
//            String messageKey = javaBeanName + "_" + field.getName() + "_Length";
//            String messageValue = javaBeanName + "_" + field.getName() + "{min}-{max}";
//            map.put(messageKey, messageValue);
//            field.addAnnotation("@Length(min = 0, max = " + introspectedColumnLength + ", message = \"{" + javaBeanName + "_" + field.getName() + "_Length}\", groups = {IBaseValid.Add.class})");
//        }
//        //@NotBlank(message = "{crewBean.username.NotBlank}", groups = {IBaseValid.ICreateValid.class})
//        //@Length(min = 3, max = 20, message = "{crewBean.username.Length}", groups = {IBaseValid.ICreateValid.class})
//    }
//}
//
//private void generateInternationalizedFile(IntrospectedTable introspectedTable) {
//    String templateDir = null;
//    try {
//        templateDir = URLDecoder.decode(com.comodin.basic.mybatis.generator.freemarker.Main.class.getClass().getResource("/").getPath(), "UTF-8") + "/template";
//    } catch (UnsupportedEncodingException e) {
//        e.printStackTrace();
//    }
//
//
//    // 创建.java类文件
//    String fileRootDir = "D:/ideaProjects/assupg/basic-projects/basic-mybatis-MBG/src/main/resources/i18n/";
//    File outDirFile = new File(fileRootDir);
//    if (!outDirFile.exists()) {
//        outDirFile.mkdir();
//    }
//
//    String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
//    File javaFile = new File(fileRootDir + "/", javaBeanName + ".properties");
//
//
//    Configuration cfg = new Configuration();
//    try {
//        // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
//        cfg.setDirectoryForTemplateLoading(new File(templateDir));
//        cfg.setObjectWrapper(new DefaultObjectWrapper());
//
//        // 步骤二：获取 模板文件
//        Template template = cfg.getTemplate("bean-web-i18n.ftl");
//
//        // 步骤三：创建 数据模型
//        Map<String, Map<String, String>> root = new HashMap<>();
//        root.put("javaBeanFieldsMaps", map);
//
//        // 步骤四：合并 模板 和 数据模型
//        // 创建.java类文件
//        if (javaFile != null) {
//            Writer javaWriter = new FileWriter(javaFile);
//            template.process(root, javaWriter);
//            javaWriter.flush();
//            System.out.println("文件生成路径： " + javaFile.getCanonicalPath());
//
//            javaWriter.close();
//        }
//        // 输出到Console控制台
//        Writer out = new OutputStreamWriter(System.out);
//        template.process(root, out);
//        out.flush();
//        out.close();
//    } catch (IOException | TemplateException e) {
//        e.printStackTrace();
//    }
//}
//
//private void generateDaoFile(IntrospectedTable introspectedTable) {
//
//}
//
//private void generateServiceFile(IntrospectedTable introspectedTable) {
//
//}
//
//private void generateControllerFile(IntrospectedTable introspectedTable) {
//
//}
//
//private void generateJspFile(IntrospectedTable introspectedTable) {
//
//}
//
//private void generateJsFile(IntrospectedTable introspectedTable) {
//
//}

//}