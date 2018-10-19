<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<form id="pagerForm" method="post" action="${ctx}/appConfig/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}" />
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/appConfig/index" method="post" onreset="$(this).find('input').val()">
        <div class="searchBar">

        </div>
    </form>
</div>
<div class="pageContent">
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="60">配置描述</th>
            <th width="40">配置类型</th>
            <th width="40">配置项</th>
            <th width="80">配置值</th>
            <th width="80" align="center">修改</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="config">
            <tr target="sid_user" rel="1">
                <td>${config.configDesc}</td>
                <td>${config.configType}</td>
                <td>${config.configKey}</td>
                <td>
                    <div>
                        <a href="${config.configValue}" target="view_window">${config.configValue}</a>
                    </div>
                </td>
                <td>
                    <div>
                         <a target="dialog"  href="${ctx}/appConfig/pop/modify?id=${config.id}" class="">修改</a>
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