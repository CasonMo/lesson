<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/5
  Time: 18:33
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


<body>
<%@ include file="base/nav.jsp" %>

<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">${sessionScope.userName}</h1>
            <p>欢迎进入选课系统</p>

        </div>
    </div>

    <div class="container">
        <!-- Example row of columns -->



    </div> <!-- /container -->

</main>
<%@ include file="../base/footer.jsp" %>

</body>
</html>
