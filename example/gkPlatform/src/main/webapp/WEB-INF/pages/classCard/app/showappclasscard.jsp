<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>配置的班级列表</title>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
</head>
<style>
    p{
        width: 95%;
        margin: 0 auto;
        margin-top: 20px;
        color: #fc4c71 !important;
        font-size: 13px;
    }
    table{
        width: 95%;
        font-size: 13px;
        margin: 0 auto;
        margin-top: 10px;
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
        <p>说明：仅显示最近50条安装记录。</p>
        <%--执行此配置的班级列表--%>
        <table align="center">
            <thead>
            <tr>
                <th width="5%">序号</th>
                <%--<th width="15%">设备名称</th>--%>
                <th width="13%">班牌显示名称</th>
                <th width="6%">版本号</th>
                <th width="14%">分配时间</th>
                <th width="10%">反馈状态</th>
                <th width="14%">反馈时间</th>
                <th width="20%">反馈信息</th>
                <th width="15%">mac_id</th>
            </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${classCards}" var="classcard" varStatus="status">
                <tr>
                    <td>
                            ${status.index + 1}
                    </td>
                   <%-- <td>
                            ${classcard.equipmentName}
                    </td>--%>
                    <td>
                            ${classcard.classroom}
                    </td>
                    <td>
                            ${classcard.versionCode}
                    </td>
                    <td>
                            ${classcard.appDistributionTime}
                    </td>
                    <td>
                            ${classcard.appStatus}
                    </td>
                    <td>
                            ${classcard.feedBackTimeFormat}
                    </td>
                    <td>
                            ${classcard.feedBackRemarks}
                    </td>
                    <td>
                            ${classcard.macId}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="${ctxStatic}/js/jquery-1.7.2.js"type="text/javascript" charset="utf-8"></script>
    <script src="${ctxStatic}/js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">

    var size='${size}';
    if(size==0){
        layer.msg("暂无数据");
    }

</script>
</body>
</html>