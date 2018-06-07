<%@ include file="../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<form id="pagerForm" method="post" action="${ctx}/person/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}"/>
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}"/>
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/person/index" method="post"
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
            <li><a class="add" href="${ctx}/person/pop/modify?roleType=${roleType}" target="dialog"
                   mask="true"><span>新增</span></a></li>
            <shiro:hasRole name="worker_er">
                <%--施工管理员才能录入施工人员--%>
                <li class="line">line</li>
                <li><a class="icon" href="${ctx}/person/template/download" target="dwzExport" targetType="navTab"
                       title="下载导入模版?"><span>下载导入模版</span></a></li>
                <li><a class="icon" href="${ctx}/person/pop/upload" target="dialog" title="导入人员?"><span>导入人员</span></a>
                </li>
            </shiro:hasRole>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="20">id</th>
            <th width="40">name</th>
            <th width="60">type</th>
            <th width="120">gender</th>
            <th width="40">contact</th>
            <th width="80" align="center">identityNum</th>
            <th width="80">insurancePurchases</th>
            <th width="80">salaryDetails</th>
            <th width="80">address</th>
            <th width="80">professionalUnit</th>
            <th width="80">status</th>
            <shiro:hasAnyRoles name="worker_er,checker">
                <th width="80" align="center">caozuo</th>
            </shiro:hasAnyRoles>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${ligu:getValueByKeyAndFlag(person.type,'personType')}</td>
                <td>${person.gender}</td>
                <td>${person.contact}</td>
                <td>${person.identityNum}</td>
                <td>${person.insurancePurchases}</td>
                <td>${person.salaryDetails}</td>
                <td>${person.address}</td>
                <td>${person.professionalUnit}</td>
                <td>${ligu:getValueByKeyAndFlag(person.status,'personStatus')}</td>
                <shiro:hasRole name="worker_er">
                    <%--施工管理员能操作--%>
                    <td>
                        <div>
                            <a target="ajaxTodo" title="确认删除？" href="${ctx}/person/delete/${person.id}" class="">删除</a>
                            <a target="dialog" href="${ctx}/person/pop/modify?id=${person.id}&roleType=${roleType}"
                               class="">修改</a>
                        </div>
                    </td>
                </shiro:hasRole>
                <shiro:hasRole name="checker">
                    <td>
                        <div>
                            <a target="dialog"
                               href="${ctx}/person/pop/modify?id=${person.id}&roleType=${roleType}&check=check"
                               class="">审核</a>
                        </div>
                    </td>
                </shiro:hasRole>

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