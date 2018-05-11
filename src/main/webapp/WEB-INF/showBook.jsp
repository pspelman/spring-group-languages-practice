<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Show me the book</h1>
<h3>ID: ${book_id}</h3>

<h5><c:out value="${selectedBook.title}"/></h5>
Description:
<p>
    <c:out value="${selectedBook.description}"/>
</p>
Written in: <c:out value="${selectedBook.language}"/><br/>
Page count: <c:out value="${selectedBook.numberOfPages}"/><br/>

<a href="/">Back</a>