<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="../../common/common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="njList" value="<%=ConstantUtil.njList%>"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/openDialog.js"></script>
    <style>
        table {
            width: 80%;
            font-size: 13px;
            margin: 0 auto;
            margin-top: 20px;
            background-color: transparent;
            border-spacing: 0;
            border-collapse: collapse;
        }

        thead {
            background: #e7eaec;
            color: #333
        }

        th {
            padding: 5px 6px 5px 6px;
            height: 35px;
            border: 1px solid #ddd;
            text-align: left;
        }

        td {
            padding: 5px 6px 5px 6px;
            border: 1px solid #ddd;
            word-wrap: break-word;
            word-break: break-all;
            line-height: 21px;
        }

        td span:hover {
            color: #fc4c71;
        }
    </style>
</head>
<body>
<form action="${ctx}/classcard/save">
</form>

<div class="container">
    <%--<h3>通知信息</h3>--%>
    <div class="stuMsg">
        <input type="hidden" name="ueditorPics" value="" id="ueditorPics">
        <table>
            <thead>
            <tr>
                <th>模块名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classCardApps}" var="app">
                <tr>
                    <td>${app.appName}</td>
                    <c:if test="${superPackage.contains(app.packageName)==false}">
                        <td><span class="deleteRef" data-appid="${app.id}" style="cursor: pointer">卸载</span></td>
                    </c:if>
                    <c:if test="${superPackage.contains(app.packageName)==true}">
                        <td></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="hidden" id="classCardId" value="${classCardId}">
    </div>
    <script>
        $(".deleteRef").on("click", function () {
            var appIds = $(this).data('appid');
            var classCardId = $("#classCardId").val();

            $.post("${ctx}/model/deleteClassCardAppRef", {
                appIds: appIds,
                classCardId: classCardId
            }, function (retJson) {
                if (retJson.code == 0) {
                    layer.msg('卸载成功')
                } else {
                    layer.msg(retJson.msg,{time:3000})
                }
            }, "json");
            setTimeout(function () {
                /* parent.location.reload();*/
                window.parent.closeAll();
                <%--openDialogView('模块分配', '${ctx}/model/classcard-app?id=${classCardId}&option=edit', '900px', '650px', false);--%>
            }, 3000);
        })
    </script>
</body>
</html>