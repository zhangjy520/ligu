<%@ include file="../../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查看图片</title>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <script src="js/jquery-1.8.3.min.js"></script>
</head>
<style>
    .over {
        overflow: hidden;
    }

    .left {
        float: left;
    }

    i {
        font-style: normal;
    }

    * {
        margin: 0;
        padding: 0;
    }

    main.col-xs-9 {
        border-left: none;
        padding-left: 0 !important;
        padding-right: 0 !important;

        width: 100%;
    }

    main.container {
        margin-bottom: 0px !important;
    }



    .roll-operation {
        width: 100%;
        margin-top: 25px;
        padding-bottom: 10px;
        border-bottom: 1px solid #ddd;
    }

    .roll-operation a {
        display: inline-block;
        margin-right: 20px;
        text-decoration: none;
        line-height: 35px;
        color: #525252;
    }

    .roll-operation .active {
        color: #54ab37;
    }

    .content-warp {
        margin-top: 30px;
    }

    span {
        display: inline-block;
    }

    p span:first-child {
        width: 70px;
        text-align: right;
        margin-right: 5px;
    }

    p {
        margin-top: 8px;
    }

    .btn-containt {
        display: inline-block;
        margin-top: 0;
        width: 100%;
    }

    .parentFileBox {
        display: none;
    }

    .btn-containt button, .btn-containt span {
        height: 28px;
        color: #fff;
        cursor: pointer;
        border: none;
        border-radius: 2px;
        outline: none;
        padding: 0 15px;
        text-align: center;
    }

    .btn-containt span {
        width: auto !important;
    }

    .btn-containt .save, .back, .up {
        background: #54AB37;
        margin-right: 15px;
    }

    .manage, .getmanage {
        background: #0090ff;
    }

    .btn-containt .quit {
        background: #ddd;
    }

    .btn-containt button {
        border-radius: 3px;
        padding: 0 8px;
    }

    .hj-container {
    }

    .hj-container li {
        position: relative;
        margin: 20px 0 25px 0;
        list-style: none;
        width: 18%;
        height: 16%;
        line-height: 16%;
        margin-right: 2.5%;
    }
    .hj-container li:nth-child(5n){
        margin-right: 0;
    }
    .hj-container li div {
        cursor: pointer;
    }

    .hj-container li p a {
        float: right;
        margin-left: 10px;
        text-decoration: none;
    }

    .hj-container li > a {
        display: inline-block;
    }

    .hj-container li p span {
        width: 100px;
        text-align: left;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        line-height: 18px;
    }

    .hj-container li p input {
        width: 120px;
        height: 28px;
        padding-left: 5px;
        display: none;
    }

    .hj-container li p a {
        display: inline-block;
        width: 15px;
        height: 16px;
        cursor: pointer;
        float: none;
        margin-left: 0;
        position: absolute;
        top: 0;
        right: 0;
        display: none;
    }

    .back, .up-sp {
        float: left;
    }

    p .up-sp {
        position: relative;
    }

    p .up-sp button {
        margin-right: 0;
    }

    p .up-sp input {
        width: 86px !important;
        height: 30px;
        margin-right: 0;
        position: absolute;
        top: 0;
        left: 0;
        opacity: 0;
    }
    li>div{
        height: 100%;
    }
    li>div>img{
        width: 100%;
        height: auto;
        max-height: 100%;
    }
    .go-back{
        float: left;
        background: #54ab37 !important;
        border: 1px solid #54ab37 !important;
        border-radius: 4px;
        color: #fff;
    }
    .manage{
        float: right;
    }
</style>
<body>

<%@ include file="../../common/sonHead/classCardHead.jsp" %>

<main class="container">
    <div class="content-warp">
        <div class="over">
            <p class="btn-containt over">
                <button class="manage">批量管理</button>
            </p>
        </div>

        <div>
            <ul class="hj-container over">
                <c:forEach items="${pageInfo.list}" var="pic">
                    <li class="left">
                        <div class='layer-photos'>
                            <img layer-pid=''
                                 src='${ctx}/file/pic/show?picPath=${(pic.thumbnailUrl!=''&&pic.thumbnailUrl!=null)?pic.thumbnailUrl:pic.picUrl}'
                                 alt=''>
                        </div>
                        <p><span>${pic.picName}</span><a class="delee" data-id="${pic.id}"
                                                         data-url="${pic.picUrl}"></a></p>
                    </li>
                </c:forEach>
                </li>
            </ul>
        </div>
        <div class="fenye">
            <c:if test="${gukeer:notEmptyString(pageInfo.pages)}">
                <div class="fenyDetail">共${pageInfo.total}条记录，本页${pageInfo.size}条</div>
            </c:if>
            <div class="fenY" id="fenY">
            </div>
        </div>
    </div>
    <form id="submit-form" method="post" action="${ctx}/classcard/schoolculture/pics">
        <input type="hidden" name="pageNum" value="${pageNum}">
    </form>
</main>
</body>
</html>
<script>
    /*-------------页面加载图片完成之后 图片在li中垂直居中显示------------*/
    window.onload=function(){
        $('.hj-container img').each(function (img_index, img_obj) {
            var img_top = ( $(img_obj).parents('li').height() - $(img_obj).height() ) / 2;
            console.log(img_top);
            $(img_obj).css('margin-top', img_top);
        });
    };

    /*---------------图片管理操作事件-----------------------*/
    var flag = 0;
    $('.manage').on('click', function () {
        flag = !flag;
        if (flag) {
            $('.back .up').hide();
            $('#as').hide();
            $(".delee").show();
            $(this).text('完成管理');
        }
        else {
            $('.back .up').show();
            $('#as').show();
            $(".delee").hide();
            $(this).text('批量管理');
        }
    });

    /*------------------删除当前图片事件-------------------*/

    $(".delee").on('click', function () {
        $(this).parents('li').remove();
        var id_urls = [];
        var id_url = {}
        id_url.id = $(this).data('id');
        id_url.url = $(this).data('url');
        id_urls.push(id_url);

        $.ajax({
            url: "${ctx}/classcard/deleteschoolpic",
            type: "post",
            data: {
                id_urls: JSON.stringify(id_urls)
            },
            success: function () {
                layer.msg("删除成功");
            },
            error: function () {
                layer.msg("删除失败");
            }
        })
    })


    <c:if test="${pageInfo.pages != 0}">
    $(".fenY").createPage({
        pageCount:${pageInfo.pages},//总页数
        current:${pageInfo.pageNum},//当前页面
        backFn: function (p) {
            $("input[name='pageNum']").val(p);
            $("form").submit();
        }
    });
    $('.gotoPage').click(function () {
        var p = $('.go').val();
        if (p <= 0 || p >${pageInfo.pages}) {
            layer.msg("请输入正确的页码")
        } else {
            $("input[name='pageNum']").val(p);
            $("form").submit();
        }
    });
    </c:if>

    /*------------查看大图功能----------*/
    layer.photos({
        photos: '.layer-photos'
        // ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
    });

</script>
