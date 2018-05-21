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
<link rel="stylesheet" href="${ctxStatic}/tj/css/pagination.css"/>
<script src="${ctxStatic}/tj/js/jquery-1.7.2.js"></script>
<script src="${ctxStatic}/tj/js/pagination.js"></script>
<script>
    $(function() {
        $("#submit-btn").click(function(event){
            $.post($('form').attr('action'),{
                id:$("input[name='id']").val(),
                no:$("input[name='no']").val(),
                name:$("input[name='name']").val(),
            },function(retJson){
                if (retJson.code == '0') {
                    alert('绑定成功');
                    window.location.href = "${ctx}/device/ring/bindRingSecond";
                } else {
                    alert(retJson.msg);
                }
            });
        });
    });
</script>
<title>手环序号-姓名绑定</title>
</head>
<body>
<header>
    <nav>
        <div class="logo">智能手环签到系统</div>
        <ul>
            <shiro:hasRole name="root">
                <li><a href="${ctx}/device/station/bindStation">基站绑定</a></li>
                <li><a href="${ctx}/device/ring/bindRingFirst">序号绑定</a></li>
                <li><a href="#"  class="active">姓名绑定</a></li>
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
        <form action="${ctx}/device/ring/doBindRingSecond" method="post">
            <input type="hidden" name="id" value="${ring.id}">
            <aside>
                <div>
                    <span>手环编号</span>
                    <input type="text" name="no" value="${ring.ringNum}" placeholder="手环编号，1~350"/>
                </div>
                <div>
                    <span>用户姓名</span>
                    <input type="text" name="name" value="${ring.studentName}" placeholder="用户姓名"/>
                </div>
                <div>
                    <input type="button" id="submit-btn" value="绑定" />
                </div>
            </aside>
        </form>
        <div class="bind-information">
            <table>
                <thead>
                <tr>
                    <th>手环编号</th>
                    <th>用户姓名</th>
                    <th>所在教室</th>
                    <th>编辑</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="ring">
                    <tr>
                        <td>
                            ${ring.ringNum}
                        </td>
                        <td>
                            ${ring.studentName}
                        </td>
                        <td>
                            ${ring.stationName}
                        </td>
                        <td>
                            <a href="${ctx}/device/ring/edit/${ring.mac}">编辑</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <footer>
                <%--<div class="left">--%>
                <%--共150条记录，每页显示--%>
                <%--<select>--%>
                <%--<option>15</option>--%>
                <%--</select>--%>
                <%--条记录--%>
                <%--</div>--%>
                <div id="pagination" class="paginationjs paginationjs-theme-blue paginationjs-small"></div>
                <script>
                    $('nav ul li a').click(function(){
                        $(this).addClass('active');
                        $(this).parent().siblings().children().removeClass('active');
                    })
                    var initData = true;
                    $('#pagination').pagination({
                        dataSource: function(done){
                            var result = [];
                            for (var i = 0; i < ${pageInfo.total}; i++) {
                                result.push(i);
                            }
                            done(result);
                        },
                        pageSize: ${pageInfo.pageSize},
                        pageNumber: ${pageInfo.pageNum},
                        showGoInput: false,
                        showGoButton: false,
                        callback: function(data, pagination){
                            if(!initData) {
                                var pageUrl = "${ctx}/device/ring/bindRingSecond?pageNum="+pagination.pageNumber;
                                window.location.href = pageUrl;
                            }
                            initData = false;
                        }
                    })
                </script>
            </footer>
        </div>
    </main>
</section>
</body>
</html>