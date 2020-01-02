<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/4
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有账户</h3>

    <c:forEach items="${accountsList}" var="account">
       <p>${account.id} ${account.name}            ${account.money}<a href="delete/${account.id}">删除</a>  <a href="edit/${account.id}">删除</a></p>
    </c:forEach>
</body>
</html>
