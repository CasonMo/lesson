<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/19
  Time: 23:12
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
    <title>成功</title>

</head>

<%@ include file="base/style.jsp" %>
<meta name="theme-color" content="#563d7c">
<link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

<!-- Custom styles for this template -->

</head>
<body class="text-center">

<script type="text/javascript">
    onload=function(){
        setInterval(go, 1000);
    };
    var x=3; //利用了全局变量来执行
    function go(){

        if(x>0){
            document.getElementById("sp").innerHTML=x;  //每次设置的x的值都不一样了。
            x--;
        }else{
            window.history.back(-1);
        }
    }
</script>
<div class="form-signin">
    <div>${msg}，页面三秒后跳转：<span id="sp"></span></div>
    <a href="javascript:window.history.go(-1)" class="btn btn-sm btn-secondary">立即跳转</a>
</div>
</body>
</html>
