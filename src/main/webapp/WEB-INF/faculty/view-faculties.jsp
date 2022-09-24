<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>VIEW faculties</title>

</head>
<body>

<a href="/faculties/get-form">+ new faculty</a>


<c:forEach items="${faculties}" var="faculty" varStatus="loop">
    <h1>${faculty.faculty}</h1>
    <a href="/faculties/edit/${faculty.id}">Edit</a>
    <a href="/faculties/delete/${faculty.id}">Delete</a>
    <hr>
</c:forEach>


<br>
<br>
<br>
<a href="/">go to HOME PAGE</a>


</body>
</html>
