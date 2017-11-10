<#if dataModel?has_content >
    <#list dataModel as property>
        <#if property.remarks?has_content >
#
            <#list property.remarks as remark>
#${remark}
            </#list>
#
        </#if>
${property.name}=${property.value}
    </#list>
</#if>