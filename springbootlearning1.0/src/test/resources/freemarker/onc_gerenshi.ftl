<#--个人史总结-->
<!--吸烟“吸烟时长”，“吸烟量”每天，未戒烟/戒烟“戒烟时长”；“饮酒频率”，“饮酒量”每次。左/右利手。-->
<#if question_key_105?seq_contains("吸烟")>
    <#if question_key_106 != "">
        吸烟${question_key_106}，
    </#if>
    ${question_key_107}每天，
    <#if question_key_108 = "是">
        戒烟${question_key_109}
    <#else>
        未戒烟
    </#if>
</#if>

