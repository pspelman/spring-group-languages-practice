<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <!-- ... -->
    <h1>EDIT BookForm page</h1>
    <form:form method="POST" action="/books/edit/${edit_book_id}" modelAttribute="book">
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
        <!-- .FIELD NEEDED FOR THE BOOK ID FROM DB.. -->
        <form:hidden path="id"/>
        <!-- ... -->
        <input type="submit" value="Submit"/>
    </form:form>
    <!-- ... -->
</div>
<a href="/">Back</a>