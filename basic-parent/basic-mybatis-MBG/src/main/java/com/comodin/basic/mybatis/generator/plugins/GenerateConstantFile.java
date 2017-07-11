package com.comodin.basic.mybatis.generator.plugins;

import com.comodin.basic.util.freemarker.Entity;
import com.comodin.basic.util.freemarker.EntityType;
import com.comodin.basic.util.freemarker.FreeMarkerUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GenerateConstantFile {

    public static void generateApplicationConstantFile(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();

        //String outFileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\java\\com\\comodin\\fleet\\constant";
        String outFileRootDir = PluginsUtils.getGenerateConstantFileDir();
        String outFileExtensionName = ".java";

        //String outFileNamePrefix = "";
        //String outFileNameSuffix = "Constant";
        //String outFileName = String.format("%s%s%s", outFileNamePrefix, javaBeanName, outFileNameSuffix);
        String outFileName = PluginsUtils.getConstantBeanClassName(javaBeanName);

        File outFile = new File(outFileRootDir, String.format("%s%s", outFileName, outFileExtensionName));

        Map<String, Entity> dataModel = new HashMap<>();
        Entity entity = new Entity(EntityType.Class);
        entity.setPackageName(PluginsUtils.getConstantPackage());
        entity.setClassName(outFileName);
        entity.setGeneratedConstructors(false);
        entity.setStaticPropertySet(PluginsUtils.getEntityConstantSet());
        dataModel.put("dataModel", entity);

        FreeMarkerUtils freeMarkerUtils = FreeMarkerUtils.getInstance("/template/freemarker");
        freeMarkerUtils.crateFile(dataModel, "freemarker-template-java.ftl", outFile.getPath());
    }
}
