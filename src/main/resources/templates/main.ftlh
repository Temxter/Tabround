<#import "part/mainWrapper.ftlh" as c>

<@c.wrapper title="Messages">
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Sign Out">
        </form>
    </div>
    <#include "include/messageList.ftlh"/>

</@c.wrapper>