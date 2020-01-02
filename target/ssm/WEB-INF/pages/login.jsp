<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/7
  Time: 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% request.setCharacterEncoding("UTF-8"); //设置页面传递参数的编码格式 %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="PeiHsiem Mo">
    <title>${pageTitle}</title>

</head>

<%@ include file="base/style.jsp" %>
<meta name="theme-color" content="#563d7c">
<link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

<style>
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>
<!-- Custom styles for this template -->

</head>
<body class="text-center">
<form class="form-signin" action="${pageContext.request.contextPath}/check" method="post">
    <%--<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
    <h1 class="h3 mb-3 font-weight-normal">选课系统</h1>
    <label for="id" class="sr-only">账号</label>
    <input type="text" name="id" id="id" class="form-control" placeholder="account" required autofocus>
    <label for="password" class="sr-only">密码</label>
    <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
    <div class="row">
        <div class="col-7">
            <%--/*验证码输入框*/--%>

            <input class="verifyInput form-control"  name="verifyInput" placeholder="请输入验证码">
        </div>
        <div class="col-4">
            <%--/*验证码图片*/--%>

            <img class="verifyCode" style="width: 110px;height: auto;" onclick="changeCode()" src="${pageContext.request.contextPath}/getVerifyCode">
        </div>
    </div>





        <%--//src的getVerifyCode是后台访问地址；项目为SSM框架。--%>


        <p style="background-color: red;margin-bottom: 10px;color: white;border-radius: 50px">${msg}</p>
    <input class="btn btn-sm btn-primary btn-block" type="submit"  value="登录">
        <p style="text-align: right;color: red"><small><a href="${pageContext.request.contextPath}/register">还未注册...</a></small></p>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
</form>
</body>
</html>

