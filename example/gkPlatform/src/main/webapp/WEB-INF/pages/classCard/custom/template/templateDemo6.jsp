<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="../../../common/common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图文编辑器</title>
    <script src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script src="${ctxStatic}/upload/h5upload.js"></script>
    <link rel="stylesheet" href="${ctxStaticNew}/kindeditor-4.1.10/themes/default/default.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/kindeditor-4.1.10/plugins/code/prettify.css"/>
    <script charset="utf-8" src="${ctxStaticNew}/kindeditor-4.1.10/kindeditor.js"></script>
    <script charset="utf-8" src="${ctxStaticNew}/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <script charset="utf-8" src="${ctxStaticNew}/kindeditor-4.1.10/plugins/code/prettify.js"></script>

</head>
<body>
<div id="bgImage" style="height: 100%;">
    <div id="headline">
        <%--<h3>标题文字</h3>--%>
    </div>

</div>
</body>
</html>