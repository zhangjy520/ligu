<%--
  Created by IntelliJ IDEA.
  User: leeyh
  Date: 2018/2/5
  Time: 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择背景图</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/addTemplate.css"/>
    <script type="text/javascript" src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxStatic}/js/openDialog.js" type="text/javascript" charset="utf-8"></script>
    <style>
        * {
            box-sizing: border-box;
        }

        .container > h3 {
            font-size: 16px;
            font-weight: normal;
            color: #54AB37;
            margin: 20px 0;
            padding: 0px 0 0px 8px;
            border-left: 3px solid #54AB37;
        }

        .container > h3 button {
            float: right;
            color: #fff;
            border-radius: 2px;
            background: #54AB37;
            border: 1px solid #54AB37;
            width: 80px;
            height: 35px;
            font-weight: bold
        }

        ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }
        .stuMsg span {
            display: inline-block;
            width: 36%;
            text-align: right;
            margin-right: 10px;
        }

        .stuMsg input[type=text] {
            width: 150px;
            height: 28px;
            padding: 0;
            padding-left: 5px;
            border-radius: 3px;
            border: 1px solid #dadada;
            outline: none;
        }

        .stuMsg label {
            margin-right: 61px;
        }

        ul li {
            position: relative;
            margin: 15px 0;
        }

        b {
            font-size: 20px;
            color: #E51C23;
            position: absolute;
            top: 4px;
            right: 76px;
        }

        .radio b {
            top: -3px;
        }

        .stuMsg select {
            font-size: 14px;
            color: #333;
            width: 150px;
            height: 28px;
            padding-left: 5px;
            border: 1px solid #dadada;
            border-radius: 2px;
            outline: none;
        }

        .uploading p {
            width: 90px;
            height: 86px;
            background: url('${ctxStatic}/image/image.png');
            margin: 0;
            margin-left: 104px;
        }

        .uploading button {
            margin-top: 10px;
            padding: 5px 20px;
            color: #fff;
            background: #54AB37;
            border: 1px solid #54AB37;
            font-weight: bold;
        }

        .parentMsg P {
            FONT-SIZE: 14PX;
            padding-left: 11px;
        }

        .parentMsg ul {
            overflow: hidden;
            box-sizing: border-box;
        }

        .parentMsg ul li {
            float: left;
            width: 50%;
            margin: 15px 0
        }

        .parentMsg ul li span {

            display: inline-block;
            width: 36%;
            text-align: right;
        }

        .parentMsg input[type=text] {
            height: 28px;
            padding: 0;
            padding-left: 5px;
            width: 190px;
            border: 1px solid #dadada;
            border-radius: 2px;
            outline: none;
        }

        .parentMsg select {
            width: 190px;
            height: 28px;
            border-radius: 2px;
            outline: none;
        }

        .container table {
            border-collapse: collapse
        }

        .container table th, .container table td {
            border: 1px solid #ddd;
            padding: 10px 0;
        }

        .container table th {
            background: #eee;
        }

        div input[type='checkbox'] {
            position: relative;
            top: 2px;
        }

        div > i {
            font-style: normal;
            margin-right: 22px;
        }

        .time-conatiner span {
            margin-right: 10px;
        }

        .day-time input {
            width: 150px;
            line-height: 24px;
            border: 1px solid #dadada;
            padding-left: 5px;
            border-radius: 2px;
            outline: none !important;
        }

        .row p, .row label {
            width: 20%;
            display: inline-block;
            text-align: right;
        }


        li>span{
            text-align: center !important;
            line-height: 20px;
        }
        li>span>input{
            margin: 0;
            width: 15px;
            height: 15px;
        }
        .module-lr>div{
            text-align: center;
            line-height: 140px;
        }
        .module-tb>div{
            text-align: center;
            line-height: 70px;
        }
        .temp-container>ul>li>p{
            margin: 0;
            text-align: left;
        }
        .temp-container>ul>li>.module-four>img{
            width: 100%;
            height: 100%;
            display: block;
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="content temp-container">
    <ul>
        <li style="text-align: left !important;">
            <span class="active"></span>
            <div class="module-four"></div>
            <p><input checked type="radio" name="bgImageId" value="no">无背景</p>
        </li>
        <c:forEach items="${bgImageList}" var="bgImage">
            <li>
                <span class="active"></span>
                <div class="module-four">
                    <img src="${bgImage.picUrl}" alt="${bgImage.picName}">
                </div>
                <p><input type="radio" name="bgImageId" value="${bgImage.picUrl}">${bgImage.picTitle}</p>
            </li>
        </c:forEach>
        <%--<li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/activity.png" alt="activity.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$activity.png">活动</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/examination.png" alt="examination.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$examination.png">考试</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/exercise.png" alt="exercise.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$exercise.png">运动</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/festival_H.png" alt="festival_H.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$festival_H.png">节假日</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/freshness.png" alt="freshness.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$freshness.png">文艺</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/guest.png" alt="guest.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$guest.png">领导莅临</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/poetry_H.png" alt="poetry_H.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$poetry_H.png">诗歌</p>
        </li>
        <li>
            <span class="active"></span>
            <div class="module-four">
                <img src="${ctxStaticNew}/images/customPageBGImages/school_opens.png" alt="school_opens.png">
            </div>
            <p><input type="radio" name="bgImageId" value="$school_opens.png">开学</p>
        </li>--%>
    </ul>
</div>
<script>
    function chooseBGImage() {
        var bgImageUrl = "";
        $('input[name="bgImageId"]:checked').each(function () {
            bgImageUrl = $(this).val();
        });
        return bgImageUrl;
    }
    function doSubmit() {
        window.parent.changeBGImage(chooseBGImage());
        window.parent.closeAlertDiv();
        return false;
    }
</script>
</body>
</html>
