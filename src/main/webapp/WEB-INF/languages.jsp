<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>Wecome to the languages</h2>
<!-- ... -->
<table class="table">
    <c:forEach items="${languages}" var="book">
        <tr>
            <td><c:out value="${language.title}"/></td>
            <td><c:out value="${language.description}"/></td>
            <td><c:out value="${language.language}"/></td>
            <td><c:out value="${language.numberOfPages}"/></td>
        </tr>
    </c:forEach>
</table>
<!-- ... -->

<form:form method="POST" action="/books/new" modelAttribute="book">
    <form:label path="title">Title
        <form:errors path="title"/>
        <form:input path="title"/></form:label>

    <form:label path="description">Description
        <form:errors path="description"/>
        <form:textarea path="description"/></form:label>

    <form:label path="language">language
        <form:errors path="language"/>
        <form:input path="language"/></form:label>

    <form:label path="numberOfPages">Pages
        <form:errors path="numberOfPages"/>
        <form:input type="number" path="numberOfPages"/></form:label>

    <input type="submit" value="Submit"/>
</form:form>