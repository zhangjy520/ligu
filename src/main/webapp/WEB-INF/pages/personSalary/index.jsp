<%@ include file="../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style>
    td >div{
        height: auto !important;
    }
</style>
<form id="pagerForm" method="post" action="${ctx}/personSalary/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}"/>
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}"/>
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/personSalary/index" method="post"
          onreset="$(this).find('input').val()">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        人员姓名：<input type="text" name="name" value="${chooseName}"/>
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul style="float: left;">
                    <li>
                        <div class="button">
                            <div class="buttonContent">
                                <button type="reset">重置</button>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">查询</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <shiro:hasAnyRoles name="worker_er,item_er,root">
                <%--非管理员无法新增施工人员--%>
            <li><a class="add" href="${ctx}/personSalary/pop/modify" target="dialog"
                   mask="true"><span>新增</span></a></li>

                <li class="line">line</li>
                <li><a title="确实要删除这些记录吗?" target="selectedTodo" postType="string" href="${ctx}/personSalary/batch_delete" class="delete"><span>批量删除</span></a></li>
                <li><a class="icon" href="${ctx}/personSalary/template/download" target="dwzExport" targetType="navTab"
                       title="下载薪资导入模版?"><span>下载薪资导入模版</span></a></li>
                <%--<li><a class="icon" href="${ctx}/personSalary/export" target="dwzExport" targetType="navTab"
                       title="导出薪资记录?"><span>导出薪资记录</span></a></li>--%>
                <li><a class="icon" href="${ctx}/personSalary/pop/upload" width="650" height="600" target="dialog" title="导入薪资记录?"><span>导入薪资记录</span></a>
                </li>

            </shiro:hasAnyRoles>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="40">姓名</th>
            <th width="80" align="center">身份证号码</th>
            <th width="80">生活费</th>
            <th width="80">生活费发放年月</th>
            <th width="80">工资</th>
            <th width="80">工资发放年月</th>
            <th width="80">发放凭证</th>
            <shiro:hasAnyRoles name="worker_er,item_er,checker,root">
                <th width="80" align="center">操作</th>
            </shiro:hasAnyRoles>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="person">
            <tr>
                <td><input name="ids" value="${person.id}" type="checkbox"></td>
                <td>${person.personName}</td>
                <td>${person.personNum}</td>
                <td>${person.salaryLife}</td>
                <td>${person.timeLife}</td>
                <td>${person.salarySum}</td>
                <td>${person.timeSum}</td>
                <td>
                    <ul>
                        <c:forEach items="${person.zhengJuList}" var="attach">
                            <li><a href="${attach}" target="view_window">${attach}</a></li>
                        </c:forEach>
                    </ul>
                </td>
                <shiro:hasAnyRoles name="worker_er,item_er,root">
                    <%--施工管理员能操作--%>
                    <td>
                        <div>
                            <a target="ajaxTodo" title="确认删除？" href="${ctx}/personSalary/delete/${person.id}" class="">删除</a>
                            <a target="dialog" href="${ctx}/personSalary/pop/modify?id=${person.id}"
                               class="">修改</a>
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
    <script>
        function batchDelete(){

        }
    </script>
</div>