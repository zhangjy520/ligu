<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<form id="pagerForm" method="post" action="${ctx}/item/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}" />
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/question/index" method="post" onreset="$(this).find('input').val()">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        项目内容：<input type="text" name="name" value="${chooseName}"/>
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul style="float: left;">
                    <li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctx}/item/pop/modify" target="dialog" mask="true"><span>新增</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="20">id</th>
            <th width="20">parentId</th>
            <th width="60">name</th>
            <th width="20">sort</th>
            <th width="40">code</th>
            <th width="120">master</th>
            <th width="120" align="center">masterName</th>
            <th width="120" align="center">companyName</th>
            <th width="80" align="center">itemFlag</th>
            <th width="80" align="center">itemCycle</th>
            <th width="80" align="center">caozuo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.parentId}</td>
                <td>${item.name}</td>
                <td>${item.sort}</td>
                <td>${item.code}</td>
                <td>${item.master}</td>
                <td>${item.masterName}</td>
                <td>${item.companyName}</td>
                <td>${item.itemFlag}</td>
                <td>${item.itemCycle}</td>
                <td>
                    <div>
                        <a target="ajaxTodo" title="确认删除？" href="${ctx}/item/delete/${item.id}" class="">删除</a>
                        <a target="dialog"  href="${ctx}/item/pop/modify?id=${item.id}" class="">修改</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option <c:if test="${pageInfo.pageSize==20}">selected</c:if> value="20">20</option>
                <option <c:if test="${pageInfo.pageSize==50}">selected</c:if> value="50">50</option>
                <option <c:if test="${pageInfo.pageSize==100}">selected</c:if> value="100">100</option>
                <option <c:if test="${pageInfo.pageSize==150}">selected</c:if> value="150">150</option>
                <option <c:if test="${pageInfo.pageSize==200}">selected</c:if> value="200">200</option>
                <option <c:if test="${pageInfo.pageSize==250}">selected</c:if> value="250">250</option>
            </select>
            <span>条，共${pageInfo.total}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${pageInfo.total}" numPerPage="${pageInfo.pageSize}" pageNumShown="5" currentPage="${pageInfo.pageNum}"></div>

    </div>
</div>