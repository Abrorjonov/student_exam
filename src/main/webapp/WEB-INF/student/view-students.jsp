<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>VIEW students</title>

</head>
<body>

<a href="/students/get-form">+ new student</a>


<c:forEach items="${students}" var="student" varStatus="loop">
    <h1>${student.full_name}</h1>
    <p>${student.course_name}</p>
    <p>${student.faculty_name}</p>
    <a href="/students/edit/${student.id}">Edit</a>
    <a href="/students/delete/${student.id}">Delete</a>
    <hr>
</c:forEach>


<br>
<br>
<br>
<a href="/">go to HOME PAGE</a>


</body>
</html>
