<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<form id="pagerForm" method="post" action="${ctx}/appGuangGao/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}" />
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/appGuangGao/index" method="post" onreset="$(this).find('input').val()">
        <div class="searchBar">

        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
                <li><a class="add" href="${ctx}/appGuangGao/pop/modify" target="dialog"
                       mask="true"><span>新增</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="60">广告ID</th>
            <th width="40">广告类型</th>
            <th width="40">广告标题</th>
            <th width="80">广告内容</th>
            <th width="80" align="center">修改</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="config">
            <tr target="sid_user" rel="1">
                <td>${config.id}</td>
                <td>${config.type}</td>
                <td>${config.title}</td>
                <td>
                    <div>
                        <a href="${config.content}" target="view_window">${config.content}</a>
                    </div>
                </td>
                <td>
                    <div>
                       <a target="ajaxTodo" title="确认删除？" href="${ctx}/appGuangGao/delete/${config.id}" class="">删除</a>
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