package com.comodin.basic.mybatis.generator.plugins;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.io.*;
import java.net.URLDecoder;
import java.util.*;

public class HibernateValidatorPlugin extends PluginAdapter {
    private FullyQualifiedJavaType hibernateValidatorConstraints = new FullyQualifiedJavaType("org.hibernate.validator.constraints.*");
    private FullyQualifiedJavaType baseValid = new FullyQualifiedJavaType("cn.assupg.basic.validation.IBaseValid");
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
    public void setProperties(Properties properties) {
        super.setProperties(properties);

        String mappers = this.properties.getProperty("mappers");
        if (StringUtility.stringHasValue(mappers)) {
            for (String mapper : mappers.split(",")) {
                //this.mappers.add(mapper);
            }
        } else {
            //throw new RuntimeException("Mapper插件缺少必要的mappers属性!");
        }
    }

    /**
     * 1、插件通过默认的构造函数创建
     * 2、setContext方法被调用
     * 3、setProperties方法被调用
     * 4、validate方法被调用。如果该方法返回false ，那么插件中的其他方法都不会再被调用。
     *
     * @param warnings
     *
     * @return
     */
    public boolean validate(List<String> warnings) {
        return true;
    }


    /**
     * 5.3 模型方法
     * 1.modelFieldGenerated, modelGetterMethodGenerated, modelSetterMethodGenerated for each field in the class
     *
     * @param field
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     *
     * @return
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        addHibernateValidator(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
        return true;
    }


    //链式编程
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable().getDomainObjectName()));
        method.addBodyLine("return this;");
        return true;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        generateInternationalizedFile(introspectedTable);
        generateDaoFile(introspectedTable);
        generateServiceFile(introspectedTable);
        generateControllerFile(introspectedTable);
        generateJspFile(introspectedTable);
        generateJsFile(introspectedTable);
        return super.contextGenerateAdditionalJavaFiles(introspectedTable);
    }


    private void addHibernateValidator(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        if (!topLevelClass.getImportedTypes().contains(hibernateValidatorConstraints)) {
            topLevelClass.addImportedType(hibernateValidatorConstraints);
        }
        if (!topLevelClass.getImportedTypes().contains(baseValid)) {
            topLevelClass.addImportedType(baseValid);
        }

        //introspectedColumn.getActualColumnName()          数据库，字段名   client_id
        //introspectedColumn.getJdbcTypeName()              数据库，字段，类型   BIGINT
        //introspectedColumn.isNullable()                   是否为空，true: 可以为空，flase 不能为空
        //introspectedColumn.getLength()                    长度
        //introspectedColumn.getRemarks()                   备注
        //introspectedColumn.getDefaultValue()              缺省值
        //introspectedColumn.getJavaProperty()              java 字段名      id
        //introspectedColumn.getFullyQualifiedJavaType()    java，字段，类型    java.lang.Long

        String column = introspectedColumn.getActualColumnName();
        if (StringUtility.stringContainsSpace(column) || introspectedTable.getTableConfiguration().isAllColumnDelimitingEnabled()) {
            column = introspectedColumn.getContext().getBeginningDelimiter() + column + introspectedColumn.getContext().getEndingDelimiter();
        }

        //得到当前，表对应的Bean名称
        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        System.out.println(introspectedTable.getFullyQualifiedTable().getDomainObjectName());

        if (!column.equals(introspectedColumn.getJavaProperty())) {
            boolean introspectedColumnNullable = introspectedColumn.isNullable();
            int introspectedColumnLength = introspectedColumn.getLength();

            if ("java.lang.Long".equals(field.getType().getFullyQualifiedName())) {
                String messageKey = javaBeanName + "_" + field.getName() + "_Length";
                String messageValue = javaBeanName + "_" + field.getName() + "{min}-{max}";
                map.put(messageKey, messageValue);
                field.addAnnotation("@Length(min = 0, max = " + introspectedColumnLength + ", message = \"{" + messageKey + "}\", groups = {IBaseValid" + ".ICreateValid.class})");

            }

            if ("java.lang.String".equals(field.getType().getFullyQualifiedName())) {
                String messageKey = javaBeanName + "_" + field.getName() + "_Length";
                String messageValue = javaBeanName + "_" + field.getName() + "{min}-{max}";
                map.put(messageKey, messageValue);
                field.addAnnotation("@Length(min = 0, max = " + introspectedColumnLength + ", message = \"{" + javaBeanName + "_" + field.getName() + "_Length}\", groups = {IBaseValid.ICreateValid.class})");
            }
            //@NotBlank(message = "{crewBean.username.NotBlank}", groups = {IBaseValid.ICreateValid.class})
            //@Length(min = 3, max = 20, message = "{crewBean.username.Length}", groups = {IBaseValid.ICreateValid.class})
        }
    }

    private void generateInternationalizedFile(IntrospectedTable introspectedTable) {
        String templateDir = null;
        try {
            templateDir = URLDecoder.decode(com.comodin.basic.mybatis.generator.freemarker.Main.class.getClass().getResource("/").getPath(), "UTF-8") + "/template";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        // 创建.java类文件
        String fileRootDir = "D:/ideaProjects/assupg/basic-projects/basic-mybatis-MBG/src/main/resources/i18n/";
        File outDirFile = new File(fileRootDir);
        if (!outDirFile.exists()) {
            outDirFile.mkdir();
        }

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        File javaFile = new File(fileRootDir + "/", javaBeanName + ".properties");


        Configuration cfg = new Configuration();
        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate("bean-web-i18n.ftl");

            // 步骤三：创建 数据模型
            Map<String, Map<String, String>> root = new HashMap<>();
            root.put("javaBeanFieldsMaps", map);

            // 步骤四：合并 模板 和 数据模型
            // 创建.java类文件
            if (javaFile != null) {
                Writer javaWriter = new FileWriter(javaFile);
                template.process(root, javaWriter);
                javaWriter.flush();
                System.out.println("文件生成路径： " + javaFile.getCanonicalPath());

                javaWriter.close();
            }
            // 输出到Console控制台
            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
            out.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private void generateDaoFile(IntrospectedTable introspectedTable) {

    }

    private void generateServiceFile(IntrospectedTable introspectedTable) {

    }

    private void generateControllerFile(IntrospectedTable introspectedTable) {

    }

    private void generateJspFile(IntrospectedTable introspectedTable) {

    }

    private void generateJsFile(IntrospectedTable introspectedTable) {

    }

}