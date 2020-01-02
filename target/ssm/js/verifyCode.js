function changeCode(){

    var src = "${pageContext.request.contextPath}/getVerifyCode?"+new Date().getTime(); //加时间戳，防止浏览器利用缓存

    $('.verifyCode').attr("src",src);                  //jQuery写法

}
 
