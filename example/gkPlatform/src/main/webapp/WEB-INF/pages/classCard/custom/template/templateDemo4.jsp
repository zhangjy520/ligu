<%--
  Created by IntelliJ IDEA.
  User: leeyh
  Date: 2018/1/29
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<head>
    <script src="http://vjs.zencdn.net/6.6.0/video.js"></script>
    <link href="http://vjs.zencdn.net/6.6.0/video-js.css" rel="stylesheet">
    <!-- If you'd like to support IE8 -->
    <script src="http://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
</head>
<div id="bgImage">
    <div id="headline">
        <%--<h3>标题文字</h3>--%>
    </div>
    <div align="center">
        <%--http://121.42.168.14:10012/video/test.mp4--%>
        <video id="my-video" autoplay loop height="90%" src=""
               type='video/mp4'>
        </video>
    </div>
</div>
