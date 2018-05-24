<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=7" />
    <title>力谷后台界面框架</title>

    <link href="${ctxStatic}/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="${ctxStatic}/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="${ctxStatic}/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <link href="${ctxStatic}/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
    <!--[if IE]>
    <link href="${ctxStatic}/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
    <![endif]-->
    <style type="text/css">
        #header{height:85px}
        #leftside, #container, #splitBar, #splitBarProxy{top:90px}
    </style>

    <!--[if lte IE 9]>
    <script src="${ctxStatic}/dwz/js/speedup.js" type="text/javascript"></script>
    <![endif]-->
    <script src="${ctxStatic}/dwz/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/js/jquery.cookie.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/js/jquery.validate.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>

    <script src="${ctxStatic}/dwz/bin/dwz.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            DWZ.init("${ctxStatic}/dwz/dwz.frag.xml", {
                loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
                statusCode:{ok:200, error:300, timeout:301}, //【可选】
                pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
                debug:false,	// 调试模式 【true|false】
                callback:function(){
                    initEnv();
                    $("#themeList").theme({themeBase:"themes"});
                    //默认收缩
                    // setTimeout(function() {$("#sidebar .toggleCollapse div").trigger("click");}, 10);
                }
            });
        });
    </script>
</head>

<body scroll="no">
<div id="layout">
    <div id="header">
        <div class="headerNav">
            <a class="logo" href="http://j-ui.com">标志</a>
            <ul class="nav">
                <li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市</a>
                    <ul>
                        <li><a href="${ctxStatic}/dwz/sidebar_1.html">北京</a></li>
                        <li><a href="${ctxStatic}/dwz/sidebar_2.html">上海</a></li>
                    </ul>
                </li>
                <li><a href="changepwd.html" target="dialog" width="600">设置</a></li>
                <li><a href="login.html">退出</a></li>
            </ul>
            <ul class="themeList" id="themeList">
                <li theme="default"><div class="selected">蓝色</div></li>
                <li theme="green"><div>绿色</div></li>
                <li theme="red"><div>红色</div></li>
            </ul>
        </div>

        <div id="navMenu">
            <ul>
                <li class="selected"><a href="#"><span>题库管理</span></a></li>
                <li><a href="${ctxStatic}/dwz/sidebar_1.html"><span>资源管理</span></a></li>
                <li><a href="${ctxStatic}/dwz/sidebar_2.html"><span>会员管理</span></a></li>
                <li><a href="${ctxStatic}/dwz/sidebar_1.html"><span>服务管理</span></a></li>
                <li><a href="${ctxStatic}/dwz/sidebar_2.html"><span>系统设置</span></a></li>
            </ul>
        </div>
    </div>

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
                    <ul class="tree">
                        <li><a>个人中心</a>
                            <ul>
                                <li><a href="${ctx}/question/index" target="navTab">my question</a></li>
                                <li><a href="${ctx }/account/myTask" target="navTab">我的任务</a></li>
                                <li><a href="${ctx }/account/groupTask" target="navTab">组任务</a></li>
                            </ul>
                        </li>
                        <li><a href="" target="navTab">系统管理</a>
                            <ul>
                                <li><a href="${ctx }/user/list" target="navTab">用户管理</a></li>
                                <li><a href="${ctx }/task/list" target="navTab">流程定义</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="accordionHeader">
                    <h2><span>Folder</span>典型页面</h2>
                </div>
                <div class="accordionContent">
                    <ul class="tree treeFolder">

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
            </div>
        </div>
    </div>

</div>

<div id="footer">Copyright &copy; 2010 <a href="${ctxStatic}/dwz/demo_page2.html" target="dialog">ligu</a></div>
</body>
</html>