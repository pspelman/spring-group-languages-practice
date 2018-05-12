<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2>Wecome to the languages</h2>
<!-- ... -->
<table class="table">
    <c:forEach var="language" items="${languages}" varStatus="loop">
        <tr>
            <td><c:out value="${language.name}"/></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td><a href="/languages/edit/${language.id}">Edit</a></td>
            <td><a href="/languages/delete/${language.id}">Delete</a></td>
            <%--<td><a href="/languages/edit/${loop.index}">Edit</a></td>--%>
            <%--<td><a href="/languages/delete/${loop.index}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>
<!-- ... -->

