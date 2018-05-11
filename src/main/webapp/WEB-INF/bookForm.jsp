<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
<!-- ... -->
    <h1>BookForm page</h1>
<form:form method="POST" action="/books/new" modelAttribute="book">
    <form:label path="title">Title<br/>
        <form:errors path="title"/>
        <form:input path="title"/></form:label>
<br/>
    <form:label path="description">Description
        <form:errors path="description"/><br/>
        <form:textarea path="description"/></form:label>
    <br/>

    <form:label path="language">language
        <form:errors path="language"/><br/>
        <form:input path="language"/></form:label>
    <br/>

    <form:label path="numberOfPages">Pages
        <form:errors path="numberOfPages"/><br/>
        <form:input type="number" path="numberOfPages"/></form:label>
    <br/>

    <input type="submit" value="Submit"/>
</form:form>
<!-- ... -->
</div>
<a href="/">Home</a>