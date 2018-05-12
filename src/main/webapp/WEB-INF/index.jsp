<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>
    THIS IS THE GROUP LANGUAGE INDEX
</h1>

<a href="/languages">All languages page</a>
<br/>
<a href="/languages/new">Add a language</a>


<br/>
Get language by id:<br/>
<form action="/languages/id/getById/" name="user_language_search_form" method="post">
    ID: <input type="text" name="find_language_id"/>
<br/>
    <input type="submit" />
<br/>

</form>




<h1>
    BOOK STUFF
</h1>


<br/>
Go to the books<br/>

<a href="/books/1234">Book 1</a>
<br/>
<h3>Search a book by number</h3>
${errors}

<form action="/books/id/getById/" name="user_book_search_form" methd="post">
    <input type="text" name="find_book_id" id="user_input_book_id"/>
    <input type="submit"/>

    <button type="submit" >Search</button>
</form>

<h3>
    <a href="/books">All books</a><br/>

    <a href="/books/new">
        Add a book
    </a>
</h3>
<%--Import language form:<br/>--%>
<%--<c:import url="lang_form.jsp"/>--%>
<%--<%@include file="lang_form.jsp"%>--%>