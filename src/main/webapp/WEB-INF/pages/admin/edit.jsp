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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="PeiHsien Mo">
    <title>Title</title>
</head>
<%@ include file="../base/style.jsp" %>
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
<link href="${pageContext.request.contextPath}/css/jumbotron.css" rel="stylesheet">
<body>
<%@ include file="base/nav.jsp" %>
<main role="main">


    <div class="container">
        <!-- Example row of columns -->
        <form action="${pageContext.request.contextPath}/admin/update/${admin.admin_id}" method="post">
            <div class="form-group"  >
                <label for="admin_id">管理员id</label>
                <input type="text" class="form-control" id="admin_id" name="admin_id" value="${admin.admin_id}"  readonly required>
            </div>
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="name" value="${admin.name}" required>
            </div>
            <div class="form-group">
                <label for="sex">性别</label>
                <input type="text" class="form-control" id="sex" name="sex" value="${admin.sex}" required>
            </div>
            <div class="form-group">
                <label for="oldPassword">旧密码</label>
                <input type="password" class="form-control" id="oldPassword" name="oldPassword" value="${admin.password}" required>
            </div>
            <div class="form-group">
                <label for="password">新密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="输入密码" required>
            </div>
            <div class="form-group">
                <label for="rePassword">确认密码</label>
                <input type="password" class="form-control" id="rePassword" name="rePassword" placeholder="请再次确认密码" required>
            </div>
            <div class="row">
                <div class="col-4">
                    <%--/*验证码输入框*/--%>

                    <input class="verifyInput form-control"  name="verifyInput" placeholder="请输入验证码">
                </div>
                <div class="col-4">
                    <%--/*验证码图片*/--%>

                    <img class="verifyCode" style="width: 110px;height: auto;" onclick="changeCode()" src="${pageContext.request.contextPath}/getVerifyCode">
                </div>
            </div>
            <div class="form-group sr-only">
                <label for="root">权限</label>
                <input type="text" class="form-control" id="root" name="root" value="${admin.root}" readonly required>
            </div>
            <button type="submit" class="btn btn-primary">确定</button><a href="${pageContext.request.contextPath}/admin/index" class="btn btn-primary">返回</a>
        </form>
        <hr>

    </div> <!-- /container -->

</main>



<%@ include file="../base/footer.jsp" %>
</body>
</html>
