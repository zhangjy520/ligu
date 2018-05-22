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
        <%--执行此配置的班级列表--%>
        <table align="center">
            <thead>
            <tr>
                <th width="5%">序号</th>
                <th width="15%">名称</th>
                <th width="30%">设备名称</th>
                <th width="15%">mac_id</th>
            </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${publishClasscards}" var="publishClasscard" varStatus="status">
                <tr>
                    <td>
                            ${status.index + 1}
                    </td>
                    <td>
                            ${publishClasscard.equipmentName}
                    </td>
                    <td>
                            ${publishClasscard.classroom}
                    </td>
                    <td>
                            ${publishClasscard.macId}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>