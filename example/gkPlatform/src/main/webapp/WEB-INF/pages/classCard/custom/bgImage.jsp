<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ include file="../../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>背景图管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classspace.css"/>
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jedate.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/diyUploadCustom/css/webuploader.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/diyUploadCustom/css/diyUpload.css">
    <script type="text/javascript" src="${ctxStaticNew}/diyUploadCustom/js/webuploader.html5only.min.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/diyUploadCustom/js/diyUploadmore.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/jquery.jedate.js"></script>
</head>
<body>
<style>

    .mode-name input {
        border: none;
    }

    main.container {
        margin-bottom: 0 !important;
    }

    .check-btnp button {
        height: 30px;
        padding: 0 15px;
        margin-right: 4px;
        border: 1px solid #54ab37;
        background: #54ab37;
        color: #fff;
        border-radius: 2px;
    }

    .edit-range > div {
        display: none;
    }

    .imgAtext button ,#img-upload button{
        background: #54AB37;
        height: 30px;
        padding: 0 15px;
        border: 1px solid #54AB37;
        outline: none;
        border-radius: 2px;
        color: #fff;
    }

    .mode-name select {
        height: 30px;
        width: 130px;
        border-radius: 2px;
        padding-left: 5px;
        color: #525252;
        font-size: 14px;
    }

    #imgButton-upload {
        display: inline-block;
    }

    .check-btnp > button, .check-btnp > span, .check-btnp > a {
        float: right;
    }
    .layui-layer{
        top: 400px !important;
    }
    .hj-container li{
        margin-right: 64px !important;
    }
    .hj-container{
        padding-bottom: 100px;
    }
    .hj-container li:nth-child(3n){
        margin-right: 0 !important;
    }
    #img-upload{
        margin: 30px 0 20px 0;
    }
    .ul_bgImage li h3{
        font-weight: normal;
        font-size: 14px;
    }
    .ul_bgImage li h3 span{
        display: inline-block;
        width: 100% !important;
        text-align: center;
    }
</style>

<%@ include file="../../common/sonHead/classCardHead.jsp" %>

<main class="container">

    <div id="img-upload" class="edit-range">
        <%--<div id="imgButton-upload"></div>--%>
        <button class="go-back">返回</button>
    </div>
    <div>
        <ul class="hj-container over ul_bgImage">
            <c:forEach items="${bgImageList}" var="bgImage">
                <li class="left">
                    <img src="${ctx}/file/pic/show?picPath=${bgImage.picUrl}"
                         alt="${bgImage.picTitle}" width="347px" height="195px">
                    <p>
                        <span style="width: 200px;">${bgImage.picTitle}</span>
                        <%--<input type="text" class="ip-name" data-id="${bgImage.id}" style="display: none;">--%>
                        <%--<i style="display: none" class="input_yes">OK</i>--%>
                        <%--<a class="dele" data-picid="${bgImage.id}" data-pid="${bgImage.pid}"></a>--%>
                        <%--<a class="edit"></a>--%>
                    </p>
                </li>
            </c:forEach>
            <%--<li class="left">
                <img src="${ctxStaticNew}/images/customPageBGImages/activity.png"
                     alt ="activity.png" width="347px" height="195px">
                <h3>
                    <span>活动</span>
                </h3>
            </li>--%>
        </ul>
    </div>
</main>
<script>
    activeMenu("base", 4);
    var flag = 1;
    $('.hj-container li ').on('mouseover', function () {
        if (flag) {
            $(this).children('p').children('a').show();
            $(this).children('p').children('span').css('width', '175px');
        }
    });
    $('.hj-container li ').on('mouseout', function () {
        $(this).children('p').children('a').hide();
        $(this).children('p').children('span').css('width', '200px');
    });

    $('.edit').on('click', function () {
        $(this).hide();
        $(this).siblings().hide();
        $(this).siblings('input').show().val($(this).siblings('span').text());
        $(this).siblings('i').show();
        $(this).siblings('input').focus();
        flag = 0;
    });

    $('.ip-name').on('keyup', function (e) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            commitInputName(this);
        }
    });

    $('.input_yes').on('click',function () {
        commitInputName($(this).siblings('input'));
    });

    function commitInputName(object) {
        object.hide();
        object.siblings('.input_yes').hide();
        object.siblings('span').show().text(object.val());

        var $id = object.data("id");
        $.ajax({
            url: "${ctx}/classcard/bgPicture/save",
            type: "post",
            data: {
                picTitle: object.val(),
                id: $id
            },
            success: function (retDate) {
                if (retDate.code == -1) {
                    layer.msg(retDate.msg);
                }
            },
            error: function () {
                layer.msg("err");
            }
        })
        flag = 1;
    }

    $('.dele').on('click', function () {
        var id = $(this).data("picid");
        var pid = $(this).data("pid");
        alertTips('400px', '200px', '删除背景图', '确定要删除此背景图吗？', 'picDelete(\''+id+'\',\''+pid+'\')');
    });
    function picDelete(id,pid,classCardId) {
        $.post("${ctx}/classcard/picture/deleteOne", {
            id : id,
            pid : pid
        }, function (retJson) {
            if (retJson.code == 0) {
                window.location.reload();
            } else {
                layer.msg(retJson.msg);
            }
        }, "json");
    }

    /*图片上传*/
    $('#imgButton-upload').diyUpload({
        url: '${ctx}/file/upload',
        success: function (data) {
            console.info(data);
            var imgRequestUrl = data.data.imgRequestUrl;
            var thumbnailUrl = data.data.thumbnailUrl;
            var imgName = data.data.fileName;
            var picTitleId = imgName.replace(/[^\w]/g,"A");
            var picTitle = $('#'+picTitleId).val();
            uploadImageBG(imgName, picTitle, imgRequestUrl,thumbnailUrl);
        },
        error: function (err) {
            console.info(err);
        },
        successFinished : function () {
            window.location.reload();
        },
        buttonText: '添加本地图片',
        chunked: false,
        // 分片大小
        chunkSize: 50 * 1024 * 1024,
        //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
        fileNumLimit: 50,
        fileSizeLimit: 150 * 1024 * 1024,
        fileSingleSizeLimit: 3 * 1024 * 1024,
        accept: {
            title: "Images",
            extensions: "gif,jpg,jpeg,ico,bmp,png",
        }
    });

    function uploadImageBG(imgName, picTitle, imgRequestUrl,thumbnailUrl) {
        //持久化保存
        var url = "${ctx}/classcard/bgPicture/save";
        $.post(url, {
            picTitle: picTitle,
            pic_name: imgName,
            pic_url: imgRequestUrl,
            thumbnail_url : thumbnailUrl,
            pid: 'bgImage'
        }, function (retJson) {
            if (retJson.code != 0) {
                layer.msg(retJson.msg);
            }
        });
        return true;
    }

    /*回退返回页面*/
    $('#img-upload button').on('click', function () {
        window.history.go(-1);
    })
</script>
</body>
</html>

