<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/5
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="mvc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ssm/account/update/${account.id}" method="post" >
    用户名<input type="text" value="${account.name}" name="name"  >
    金额<input type="text" value="${account.money}" name="money">
    <input type="submit" value="提交">
</form>
</body>
</html>
