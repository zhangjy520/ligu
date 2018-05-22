<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="../../../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>自定义界面预览</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.min.js"></script>--%>
    <link rel="stylesheet" href="${ctxStaticNew}/css/swiper.min.css">
    <script src="${ctxStaticNew}/js/swiper.min.js"></script>
    <style>
        *{
            box-sizing: border-box;
        }
        body{
            height: 100%;
            margin: 0;
        }
        #bgImage{
            width: 100%;
            background-size: 100% 100% !important;
            height: 100%;
        }
        h1,h2,h3,h4,h5,p{
            margin-top: 0;
            margin-bottom: 0;
        }
        .layui-layer{
            top: 0 !important;
            left: 0 !important;
        }
        .swiper-slide img{
            height: 100%;
            width: auto;
        }
    </style>
</head>
<body>
    <div id="pageContent"></div>
</body>
</html>
<script>
    if('${templateType}'=='wz'){
        $("#pageContent").html(window.parent.editor.html());
    }else{
        $("#pageContent").html(window.parent.getContent('pageContent'));
    }

    // picVheightPreview();
    // function picVheightPreview(){
    //     var aheight = $('#bgImage').height();
    //     var aheightt = $('#stu-manage').height();
    //     var headHight;
    //     if($('#headline').height() != 0){
    //         headHight = $('#headline').height();
    //         $('#stu-manage').siblings('div').height(aheight - headHight);
    //         $('.swiper-container').height(aheightt - headHight);
    //         $('.swiper-wrapper').height(aheightt - headHight);
    //     }
    // }
</script>