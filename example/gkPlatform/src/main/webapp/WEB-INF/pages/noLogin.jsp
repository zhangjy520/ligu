<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.StringWriter" %>
<%@ include file="common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>提示</title>
    <link rel="icon" href="${ctxStaticNew}/images/logo.png"/>
    <style>
        body>div{margin-top:12%;text-align:center;}
        .noticeDiv >div{
            padding-top: 16px;
        }
        #backIndex{
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div>
    <img src="${ctxStaticNew}/images/noLogin.png" alt=""/>
    <div class="noticeDiv" style="padding-top: 30px">
        <div style="font-size: 18px;color: #525252">登录超时，请<a style="font-size: 14px;color: #54AB37" id="backIndex" href = '${ctx}/login'>重新登录</a></div>
    </div>
</div>
</body>
</html>