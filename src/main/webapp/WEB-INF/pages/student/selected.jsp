<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/26
  Time: 10:59
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

<main role="main">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">课程名称</th>
            <th scope="col">授课教师</th>
            <th scope="col">授课地点</th>
            <th scope="col">授课时间</th>
        </tr>
        </thead>
        <tbody>

            <c:forEach var="lesson" items="${student.lessons}">
                <c:if test="${lesson.lesson_id!=null}">
                    <tr>
                        <th scope="row">${lesson.lesson_id}</th>
                        <td>${lesson.name}</td>
                        <td>${lesson.teacher.name}</td>
                        <td>${lesson.teach_place}</td>
                        <td>${lesson.teach_time}</td>

                        <td><a href="${pageContext.request.contextPath}/student/unSubLesson?stuId=${userId}&&lessonId=${lesson.lesson_id}">退选</a></td>
                    </tr>
                </c:if>
            </c:forEach>

        </tbody>
    </table>
    ${page}
</main>
<%@ include file="../base/footer.jsp" %>
</body>
</html>