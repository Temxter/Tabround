<#macro login isLogin=true>
    <h3>${isLogin?string("Login","Registration")}</h3>
    <form method="post" action="/${isLogin?string("login","registration")}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username">
        ${usernameError!""}
        <label for="password">Password: </label>
        <input type="password" name="password" id="password">
        <#if !isLogin>
            <label for="passwordConfirm">Password confirmation: </label>
            <input type="password" name="passwordConfirm" id="passwordConfirm">
        </#if>
        <input type="submit">
    </form>
    <p>
    <#if isLogin>
        <a href="/registration">Registration</a>
    <#else >
        <a href="/login">Login</a>
    </#if>
    </p>
</#macro>

<#macro logout>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Sign Out">
        </form>
    </div>
</#macro>