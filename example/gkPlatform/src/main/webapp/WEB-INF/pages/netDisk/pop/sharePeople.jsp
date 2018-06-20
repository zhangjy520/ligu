<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: 'microsoft YaHei';
        }

        .clearfix:after {
            content: '';
            display: block;
            clear: both;
        }

        .container {
            width: 825px;
            margin: 0 auto;
            border: 1px solid #ddd;
        }

        aside, section {
            height: 100%;
        }

        aside {
            border-right: 1px solid #ddd;
            float: left;
            padding: 28px 20px;
            width: 60%;
        }

        section {
            float: right;
        }

        aside > header {
            overflow: hidden;
            position: relative;
            width: 62%;
        }

        aside > header i {
            cursor: pointer;
            display: none;
            position: absolute;
            width: 11px;
            height: 10px;
            right: 43px;
            top: 11px;
            background: url(${ctxStaticNew}/images/icon-c-2.png) no-repeat center center;
        }

        aside > header > span {
            font-size: 14px;
            color: #525252;
            line-height: 30px;
        }

        aside > header > input[type=text] {
            padding-left: 5px;
            padding-right: 23px;
            float: right;
            height: 30px;
            width: 200px;
            border: 1px solid #dadada;
            border-right: none;
            outline: none;
        }

        aside > header > button {
            cursor: pointer;
            float: right;
            border: 1px solid #54ab37;
            width: 37px;
            height: 30px;
            background: #54ab37;
            border-top-right-radius: 3px;
            border-bottom-right-radius: 3px;
        }

        aside > header > button > span {
            display: inline-block;
            width: 17px;
            height: 28px;
            background: url(${ctxStaticNew}/images/icon-r.png) no-repeat center center;
        }

        aside > div {
            max-height: 500px;
            overflow-y: scroll;
            margin-top: 25px;
        }

        aside > div > table {
            font-size: 14px;
            width: 100%;
            border-collapse: collapse
        }

        aside > div > table input[type=checkbox] {
            cursor: pointer;
            position: relative;
            top: 2px;
            margin: 0;
            margin-right: 5px;
        }

        aside > div > table label {
            cursor: pointer;
        }

        aside > div > table span {
            margin-right: 25px;
        }

        aside > div > table th {
            text-align: left;
            background: #F2F2F2;
            color: #333;
            font-weight: normal;
            padding: 10px;
        }

        aside > div > table td {
            color: #525252;
            padding: 10px;
        }

        aside > div > table tbody tr:nth-child(2n-1) {
            background: #F8F8F8;
        }

        aside > div > table td ul {
            list-style: none;
            padding: 0;
            overflow: hidden;
            margin: 0;
        }

        aside > div > table td ul li {
            float: left;
            width: 20%;
            margin-bottom: 10px;
        }

        section {
            float: left;
            padding: 28px 20px;
            width: 40%;
        }

        section > header {
            padding-bottom: 15px;
            color: #525252;
            font-size: 14px;
            overflow: hidden;
            border-bottom: 1px solid #ddd;
        }

        section > header span {
            float: right;
            color: #fa2250;
            font-size: 12px;
            cursor: pointer;
            padding-left: 21px;
            background: url(${ctxStaticNew}/images/icon-d.png) no-repeat left center;
        }

        section > div {
            max-height: 500px;
            overflow-y: scroll;
        }

        section > div > ul {
            list-style: none;
            padding: 0;
            overflow: hidden;
        }

        section > div > ul > li {
            padding-left: 10px;
            text-align: center;
            cursor: pointer;
            float: left;
            width: 33%;
            position: relative;
            font-size: 14px;
            color: #333;
            margin-bottom: 15px;
        }

        section > div > ul > li > span {
            float: left;
        }

        /*section>div>ul>li>i{position:absolute;width:9px;height:9px;background: url(images/icon-c-3.png) no-repeat center center;right:3px; top:5px;}*/
        section > div > ul > li > i {
            float: left;
            width: 9px;
            height: 9px;
            background: url(${ctxStaticNew}/images/icon-c-3.png) no-repeat center center;
            margin-top: 6px;
            margin-left: 10px;
        }

        section > div > ul > li:hover > i {
            background: url(${ctxStaticNew}/images/icon-c-1.png) no-repeat center center;
        }
    </style>
    <script src="${ctxStaticNew}/js/jquery.min.js"></script>
    <script src="${ctxStaticNew}/js/layer/layer.js"></script>
    <script src="${ctxStaticNew}/js/openDialog.js"></script>
</head>
<body>
<!-- 全选按钮class必须为allCheck，数据内容的class必须为contentCheck，id为真实获取的userid，lable for id= userid,label id=任意不重复
	<input class="contentCheck" type="checkbox" id="userid10"/>
	<label id="wst" for="userid10">王思彤0</label>
 -->
<main class="container clearfix">
    <c:forEach var="${teacherList}" items="teacher">
        <span style="margin: 20px">${teacher.name}</span>
    </c:forEach>

</main>
<script>

</script>
</body>
</html>