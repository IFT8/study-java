<#if dataModel?has_content >
    <#list dataModel as property>
#${property.remarks}
${property.name}=${property.value}
    </#list>
</#if>
