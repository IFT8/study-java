package com.comodin.basic.mybatis.generator.plugins;

import com.comodin.basic.mybatis.generator.freemarker.Entity;
import com.comodin.basic.mybatis.generator.freemarker.EntityProperty;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.mybatis.generator.api.IntrospectedColumn;
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
import tk.mybatis.mapper.MapperException;

import java.io.*;
import java.util.*;

/**
 * 通用Mapper生成器插件
 *
 * @author liuzh
 */
@SuppressWarnings({"Convert2Diamond", "unused"})
public class ComodinPlugin extends PluginAdapter {
    private Set<String> mappers = new HashSet<String>();
    private boolean caseSensitive = false;
    //开始的分隔符，例如mysql为`，sqlServer为 [
    private String beginningDelimiter = "";
    //结束的分隔符，例如mysql为`，sqlServer为 ]
    private String endingDelimiter = "";
    //数据库模式
    private String schema;

    //注释生成器
    private CommentGeneratorConfiguration commentCfg;

    @Override
    public void setContext(Context context) {
        super.setContext(context);

        //设置默认的注释生成器
        commentCfg = new CommentGeneratorConfiguration();
        commentCfg.setConfigurationType(ComodinCommentGenerator.class.getCanonicalName());
        context.setCommentGeneratorConfiguration(commentCfg);

        //支持oracle获取注释#114
        context.getJdbcConnectionConfiguration().addProperty("remarksReporting", "true");
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String mappers = this.properties.getProperty("mappers");
        if (StringUtility.stringHasValue(mappers)) {
            this.mappers.addAll(Arrays.asList(mappers.split(",")));
        } else {
            throw new MapperException("Mapper插件缺少必要的mappers属性!");
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

    private String getDelimiterName(String name) {
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
     * @param interfaze         //
     * @param topLevelClass     //
     * @param introspectedTable //
     *
     * @return //
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
     * @param topLevelClass     //
     * @param introspectedTable //
     */
    private void processEntityClass(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addAnnotation("@SuppressWarnings(\"unused\")");
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

        generateInternationalizedFile("", introspectedTable);
        generateInternationalizedFile("en_US", introspectedTable);
        generateInternationalizedFile("zh_CN", introspectedTable);
        generateInternationalizedFile("es_MX", introspectedTable);
        generateApplicationConstantFile(introspectedTable);
    }

    /**
     * 生成基础实体类
     *
     * @param topLevelClass     //
     * @param introspectedTable //
     *
     * @return //
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 生成实体类注解KEY对象
     *
     * @param topLevelClass     //
     * @param introspectedTable //
     *
     * @return //
     */
    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        processEntityClass(topLevelClass, introspectedTable);
        return true;
    }

    /**
     * 生成带BLOB字段的对象
     *
     * @param topLevelClass     //
     * @param introspectedTable //
     *
     * @return //
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

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        method.setReturnType(new FullyQualifiedJavaType(introspectedTable.getFullyQualifiedTable().getDomainObjectName()));
        method.addBodyLine("return this;");
        return super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }


    private void generateInternationalizedFile(String language, IntrospectedTable introspectedTable) {
        String templateDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\resources\\template";

        // 创建.java类文件
        String fileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\resources\\i18n";
        File outDirFile = new File(fileRootDir);
        if (!outDirFile.exists()) {
            outDirFile.mkdir();
        }

        File javaFile;
        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        if (language == null || "".equals(language.trim())) {
            javaFile = new File(fileRootDir, javaBeanName + ".properties");
        } else {
            javaFile = new File(fileRootDir, javaBeanName + "_" + language + ".properties");
        }

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate("bean-i18n.ftl");

            // 步骤三：创建 数据模型
            Map<String, Map<String, String>> root = new HashMap<>();
            root.put("javaBeanFieldsMaps", ComodinCommentGenerator.getInternationalizedMap());

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

    private void generateApplicationConstantFile(IntrospectedTable introspectedTable) {
        String templateDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\resources\\template";

        // 创建.java类文件
        String fileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\java\\com\\comodin\\fleet\\constant";
        File outDirFile = new File(fileRootDir);
        if (!outDirFile.exists()) {
            outDirFile.mkdir();
        }

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        File javaFile = new File(fileRootDir, javaBeanName + "Constant" + ".java");


        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate("bean-constant.ftl");

            // 步骤三：创建 数据模型
            Map<String, Object> root = new HashMap<>();
            Entity user = new Entity();
            user.setJavaPackage("com.comodin.fleet.constant");  // 创建包名
            user.setClassName(javaBeanName + "Constant");       // 创建类名
            user.setConstructors(false);                        // 是否创建构造函数
            List<EntityProperty> propertyList = ComodinCommentGenerator.getApplicationConstantMap();
            user.setPropertyList(propertyList);
            root.put("entity", user);

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
}