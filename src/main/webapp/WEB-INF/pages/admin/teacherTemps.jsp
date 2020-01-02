<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/24
  Time: 1:14
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
            <th scope="col">名字</th>
            <th scope="col">性别</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${teachers.size() == 0}">
            <tr>
                <td colspan="6">
                    <p style="color: red">没有需要审核的教师</p>
                </td>
            </tr>
        </c:if>
        <c:forEach var="teacher" items="${teachers}">

            <tr>
                <th scope="row">${teacher.teach_id}</th>
                <td>${teacher.name}</td>
                <td>${teacher.sex}</td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/admin/addToTeacher/${teacher.teach_id}'" type="button" class="btn btn-light">通过</button>
                        <button  onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/admin/deleteTeacherTemp/${teacher.teach_id}'" type="button" class="btn btn-light">不通过</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    ${page}
</main>

<%@ include file="../base/footer.jsp" %>
</body>
</html>

