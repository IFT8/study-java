package ${entity.javaPackage};

public class ${entity.className} <#if entity.superClass?has_content> extends ${entity.superClass} </#if> {
    /********** attribute ***********/
    <#list entity.propertyList as property>
    private ${property.javaType} ${property.propertyName};
    </#list>

    /********** constructors ***********/
    <#if entity.constructors>
    public ${entity.className}() {}

    public ${entity.className}(<#list entity.propertyList as property>${property.javaType} ${property.propertyName}<#if property_has_next>,</#if></#list>) {
    <#list entity.propertyList as property>
        this.${property.propertyName} = ${property.propertyName};
    </#list>
    }
    </#if>

    /********** get/set ***********/
    <#list entity.propertyList as property>
    public ${property.javaType} get${property.propertyName?cap_first}() {
    <#if property.javaType == "String">
        return (${property.propertyName} == null) ? null : this.${property.propertyName}.trim();
    <#else>
        return ${property.propertyName};
    </#if>
    }

    public ${entity.className} set${property.propertyName?cap_first}(${property.javaType} ${property.propertyName}) {
    <#if property.javaType == "String">
        this.${property.propertyName} = (${property.propertyName} == null) ? null : ${property.propertyName}.trim();
        return this;
    <#else>
        this.${property.propertyName} = ${property.propertyName};
        return this;
    </#if>
    }
    </#list>
}