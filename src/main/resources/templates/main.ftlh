<#import "part/mainWrapper.ftlh" as w>
<#import "part/loginPart.ftlh" as l>

<@w.wrapper title="Messages">
    <@l.logout/>
    <h4><a href="/users">User list</a></h4>
    <#include "include/messageList.ftlh"/>

</@w.wrapper>