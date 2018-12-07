<%@ include file="../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<form id="pagerForm" method="post" action="${ctx}/question/score">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}"/>
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}"/>
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/question/index" method="post"
          onreset="$(this).find('input').val()">
        <div class="searchBar">
            <table class="searchContent">

            </table>
            <div class="subBar">
                <ul style="float: left;">
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <shiro:hasAnyRoles name="root">
                <li><a title="确实要删除这些人的考试数据吗?" target="selectedTodo" postType="string"
                       href="${ctx}/question/batch_delete"
                       class="delete"><span>批量删除</span></a></li>
            </shiro:hasAnyRoles>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="40">考试人员</th>
            <th width="60">最新考试时间</th>
            <th width="120">最高分数</th>
            <th width="40">历史考试成绩</th>
            <shiro:hasAnyRoles name="root">
                <th width="80">操作</th>
            </shiro:hasAnyRoles>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="question">
            <tr target="sid_user" rel="1">
                <td><input name="ids" value="${question.id}" type="checkbox"></td>
                <td>${question.name}</td>
                <td>${ligu:millsToDate(question.latestTime,'yyyy-MM-dd HH:mm')}</td>
                <td>${question.maxScore}</td>
                <td><a style="color: blue" href="${ctx}/question/score/${question.id}?personName=${question.name}"
                       target="dialog" height="600" width="1200">点击查看</a></td>

                <shiro:hasAnyRoles name="root">
                    <td>
                        <div>
                            <a target="ajaxTodo" title="确认删除？删除后,此人的所有历史成绩将被清空"
                               href="${ctx}/question/batch_delete?ids=${question.id}"
                               class="">删除历史成绩</a>
                        </div>
                    </td>
                </shiro:hasAnyRoles>
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