<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <META http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Language" content="en" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>首页</title>
    <link href="${ctxStatic}/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/main.js"></script>
</head>

<body>
    <table>
        <tr>
            <td>ID</td>
            <td>标题</td>
            <td>路径</td>
            <td>权限标识</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${menuList}" var="menu">
            <tr>
                <td>${menu.id}</td>
                <td>${menu.name}</td>
                <td>${menu.href}</td>
                <td>${menu.permission}</td>
                <td>
                    <a href="${ctx}/menu/edit?id=${menu.id}">编辑</a> |
                    <a href="${ctx}/menu/addSub?parentId=${menu.id}">添加子菜单</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="${ctx}/menu/add">添加</a>

</body>
</html>

