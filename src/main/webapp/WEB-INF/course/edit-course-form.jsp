<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EDIT Course</title>
</head>
<body>

<form action="/courses/edit" method="post">
    <input type="text" name="id" hidden value="${course.id}">
    <label for="course">course: </label>
    <input value="${course.course}" name="course" type="number" id="course">
    <hr>

    <button type="submit">save</button>
    <br>
    <br>
    <br>
    <a href="/">go to HOME PAGE</a>
</form>

</body>
</html>
