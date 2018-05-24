<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<form id="pagerForm" method="post" action="${ctx }/user/list">
    <input type="hidden" name="pageNum" value="${users.current}" />
    <input type="hidden" name="numPerPage" value="10" />
</form>

<div class="pageHeader">
    <form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post" onreset="$(this).find('select.combox').comboxReset()">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        我的客户：<input type="text" name="keyword" />
                    </td>
                    <td>
                        <select class="combox" name="province" ref="demo_combox_city" refUrl="demo/combox/city_{value}.html" reset-value="bj">
                            <option value="all">所有省市</option>
                            <option value="bj">北京</option>
                            <option value="sh">上海</option>
                            <option value="zj">浙江省</option>
                        </select>
                        <select class="combox" name="city" id="demo_combox_city" ref="demo_combox_region" refUrl="demo/combox/region_{value}.html">
                            <option value="all">所有城市</option>
                        </select>
                        <select class="combox" name="region" id="demo_combox_region">
                            <option value="all">所有区县</option>
                        </select>
                    </td>
                    <td>
                        <select class="combox" name="type">
                            <option value="all">所有等级</option>
                            <option value="1">1级</option>
                            <option value="2">2级</option>
                            <option value="3" selected>3级</option>
                        </select>
                    </td>
                    <td class="dateRange">
                        建档日期:
                        <input name="startDate" class="date readonly" readonly="readonly" type="text" value="">
                        <span class="limit">-</span>
                        <input name="endDate" class="date readonly" readonly="readonly" type="text" value="">
                    </td>
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
                    <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctx }/user/add.html" target="dialog" mask="true"><span>添加</span></a></li>
            <li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
        <tr>
            <th width="80">id</th>
            <th width="120">名称</th>
            <th>登录名</th>
            <th width="100">密码</th>
            <th width="150">职务</th>
            <th width="80" align="center">职务描述</th>
            <th width="80">角色code</th>
            <th width="80" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users.records}" var="user">
            <tr target="sid_user" rel="1">
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.loginName}</td>
                <td>${user.passWord}</td>
                <td>${user.bsRole.name}</td>
                <td>${user.bsRole.dec}</td>
                <td>${user.bsRole.roleCode}</td>
                <td>
                    <div>
                        <a target="ajaxTodo" title="确认删除？" href="${ctx}/user/del.json?id=${user.id}" class="">删除</a>
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
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="150">150</option>
                <option value="200">200</option>
                <option value="250">250</option>
            </select>
            <span>条，共${users.total}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${users.total}" numPerPage="10" pageNumShown="5" currentPage="${users.current}"></div>

    </div>
</div>