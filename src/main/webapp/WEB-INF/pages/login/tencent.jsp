<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta charset="utf-8">
<title>首页 - QQ安全中心 - 用心守护你的QQ</title>
<meta name="keywords" content="QQ安全中心,密保问题,密保手机,QQ安全中心（手机版）,QQ令牌,Q币Q点保护,QQ登录保护,登录保护,登录记录,游戏保护,消息中心,Q币被盗,修改密码,QQ密码,改密,找回密码,手机令牌,忘记密保,手机换号怎么改密,保护QQ,怎么修改QQ密码,QQ密码忘了怎么办,密保忘了怎么改密,QQ被盗,QQ异地登录">
<meta name="description" content="QQ安全中心为您的腾讯在线生活提供安全护航。在这里，您可以管理您的帐号密码、密保，为Q币、游戏装备、QQ开启保护，还可以获得最新的安全资讯。">

<title>QQ安全中心</title>

 <link rel="icon" href="${ctx}/assets/images/title.ico"/>
<link rel="stylesheet" href="${ctx}/assets/css/styleqq.css"/>
    <script type="text/javascript" src="${ctx}/assets/js/jquery.min.js"></script>
    <script>
        function close_top_notice()
        {
            document.getElementById("top_notice").style.display="none";
            var exp = new Date();
            var top_notice_val = exp.getFullYear() + "-" + (exp.getMonth()+1) + "-" + exp.getDate();
            exp.setTime(exp.getTime() + 8*60*60*1000 + 60*1000*30);
            var cookie_val = "top_notice=" + top_notice_val + ";expires=" + exp.toGMTString() + ";PATH=/; DOMAIN=.aq.qq.com";
            document.cookie = cookie_val;
        }
        function switchToOld()
        {
            document.cookie = "aq_ver=redirect_to_aq_v1;PATH=/; DOMAIN=aq.qq.com";
            top.location.href="/cn/index";
        }
        function hide_ad_app()
        {
            $("#ad_app_priv").hide();
        }
        function reload_top(n)
        {
            document.cookie = "pt_mbkey=; EXPIRES=Fri, 02-Jan-1970 00:00:00 GMT; PATH=/; DOMAIN=.qq.com";
            top.location.reload();
        }

        function login() {
            alert($("#username").val());
            alert($("#password").val());
        }
    </script>
 </head>
<body>

<div id="top_notice" class="mod_top_notice">
	<p><span>QQ安全中心温馨提醒：</span>近期出现多起利用QQ或微信诈骗事件，凡在QQ或微信上遇到好友借钱、充值等，请务必先电话确认，谨防上当受骗！<a href="http://110.qq.com" target="_blank">点击快速举报诈骗和锁定帐号</a></p>
	<a class="close" href="javascript:close_top_notice();" title="关闭"><span>关闭</span></a>
</div>


<div id="headerAll">

	<div id="header">

    	<div id="top">
		<a class="logo" href="https://undefined/" onclick="sendHotClick('HEADER.TO.LOGO');"><cite>QQ安全中心<br>在线生活安全护航</cite></a>
        	<div class="right_info">
            <ul>
			
			<li id="header_login_but" style="display: none;"><a href="javascript:alert_login('');">登录</a></li>
			<li><a href="https://aq.qq.com/v2/safe_school/report_index.shtml" target="_blank" onclick="sendHotClick('HEADER.TO.REPORT');">举报</a></li>
			<li><a href="http://support.qq.com/discuss/387_1.shtml" target="_blank" onclick="sendHotClick('HEADER.TO.FEEDBACK');">反馈意见</a></li>
			<li class="pr"><a>站点地图<b></b></a></li>
			<li><a href="http://aq.qq.com/en/index/en_index?source_id=2882">English</a></li>
            </ul>
            </div>

        </div>
    
    	<div id="menu">
        	<ul>
            <li id="menu_index" class="on1"><a class="m1" href="https://aq.qq.com/cn2/index"><cite>首页</cite></a></li>
			<li id="menu_toolbox"><a class="m5" href="https://aq.qq.com/cn2/manage/my_mb" ><cite>密保工具箱</cite></a></li>
            <li id="menu_account_prot"><a class="m2" href="https://aq.qq.com/cn2/safe_service/my_prot" ><cite>帐号保护</cite></a></li>
            <li id="menu_pwd_manage"><a class="m3" href="https://aq.qq.com/cn2/psw_mgr/psw_mgr_index" ><cite>密码管理</cite></a></li>
            <li id="menu_safe_mutual"><a class="m4" href="https://aq.qq.com/cn2/safe_school/safe_school_index"><cite>安全学堂</cite></a></li>
            </ul>
        </div>
		
		
		
   	   <a class="handheld" href="https://aq.qq.com/app" target="_blank"></a>

	   <!--密保工具箱下拉菜单-->
<div class="accounts_list toolbox_list" id="submenu_toolbox" name="submenu" style="display:none;">
	<h3><a href="https://aq.qq.com/cn2/manage/my_mb"><cite>密保工具</cite></a></h3>
	<ul>
	
	<li><a class="t1" href="https://aq.qq.com/cn2/manage/mbtoken/mbtoken_home?source_id=2228"><cite>QQ安全中心手机版</cite></a></li>
	<li><a class="t2" href="https://aq.qq.com/cn2/manage/mobile/mobile_index?source_id=2228"><cite>密保手机</cite></a></li>
	<li><a class="t3" href="https://aq.qq.com/cn2/manage/qqtoken/qqtoken_home?source_id=2228"><cite>QQ令牌</cite></a></li>
	<li><a class="t4" href="https://aq.qq.com/cn2/manage/question/my_question?source_id=2228"><cite>密保问题</cite></a></li>
	<li><a class="t5" href="https://aq.qq.com/cn2/aq_recommend/aq_recommend_face?source_id=3258"><cite>人脸识别</cite></a></li>
	</ul>
</div><!--密保工具箱下拉菜单 End-->

<!--帐号保护下拉菜单-->
<div class="accounts_list" id="submenu_account_prot"  name="submenu" style="display:none;">
	<h3><a href="https://aq.qq.com/cn2/safe_service/my_prot"><cite>帐号保护</cite></a></h3>
	<ul>
    <li><a class="a1" href="https://aq.qq.com/cn2/safe_service/my_qbqd_prot"><cite>保护Q币Q点</cite></a></li>
    <li><a class="a2" href="https://aq.qq.com/cn2/safe_service/my_game_prot"><cite>保护游戏</cite></a></li>
    <li><a class="a3" href="https://aq.qq.com/cn2/safe_service/my_login_prot"><cite>保护QQ登录</cite></a></li>
    <!-- <li><a  class="a4" href="/cn2/safe_service/my_key_prot"><cite>保护QQ SHOW物品</cite></a></li> -->
    </ul>
</div><!--帐号保护下拉菜单 End-->

<!--密码管理下拉菜单-->
<div class="accounts_list password_list" id="submenu_pwd_manage" name="submenu" style="display:none;">
	<h3><a href="https://aq.qq.com/cn2/psw_mgr/psw_mgr_index"><cite>密码管理</cite></a></h3>
	<ul>
    <li><a class="pw1" href="https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=4.0"><cite>修改密码</cite></a></li>
    <li><a class="pw2" href="https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=4.0"><cite>找回密码</cite></a></li>
	<li><a class="pw3" href="https://aq.qq.com/cn2/psw_strength_check/pswcheck_index"><cite>密码强度检测</cite></a></li>
    <li><a class="pw4" href="https://aq.qq.com/cn2/ipwd/my_ipwd"><cite>独立密码管理</cite></a></li>
    <li><a class="pw5" href="https://aq.qq.com/cn2/appeal/appeal_index"><cite>帐号申诉</cite></a></li>
    </ul>
</div><!--密码管理下拉菜单 End-->

<!--站点地图-->
<div class="m_h" style="display:none;" id="site_map_menu" >
	<div class="m_h_t">站点地图<b></b></div>
    <dl>
    <dt><a href="https://aq.qq.com/cn2/index">首页</a></dt>
    </dl>
    
    <dl>
    <dt><a href="https://aq.qq.com/cn2/safe_service/my_prot">帐号保护</a></dt>
    <dd>
    <a href="https://aq.qq.com/cn2/safe_service/my_qbqd_prot">Q币Q点保护</a>
    <a href="https://aq.qq.com/cn2/safe_service/my_login_prot">QQ登录保护</a>
    <a href="https://aq.qq.com/cn2/safe_service/my_game_prot">游戏保护</a>
    <!-- <a  href="/cn2/safe_service/my_key_prot">QQ秀物品保护</a> -->
    </dd>
    </dl>
    
    <dl>
    <dt><a href="https://aq.qq.com/cn2/manage/my_mb">密保工具箱</a></dt>
    <dd>
    <a href="https://aq.qq.com/cn2/manage/question/my_question">密保问题</a>
    <a href="https://aq.qq.com/cn2/manage/mobile/mobile_index">密保手机</a>
  <!--  <a  href="/cn2/manage/mbk/my_mbk">密保卡</a> -->
    <a href="https://aq.qq.com/cn2/manage/qqtoken/qqtoken_home">QQ令牌</a>
    <a href="https://aq.qq.com/cn2/manage/mbtoken/mbtoken_home">QQ安全中心手机版</a>
    </dd>
    </dl>
    
    <dl>
    <dt><a href="https://aq.qq.com/cn2/psw_mgr/psw_mgr_index">密码管理</a></dt>
    <dd>
    <a href="https://aq.qq.com/cn2/findpsw/findpsw_index">找回密码</a>
    <a href="https://aq.qq.com/cn2/change_psw/change_psw_index">修改密码</a>
    <a href="https://aq.qq.com/cn2/appeal/appeal_index">帐号申诉</a><br>
    <a href="https://aq.qq.com/cn2/ipwd/my_ipwd">独立密码管理</a>
	<a href="https://aq.qq.com/cn2/psw_strength_check/pswcheck_index">密码强度检测</a>
    </dd>
    </dl>

    <dl>
    <dt><a href="https://aq.qq.com/cn2/safe_school/safe_school_index">安全学堂</a></dt>
    </dl>
    
    <dl class="n">
    <dt class="g">其他</dt>
    <dd>
    <a href="https://aq.qq.com/v2/safe_school/report_index.shtml">举报</a>
    <a href="https://aq.qq.com/cn2/personal_info/personal_info_index">个人资料</a>
	<a href="https://aq.qq.com/v2/notice/notice.shtml">系统公告</a>
	<a href="http://service.qq.com/special_auto/aq.html">腾讯客服</a><br>
	<a href="https://aq.qq.com/110?source_id=2495">防骗小助手</a>
	<a href="https://aq.qq.com/cn2/login_limit/login_limit_index?source_id=3217">帐号解封</a>
    </dd>
    </dl>
</div>
<!--站点地图end-->
</div>
</div>

<div id="ad_app_priv">

    <a href="javascript:hide_ad_app();" class="ad_app_close"></a>

    <div class="ad_app_area">

        <div class="ad_app_about"></div>

        <img src="${ctx}/assets/images/qrcode.png">

        <p class="ad_app_text">帐号安全随身掌控<span>号码丢失轻松找回</span></p>

    </div>

    

</div>

<!-- AD End -->

<!--Login-->
<div id="loginbar">
<div id="login">

<div class="login" id="login_alert" style="display: block; z-index: 10003; padding: 0px; width: 383px;">
    <div class="db1">
        <p id="db1_1">账号密码登录</p>
        <p id="db1_2">推荐使用<a style="cursor: pointer;text-decoration: none;color: #3481cf;">快速安全登录</a>，防止盗号。</p>
    </div>
    <div class="db2">
        <input id="username" type="text" placeholder="支持QQ号/邮箱/手机号登录">
        <input id="password" type="password" placeholder="密码">
        <input id="loginBtn" onclick="login()" type="button" value="登录">
    </div>
	<div class="forget">忘了密码？</div>
</div>



</div>
</div>

<!--Login End-->

<!--indexInfo-->
<div id="indexinfo">
	<dl>
    <a href="https://aq.qq.com/cn2/appeal/appeal_index?source_id=2224">
    <dt><i class="icon14"></i><span>帐号申诉</span></dt>
    <dd>申诉和辅助好友申诉</dd>
    </a>
    </dl>
	
	<dl>
    <a href="https://aq.qq.com/110?source_id=2497">
    <dt><i class="icon21"></i><span>紧急冻结</span></dt>
    <dd>QQ被盗？立即阻止损失</dd>
    </a>
    </dl>

	<dl>
    <a href="https://aq.qq.com/cn2/login_limit/login_limit_index?source_id=3215">
    <dt><i class="icon1"></i><span>帐号解封</span></dt>
    <dd>解除保护模式，恢复登录</dd>
    </a>
    </dl>	
	
	
	<dl>
    <a href="https://aq.qq.com/cn2/findpsw/pc/pc_find_pwd_input_account?source_id=2927">
    <dt><i class="icon11"></i><span>找回密码</span></dt>
    <dd>帮您快速找回QQ密码</dd>
    </a>
    </dl>
    
	<dl>
    <a href="https://aq.qq.com/cn2/manage/mobile/mobile_index?source_id=2929">
    <dt><i class="icon2"></i><span>密保手机</span></dt>
    <dd>绑定或更换密保手机</dd>
    </a>
    </dl>
</div><!--indexInfo End-->



<!--Footer-->
<!--Footer-->
<div id="footer">
  <p><a href="http://www.tencent.com/" target="_blank">关于腾讯</a>|<a href="http://www.tencent.com/index_e.shtml" target="_blank">About Tencent</a>|<a href="http://www.qq.com/contract.shtml" target="_blank">服务条款</a>|<a href="http://hr.tencent.com/" target="_blank">腾讯招聘</a>|<a href="http://kf.qq.com/special_auto/aq.html" target="_blank">腾讯客服<span id="debug"></span></a></p>
  <p>Copyright © 1998 - <span id="current_year">2017</span> Tencent. All Rights Reserved </p>
  <p>腾讯公司 版权所有</p>
</div>

<iframe name="aqrjs_hidden_frame" id="aqrjs_hidden_frame" style="width:150px; height:150px; display:none;" src="about:blank"></iframe>





</body></html>