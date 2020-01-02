<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/13
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/jumbotron.css" rel="stylesheet">
<body>
<%@ include file="base/nav.jsp" %>

<main role="main">

    <div class="container">
        <!-- Example row of columns -->
        <ul class="list-group list-group-horizontal-md">
            <li class="list-group-item">用户名${admin.admin_id}</li>
            <li class="list-group-item">用户名${admin.name}</li>
            <li class="list-group-item">用户名{admin.sex}</li>
        </ul>
        <hr>

    </div> <!-- /container -->

</main>
<%@ include file="../base/footer.jsp" %>

</body>
</html>
