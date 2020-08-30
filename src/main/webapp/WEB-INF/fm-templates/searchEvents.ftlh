<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>
<ul class="list-group">
    <#list listOfQueriedEvents as event>
        <li class="list-group-item"> ${event.getName()} <br>
            ${event.getPlace().getName()}
            <#if event.getPlace().getSubname()??>
                - ${event.getPlace().getSubname()}
            </#if>
                <br>
                ${event.startDate} - ${event.endDate}
        </li>
    </#list>
</ul>
</body>
</html>
