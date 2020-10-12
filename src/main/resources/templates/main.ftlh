<#import "part/wrapper.ftlh" as c>

<@c.wrapper title="Messages">
    <h1>Messages</h1>
    <form action="/messages/add" method="post">
        <label for="text">Text: </label>
        <input type="text" name="text" id="text">
        <label for="tag">Tag: </label>
        <input type="text" name="tag" id="tag">
        <button type="submit">Submit</button>
    </form>
    <ol>
        <#list messages as message>
            <li>
                <p>id: ${message.id}
                    message: ${message.text}
                    tag: ${message.tag}</p>
            </li>
        <#else >
            <p>No messages</p>
        </#list>
    </ol>
</@c.wrapper>