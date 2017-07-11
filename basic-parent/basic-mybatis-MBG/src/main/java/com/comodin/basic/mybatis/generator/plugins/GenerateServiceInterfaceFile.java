package com.comodin.basic.mybatis.generator.plugins;

import com.comodin.basic.util.freemarker.Entity;
import com.comodin.basic.util.freemarker.EntityType;
import com.comodin.basic.util.freemarker.FreeMarkerUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GenerateServiceInterfaceFile {

    public static void generateApplicationServiceInterfaceFile(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        //String outFileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\java\\com\\comodin\\fleet\\service";
        String outFileRootDir = PluginsUtils.getServiceInterfaceFileDir();
        String outFileExtensionName = ".java";

        //String outFileNamePrefix = "I";
        //String outFileNameSuffix = "Service";
        //String outFileName = String.format("%s%s%s", outFileNamePrefix, javaBeanName, outFileNameSuffix);
        String outFileName = PluginsUtils.getServiceInterfaceClassName(javaBeanName);

        File outFile = new File(outFileRootDir, String.format("%s%s", outFileName, outFileExtensionName));

        Set<String> importPackageSet = new HashSet<>();
        //importPackageSet.add("com.comodin.basic.service.IBaseService");
        //importPackageSet.add("com.comodin.basic.vo.BaseVo");
        //importPackageSet.add("com.comodin.fleet.bean.CrewBean");
        importPackageSet.addAll(PluginsUtils.getServiceInterfaceExtendsInterfaceSet());
        importPackageSet.add(PluginsUtils.PACKAGE_BASE_VO);
        FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importPackageSet.add(entityType.getFullyQualifiedName());

        Map<String, Entity> dataModel = new HashMap<>();
        Entity entity = new Entity(EntityType.Interface);
        entity.setPackageName(PluginsUtils.getServiceInterfacePackage());
        entity.setClassName(outFileName);
        entity.setImportPackageSet(importPackageSet);
        PluginsUtils.getServiceInterfaceExtendsInterfaceSet().forEach(serviceInterfaceExtendsInterface -> {
            FullyQualifiedJavaType serviceInterfaceExtendsInterfaceType = new FullyQualifiedJavaType(serviceInterfaceExtendsInterface);
            entity.getInterfaceSuperClassSet().add(serviceInterfaceExtendsInterfaceType.getShortName() + "<" + javaBeanName + ", BaseVo<" + javaBeanName + ">>");
        });
        dataModel.put("dataModel", entity);

        FreeMarkerUtils freeMarkerUtils = FreeMarkerUtils.getInstance("/template/freemarker");
        freeMarkerUtils.crateFile(dataModel, "freemarker-template-java.ftl", outFile.getPath());
    }
}
