<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/25
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
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

<link href="${pageContext.request.contextPath}/css/jumbotron.css" rel="stylesheet">
<body>
<%@ include file="base/nav.jsp" %>
<main role="main">

    <div class="container">
        <div class="col-6">
            <!-- Example row of columns -->
            <form action="${pageContext.request.contextPath}/admin/saveClass" method="post" autocomplete="off">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <select class="custom-select" id="department">
                            <option selected disabled value="">下拉选择系</option>

                            <c:forEach var="d" items="${departments}">
                                <option value="${d.department}">${d.department}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with dropdown button" placeholder="请输入系名" name="department" id="departmentName" >
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">班级编号</span>
                    </div>
                    <input type="text" class="form-control" placeholder="班级编号" name="class_id" aria-label="class_id" aria-describedby="basic-addon1" id="class_id" >
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon2">班级名称</span>
                    </div>
                    <input type="text" class="form-control" placeholder="班级名称" name="name" aria-label="name" aria-describedby="basic-addon2" id="name" >
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

                <button type="submit" class="btn btn-primary">确定</button><a href="${pageContext.request.contextPath}/admin/index" class="btn btn-primary">返回</a>
            </form>


        </div> <!-- /container -->
    </div>


</main>
<script>
    $('#department').click(function() {
        // var departmentValue=$('input:radio[name="department"]:checked').val();
        var departmentValue = $('#department option:selected').val();
        // $.ajax({
        //     url: "/ssm/class/findByDepartment", //请求的url地址
        //     dataType: "html", //返回格式为json
        //     async: true,//请求是否异步，默认为异步，这也是ajax重要特性
        //     data: {"department": departmentValue}, //参数值
        //     type: "post", //请求方式
        //     beforeSend: function () {
        //         //请求前的处理
        //     },
        //     success: function (data) {
        //         //请求成功时处理
        //         $("#classes").html(data);
        //     },
        //     complete: function () {
        //         //请求完成的处理
        //     },
        //     error: function () {
        //         //请求出错处理
        //     }
        // });
        $("#departmentName").val(departmentValue);
    })
</script>


<%@ include file="../base/footer.jsp" %>
</body>
</html>
