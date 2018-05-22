<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../common/common.jsp" %>
<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<c:set var="njList" value="<%=ConstantUtil.njList%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/oldCss.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <script src="${ctxStaticNew}/js/jquery.min.js"></script>
    <script src="${ctxStaticNew}/js/layer/layer.js"></script>
    <script src="${ctxStaticNew}/js/openDialog.js"></script>
    <script src="${ctxStaticNew}/js/laydate.js"></script>
</head>
<style>
    table{
        width: 85%;
        font-size: 13px;
        margin: 0 auto;
        margin-top: 20px;
        background-color: transparent;
        border-spacing: 0;
        border-collapse: collapse;
    }
    thead{
        background: #e7eaec;
        color: #333
    }
    th{
        padding: 5px 6px 5px 6px;
        height: 35px;
        border: 1px solid #ddd;
        text-align: left;
    }
    td{
        padding: 5px 6px 5px 6px;
        border: 1px solid #ddd;
        word-wrap: break-word;
        word-break: break-all;
        line-height: 21px;
        text-align: left;
    }
    td span:hover{
        color: #fc4c71;
    }
    td input{
        border: none;
        outline: none;
        background: none;
        cursor: pointer;
    }
    td input:first-child{
        color: #54ab37;
    }
    td input:last-child{
        color: #fc4c71;
    }
</style>
<body>
    <div>
        <table align="center">
            <thead>
            <tr>
                <th width="3%">序号</th>
                <th width="12%">名称</th>
                <th width="7%">循环星期</th>
                <th width="5%">开机时间</th>
                <th width="5%">关机时间</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${classcardConfigViews}" var="configPageView" varStatus="status">
                <tr>
                    <td>
                            ${status.index + 1}
                    </td>
                    <td>
                            ${configPageView.name}
                    </td>

                    <td>
                            ${configPageView.week}
                    </td>
                    <td>
                            ${configPageView.startTimeView}
                    </td>
                    <td>
                            ${configPageView.endTimeView}
                    </td>
                    <td>
                        <input type="button" onclick="configEdit('${configPageView.id}')" value="查看"/>
                        <input type="button" onclick="delConfig('${configPageView.id}')" value="删除"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<script type="text/javascript">
    function configDelete(configId) {
        var url = "${ctx}/classcard/config/deleteOne";

        $.get(url,{
            configId:configId,
            classcardId:'${classcardId}'
        },function (retJson) {
            if (retJson.code == '0'){
                layer.msg(retJson.msg);
            }
            else {
                layer.msg("删除失败");
            }
        }, "json");
        closeAlertDiv();
        setTimeout(function () {
            window.location.reload();
        }, 200);
    }

    function delConfig(configId) {
        alertTips('400px','200px','删除播放','确定要删除${configPageView.name}吗？','configDelete(\''+ configId +'\')');
    }

    function configEdit(configId) {
        var url = '${ctx}/classcard/config/edit?option=edit&id=' + configId;
        openDialogView('开关机配置',url,'900px','650px',false);
    }
</script>
</body>
</html>