<%@ include file="../../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>校园文化</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classspace.css"/>
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/oldCss.css">
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/diyUpload/css/diyUpload.css">
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/diyUpload/css/webuploader.css">
    <script type="text/javascript" src="${ctxStaticNew}/diyUpload/js/diyUploadmore.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/diyUpload/js/webuploader.html5only.min.js"></script>

    <%--编辑器--%>
    <link rel="stylesheet" href="${ctxStaticNew}/kindeditor-4.1.10/themes/default/default.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/kindeditor-4.1.10/plugins/code/prettify.css"/>
    <script charset="utf-8" src="${ctxStaticNew}/kindeditor-4.1.10/kindeditor.js"></script>
    <script charset="utf-8" src="${ctxStaticNew}/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <script charset="utf-8" src="${ctxStaticNew}/kindeditor-4.1.10/plugins/code/prettify.js"></script>

    <style type="text/css">
        .banjijieshao {
            margin-top: 15px;
        }

        .none {
            visibility: hidden;
        }

        .content {
            width: 1200px;
            margin: 0 auto;
        }

        .file_upload {
            width: 48%;
            min-height: 400px;
            margin: 10px;
            position: relative;
            display: inline-block;
            vertical-align: top;
        }

        .file_upload > div {
            width: 100%;
            height: 100%;
        }

        .file_con .hidee {
            width: 120px;
            height: 30px;
            opacity: 0;
            filter: alpha(opacity=0);
            position: absolute;
            left: 0;
            z-index: 22;
        }

        .file_con .file_uploader, .upload_bt {
            position: absolute;
            left: 0;
            top: 0;
            display: inline-block;
            padding: 6px 14px;
            color: #fff;
            background: #2ECC71;
            text-align: center;
            z-index: 11;
            border-radius: 15px;
            cursor: pointer;
        }

        .upload_bt {
            left: 130px;
        }

        .file_con .hide:hover {
            box-shadow: 1px 2px #44795b;
        }

        .parentFileBox > .fileBoxUl > li > .diyFileName {
            width: 115px !important;
        }

        .img_holder, .m_img_holder {
            padding-top: 40px;
        }

        .img_holder img, .m_img_holder img {
            max-width: 200px;
        }

        .img_box {
            position: relative;
            display: inline-block;
            vertical-align: top;
            border: 1px transparent dashed;
            padding: 12px;
            box-shadow: 2px 2px 10px #ccc;
        }

        .img_box:hover {
            /*border: 1px #ccc dashed;*/
        }

        .img_box:hover .delete {
            display: block;
        }

        .img_box .delete {
            position: absolute;
            right: 1px;
            top: 0;
            display: none;
            font-family: Arial;
            font-size: 12px;
            cursor: pointer;
        }

        .progress {
            display: inline-block;
            margin-top: 10px;
        }

        .flie-name {
            margin: 5px 0 0 15px;
            vertical-align: top;
        }

        .parentFileBox {
            display: inline-block;
            margin-left: 30px;
        }

        .fenY .go, .fenY1 .go, .fenY2 .go, .gotoPage {
            bottom: 0 !important;
        }

        #fenYgo {
            bottom: -1px !important;
        }

        .nav-menu li a:hover {
            color: #fff !important;
        }

        .layer-photos {
            cursor: pointer;
        }

        .list-ul{
            margin-bottom: 30px;
        }
        .list-ul li{
            margin-top: 20px;
        }
        .list-ul li span:first-child{
            display: inline-block;
            line-height: 28px;
        }
        .parentFileBox{
            width: 580px !important;
        }

        textarea{
            width: 650px !important;
            height: 200px !important;
        }
        .xh-li .parentFileBox>.fileBoxUl>li{
            width: 100% !important;
        }
        .sp-li .parentFileBox>.fileBoxUl>li{
            width: 100% !important;
        }
        .sp-li .parentFileBox,.sp-li .parentFileBox>.fileBoxUl{
            width: 145px !important;
        }
        .xh-li .parentFileBox,.xh-li .parentFileBox>.fileBoxUl{
            width: 145px !important;
        }
        #schoolVideo{
            text-align: left;
        }
        .ke-container{
            width: 80% !important;
            display: inline-block !important;
            vertical-align: top;
        }
        .ke-container .ke-toolbar>span{
            width: auto !important;
        }
        .ke-toolbar-icon{
            width: 16px !important;
        }
        .ke-content{
            font-size: 14px !important;
        }
    </style>
</head>
<body>
<%@ include file="../../common/sonHead/classCardHead.jsp" %>
<main class="container">
    <!--班牌管理-->
    <div class="" id="stu-manage">

        <main class="">

            <form id="editForm"  method="post" enctype="multipart/form-data">
                <div class="content-warp banjijieshao">
                    <p><span>校园简介：</span>
                        <textarea  id="introduction" value="" >${schoolCulture.introduction}</textarea>
                    </p>
                    <ul class="list-ul" style="margin-top: 20px;">
                        <li class="xh-li">
                            <span style="vertical-align: top;">学校校徽：</span>
                            <div style="display: inline-block;vertical-align: top" id="schoolBadgePicUpload" data-flag='schoolCulture' data-flagtype='schoolculturebadge' class="webuploader-container ">
                                <div class="webuploader-pick">上传校徽</div>
                                <div style="position: absolute; top: 0px; left: 0px; width: 126px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
                                    <input type="file" name="file" class="webuploader-element-invisible">
                                    <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                                </div>
                            </div>
                            <span id='schoolBadgePic' class="flie-name introductionFileName" style="width: 100px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" title="${schoolBadgePicName}"> ${schoolBadgePicName}</span>

                            <c:if test="${not empty schoolCulture.schoolBadgePicId}">
                                <span id="delXh" data-id="${schoolCulture.schoolBadgePicId}" style="cursor: pointer;display: inline-block;height: 26px;width:26px;line-height: 32px;color: #fc4c71;background: url(${ctxStaticNew}/images/x_alt.png) no-repeat center;position: relative;top: 3px;"></span>
                            </c:if>

                        </li>
                        <li class="sp-li">
                            <span style="vertical-align: top;">宣传视频：</span>

                            <div style="display: inline-block;vertical-align: top" id="schoolVideoUpload"
                                 data-flag='schoolCulture' data-flagtype='schoolculturevideo'
                                 class="webuploader-container ">
                                <div class="webuploader-pick">上传视频</div>
                                <div style="position: absolute; top: 0px; left: 0px; width: 126px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
                                    <input type="file" name="file" class="webuploader-element-invisible">
                                    <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                                </div>
                            </div>

                            <c:if test="${not empty video.videoName}">
                            <a target="__black" href="${ctx}/classcard/schoolculture/video" style="vertical-align: bottom;">
                            <span id='schoolVideo' style="overflow:  hidden;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;"
                                  class="flie-name introductionFileName"> ${video.videoName}</span>
                            </a>
                            </c:if>
                            <c:if test="${not empty video.videoName}">
                                 <span id="delVideo" data-id="${schoolCulture.id}" style="cursor: pointer;display: inline-block;height: 26px;width:26px;line-height: 32px;color: #fc4c71;background: url(${ctxStaticNew}/images/x_alt.png) no-repeat center;position: relative;top: 3px;"></span>
                            </c:if>
                            <p style="margin: 0; padding-left: 105px;color: #999;font-size: 12px;">250M以内</p>
                        </li>
                        <li>
                            <span style="vertical-align: top;">学校图片：</span>
                            <div class="time" style="position: absolute;top:50%;left: 50%;"></div>
                            <div style="display: inline-block;vertical-align: top" id="schoolPicUpload"
                                 data-flag='schoolCulture'
                                 class="webuploader-container ">
                                <div class="webuploader-pick">上传图片</div>
                                <div style="position: absolute; top: 0px; left: 0px; width: 126px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
                                    <input type="file" name="file" class="webuploader-element-invisible">
                                    <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                                </div>
                            </div>


                            <a id="showSchoolculturePics" target="__black" href="${ctx}/classcard/schoolculture/pics" style="vertical-align: bottom;margin-left: 15px;">查看图片</a>
                            <p style="margin: 0;margin-top: 3px; padding-left: 105px;color: #999;font-size: 12px;">每张3M以内，一次可上传50张，不限次数。</p>
                        </li>
                    </ul>

                    <div class="btn-containt">
                        <span id="savBtn" class="saveBtn save" onclick="fun_editForm()">保存</span>
                    </div>

                </div>
                <input type="hidden" id="schoolBadgePicUrl" value="">
                <input type="hidden" id="schoolBadgePicName" value="">
                <input type="hidden" id="schoolBadgePicThumbnailUrl" value="">

                <input type="hidden" id="schoolVideoUrl" value="">
                <input type="hidden" id="schoolVideoName" value="">


                <input type="hidden" id="schoolPicUrl" value="">
                <input type="hidden" id="schoolPicThumbnailUrl" value="">

                <input type="hidden" name="pic_urls" , id="pic_urls">
                <input type="hidden" name="fileName" id="fileName" value="">
                <input type="hidden" name="thumbnail_flag" id="thumbnail_flag" value="">
                <input type="hidden" name="failList" value="">
                <input type="hidden" name="ctx" value='${ctx}'>

            </form>
        </main>
    </div>
</main>

<script>
    activeMenu("all", 3);
    $('#schoolBadgePicUpload').diyUpload({
        url: '${ctx}/file/upload',
        success: function (data) {
            $('#schoolBadgePicUrl').val(data.data.imgRequestUrl);
            $('#schoolBadgePicName').val(data.data.fileName);

            if (data.data.thumbnailUrl != '') {
                $('#schoolBadgePicThumbnailUrl').val(true)
            } else {
                $('#schoolBadgePicThumbnailUrl').val(false);
            }
            if($('.xh-li .parentFileBox').length > 0){
                $('#schoolBadgePic').hide();
            }else {
                $('#schoolBadgePic').show();
            }
            if($('.xh-li .parentFileBox ul li').length > 1){
                $('.xh-li .parentFileBox ul li').hide();
                $('.xh-li .parentFileBox ul li').eq($('.xh-li .parentFileBox ul li').length - 1).show();
            }

            /*是否有原有上传校徽*/
            if($('.xh-li .parentFileBox').length > 0){
                $('.xh-li #schoolBadgePic, .xh-li #delXh').hide();
            }else {
                $('.xh-li #schoolBadgePic, .xh-li #delXh').show();
            }
        },
        error: function (err) {
            console.info(err);
        },
        buttonText: '上传校徽',
        chunked: false,
        // 分片大小
        chunkSize: 50 * 1024 * 1024,
        //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
        fileNumLimit: 1,
        fileSizeLimit: 3 * 1024 * 1024,
        fileSingleSizeLimit: 3 * 1024 * 1024,
        accept: {
            title: "Images",
            extensions: "gif,jpg,jpeg,ico,bmp,png",
        },
    });

    $('#schoolVideoUpload').diyUpload({
        url: '${ctx}/file/upload',
        success: function (data) {
            $('#schoolVideoUrl').val(data.data.imgRequestUrl);
            $('#schoolVideoName').val(data.data.fileName);
            /*是否有原有上传视频文件*/
            if($('.sp-li .parentFileBox').length > 0){
                $('.sp-li a, .sp-li #delVideo').hide();
            }else {
                $('.sp-li a, .sp-li #delVideo').show();
            }
        },
        error: function (err) {
            console.info(err);
        },
        buttonText: '上传视频',
        chunked: false,
        // 分片大小
        chunkSize: 50 * 1024 * 1024,
        //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
        fileNumLimit: 1,
        fileSizeLimit: 250 * 1024 * 1024,
        fileSingleSizeLimit: 250 * 1024 * 1024,
        accept: {
            title: "Images",
            extensions: "rmvb,rm,flv,mp4,mov"
        },
    });

$('#schoolPicUpload').on('click',function () {

    $('#showSchoolculturePics').hide();
})

    $('#schoolPicUpload').diyUpload({
        url: '${ctx}/file/upload',
        success: function (data) {

            var tmpurl = $('#pic_urls').val();
            if (tmpurl != '') {
                $('#pic_urls').val(tmpurl + "," + data.data.fileName + "@#@" + data.data.imgRequestUrl);
            } else {
                $('#pic_urls').val(data.data.fileName + "@#@" + data.data.imgRequestUrl);
            }

            var fileName = $('#fileName').val();
            if (fileName != '') {
                $('#fileName').val(fileName + "," + data.data.fileName);
            } else {
                $('#fileName').val(data.data.fileName);
            }
            var thumbnailurl = $('#thumbnail_flag').val();
            if (thumbnailurl != '') {
                if (data.data.thumbnailUrl != '') {
                    $('#thumbnail_flag').val(thumbnailurl + "," + true);
                } else {
                    $('#thumbnail_flag').val(thumbnailurl + "," + false);
                }
            } else {
                if (data.data.thumbnailUrl != '') {
                    $('#thumbnail_flag').val(true);
                } else {
                    $('#thumbnail_flag').val(false);
                }
            }
        },
        error: function (err) {
            console.info(err);
        },
        buttonText: '上传图片',
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
        },
    });
    function fun_editForm() {
        if($(".time").length == 0 ||$(".time").is(":hidden")){
        var $urls = $('#pic_urls').val().split(',');
        var thumbnailurls = $('#thumbnail_flag').val().split(',');
        var filename = $('#fileName').val().split(',');
        var urlNameList = [];

        if ($('#pic_urls').val() != '') {
            for (var i = 0; i < $urls.length; i++) {
                var url_name = {};
                url_name.url = $urls[i].split("@#@")[1];
                url_name.name = filename[i];
                url_name.thumbnail = thumbnailurls[i];
                urlNameList.push(url_name);
            }
        }

        $.post($("form").attr('action'), {
            url_name: JSON.stringify(urlNameList),
            introduction: $("#introduction").val(),/*editor.html(),*/
            schoolBadgePicUrl: $("#schoolBadgePicUrl").val(),
            schoolBadgePicName: $("#schoolBadgePicName").val(),
            schoolBadgePicThumbnailUrl: $("#schoolBadgePicThumbnailUrl").val(),
            schoolVideoUrl: $("#schoolVideoUrl").val(),
            schoolVideoName: $("#schoolVideoName").val()
        }, function (retJson) {
            if (retJson.code == 0) {
                layer.msg('保存成功');
                setTimeout(function () {
                    window.location.reload();
                },1000)
            } else {
                layer.msg(retJson.msg);
            }
        });
        return true;
        }else{
            layer.msg('上传中,请等待');
        }
    };

    $("#delVideo").on('click',function () {

        var schoolCultureId= $(this).data("id");
        var schoolId='${schoolId}';
        $.post("${ctx}/classcard/delschoolvideo", {
            schoolCultureId: schoolCultureId,
            schoolId:schoolId
        }, function (retJson) {
            if (retJson.code == 0) {
                layer.msg('删除成功');
                setTimeout(function () {
                    window.location.reload();
                },1000)
            } else {
                layer.msg(retJson.msg);
            }
        });

    });

    //删除校徽
    $("#delXh").on('click',function () {
        var schoolCultureId= $(this).data("id");
        var schoolId='${schoolId}';
        $.post("${ctx}/classcard/delschoolbadgePic", {
            schoolCultureId: schoolCultureId,
            schoolId:schoolId
        }, function (retJson) {
            if (retJson.code == 0) {
                layer.msg('删除成功');
                setTimeout(function () {
                    window.location.reload();
                },1000)
            } else {
                layer.msg(retJson.msg);
            }
        });

    });



    /*编辑器-----------------*/
   /* var editor;
    KindEditor.ready(function (K) {
        editor = K.create('textarea', {
            cssPath: '${ctxStaticNew}/kindeditor-4.1.10/plugins/code/prettify.css',
            uploadJson: '${ctx}/file/kindeditor/upload',
            allowFileManager: true,
            urlType : 'domain',
            height : "400px",
            resizeType : 1,
            cssData: 'body { font-size: 20px}',
            items:[ 'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'cut', 'copy', 'paste',
                '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                'superscript', 'clearhtml', '|', 'formatblock', 'fontsize','/',
                'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage', 'table', 'hr', 'emoticons','|', 'about'],
            afterCreate: function () {
                var self = this;
                K.ctrl(document, 13, function () {
                    self.sync();
                    document.forms['example'].submit();
                });
                K.ctrl(self.edit.doc, 13, function () {
                    self.sync();
                    document.forms['example'].submit();
                });
            }
        });
        prettyPrint();
    });*/
</script>
</body>
</html>

