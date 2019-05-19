<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<form id="pagerForm" method="post" action="${ctx}/projectInfo/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}" />
</form>

<div class="pageHeader">
   <%-- <form onsubmit="return navTabSearch(this);" action="${ctx}/projectInfo/index" method="post" onreset="$(this).find('input').val()">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        题目内容：<input type="text" name="content" value="${chooseContent}"/>
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
    </form>--%>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctx}/projectInfo/pop/modify" target="dialog" mask="true"><span>新增</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="${ctx}/projectInfo/template/download" target="dwzExport" targetType="navTab" title="下载导入模版?"><span>下载导入模版</span></a></li>
            <li><a class="icon" href="${ctx}/projectInfo/pop/upload" target="dialog" title="导入工程信息?"><span>导入工程信息</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="40">id</th>
            <th width="60">区县</th>
            <th width="120">专业</th>
            <th width="40">工程年份</th>
            <th width="80">工程名称</th>
            <th width="80">施工单位名称</th>
            <th width="80" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="projectInfo">
            <tr target="sid_user" rel="1">
                <td>${projectInfo.id}</td>
                <td>${projectInfo.area}</td>
                <td>${projectInfo.profession}</td>
                <td>${projectInfo.projectYear}</td>
                <td>${projectInfo.projectName}</td>
                <td>${projectInfo.companyUnit}</td>
                <td>
                    <div>
                        <a target="ajaxTodo" title="确认删除？" href="${ctx}/projectInfo/delete/${projectInfo.id}" class="">删除</a>
                        <a target="dialog"  href="${ctx}/projectInfo/pop/modify?id=${projectInfo.id}" class="">修改</a>
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