<%@ include file="../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<form id="pagerForm" method="post" action="${ctx}/projectReport/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}"/>
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}"/>
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/projectReport/index" method="post"
          onreset="$(this).find('input').val()">
        <div class="searchBar">

        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctx}/projectReport/pop/modify" target="dialog" width="650" height="500"
                   mask="true"><span>新增</span></a></li>

        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="60">工程全名</th>
            <th width="40">简称</th>
            <th width="80">完成描述</th>
            <th width="40">完成报告图片</th>
            <%--<th width="80">附件文档</th>--%>
            <th width="80" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="report">
            <tr target="sid_user" rel="1">
                <td>${report.projectName}</td>
                <td>${report.projectSimpleName}</td>
                <td>${report.projectDesc}</td>
                <td>
                    <div>
                        <a href="${report.projectPic}" target="view_window">${report.projectPic}</a>
                    </div>
                </td>
                    <%--<td>--%>
                    <%--<div>--%>
                    <%--<a href="${report.projectAttach}" target="view_window">${config.projectAttach}</a>--%>
                    <%--</div>--%>
                    <%--</td>--%>
                <td>
                    <div>
                        <a target="dialog" href="${ctx}/projectReport/pop/modify?id=${report.id}" class="">修改</a>
                        <a target="dialog" href="${ctx}/projectReport/pop/modify?id=${report.id}&type=view" class="">查看</a>
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
                <option
                        <c:if test="${pageInfo.pageSize==20}">selected</c:if> value="20">20
                </option>
                <option
                        <c:if test="${pageInfo.pageSize==50}">selected</c:if> value="50">50
                </option>
                <option
                        <c:if test="${pageInfo.pageSize==100}">selected</c:if> value="100">100
                </option>
                <option
                        <c:if test="${pageInfo.pageSize==150}">selected</c:if> value="150">150
                </option>
                <option
                        <c:if test="${pageInfo.pageSize==200}">selected</c:if> value="200">200
                </option>
                <option
                        <c:if test="${pageInfo.pageSize==250}">selected</c:if> value="250">250
                </option>
            </select>
            <span>条，共${pageInfo.total}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${pageInfo.total}" numPerPage="${pageInfo.pageSize}"
             pageNumShown="5" currentPage="${pageInfo.pageNum}"></div>

    </div>
</div>