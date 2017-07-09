<#-- @ftlvariable name="dataModel" type="com.comodin.basic.util.freemarker.Entity" -->
package ${dataModel.packageName};

<#--<#if dataModel.importPackageSet?? && (dataModel.importPackageSet?size > 0) >-->
<#if dataModel.importPackageSet?has_content >
    <#list dataModel.importPackageSet as importPackage>
    import ${importPackage};
    </#list>
</#if>

<#if dataModel.classAnnotationSet?has_content >
    <#list dataModel.classAnnotationSet as classAnnotation>
    ${classAnnotation}
    </#list>
</#if>
<#if dataModel.classType == "Class">
public class ${dataModel.className} <#if dataModel.superClass?has_content>extends ${dataModel.superClass}</#if> <#if dataModel.implementsInterfaceClassSet?has_content>implements <#list dataModel.implementsInterfaceClassSet as implementsInterfaceClass>${implementsInterfaceClass}<#if implementsInterfaceClass_has_next>,</#if></#list> </#if>{

<#else>
public interface ${dataModel.className} <#if dataModel.superClass?has_content>extends ${dataModel.superClass}</#if> <#if dataModel.implementsInterfaceClassSet?has_content>implements <#list dataModel.implementsInterfaceClassSet as implementsInterfaceClass>${implementsInterfaceClass}<#if implementsInterfaceClass_has_next>,</#if></#list> </#if>{

</#if>
<#--********** class attribute ***********-->
<#if dataModel.staticPropertyList?has_content >
    <#list dataModel.staticPropertyList as staticProperty>
        <#if staticProperty.remarks != "">
        /**
        * ${staticProperty.remarks}
        */
        </#if>
        <#if staticProperty.type == "String">
        public static final ${staticProperty.type} ${staticProperty.name} = "${staticProperty.value}";
        <#else>
        public static final ${staticProperty.type} ${staticProperty.name} = ${staticProperty.value};
        </#if>
    </#list>
</#if >
<#--********** attribute ***********-->
<#if dataModel.entityPropertyList?has_content >
    <#list dataModel.entityPropertyList as entityProperty>
        <#if entityProperty.remarks != "">
        /**
        * ${entityProperty.remarks}
        */
        </#if>
        <#if entityProperty.type == "String">
        public static final ${entityProperty.type} ${entityProperty.name} = "${entityProperty.value}";
        <#else>
        public static final ${entityProperty.type} ${entityProperty.name} = ${entityProperty.value};
        </#if>
    </#list>
</#if >
<#--********** constructors ***********-->
<#if dataModel.generatedConstructors>
public ${dataModel.className}() {
}
    <#if dataModel.entityPropertyList?has_content >
    public ${dataModel.className}(<#list dataModel.entityPropertyList as entityProperty>${entityProperty.type} ${entityProperty.name}<#if entityProperty_has_next>,</#if></#list>) {
        <#list dataModel.entityPropertyList as entityProperty>
        this.${entityProperty.name} = ${entityProperty.name};
        </#list>
    }
    </#if>
</#if>
<#--********** get/set ***********-->
<#if dataModel.generatedGetSetMethod>
    <#if dataModel.entityPropertyList?has_content >
        <#list dataModel.entityPropertyList as entityProperty>
            <#if entityProperty.remarks != "">
            /**
            * get ${entityProperty.remarks}
            */
            </#if>
        public ${entityProperty.type} get${entityProperty.name?cap_first}() {
            <#if entityProperty.type == "String">
            return (${entityProperty.name} == null) ? null : this.${entityProperty.name}.trim();
            <#else>
            return ${entityProperty.name};
            </#if>
        }

            <#if entityProperty.remarks != "">
            /**
            * set ${entityProperty.remarks}
            */
            </#if>
        public ${dataModel.className} set${entityProperty.name?cap_first}(${entityProperty.type} ${entityProperty.name}) {
            <#if entityProperty.type == "String">
            this.${entityProperty.name} = (${entityProperty.name} == null) ? null : ${entityProperty.name}.trim();
            return this;
            <#else>
            this.${entityProperty.name} = ${entityProperty.name};
            return this;
            </#if>
        }
        </#list>
    </#if>
</#if>
}