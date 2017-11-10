<#-- @ftlvariable name="dataModel" type="com.comodin.basic.util.freemarker.Entity" -->
package ${dataModel.packageName};
<#--<#if dataModel.importPackageSet?? && (dataModel.importPackageSet?size > 0) >-->
<#if dataModel.importPackageSet?has_content >

    <#list dataModel.importPackageSet as importPackage>
import ${importPackage};
    </#list>
</#if>

/**
 * @author Code generator automatically generated
 */
<#if dataModel.classAnnotationSet?has_content >
    <#list dataModel.classAnnotationSet as classAnnotation>
${classAnnotation}
    </#list>
<#else>
</#if>
<#if dataModel.classType == "Class">
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public class ${dataModel.className} <#if dataModel.superClass?has_content>extends ${dataModel.superClass}</#if> <#if dataModel.implementsInterfaceClassSet?has_content>implements <#list dataModel.implementsInterfaceClassSet as implementsInterfaceClass>${implementsInterfaceClass}<#if implementsInterfaceClass_has_next>,</#if></#list> </#if>{
<#else>
@SuppressWarnings({"unused", "SpringAutowiredFieldsWarningInspection", "StatementWithEmptyBody"})
public interface ${dataModel.className} <#if dataModel.interfaceSuperClassSet?has_content>extends <#list dataModel.interfaceSuperClassSet as interfaceSuperClass>${interfaceSuperClass}<#if interfaceSuperClass_has_next>,</#if></#list> </#if>{
</#if>
<#--********** class attribute ***********-->
<#if dataModel.staticPropertySet?has_content >

    <#list dataModel.staticPropertySet as property>
    <#if property.remarks?has_content >
    /**
    <#list property.remarks as remark>
     * ${remark}
    </#list>
     */
    </#if>
    <#if property.type == "String">
    public static final ${property.type} ${property.name} = "${property.value}";
    <#else>
    public static final ${property.type} ${property.name} = ${property.value};
    </#if>
    </#list>
</#if >
<#--********** attribute ***********-->
<#if dataModel.entityPropertySet?has_content >

    <#list dataModel.entityPropertySet as property>
    <#if property.remarks?has_content >
    /**
    <#list property.remarks as remark>
     * ${remark}
    </#list>
     */
    </#if>
    <#if property.type == "String">
    public ${property.type} ${property.name} = "${property.value}";
    <#else>
    public ${property.type} ${property.name} = ${property.value};
    </#if>
    </#list>
</#if >
<#--********** constructors ***********-->
<#if dataModel.generatedConstructors>

    public ${dataModel.className}() {
    }
    <#if dataModel.entityPropertySet?has_content >

    public ${dataModel.className}(<#list dataModel.entityPropertySet as entityProperty>${entityProperty.type} ${entityProperty.name}<#if entityProperty_has_next>,</#if></#list>) {
        <#list dataModel.entityPropertySet as entityProperty>
        this.${entityProperty.name} = ${entityProperty.name};
        </#list>
    }
    </#if>
</#if>
<#--********** 临时方法体 ***********-->
<#if dataModel.temporaryMethodBodySet?has_content >

    <#list dataModel.temporaryMethodBodySet as temporaryMethodBody>
    ${temporaryMethodBody}
    </#list>
</#if>
<#--********** get/set ***********-->
<#if dataModel.generatedGetSetMethod>

    <#if dataModel.entityPropertySet?has_content >
    <#list dataModel.entityPropertySet as property>
    <#if property.remarks?has_content >
    /**
     <#list property.remarks as remark>
     * get ${remark}
     </#list>
     */
    </#if>
    <#if property.type == "Boolean">
    public ${property.type} is${property.name?cap_first}() {
    <#else>
    public ${property.type} get${property.name?cap_first}() {
    </#if>
        <#if property.type == "String">
        return (${property.name} == null) ? null : this.${property.name}.trim();
        <#else>
        return ${property.name};
        </#if>
    }

    <#if property.remarks?has_content >
    /**
        <#list property.remarks as remark>
        * set ${remark}
        </#list>
    */
    </#if>
    public ${dataModel.className} set${property.name?cap_first}(${property.type} ${property.name}) {
        <#if property.type == "String">
        this.${property.name} = (${property.name} == null) ? null : ${property.name}.trim();
        return this;
        <#else>
        this.${property.name} = ${property.name};
        return this;
        </#if>
    }
        </#list>
    </#if>
</#if>

}