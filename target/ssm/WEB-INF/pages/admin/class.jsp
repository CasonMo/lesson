<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/25
  Time: 14:23
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
            <th scope="col">班级</th>
            <th scope="col">系</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="class_" items="${classes}">
            <tr>
                <th scope="row">${class_.class_id}</th>
                <td>${class_.name}</td>
                <td>${class_.department}</td>
                <td>
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/admin/deleteClass/${class_.class_id}'" type="button" class="btn btn-light">删除</button>
                        <button  onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/admin/classEdit/${class_.class_id}'" type="button" class="btn btn-light">编辑</button>
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