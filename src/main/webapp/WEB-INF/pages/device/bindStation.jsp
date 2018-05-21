<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="login">
<meta name="author" content="lexi">
<link rel="stylesheet" href="${ctxStatic}/tj/css/style.css"/>
<script src="${ctxStatic}/tj/js/jquery-1.7.2.js"></script>

<script>
    $(function() {
        $("#submit-btn").click(function(event){
            $.post($('form').attr('action'),{
                station:$("input[name='station']").val(),
                screen:$("input[name='screen']").val(),
                className:$("input[name='className']").val(),
            },function(retJson){
                if (retJson.code == '0') {
                    window.location.href="${ctx}/device/station/bindStation";
                } else {
                    alert(retJson.msg);
                }
            });
        });
    });

    function del(mac) {
        if (confirm('确认删除吗？')) {
            $.post("${ctx}/device/station/del/"+mac,{

            },function(retJson){
                if (retJson.data > 0) {
                    alert('删除成功');
                    window.location.href="${ctx}/device/station/bindStation";
                } else {
                    alert(retJson.msg);
                }
            });
        }
    }
</script>
<title>基站班牌绑定</title>
</head>
<body>
<header>
    <nav>
        <div class="logo">智能手环签到系统</div>
        <ul>
            <shiro:hasRole name="root">
                <li><a href="#" class="active">基站绑定</a></li>
                <li><a href="${ctx}/device/ring/bindRingFirst">序号绑定</a></li>
                <li><a href="${ctx}/device/ring/bindRingSecond">姓名绑定</a></li>
            </shiro:hasRole>
            <shiro:hasRole name="tjzh">
                <li><a href="#" class="active">姓名绑定</a></li>
            </shiro:hasRole>
            <li><a href="${ctx}/doLogout">退出登录</a></li>
        </ul>
    </nav>

</header>
<section>
    <main>
        <form action="${ctx}/device/station/doBindStation">
            <aside>
                    <div>
                        <span>基站MAC地址:</span>
                        <input name="station" value="${station.stationMac}" type="text" <c:if test="${!empty modify}"> disabled </c:if> placeholder="基站的MAC地址">
                    </div>
                    <div>
                        <span>班牌MAC地址:</span>
                        <input name="screen" value="${station.screenMac}" type="text" <c:if test="${!empty modify}"> disabled </c:if> placeholder="班牌的MAC地址">
                    </div>
                    <div>
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;教室名称:</span>
                        <input name="className" value="${station.className}" type="text" placeholder="教室名称">
                    </div>
                    <div>
                        <input type="button" value="绑定" id="submit-btn" />
                    </div>
            </aside>
        </form>

        <div class="bind-information">
            <c:if test="${empty modify}">
                <table>
                    <thead>
                    <tr>
                        <th>班级名称</th>
                        <th>基站MAC</th>
                        <th>班牌MAC</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="station">
                        <tr>
                            <td>
                                ${station.className}
                            </td>
                            <td>
                                ${station.stationMac}
                            </td>
                            <td>
                                ${station.screenMac}
                            </td>
                            <td>
                                <a href="${ctx}/device/station/edit/${station.stationMac}">编辑</a> |
                                <a class="delete" onclick="del('${station.stationMac}');">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </main>
</section>
</body>
</html>