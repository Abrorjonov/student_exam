<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EDIT Faculty</title>
</head>
<body>

<form action="/faculties/edit" method="post">
    <input type="text" name="id" hidden value="${faculty.id}">
    <label for="faculty">faculty: </label>
    <input value="${faculty.faculty}" name="faculty" type="text" id="faculty">
    <hr>

    <button type="submit">save</button>
    <br>
    <br>
    <br>
    <a href="/">go to HOME PAGE</a>
</form>

</body>
</html>
