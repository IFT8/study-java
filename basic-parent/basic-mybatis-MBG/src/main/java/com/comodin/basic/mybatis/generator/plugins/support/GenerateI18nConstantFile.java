package com.comodin.basic.mybatis.generator.plugins.support;


import com.comodin.basic.mybatis.generator.util.PluginsUtils;
import com.comodin.basic.util.freemarker.*;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"WeakerAccess", "unused"})
public class GenerateI18nConstantFile {

    public static void generateI18nConstantFile(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        Set<EntityProperty> entityI18nSet = PluginsUtils.getEntityI18nToMapByEntityBeanName().get(javaBeanName);
        //if (entityI18nSet.isEmpty()) {
        //    return;
        //}
        Set<EntityProperty> entityI18nConstantSet = new HashSet<>();
        if (!entityI18nSet.isEmpty()) {
            for (EntityProperty entityI18n : entityI18nSet) {
                EntityProperty entityProperty = new EntityProperty()
                        .setType(EntityPropertyType.String)
                        .setName(entityI18n.getName()).setValue(entityI18n.getName()).setRemarks(entityI18n.getRemarks());
                entityI18nConstantSet.add(entityProperty);
            }
        }

        //String outFileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\java\\com\\comodin\\fleet\\constant\\i18n";
        String outFileRootDir = PluginsUtils.getGenerateI18nConstantFileDir();
        String outFileExtensionName = ".java";

        //String outFileNamePrefix = "";
        //String outFileNameSuffix = "Constant";
        //String outFileName = String.format("%s%s%s", outFileNamePrefix, javaBeanName, outFileNameSuffix);
        String outFileName = PluginsUtils.getI18nConstantBeanClassName(javaBeanName);

        File outFile = new File(outFileRootDir, String.format("%s%s", outFileName, outFileExtensionName));

        Map<String, Entity> dataModel = new HashMap<>();
        Entity entity = new Entity(EntityType.Class);
        entity.setPackageName(PluginsUtils.getI18nConstantPackage());
        entity.setClassName(outFileName);
        entity.setGeneratedConstructors(false);
        entity.setStaticPropertySet(entityI18nConstantSet);
        dataModel.put("dataModel", entity);

        FreeMarkerUtils freeMarkerUtils = FreeMarkerUtils.getInstance("/template/freemarker");
        freeMarkerUtils.crateFile(dataModel, "freemarker-template-java.ftl", outFile.getPath());
    }
}