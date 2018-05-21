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
            $.post($('#bindForm').attr('action'),{
                mac:$("input[name='mac']").val(),
                no:$("input[name='no']").val(),
            },function(retJson){
                if (retJson.code == '0') {
                    alert('保存成功');
                    window.location.href="${ctx}/device/bindRingFirst";
                } else {
                    alert(retJson.msg);
                }
            });
        });

        $("#import_btn").click(function(event){
            var form = $('#importForm');
            var fileName = $("input[name='file']").val();
            alert('导入文件：' + fileName);
            if (fileName == "" || fileName.length == 0) {
                alert('请选择导入文件');
                return;
            } else {
                form.submit();
            }
        });

        $("#random_btn").click(function(event){
            $.post($('#randomForm').attr('action'),{

            },function(retJson){
                if (retJson.code == '0') {
                    alert('分班成功');
                    window.location.href="${ctx}/device/ring/bindRingFirst";
                } else {
                    alert(retJson.msg);
                }
            });
        });
    });
</script>
<title>手环序号-mc绑定</title>
</head>
<body>
<header>
    <nav>
        <div class="logo">智能手环签到系统</div>
        <ul>
            <shiro:hasRole name="root">
                <li><a href="${ctx}/device/station/bindStation">基站绑定</a></li>
                <li><a href="#"  class="active">序号绑定</a></li>
                <li><a href="${ctx}/device/ring/bindRingSecond">姓名绑定</a></li>
            </shiro:hasRole>
            <shiro:hasRole name="board_user">
                <li><a href="#" class="active">姓名绑定</a></li>
            </shiro:hasRole>
            <li><a href="${ctx}/doLogout">退出登录</a></li>
        </ul>
    </nav>

</header>
<section>
    <main>
        <aside>
            <div>
                <form id="importForm" action="${ctx}/device/ring/importRings" method="post" enctype="multipart/form-data" >
                    <input type="file" name="file"> <br>
                    <input type="button" id="import_btn" value="导入Excel">
                </form>
            </div>
            <div>
                &nbsp;&nbsp;
            </div>
            <div>
                将手环随机分班
                <form id="randomForm" action="${ctx}/device/ring/random" method="post">
                    <input type="button" id="random_btn" value="分班">
                </form>
            </div>
        </aside>
        <div class="bind-information">
            <table>
                <thead>
                <tr>
                    <th>
                        手环编号
                    </th>
                    <th>
                        手环mac
                    </th>
                    <th>
                        所在班级
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfo.list}" var="ring">
                    <tr>
                        <td>
                            ${ring.ringNum}
                        </td>
                        <td>
                            ${ring.mac}
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${empty ring.stationName}">
                                    未分班
                                </c:when>
                                <c:otherwise>
                                    ${ring.stationName}
                                </c:otherwise>
                            </c:choose>
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
                                var pageUrl = "${ctx}/device/ring/bindRingFirst?pageNum="+pagination.pageNumber;
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