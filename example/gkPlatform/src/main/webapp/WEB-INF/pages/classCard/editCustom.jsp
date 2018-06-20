<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ include file="../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
                <th width="5%">序号</th>
                <th width="15%">名称</th>
                <th width="10%">时间设定</th>
                <th width="10%">循环星期</th>
                <th width="10%">循环日期</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${customPageViews}" var="customPageView" varStatus="status">
                <tr>
                    <td>
                            ${status.index + 1}
                    </td>
                    <td>
                            ${customPageView.name}
                    </td>
                    <td>
                            ${customPageView.startTimeView} --- ${customPageView.endTimeView}
                    </td>
                    <td>
                        <c:if test="${customPageView.loopMark == 'D'}">
                            天
                        </c:if>
                        <c:if test="${customPageView.loopMark == 'W'}">
                            周
                        </c:if>
                        <c:if test="${customPageView.loopMark == 'M'}">
                            月
                        </c:if>
                        <c:if test="${customPageView.loopMark == 'N'}">
                            不循环
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${customPageView.loopDate == ''}">
                            ---
                        </c:if>
                        <c:if test="${customPageView.loopDate != ''}">
                            ${customPageView.loopDate}
                        </c:if>
                    </td>
                    <td>
                        <input type="button" onclick="editPage('${customPageView.id}','disabled')" value="查看"/>
                        <input type="button" onclick="delCustomPage('${customPageView.id}')" value="删除"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<script type="text/javascript">
    function customPageDelete(pageId) {
        var url = "${ctx}/classcard/custom/unpublish";

        $.get(url,{
            pageId:pageId,
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

    function delCustomPage(pageId) {
        alertTips('400px','200px','删除播放','确定要删除${customPageView.name}吗？','customPageDelete(\''+ pageId +'\')');
    }

    function editPage(pageId,option) {
        window.open("${ctx}/classcard/custom/edit?pageId="+pageId+"&option="+option);
    }
</script>
</body>
</html>