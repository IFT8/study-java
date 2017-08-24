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
public class GenerateServiceImplementsFile {

    public static void generateServiceImplementsFile(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        //String outFileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\java\\com\\comodin\\fleet\\service\\impl";
        String outFileRootDir = PluginsUtils.getServiceImplementsFileDir();
        String outFileExtensionName = ".java";

        //String outFileNamePrefix = "";
        //String outFileNameSuffix = "Service";
        //String outFileName = String.format("%s%s%s", outFileNamePrefix, javaBeanName, outFileNameSuffix);
        String outFileName = PluginsUtils.getServiceImplementsClassName(javaBeanName);

        File outFile = new File(outFileRootDir, String.format("%s%s", outFileName, outFileExtensionName));

        Set<String> importPackageSet = new HashSet<>();
        //importPackageSet.add("com.comodin.basic.vo.BaseVo");
        //importPackageSet.add("org.springframework.stereotype.Service");
        //importPackageSet.add("com.comodin.fleet.bean.CrewBean");
        //importPackageSet.add("com.comodin.basic.service.AbstractBaseService");
        //importPackageSet.add("com.comodin.fleet.service.ICrewBeanService");

        importPackageSet.add(PluginsUtils.PACKAGE_BASE_VO);
        importPackageSet.add(PluginsUtils.PACKAGE_SPRING_ANNOTATION_SERVICE);
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importPackageSet.add(entityType.getFullyQualifiedName());
        importPackageSet.add(PluginsUtils.getServiceImplementsExtendsSubClass());
        importPackageSet.add(PluginsUtils.getServiceInterfacePackage() + "." + PluginsUtils.getServiceInterfaceClassName(javaBeanName));


        Map<String, Entity> dataModel = new HashMap<>();
        Entity entity = new Entity(EntityType.Class);
        entity.setPackageName(PluginsUtils.getServiceImplementsPackage());
        entity.setClassName(outFileName);
        entity.setImportPackageSet(importPackageSet);
        entity.setClassAnnotationSet(new HashSet<>(Collections.singletonList("@Service")));
        FullyQualifiedJavaType serviceImplementsExtendsSubClassType = new FullyQualifiedJavaType(PluginsUtils.getServiceImplementsExtendsSubClass());
        entity.setSuperClass(serviceImplementsExtendsSubClassType.getShortName() + "<" + javaBeanName + ", BaseVo<" + javaBeanName + ">>");
        entity.setImplementsInterfaceClassSet(new HashSet<>(Collections.singletonList(PluginsUtils.getServiceInterfaceClassName(javaBeanName))));
        dataModel.put("dataModel", entity);

        FreeMarkerUtils freeMarkerUtils = FreeMarkerUtils.getInstance("/template");
        freeMarkerUtils.crateFile(dataModel, "freemarker-template-java.ftl", outFile.getPath());
    }
}
