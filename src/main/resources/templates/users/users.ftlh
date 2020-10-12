<#import "../part/mainWrapper.ftlh" as w>
<#import "../part/loginPart.ftlh" as l>

<@w.wrapper title="Users">
    <@l.logout/>
    <h3>Users</h3>
    <table>
        <tr>
        <td>Id</td>
        <td>Username</td>
        <td>Role</td>
        <td>Active</td>
        <td>Edit</td>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td>${user.active?string("Active","No active")}</td>
                <td><a href="/users/${user.id}">Edit</a></td>
            </tr>
        </#list>
    </table>
</@w.wrapper>