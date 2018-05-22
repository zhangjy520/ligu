<%@ include file="../../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看视频</title>
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://vjs.zencdn.net/6.6.0/video-js.css" rel="stylesheet">
    <!-- If you'd like to support IE8 -->
    <script type="text/javascript" src="${ctxStaticNew}/js/vjs/video.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/vjs/videojs-ie8.min.js"></script>
</head>
<style>
    div{
        margin: 0 auto;
    }
</style>
<body>
    <video autoplay="autoplay" id="my-video" class="video-js" controls preload="auto" width="680" height="464"
           poster="MY_VIDEO_POSTER.jpg" data-setup="{}" >
        <source src="http://${serverName}:${serverPort}/video/${url}" type='video/mp4'>
        <p class="vjs-no-js">
            To view this video please enable JavaScript, and consider upgrading to a web browser that
            <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
        </p>
    </video>
</body>
</html>

