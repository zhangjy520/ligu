<%@include file="../common/common.jsp" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="login">
    <meta name="author" content="lexi">
    <link rel="stylesheet" href="${ctx}/assets/css/header.css"/>
    <link rel="stylesheet" href="${ctx}/assets/css/menuPage.css"/>
    <style>
        .menu_main{
            cursor: pointer;
        }
    </style>
</head>
<nav>
    <div class="menu">
                <span class="menu_logo">
                    LOGO 校园智能感知系统
                </span>
        <ul class="menu_main">
            <li>
                <a onclick='window.location.href="${ctx}/teacherHome"'>首页</a>
            </li>
            <li class="dailyHealth">
                <a>日常健康</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/tdailyData"'>日常数据</li>
                    <li onclick='window.location.href="${ctx}/thealthGuide"'>健康指导</li>
                    <li onclick='window.location.href="${ctx}/tdailyHealth"'>健康管理</li>
                </ul>
            </li>
            <li class="dailyHealth">
                <a onclick='window.location.href="${ctx}/index"'>手环监控</a>
            </li>
            <li class="dailyHealth">
                <a>体质监测</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/tbodyHealth"'>体质健康</li>
                    <li onclick='window.location.href="${ctx}/tP.E.test"'>体育测试</li>
                </ul>
            </li>
            <li class="dailyHealth">
                <a>学生档案</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/tstudentFiles"'>班级档案</li>
                    <li onclick='window.location.href="${ctx}/tclassFiles"'>学生档案</li>
                </ul>
            </li>

        </ul>
        <div class="user">
            <img src="${ctx}/assets/image/email.png" alt=""/>
            <b></b>
            <span class="user1">刘菲</span>
        </div>
    </div>
</nav>