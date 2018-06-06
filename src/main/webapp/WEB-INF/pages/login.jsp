<%@ include file="common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台管理</title>
    <link href="${ctxStatic}/css/login.css" rel="stylesheet" type="text/css">
    <script src="${ctxStatic}/js/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="${ctxStatic}/images/login-img.png"></div>
    <div class="login">
        <div class="login_logo"><a><img
                src="${ctxStatic}/images/login_logo.png"></a></div>
        <div class="login_name">
            <p>后台管理系统</p>
        </div>
        <input name="username" type="text" value="用户名" onfocus="this.value=''"
               onblur="if(this.value==''){this.value='用户名'}">
        <span id="password_text"
              onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">密码</span>
        <input name="password" type="password" id="password" style="display:none;"
               onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};">
        <input value="登录" style="width:100%;" type="button" onclick="login()">

    </div>
    <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
<script>

    $("body").keydown(function () {
        if (event.keyCode == "13") {//keyCode=13是回车键
            login();
        }
    });

    function login() {

        $.ajax({
            type: "post",
            url: "${ctx}/doLogin",
            data: {
                username: $('input[name="username"]').val(),
                password: $('input[name="password"]').val()
            },
            dataType: "json",
            success: function (data) {
                if (data.code == '0') {
                    window.location.replace("${ctx}/" + data.data);
                } else {
                    alert(data.msg);
                }
            },
            error: function (e) {
                //alert(JSON.stringify(e));
            }
        });
    }
</script>
</body>
</html>