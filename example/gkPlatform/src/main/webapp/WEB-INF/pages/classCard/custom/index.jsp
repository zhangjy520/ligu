<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ include file="../../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>自定义界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jedate.css">
    <script type="text/javascript" src="${ctxStaticNew}/js/jquery.jedate.js"></script>
</head>
<body>
<style>
    main .col-xs-9 {
        width: 100% !important;
        padding-left: 15px !important;
        border: none;
    }

    .nav-menu li a:hover {
        color: #fff !important;
    }

    main.col-xs-9 .search-box .roll-operation button.roll-delete {
        background: #fc4c71;
    }
</style>

<%@ include file="../../common/sonHead/classCardHead.jsp" %>

<main class="container">
    <!--班牌自定义显示界面-->
    <div class="row" id="stu-manage">
        <main class="col-xs-9">
            <div class="search-box">
                <div class="roll-operation">
                    <button class="roll-add" onclick="addCustom()">新增</button>
                    <button class="roll-delete" onclick="ifChoose()">删除</button>
                    <button class="roll-message" onclick="bgImageManage()">背景图管理</button>
                    <%--<button class="roll-message" onclick="templateManage()">模板管理</button>--%>
                </div>
            </div>
            <div>
                <table>
                    <thead>
                    <tr>
                        <th width="5%"><input type="checkbox" id="choseAll"/></th>
                        <th width="5%">序号</th>
                        <th width="15%">名称</th>
                        <th width="15%">时间设定</th>
                        <th width="15%">模板类型</th>

                        <th width="8%">循环周期</th>
                        <th width="6%">制作人</th>
                        <th width="6%">状态</th>
                        <th width="25%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="customView" varStatus="status">
                        <tr>
                            <td>
                                <input name="chose" class="chose" type="checkbox" value="${customView.id}"/>
                            </td>
                            <td>
                                    ${status.index + 1 +(pageInfo.pageNum-1)*10}
                            </td>
                            <td>
                                    ${customView.name}
                            </td>
                            <td>
                                    ${customView.startTimeView} --- ${customView.endTimeView}
                            </td>
                            <td>
                                    ${customView.templateName}<c:if test="${customView.templateName=='轮播图模板'&&customView.intervalTime!=''&&customView.intervalTime!=null}">（间隔：${customView.intervalTime}s）</c:if>

                            </td>
                            <td>
                                <c:if test="${customView.loopMark == null}">
                                    未设置
                                </c:if>
                                <c:if test="${customView.loopMark == 'D'}">
                                    每天
                                </c:if>
                                <c:if test="${customView.loopMark == 'W'}">
                                    周 [${customView.loopDate}]
                                </c:if>
                                <c:if test="${customView.loopMark == 'M'}">
                                    月 [${customView.loopDate}]
                                </c:if>
                                <c:if test="${customView.loopMark == 'N'}">
                                    不循环
                                </c:if>
                            </td>
                            <td>
                                    ${customView.createByName}
                            </td>
                            <td>
                                <c:if test="${customView.status == 0}">
                                    编辑中
                                </c:if>
                                <c:if test="${customView.status == 1}">
                                    发布中
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${customView.status == 0}">
                                    <span class="td-edit" onclick="editPage('${customView.id}','')">编辑</span>
                                    <span class="copy" onclick="copy('${customView.id}')">复制</span>
                                    <span class="td-delete"
                                          style="padding-left: 20px;cursor: pointer;margin-right: 20px"
                                          onclick="alertTips('400px','200px','删除界面','确定删除该界面吗？','customDelete(\'${customView.id}\')')">删除</span>
                                    <span class="" onclick="publishPage('${customView.id}')">发布</span>
                                </c:if>
                                <c:if test="${customView.status == 1}">
                                    <span class="see" onclick="editPage('${customView.id}','disabled')">查看页面</span>
                                    <span class="equipment" onclick="findClasscard('${customView.id}')">发布的设备</span>
                                    <span class=""
                                          onclick="alertTips('400px','200px','取消发布','确定取消该界面的发布吗？','unpublishPage(\'${customView.id}\')')">取消发布</span>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="fenye">
                <c:if test="${gukeer:notEmptyString(pageInfo.pages)}">
                    <div class="fenyDetail">共${pageInfo.total}条记录，本页${pageInfo.size}条</div>
                </c:if>
                <div class="fenY" id="fenY">
                </div>
            </div>
        </main>
    </div>

</main>

<form id="submit-form" method="get" action="${ctx}/classcard/custom/index">
    <%--<input type="hidden" name="ueditorPics" value="">
    分页查询的其他字段
    条件查询的其他字段
    ajax提交--%>
    <input type="hidden" name="pageNum" value="${pageInfo.pageNum}">
</form>

<script>
    <shiro:hasAnyRoles name="headTeacher">
    activeMenu("base", 2);
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="classCardAdmin,schoolAdmin">
    activeMenu("base", 3);
    </shiro:hasAnyRoles>

    function subForm() {
        $("form").submit();
    };

    <c:if test="${pageInfo.pages != 0}">
    $(".fenY").createPage({
        pageCount:${pageInfo.pages},//总页数
        current:${pageInfo.pageNum},//当前页面
        backFn: function (p) {
            $("input[name='pageNum']").val(p);
            subForm();
        }
    });
    $('.gotoPage').click(function () {
        var p = $('.go').val();
        if (p <= 0 || p >${pageInfo.pages}) {
            layer.msg("请输入正确的页码")
        } else {
            $("input[name='pageNum']").val(p);
            subForm();
        }
    })

    </c:if>

    //时间插件
    function timeShow(element) {
        $.jeDate(element, {
            format: "hh:mm"
        });
    }

    function customDelete(id) {
        closeAlertDiv();
        $.post("${ctx}/classcard/custom/multidelete", {
            pageId: id + ","
        }, function (retJson) {
            if (retJson.code == 0)
                layer.msg('删除成功');
            else layer.msg("删除失败");
        }, "json");

        setTimeout(function () {
            window.location.reload();
        }, 700);//删除

    }

    function ifChoose() {
        if ($('input:checkbox[name=chose]:checked').length > 0) {
            alertTips('400px', '200px', '删除界面', '确定要删除选中的' + $('input:checkbox[name=chose]:checked').length + '个界面吗？', 'choose()')
        }
        else {
            layer.msg("请选择界面")
        }
    }
    function choose() {
        closeAlertDiv();
        var spCodesTemp = "";
        $('input:checkbox[name=chose]:checked').each(function (i) {
            spCodesTemp += ($(this).val() + ",");
        });
        $.post("${ctx}/classcard/custom/multidelete", {
            pageId: spCodesTemp
        }, function (retJson) {

            if (retJson.code == 0)
                layer.msg('删除成功');
            else layer.msg(retJson.msg);
        }, "json");

        setTimeout(function () {
            window.location.reload();
        }, 1000);//删除
    }

    function addCustom() {
        //window.location.href = "${ctx}/classcard/custom/createPageByTemplate";
        openDialogWithoutReload('新增', '${ctx}/classcard/custom/selectTemplate', '450px', '300px', false);
    }

    function publishPage(pageId) {
        var url = "${ctx}/classcard/custom/publishPage?pageId=" + pageId;
        openDialogView('配置发布的信息', url, '850px', '650px', false);
    }

    function findClasscard(pageId) {
        var url = "${ctx}/classcard/custom/findPublishClasscard?pageId=" + pageId;
        openDialogView('已发布的设备', url, '50%', '70%', false);
    }

    function editPage(pageId, option) {
        window.location.href = "${ctx}/classcard/custom/edit?pageId=" + pageId + "&option=" + option;
    }

    function unpublishPage(pageId) {
        var url = "${ctx}/classcard/custom/unpublish";
        $.get(url, {
            pageId: pageId
        }, function (retJson) {
            layer.msg(retJson.data);
        }, "json");

        setTimeout(function () {
            window.location.reload();
        }, 1000);//取消发布
    }

    function templateManage() {
        window.location.href = "${ctx}/classcard/custom/template/index";
    }
    function bgImageManage() {
        window.location.href = "${ctx}/classcard/custom/bgImage/index";
    }

    var allBtn = $('#choseAll');
    var normalBtn = $('.chose');
    //    console.log(allBtn.checked);
    $(allBtn).click(function () {
        if (this.checked == true) {
            for (var i = 0; i < normalBtn.length; i++) {
                normalBtn[i].checked = true;
            }
        } else {
            for (var i = 0; i < normalBtn.length; i++) {
                normalBtn[i].checked = false;
            }
        }
    })

    function copy(customId) {
        $.post("${ctx}/classcard/custom/copy", {
                customId: customId
            }, function (retJson) {

                if (retJson.code == 0) {
                    layer.msg('复制成功')
                } else {
                    layer.msg(retJson.msg);
                }
                setTimeout(function () {
                    window.location.reload();
                },2000)
            }, "json"
        )
    }

</script>
</body>
</html>

