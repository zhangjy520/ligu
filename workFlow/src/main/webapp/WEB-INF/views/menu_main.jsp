<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>网软请假流程演示</title>
        <link href="${ctx }/static/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="${ctx }/static/dwz/css/core.css">
        <!--[if IE]>
		<link href="${ctx }/static/dwz/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
		<![endif]-->
        <script type="text/javascript" src="${ctx }/static/jquery/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="${ctx }/static/jquery/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${ctx }/static/dwz/js/dwz.min.js"></script>
        <script type="text/javascript">
			$(function(){
				DWZ.init("${ctx }/static/dwz/dwz.frag.xml", {
					loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
					statusCode:{ok:200, error:300, timeout:301}, //【可选】
					pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
					keys: {statusCode:"statusCode", message:"message"}, //【可选】
					ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
					debug:false,	// 调试模式 【true|false】
					callback:function(){
						initEnv();
						$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
					}
				});
			});
		</script>
    </head>
    <body>
        <!--  header -->
        <div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li><a href="http://weibo.com/dwzui" target="_blank">微博</a></li>
					<li><a href="logOut.html">退出</a></li>
				</ul>
			</div>
			<!-- navMenu -->
		</div>
        <!-- menu -->
        <div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>界面组件</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="" target="navTab">主框架面板</a>
								<ul>
									<li><a href="${ctx }/account/list" rel="account" target="navTab">我的主页</a></li>
								</ul>
							</li>
							
							<li><a>我的任务</a>
								<ul>
									<li><a href="${ctx }/account/myTask" rel="myTask" target="navTab">我的任务</a></li>
								</ul>
							</li>
									
							<li><a>所有流程</a>
								<ul>
									<li><a href="${ctx }/task/list" rel="task" target="navTab">我的任务</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>典型页面</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder treeCheck">
							<li><a href="${ctx }/user/list" rel="user" target="navTab">用户管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>流程演示</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">	
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">  
                	</div>
				</div>
			</div>
		</div>
                    
        <div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">DWZ团队</a> 京ICP备15053290号-2</div>
        
        <script type="text/javascript">
        
        </script>
    </body>
</html>