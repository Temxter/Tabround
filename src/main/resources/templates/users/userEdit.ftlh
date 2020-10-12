<#import "../part/mainWrapper.ftlh" as w>
<#import "../part/loginPart.ftlh" as l>

<@w.wrapper title="Users">
    <@l.logout/>
    <form method="post" action="/users">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>ID: <input type="text" name="userId" value="${user.id}" readonly></div>
        <div>Username: <input type="text" name="username" value="${user.username}"></div>
        <div>Password: <input type="password" name="password"></div>
        <div>Roles:
            <#list roles as role>
                <label>${role}<input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}></label>
            </#list>
        </div>
        <div>Active:
            <input type="checkbox" name="roles" value="active" ${user.active?string("checked", "")}>
        </div>
        <input type="submit"/>
    </form>
</@w.wrapper>