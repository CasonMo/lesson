<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/12/4
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="PeiHsien Mo">
    <title>Title</title>
</head>
<%@ include file="../base/style.jsp" %>
<%@ include file="base/nav.jsp" %>
<body>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        下拉选择课程
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <c:forEach var="lesson" items="${lessons}">

            <a class="dropdown-item" href="${pageContext.request.contextPath}/teacher/findLessonSelectedByLessonIDAndTeachId?lesson_id=${lesson.lesson_id}">${lesson.name}</a>
        </c:forEach>


    </div>
</div>
<main role="main">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">名字</th>
            <th scope="col">性别</th>
            <th scope="col">班别</th>
            <th scope="col">系</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <th scope="row">${student.stu_id}</th>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.aClass.name}</td>
                <td>${student.aClass.department}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    ${page}
</main>
<%@ include file="../base/footer.jsp" %>
</body>
</html>