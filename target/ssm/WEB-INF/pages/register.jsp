<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/11/20
  Time: 15:19
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
    <title>${pageTitle}</title>

</head>

<%@ include file="base/style.jsp" %>
<meta name="theme-color" content="#563d7c">
<link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
<style>
    input{
        margin-bottom: 10px;
    }
    select{
        margin-bottom: 10px;
    }
</style>
<!-- Custom styles for this template -->

</head>
<body class="text-center">
<form class="form-signin" action="${pageContext.request.contextPath}/studentCheck" method="post" id="mainForm" autocomplete="off">
    <!--<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">-->
    <h1 class="h3 mb-3 font-weight-normal">注册账号</h1>


    <div>
        <label for="id" class="sr-only">账号</label>
        <input type="text" name="stu_id" id="id" class="form-control" placeholder="账户" required autofocus>
    </div>



    <div>
        <label for="password" class="sr-only">密码</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" required>
    </div>

    <div>
        <label for="password2" class="sr-only">确认密码</label>
        <input type="password" name="password2" id="password2" class="form-control" placeholder="确认密码" required>
    </div>


    <!--<div >-->
    <!--<label for="sex" class="sr-only">性别</label>-->
    <!--<select class="custom-select" id="sex" required>-->
    <!--<option selected disabled value="">下拉选择性别</option>-->
    <!--&lt;!&ndash;<c:forEach var="department" items="${departmentList}">&ndash;&gt;-->

    <!--<option  name="sex"  value="男">男</option>-->
    <!--<option  name="sex"  value="女">女</option>-->

    <!--&lt;!&ndash;</c:forEach>&ndash;&gt;-->
    <!--</select>-->
    <!--</div>-->



    <div>
        <label for="name" class="sr-only ">真实姓名</label>
        <input type="text" name="name" id="name" class="form-control" placeholder="真实姓名" required >
    </div>

    <div class="custom-control custom-radio custom-control-inline">
        <input type="radio" id="man" name="sex" class="custom-control-input" value="男" checked>
        <label class="custom-control-label" for="man">男</label>
    </div>
    <div class="custom-control custom-radio custom-control-inline">
        <input type="radio" id="women" name="sex" class="custom-control-input" value="女">
        <label class="custom-control-label" for="women">女</label>
    </div>

    <div id="studentForm">
        <div >
            <label for="department" class="sr-only">系：</label>
            <select class="custom-select" id="department" >
                <option selected disabled value="">下拉选择系</option>
             <c:forEach var="department" items="${departmentList}">

                <option  name="department"  value="${department.department}">${department.department}</option>


                </c:forEach>
            </select>
        </div>

        <div >
            <label for="classes" class="sr-only">班级：</label>
            <select class="custom-select" id="classes" name="class_id">
                <option selected disabled value="">下拉选择班级</option>

            </select>
        </div>
    </div>

    <%--<div>--%>
        <%--<label for="class_id" class="sr-only">账号</label>--%>
        <%--<input type="text" name="class_id" id="class_id" class="form-control" placeholder="班级id" >--%>
    <%--</div>--%>

    <div>
        <div class=" custom-radio custom-control-inline">
            <strong>账号类型：</strong>
        </div>
        <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" id="student" name="rule" class="custom-control-input" checked>
            <label class="custom-control-label" for="student">学生</label>
        </div>
        <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" id="teacher" name="rule" class="custom-control-input">
            <label class="custom-control-label" for="teacher">教师</label>
        </div>
    </div>
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

    <p style="background-color: red;margin-bottom: 10px;color: white;border-radius: 50px">${msg}</p>

    <div class="row">

        <div class="col-md-4">
            <input class="btn btn-sm btn-primary btn-block" type="reset" value="重置">
        </div>
        <div class="col-md-4">
            <input class="btn btn-sm btn-success btn-block" type="submit" value="确认提交">
        </div>
        <div class="col-md-4">
            <a class="btn btn-sm btn-primary btn-block" href="${pageContext.request.contextPath}/login" >返回登录</a>
        </div>
    </div>



    <p class="mt-5 mb-3 text-muted">&copy; design by PeiHsien Mo</p>
</form>
<script>
    $(document).ready(function(){

        $('#teacher').click(function () {
            $('#studentForm').hide();
            $('#mainForm').attr("action","${pageContext.request.contextPath}/teacherCheck");
            $('#id').attr("name","teach_id");

        })
        $('#student').click(function () {
            $('#studentForm').show();
            $('#mainForm').attr("action","${pageContext.request.contextPath}/studentCheck");
            $('#id').attr("name","stu_id");
        })
        // $("classes")

        $('#department').click(function(){
            // var departmentValue=$('input:radio[name="department"]:checked').val();
            var departmentValue=$('#department option:selected') .val();
            $.ajax({
                url:"${pageContext.request.contextPath}/class/findByDepartment", //请求的url地址
                dataType:"html", //返回格式为json
                async:true,//请求是否异步，默认为异步，这也是ajax重要特性
                data:{"department":departmentValue}, //参数值
                type:"post", //请求方式
                beforeSend:function(){
                    //请求前的处理
                },
                success:function(data){
                    //请求成功时处理
                    $("#classes").html(data);
                },
                complete:function(){
                    //请求完成的处理
                },
                error:function(){
                    //请求出错处理
                }
            });
            //  htmlobj=$.ajax({url:"${pageContext.request.contextPath}/class/findByDepartment/"+departmentValue,async:false});
            // $("#classList").html(htmlobj.responseText);
        });
    });

</script>
</body>
</html>

