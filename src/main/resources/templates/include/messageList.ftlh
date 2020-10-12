<h3>Messages</h3>
<form action="/messages/add" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <label for="text">Text: </label>
    <input type="text" name="text" id="text">
    <label for="tag">Tag: </label>
    <input type="text" name="tag" id="tag">
    <button type="submit">Submit</button>
</form>
<form method="get" action="/messages">
    <input type="text" name="filter" value="${RequestParameters.filter!}">
    <input type="submit" value="Search">
</form>
<ol>
    <#list messages as message>
        <li>
            <p>id: ${message.id};
                message: ${message.text};
                tag: ${message.tag};
                author:
                <#if message.author??>
                    <strong>${message.author.username}</strong>
                <#else>
                    <strong>Unknown</strong>
                </#if>
            </p>
        </li>
    <#else >
        <p>No messages</p>
    </#list>
</ol>