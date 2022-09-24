<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>VIEW courses</title>

</head>
<body>

<a href="/courses/get-form">+ new course</a>


<c:forEach items="${courses}" var="course" varStatus="loop">
    <h1>${course.course}</h1>
    <a href="/courses/edit/${course.id}">Edit</a>
    <a href="/courses/delete/${course.id}">Delete</a>
    <hr>
</c:forEach>


<br>
<br>
<br>
<a href="/">go to HOME PAGE</a>


</body>
</html>
