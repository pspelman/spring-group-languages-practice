<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
This is the lang form!
<br/>
<div class="form">
    <form:form method="POST" action="/languages/edit/${edit_language_id}" modelAttribute="language">
        <form:label path="name">Language:
            <form:errors path="name"/>
            <form:input path="name"/></form:label>
        <br/>
        <form:label path="creator">Creator:
            <form:errors path="creator"/>
            <form:textarea path="creator"/></form:label>
        <br/>
        <form:label path="currentVersion">Version:
            <form:errors path="currentVersion"/>
            <form:input path="currentVersion"/></form:label>
        <br/>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
