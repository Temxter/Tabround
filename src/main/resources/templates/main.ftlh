<#import "part/mainWrapper.ftlh" as w>
<#import "part/loginPart.ftlh" as l>

<@w.wrapper title="Messages">
    <@l.logout/>
    <#include "include/messageList.ftlh"/>

</@w.wrapper>