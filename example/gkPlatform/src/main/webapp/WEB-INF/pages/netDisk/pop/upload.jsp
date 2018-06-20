<%@ include file="../../common/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html">--%>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

    <%--<style>--%>
        <%--body {--%>
            <%--font-size: 0.8em;--%>
            <%--font-family: "Roboto", "Noto Sans CJK SC", "Nato Sans CJK TC", "Nato Sans CJK JP", "Nato Sans CJK KR", -apple-system, ".SFNSText-Regular", "Helvetica Neue", "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Zen Hei", Arial, sans-serif;--%>
        <%--}--%>

        <%--.container {--%>
            <%--width: 400px;--%>
            <%--margin: 0 auto;--%>
            <%--margin-top: 30px;--%>
        <%--}--%>

        <%--input {--%>
            <%--margin: 0 10px 0 20px--%>
        <%--}--%>

        <%--span {--%>
            <%--margin-right: 10px;--%>
        <%--}--%>

        <%--a {--%>
            <%--color: #B7B8B8--%>
        <%--}--%>

        <%--.file-box {--%>
            <%--position: absolute;--%>
        <%--}--%>

        <%--.txt {--%>
            <%--width: 200px;--%>
            <%--height: 35px;--%>
        <%--}--%>

        <%--.file {--%>
            <%--filter: alpha(opacity:0);--%>
            <%--opacity: 0;--%>
            <%--border: 1px red solid;--%>
            <%--z-index: 8888;--%>
            <%--position: absolute;--%>
            <%--right: 0px;--%>
            <%--height: 40px;--%>
            <%--width: 45px;--%>
            <%--margin: -40px -12px;--%>
        <%--}--%>

        <%--.demo{min-width:360px;margin:30px auto;padding:10px 20px}--%>
        <%--.demo h3{line-height:40px; font-weight: bold;}--%>
        <%--.file-item{float: left; position: relative; width: 110px;height: 110px; margin: 0 20px 20px 0; padding: 4px;}--%>
        <%--.file-item .info{overflow: hidden;}--%>
        <%--.uploader-list{width: 100%; overflow: hidden;}--%>
    <%--</style>--%>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/webuploader/webuploader.css">
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/webuploader/style.css">
    <style>
        .demo{min-width:360px;margin:30px auto;padding:10px 20px}
        .demo h3{line-height:40px; font-weight: bold;}
        .file-item{float: left; position: relative; width: 110px;height: 110px; margin: 0 20px 20px 0; padding: 4px;}
        .file-item .info{overflow: hidden;}
        .uploader-list{width: 100%; overflow: hidden;}
    </style>

    <%--<script src="${ctxStaticNew}/js/jquery.min.js"></script>--%>
    <%--<link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/webuploader.css">--%>
    <%--<script>--%>


        <%--var isSubmit = false;--%>
        <%--function doSubmit() {//回调函数，在编辑和保存动作时，供openDialog调用提交表单。--%>
            <%--var divas = parent.$("#directoryPathDiv").children();--%>
            <%--var directotypath = directoryPathF(divas);--%>


            <%--window.parent.layer.msg('导入中', {icon: 16, shade: 0.5, time: 1000000000});//当生成完成这个对话框才被关掉--%>
            <%--if (!isSubmit) {--%>
                <%--$.ajax({--%>
                    <%--url: '${url}/?token=${token}&repositoryId=${repositoryId}&directotypath=' + encodeURI(directotypath),--%>
                    <%--type: 'POST',--%>
                    <%--cache: false,--%>
                    <%--data: new FormData($('#inputForm')[0]),--%>
                    <%--processData: false,--%>
                    <%--contentType: false--%>
                <%--}).done(function (res) {--%>
<%--//                    window.parent.importCallBack(res);--%>
                    <%--var index = parent.layer.getFrameIndex(window.name);--%>
                    <%--parent.layer.close(index);--%>
                    <%--parent.layer.closeAll();--%>
                    <%--var currentFolederName = parent.$("#hiddenCurrentfolederName").val();--%>
                    <%--var totalUrl = parent.$(".totalFileUrl").val();--%>
                    <%--parent.partflush(totalUrl, currentFolederName);--%>
                <%--}).fail(function (res) {--%>
<%--//                    alert(res.msg);--%>
                    <%--layer.msg("模板异常，导入失败！");--%>
                    <%--setTimeout(function () {--%>
                        <%--parent.location.reload();--%>
                    <%--}, 500)--%>
                <%--});--%>
            <%--} else {--%>
                <%--window.parent.layer.closeAll();--%>
                <%--window.parent.layer.msg("表单提交异常,请稍后再试!");--%>
            <%--}--%>
            <%--isSubmit = true;--%>
            <%--return false;--%>
        <%--}--%>
        <%--/////////////////////////////////////引入webupoloader插件测试--%>
    <%--</script>--%>
</head>
<body>
<%--<div class="container">--%>
    <%--<!--目标样式的文件选择框-->--%>
    <%--<form id="inputForm" method="post" enctype="multipart/form-data">--%>
        <%--<div class="file-box">--%>
            <%--<label>请选择文件：</label>--%>
            <%--<input type="file" name="file" multiple="multiple"/>--%>
        <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>
<div class="container">
    <div class="row main">
        <div class="demo">
            <div id="uploadfile">
                <div id="thelist" class="uploader-list"></div>
                <div class="form-group form-inline">
                    <div id="picker" style="float:left">选择文件</div> &nbsp;
                    <button id="ctlBtn" class="btn btn-default" style="padding:8px 15px;">开始上传</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctxStaticNew}/js/webuploader.min.js"></script>
<script type="text/javascript" src="${ctxStaticNew}/js/upload.js"></script>
<script>
    function directoryPathF(divas) {
        var aLength = 0;
        if (divas != undefined && divas != "") {
            aLength = divas.length
        }

        var directoryPath = "";
        if (aLength > 0) {
            directoryPath = parent.$(".directoryPathDiv a").last().attr("hre");
        }
        return directoryPath;
    }

    $(function(){
        var $list = $('#thelist'),
                $btn = $('#ctlBtn');
        var divas = parent.$("#directoryPathDiv").children();
        var directotypath = directoryPathF(divas);

        var uploader = WebUploader.create({
            resize: false, // 不压缩image
            swf: '${ctxStaticNew}/js/uploader.swf', // swf文件路径
            server: '${url}/?token=${token}&repositoryId=${repositoryId}&directotypath='+ encodeURI(directotypath), // 文件接收服务端。
            pick: '#picker', // 选择文件的按钮。可选
            chunked: false, //是否要分片处理大文件上传
            //chunkSize:2*1024*1024 //分片上传，每片2M，默认是5M
            //auto: false //选择文件后是否自动上传
            // chunkRetry : 2, //如果某个分片由于网络问题出错，允许自动重传次数
            //runtimeOrder: 'html5,flash',
            // accept: {
            //   title: 'Images',
            //   extensions: 'gif,jpg,jpeg,bmp,png',
            //   mimeTypes: 'image/*'
            // }
        });
        // 当有文件被添加进队列的时候
        uploader.on( 'fileQueued', function( file ) {
            $list.append( '<div id="' + file.id + '" class="item">' +
                    '<h4 class="info">' + file.name + '</h4>' +
                    '<p class="state">等待上传...</p>' +
                    '</div>' );
        });
        // 文件上传过程中创建进度条实时显示。
        uploader.on( 'uploadProgress', function( file, percentage ) {
            var $li = $( '#'+file.id ),
                    $percent = $li.find('.progress .progress-bar');

            // 避免重复创建
            if ( !$percent.length ) {
                $percent = $('<div class="progress progress-striped active">' +
                        '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                        '</div>' +
                        '</div>').appendTo( $li ).find('.progress-bar');
            }

            $li.find('p.state').text('上传中');

            $percent.css( 'width', percentage * 100 + '%' );
        });
        // 文件上传成功
        uploader.on( 'uploadSuccess', function( file,response ) {
            console.log(response)
            $( '#'+file.id ).find('p.state').text('已上传');
        });

        // 文件上传失败，显示上传出错
        uploader.on( 'uploadError', function( file ) {
            $( '#'+file.id ).find('p.state').text('上传出错');
        });
        // 完成上传完
        uploader.on( 'uploadComplete', function( file ) {
            $( '#'+file.id ).find('.progress').fadeOut();
        });

        $btn.on('click', function () {
            if ($(this).hasClass('disabled')) {
                return false;
            }
            uploader.upload();
            // if (state === 'ready') {
            //     uploader.upload();
            // } else if (state === 'paused') {
            //     uploader.upload();
            // } else if (state === 'uploading') {
            //     uploader.stop();
            // }
        });

    });
</script>
</body>
</html>