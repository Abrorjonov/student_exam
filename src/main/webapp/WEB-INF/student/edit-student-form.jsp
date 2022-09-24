<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EDIT Student</title>
</head>
<body>

<form action="/students" method="post">
    <label for="student"></label>
    <input name="full_name" type="text" id="student" value="${student.full_name}">
    <br>
    <label for="course">course:</label>
    <select name="course_id"  id="course">
        <c:forEach items="${course}" var="course" >
            <option value="${course.id}">${course.course}</option>
        </c:forEach>
    </select>
    <br>
    <label for="faculty">course:</label>
    <select name="faculty_id"  id="faculty">
        <c:forEach items="${faculty}" var="fac" >
            <option value="${fac.id}">${fac.faculty}</option>
        </c:forEach>
    </select>
    <hr>
    <button type="submit">save</button>    <br>
    <br>
    <br>
    <a href="/">go to HOME PAGE</a>
</form>

</body>
</html>
