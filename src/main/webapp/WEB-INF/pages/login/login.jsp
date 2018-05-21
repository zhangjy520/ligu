<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="login">
<meta name="author" content="lexi">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css"/>

<script src="${pageContext.request.contextPath}/assets/js/jquery.js"></script>

<script>
	$(function() {
		$("#login_btn").click(function(event){
			$.post($('form').attr('action'),{
				username:$('#username').val(),
				password:$('#password').val()
			},function(retJson){
				if (retJson.code == '0') {
					window.location.replace("${pageContext.request.contextPath}/"+retJson.data);
				} else {
					alert(retJson.msg);
				}
			});
		});

	});
</script>
<title>login</title>
</head>
<body>
	<div class="headInfo">
			<!-- <img align="absmiddle" src="image/yangguangFb.png"/>阳光分班
			<div class="devideLine">
				 均衡搭配 智能分班
			</div> -->
		</div>
		<div class="loginForm">
			<form method="post"  action="${pageContext.request.contextPath}/doLogin" autocomplete="off" >
				<div style="height: 20%;text-align: center;font-size: 20px;color: #1AB394;line-height: 66px;">
					用户登录					
				</div>
				<div class="" style="height: 80%;">
					 <input class="form-control noAuto" placeholder="请输入帐号" id="username" name="username" type="text" >
					 <input class="form-control noAuto" placeholder="请输入密码" id="password" name="password" type="password" value="">
					
					<div class="checks">
						<input class="rsCheck" style="float:left;" type="checkbox" name="remember"  id="" value="Remember Me" />
						<label>&nbsp;记住我</label>
						<label style="float: right;">忘记密码?</label>
					</div>
					
					<div id="login_btn" class="btn btn-lg btn-success btn-block">登录</div>
					<!-- <input type="submit" id="loginButton" value="登录"/> -->
				</div>
				
			</form>
			
		</div>
<%-- 
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title">xxxLogin</h2>
                </div>
                <div class="panel-body">
                    <form method="post" action="${pageContext.request.contextPath}/doLogin">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="请输入帐号" id="username" name="username" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="请输入密码" id="password" name="password" type="password" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <div id="login_btn" class="btn btn-lg btn-success btn-block">登录</div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div> --%>
</body>
</html>