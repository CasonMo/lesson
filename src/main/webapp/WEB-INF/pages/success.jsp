<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/18
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); //设置页面传递参数的编码格式 %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="PeiHsiem Mo">
    <title>成功</title>

</head>

<%@ include file="base/style.jsp" %>
<meta name="theme-color" content="#563d7c">
<link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

<!-- Custom styles for this template -->

</head>
<body class="text-center">

<script type="text/javascript">


        var a=setInterval(go, 1000);
    var x=3; //利用了全局变量来执行
    function go(){

        if(x>0){
            document.getElementById("sp").innerHTML=x;  //每次设置的x的值都不一样了。
            x--;
        }else{
            clearInterval(a);

            <c:if test="${hyperlink==null}" var="flag" scope="page">
            window.history.back(-1);
                </c:if>
                <c:if test="${not flag}">
            location.href='${hyperlink}';
            </c:if>



        }
    }
</script>
<div class="form-signin">
    <div>${msg}，页面三秒后跳转：<span id="sp"></span></div>
    <c:if test="${hyperlink==null}" var="flag" scope="page">
        <a href="javascript:window.history.go(-1)" id="btn" class="btn btn-sm btn-secondary">立即跳转</a>
    </c:if>
    <c:if test="${not flag}">
        <a href="${hyperlink}" class="btn btn-sm btn-secondary">立即跳转</a>
    </c:if>

</div>
</body>
</html>
