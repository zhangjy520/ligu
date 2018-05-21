<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="login">
<meta name="author" content="lexi">

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<title>学生</title>
<script>
    $(function() {
        $("#submit-btn").click(function(event){
            $.post($("form").attr('action'),{
                id:$("input[name='id']").val(),
                name:$("input[name='name']").val(),
            },function(retJson){
                if (retJson.code == '0') {
                    window.location.replace("${ctx}/student/index");
                } else {
                    alert(retJson.msg);
                }
            });
        });
    });
</script>
</head>
<title></title>
<body>

<form action="${ctx}/student/save">
    <input type="hidden" name="id" value="${student.id}">
    <input type="text" name="name" value="${student.name}">
    <input id="submit-btn" type="button" value="修改">
</form>

</body>
</html>