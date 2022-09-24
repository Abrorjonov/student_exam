<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> ADD Faculty</title>
</head>
<body>

<form action="/faculties" method="post">
    <label for="faculty">Faculty: </label>
    <input name="faculty" type="text" id="faculty">
    <hr>
    <button type="submit">save</button>
    <br>
    <br>
    <br>
    <a href="/">go to HOME PAGE</a>
</form>

</body>
</html>
