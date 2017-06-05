package com.comodin.basic.mybatis.generator.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static String templateDir;
    private static File javaFile = null;

    public static void main(String[] args) throws UnsupportedEncodingException {
        templateDir = URLDecoder.decode(Main.class.getClass().getResource("/").getPath(), "UTF-8") + "/template";
        //testHtml();
        testBean();
    }

    public static void testBean() {
        Configuration cfg = new Configuration();
        try {
            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            // 步骤二：获取 模板文件
            Template template = cfg.getTemplate("test-entity.ftl");

            // 步骤三：创建 数据模型
            Map<String, Object> root = createDataModel();

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

    /**
     * 创建数据模型
     *
     * @return
     */
    private static Map<String, Object> createDataModel() {
        Map<String, Object> root = new HashMap<>();
        Entity user = new Entity();
        user.setJavaPackage("com.study.entity"); // 创建包名
        user.setClassName("User");  // 创建类名
        user.setConstructors(true); // 是否创建构造函数
        // user.setSuperclass(person);

        List<Property> propertyList = new ArrayList<>();

        // 创建实体属性一
        Property attribute1 = new Property();
        attribute1.setJavaType("String");
        attribute1.setPropertyName("name");
        attribute1.setPropertyEnumType(PropertyEnumType.String);

        // 创建实体属性二
        Property attribute2 = new Property();
        attribute2.setJavaType("int");
        attribute2.setPropertyName("age");
        attribute2.setPropertyEnumType(PropertyEnumType.Int);

        propertyList.add(attribute1);
        propertyList.add(attribute2);

        // 将属性集合添加到实体对象中
        user.setPropertyList(propertyList);

        // 创建.java类文件
        File outDirFile = new File("D:\\ideaProjects\\assupg\\basic-projects\\basic-mybatis-MBG\\src\\main\\java");
        if (!outDirFile.exists()) {
            outDirFile.mkdir();
        }
        javaFile = toJavaFilename(outDirFile, user.getJavaPackage(), user.getClassName());
        root.put("entity", user);
        return root;
    }


    /**
     * 创建.java文件所在路径 和 返回.java文件File对象
     *
     * @param outDirFile    生成文件路径
     * @param javaPackage   java包名
     * @param javaClassName java类名
     *
     * @return
     */
    private static File toJavaFilename(File outDirFile, String javaPackage, String javaClassName) {
        String packageSubPath = javaPackage.replace('.', '/');
        File packagePath = new File(outDirFile, packageSubPath);
        File file = new File(packagePath, javaClassName + ".java");
        if (!packagePath.exists()) {
            packagePath.mkdirs();
        }
        return file;
    }


    public static void testHtml() {
        try {
            Configuration cfg = new Configuration();
            // 指定模板文件从何处加载的数据源，这里设置成一个文件目录
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            // 获取或创建模板
            Template template = cfg.getTemplate("test-html.ftl");

            // 创建数据模型
            Map<String, Object> root = new HashMap<>();
            root.put("user", "Big Joe1");

            Map<String, String> latest = new HashMap<>();
            latest.put("url", "http://blog.csdn.net/janice0529/article/details/products/greenmouse.html");
            latest.put("name", "green mouse");
            root.put("latestProduct", latest);

            // 将模板和数据模型合并 输出到Console
            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}