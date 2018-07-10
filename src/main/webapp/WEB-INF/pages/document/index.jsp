<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<form id="pagerForm" method="post" action="${ctx}/doc/index">
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageInfo.pageSize}" />
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="${ctx}/doc/index" method="post" onreset="$(this).find('input').val()">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        文档名称：<input type="text" name="name" value="${chooseName}"/>
                    </td>
                    <td>
                        文档类型：
                        <select class="" name="type">
                            <option value="0" >请选择</option>
                            <option value="1" <c:if test="${chooseType eq'1'}">selected</c:if> >安全生产视频课程</option>
                            <option value="2" <c:if test="${chooseType eq '2'}">selected</c:if> >安全生产培训文档</option>
                            <option value="3" <c:if test="${chooseType eq '3'}">selected</c:if> >安全生产安全守则</option>
                            <option value="4" <c:if test="${chooseType eq '4'}">selected</c:if> >施工工艺视频课程</option>
                            <option value="5" <c:if test="${chooseType eq '5'}">selected</c:if> >施工工艺培训文档</option>
                            <option value="6" <c:if test="${chooseType eq '6'}">selected</c:if> >施工工艺工艺示例</option>
                        </select>
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
            <shiro:hasAnyRoles name="root">
            <li><a class="add" href="${ctx}/doc/pop/modify" target="dialog" mask="true"><span>新增</span></a></li>
            </shiro:hasAnyRoles>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="20">文档编号</th>
            <th width="60">文档名称</th>
            <th width="40">文档类型</th>
            <th width="40">文档下载地址</th>
            <th width="80">文档大小</th>
            <th width="80">文档访问次数</th>
            <th width="80">文档说明</th>
            <shiro:hasAnyRoles name="root">
            <th width="80" align="center">操作</th>
            </shiro:hasAnyRoles>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageInfo.list}" var="doc">
            <tr target="sid_user" rel="1">
                <td>${doc.id}</td>
                <td>${doc.name}</td>
                <td>${ligu:getValueByKeyAndFlag(doc.type,'documentType')}</td>
                <td>
                    <div>
                        <a href="${doc.url}" target="view_window">${doc.url}</a>
                    </div>
                </td>
                <td>${doc.size}</td>
                <td>${doc.applyTime}</td>
                <td>${doc.remark}</td>
                <shiro:hasAnyRoles name="root">
                <td>
                    <div>
                        <a target="ajaxTodo" title="确认删除？" href="${ctx}/doc/delete/${doc.id}" class="">删除</a>
                        <a target="dialog"  href="${ctx}/doc/pop/modify?id=${doc.id}" class="">修改</a>
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