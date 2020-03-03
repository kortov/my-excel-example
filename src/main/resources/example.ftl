<style>
    .default {
        text-align: center;
        vertical-align: middle;
        /*font-weight: bold;*/
        font-size: 14px;
    }
</style>
<table style="border: thin;border-right-style: thin;border-top-style: thin">
    <caption>${sheetName}</caption>
    <thead>
    <tr style="background-color: #C0C0C0">
        <th rowspan="3" class="default">№ п/п</th>
        <th rowspan="3" class="default">ФИО</th>
        <th rowspan="3" class="default">Подразделение</th>
        <th rowspan="3" class="default">Комментарий</th>

        <#--        <th colspan="${titles.size()}" class="default" >Количество</th>-->
        <th colspan="12" class="default">Количество</th>


    </tr>
    <tr style="background-color: #C0C0C0">
        <#list titles as title>
            <th class="default" colspan="3">${title}</th>
        </#list>
    </tr>
    <tr style="background-color: #C0C0C0">
        <#list titles as title>
            <#list subtitles as subtitle>
                <th class="default">${subtitle}</th>
            </#list>
        </#list>
    </tr>

    </thead>
    <tbody>
    <#list data as item>
        <tr>
            <#if item.category == "Кат" >
                <td style="background-color:red">${item.category}</td>
            <#else>
                <td style="background-color:yellow">${item.category}</td>
            </#if>

            <td>${item.name}</td>
            <td>${item.count}</td>
            <td url>aaa</td>
        </tr>
    </#list>
    </tbody>
</table>