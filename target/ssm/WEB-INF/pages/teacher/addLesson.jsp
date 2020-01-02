<%--
  Created by IntelliJ IDEA.
  User: 惠普
  Date: 2019/12/4
  Time: 16:53
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
        <%--<div class="row justify-content-md-center">--%>
        <div class="col-6">
            <!-- Example row of columns -->
            <form action="${pageContext.request.contextPath}/teacher/saveLesson" method="post" autocomplete="off">

                <div>
                    <script>
                        function a(obj) {;
                            $(obj).find("div").show();
                        }
                        function b(obj) {
                            $(obj).find("div").hide();
                        }
                    </script>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="false" aria-expanded="true">
                            下拉选择班级（可多选）
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="classMenu">
                            <c:forEach var="department" items="${departments}">
                                <div  onmouseover="a(this)" onmouseout="b(this)">
                                    <span class="dropdown-header">${department.department}</span>

                                    <c:forEach var="class_" items="${classes}">
                                        <c:if test="${department.department == class_.department}">
                                            <div class="form-check" id="${class_.class_id}" style="display: none;">
                                                <input class="form-check-input" type="checkbox" name="class_id1[]" value="${class_.class_id}" id="defaultCheck${class_.class_id}">
                                                <label class="form-check-label" for="defaultCheck${class_.class_id}">
                                                        ${class_.name}
                                                </label>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>

                            </c:forEach>
                        </div>
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with dropdown button" placeholder="请输入可选课班级" name="class_id" id="class_id" value="" readonly>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon2">课程名称</span>
                    </div>
                    <input type="text" class="form-control" placeholder="课程名称" name="name" aria-label="name" aria-describedby="basic-addon2" id="name" value="">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon3">授课时间</span>
                    </div>
                    <input type="text" class="form-control" placeholder="授课时间" name="teach_time" aria-label="name" aria-describedby="basic-addon3" id="teach_time" value="">
                    <select name="day">
                        <option readonly="">下拉选择星期</option>
                        <option value="周一">周一</option>
                        <option value="周二">周二</option>
                        <option value="周三">周三</option>
                        <option value="周四">周四</option>
                        <option value="周五">周五</option>
                        <option value="周六">周六</option>
                        <option value="周日">周日</option>
                    </select>
                    <div class="dropdown">
                        <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-toggle="dropdown" aria-haspopup="false" aria-expanded="true">
                            下拉选择节数（可多选）
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="lessonMenu">

                            <div class="form-check" id="1" >
                                <input class="form-check-input" type="checkbox" name="lesson[]" value="1" id="lesson_1">
                                <label class="form-check-label" for="lesson_1">
                                    1
                                </label>
                            </div>
                            <div class="form-check" id="2" >
                                <input class="form-check-input" type="checkbox" name="lesson[]" value="2" id="lesson_2">
                                <label class="form-check-label" for="lesson_2">
                                    2
                                </label>
                            </div>
                            <div class="form-check" id="3" >
                                <input class="form-check-input" type="checkbox" name="lesson[]" value="3" id="lesson_3">
                                <label class="form-check-label" for="lesson_3">
                                    3
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon4">授课教师</span>
                    </div>
                    <input type="text" class="form-control" placeholder="${sessionScope.userName}" name="teach_id" aria-label="teach_id" aria-describedby="basic-addon4" id="teach_id" value="${sessionScope.userId}" readonly>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon6">授课地点</span>
                    </div>
                    <input type="text" class="form-control" placeholder="授课地点" name="teach_place" aria-label="teach_place" aria-describedby="basic-addon6" id="teach_place" value="" >
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon5">可选人数</span>
                    </div>
                    <input type="text" class="form-control" placeholder="可选课人数" name="limit" aria-label="limit" aria-describedby="ba sic-addon5" id="limit" value="">
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
        <%--</div>--%>

    </div>


</main>
<script>


    $('#classMenu').click(function() {
        // var classValue=$('input:checkbox[name="class_id[]"]:checked').val();

//jquery获取复选框值
        var chk_value =[];//定义一个数组
        $('input:checkbox[name="class_id1[]"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数
            chk_value.push($(this).val());//将选中的值添加到数组chk_value中
        });
        $("#class_id").val(chk_value);


    })
</script>


<%@ include file="../base/footer.jsp" %>
</body>
</html>
