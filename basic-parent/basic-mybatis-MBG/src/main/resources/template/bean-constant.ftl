package ${entity.javaPackage};

public class ${entity.className} {
<#list entity.propertyList as property>
    <#if property.remarks != "">
    /**
     * ${property.remarks}
     */
    </#if>
    <#if property.type == "String">
    public static final ${property.type} ${property.name} = "${property.value}";
    <#else>
    public static final ${property.type} ${property.name} = ${property.value};
    </#if>
</#list>
}