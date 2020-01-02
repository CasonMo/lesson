<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/28
  Time: 21:41
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
            <th scope="col">可选人数</th>
            <th scope="col">已选人数</th>
        </tr>
        </thead>
        <tbody>

            <c:forEach var="lesson" items="${teacher.lessons}">
                <c:if test="${lesson.lesson_id!=null}">
                <tr>
                    <th scope="row">${lesson.lesson_id}</th>
                    <td>${lesson.name}</td>

                    <td>${teacher.name}</td>

                    <td>${lesson.teach_place}</td>
                    <td>${lesson.teach_time}</td>
                    <td>${lesson.limit}</td>
                    <td>${lesson.selected}</td>
                    <td>
                        <div class="btn-group" role="group" aria-label="Basic example">
                            <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/teacher/deleteLesson/${lesson.lesson_id}'" type="button" class="btn btn-light">删除</button>
                            <button  onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/teacher/editLesson/${lesson.lesson_id}'" type="button" class="btn btn-light">编辑</button>
                        </div>
                    </td>
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
