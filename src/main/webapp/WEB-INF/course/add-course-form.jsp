<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> ADD Course</title>
</head>
<body>

<form action="/courses" method="post">
    <label for="course">course: </label>
    <input name="course" type="number" id="course">
    <hr>
    <button type="submit">save</button>
    <br>
    <br>
    <br>
    <a href="/">go to HOME PAGE</a>
</form>

</body>
</html>
