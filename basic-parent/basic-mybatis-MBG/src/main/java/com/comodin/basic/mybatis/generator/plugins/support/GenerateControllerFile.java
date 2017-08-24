package com.comodin.basic.mybatis.generator.plugins.support;

import com.comodin.basic.mybatis.generator.util.PluginsUtils;
import com.comodin.basic.util.freemarker.Entity;
import com.comodin.basic.util.freemarker.EntityType;
import com.comodin.basic.util.freemarker.FreeMarkerUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.File;
import java.util.*;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GenerateControllerFile {

    public static void generateControllerFile(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        //String outFileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\java\\com\\comodin\\fleet\\controller";
        String outFileRootDir = PluginsUtils.getControllerFileDir();
        String outFileExtensionName = ".java";

        //String outFileNamePrefix = "";
        //String outFileNameSuffix = "Controller";
        //String outFileName = String.format("%s%s%s", outFileNamePrefix, javaBeanName, outFileNameSuffix);
        String outFileName = PluginsUtils.getControllerClassName(javaBeanName);

        File outFile = new File(outFileRootDir, String.format("%s%s", outFileName, outFileExtensionName));

        Set<String> importPackageSet = new HashSet<>();
        //importPackageSet.add("com.comodin.basic.vo.BaseVo");
        //importPackageSet.add("org.springframework.stereotype.Controller");
        //importPackageSet.add("org.springframework.web.bind.annotation.RequestMapping");
        //importPackageSet.add("com.comodin.fleet.bean.CrewBean");
        //importPackageSet.add("com.comodin.basic.controller.AbstractBaseController");

        importPackageSet.add(PluginsUtils.PACKAGE_BASE_VO);
        importPackageSet.add(PluginsUtils.PACKAGE_SPRING_ANNOTATION_CONTROLLER);
        importPackageSet.add(PluginsUtils.PACKAGE_SPRING_ANNOTATION_REQUEST_MAPPING);
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importPackageSet.add(entityType.getFullyQualifiedName());
        importPackageSet.add(PluginsUtils.getControllerExtendsSubClass());


        Map<String, Entity> dataModel = new HashMap<>();
        Entity entity = new Entity(EntityType.Class);
        entity.setPackageName(PluginsUtils.getControllerPackage());
        entity.setClassName(outFileName);
        entity.setImportPackageSet(importPackageSet);
        entity.setClassAnnotationSet(new HashSet<>(Arrays.asList("@RequestMapping(\"/"+PluginsUtils.getControllerRequestMappingModuleName(javaBeanName)+"\")", "@Controller")));

        FullyQualifiedJavaType controllerExtendsSubClassType = new FullyQualifiedJavaType(PluginsUtils.getControllerExtendsSubClass());
        entity.setSuperClass(controllerExtendsSubClassType.getShortName() + "<" + javaBeanName + ", BaseVo<" + javaBeanName + ">>");
        entity.setTemporaryMethodBodySet(new HashSet<>(Collections.singletonList("@Override protected String getModuleName() {return \""+PluginsUtils.getControllerRequestMappingModuleName(javaBeanName)+"\";}")));
        dataModel.put("dataModel", entity);

        FreeMarkerUtils freeMarkerUtils = FreeMarkerUtils.getInstance("/template/freemarker");
        freeMarkerUtils.crateFile(dataModel, "freemarker-template-java.ftl", outFile.getPath());
    }
}
