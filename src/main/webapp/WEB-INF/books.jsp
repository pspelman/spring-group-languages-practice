<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<table class="table">
    <c:forEach var="book" items="${books}" varStatus="loop">
        <tr>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.description}"/></td>
            <td><c:out value="${book.language}"/></td>
            <td><c:out value="${book.numberOfPages}"/></td>
            <td><a href="/books/edit/${loop.index}">Edit</a></td>
            <td><a href="/books/delete/${loop.index}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
<!-- ... -->

<a href="/">Home</a>