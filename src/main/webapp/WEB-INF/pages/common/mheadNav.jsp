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
                <a onclick='window.location.href="${ctx}/admin/xzHome"'>首页</a>
            </li>
            <li class="dailyHealth">
                <a>日常健康</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/admin/dailyData"'>日常数据</li>
                    <li onclick='window.location.href="${ctx}/admin/healthGuide"'>健康指导</li>
                    <li onclick='window.location.href="${ctx}/admin/dailyHealth"'>健康管理</li>
                </ul>
            </li>
            <li class="dailyHealth">
                <a onclick='window.location.href="${ctx}/admin/shjk"'>手环监控</a>
            </li>
            <li class="dailyHealth">
                <a>体质监测</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/admin/bodyHealth"'>体质健康</li>
                    <li onclick='window.location.href="${ctx}/admin/PEtest"'>体育测试</li>
                    <li onclick='window.location.href="${ctx}/admin/gradeManage"'>成绩管理</li>
                </ul>
            </li>
            <li class="dailyHealth">
                <a>学生档案</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/admin/studentFiles"'>班级档案</li>
                    <li onclick='window.location.href="${ctx}/admin/classFiles"'>学生档案</li>
                </ul>
            </li>
            <li class="dailyHealth">
                <a>基础管理</a>
                <ul class="menu-box">
                    <li onclick='window.location.href="${ctx}/admin/shManage"'>手环管理</li>
                    <li onclick='window.location.href="${ctx}/admin/temporarySH"'>临时手环</li>
                    <li onclick='window.location.href="${ctx}/admin/shStock"'>手环库存</li>
                    <li onclick='window.location.href="${ctx}/admin/baseStation"'>基站管理</li>
                    <li onclick='window.location.href="${ctx}/admin/blockManage"'>校区管理</li>
                    <li onclick='window.location.href="${ctx}/admin/basicManage"'>学生管理</li>
                    <li onclick='window.location.href="${ctx}/admin/teacherManage"'>教师管理</li>
                    <li onclick='window.location.href="${ctx}/admin/roleManage"'>角色管理</li>
                </ul>
            </li>
        </ul>
        <div class="user">
            <img src="${pageContext.request.contextPath}/assets/image/m/email.png" alt=""/>
            <b></b>
            <span>孟庆</span>
        </div>
    </div>
</nav>