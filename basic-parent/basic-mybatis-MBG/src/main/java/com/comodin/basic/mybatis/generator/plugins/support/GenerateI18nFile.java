package com.comodin.basic.mybatis.generator.plugins.support;


import com.comodin.basic.mybatis.generator.util.PluginsUtils;
import com.comodin.basic.util.freemarker.EntityProperty;
import com.comodin.basic.util.freemarker.FreeMarkerUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.File;
import java.util.*;

/**
 * @author Code generator automatically generated
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class GenerateI18nFile {

    public static void generateI18nFile(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //if (PluginsUtils.getEntityI18nToMapByEntityBeanName().isEmpty() || PluginsUtils.getI18nLanguageSet().isEmpty()) {
        //    return;
        //}

        String javaBeanName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
        List<EntityProperty> entityI18nSet = PluginsUtils.getEntityI18nToMapByEntityBeanName().get(javaBeanName);
        //if (entityI18nSet.isEmpty()) {
        //    return;
        //}
        if (entityI18nSet == null) {
            entityI18nSet = new ArrayList<>();
        }

        //String outFileRootDir = "D:\\ideaProjects\\study-java\\basic-parent\\basic-mybatis-MBG\\src\\main\\resources\\i18n";
        String outFileRootDir = PluginsUtils.getGenerateI18nFileDir();
        String outFileExtensionName = ".properties";

        String outFileNamePrefix = PluginsUtils.getI18nFileNamePrefix();
        String outFileNameSuffix = PluginsUtils.getI18nFileNameSuffix();


        List<EntityProperty> finalEntityI18nSet = entityI18nSet;
        PluginsUtils.getI18nLanguageSet().forEach(language -> {
            String outFileName;
            if (language == null || "\"\"".equals(language.trim()) || "default".equalsIgnoreCase(language.trim())) {
                outFileName = String.format("%s%s%s", outFileNamePrefix, javaBeanName, outFileNameSuffix);
            } else {
                outFileName = String.format("%s%s%s_%s", outFileNamePrefix, javaBeanName, outFileNameSuffix, language);
            }
            File outFile = new File(outFileRootDir, String.format("%s%s", outFileName, outFileExtensionName));

            Map<String, List<EntityProperty>> dataModel = new HashMap<>();
            dataModel.put("dataModel", finalEntityI18nSet);

            FreeMarkerUtils freeMarkerUtils = FreeMarkerUtils.getInstance("/template/freemarker");
            freeMarkerUtils.crateFile(dataModel, "freemarker-template-java-properties.ftl", outFile.getPath());
        });
    }
}
