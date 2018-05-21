<%@ include file="../common/common.jsp"%>
<%@ include file="../common/headerMenu.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <META http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Language" content="en" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>个人空间-教师</title>
    <script type="text/javascript" src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/main.js"></script>
</head>

<body>
<div class="longHeader">
</div>
<div class="neiNian1">
    <div class="neiNian2">


        <div class="headerMenu">
            <div class="menuLeft">
                <table class="menuLeftTable" cellpadding=13px;>
                    <tr class="tableChange">
                        <!--<td class="leftMenu">
                            <img src="${ctxStatic}/image/leftDiv.png">
                        </td>-->
                        <td>

                            <img src="${ctxStatic}/image/logo.png">
                        </td>
                        <td class="underLine"><a class="doudong">&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;</a></td>
                    </tr>
                </table>
                <div class="menuRight">
                    <img id="pengyqShow" src="${ctxStatic}/image/rightDiv.png">
                </div>
            </div>

        </div>
    </div>
</div>
<div class="mainContain">
    <div class="forBeauty">
        <div class="mainClass" id="personInfo">
            <div class="neiNian3">
                上次登录时间:<label>2016年7月5日</lable>
            </div>
            <div class="neiNian4">
                <img src="${ctxStatic}/image/headPicTeacher.png">
            </div>
            <div class="neiNian5" >
                <p class="neiNian6">赵慧子&nbsp;<input type="button" value="教师" class="neiNian7" />
                <p class="neiNian8">哈尔滨市第三中学</p>
                </p>
            </div><br>
            <div class="neiNian9">
                <a class="special">43</a> 关注  &nbsp;| <a class="special">63</a> 粉丝 | &nbsp;<a class="special">79</a> 动态
            </div>
        </div>

        <div class="withLine" id="public">
            <div class="withLine1">
                <div class="withLineLeft">通知公告</div>
                <div class="withLineRight"><img src="${ctxStatic}/image/flush.png"></div>
            </div>
            <div class="withLine2 publicLi neiNian10">
                <ul>
                    <c:forEach items="${notifyList}" var="notify">
                        <li  onclick="window.open('${ctx}/notify/details/${notify.id}')">
                            <p class="green publicText">
                                <c:choose>
                                    <c:when test="${empty notify.type || notify.type==0}">
                                        【平台】
                                    </c:when>
                                    <c:when test="${notify.type==1}">
                                        【区级】
                                    </c:when>
                                    <c:when test="${notify.type==2}">
                                        【校级】
                                    </c:when>
                                    <c:otherwise>
                                        【其他】
                                    </c:otherwise>
                                </c:choose>
                                <a class="normalCss">${notify.title}</a>
                                <a class="publicTime">${gukeer:intervalNowTimeToView(notify.publishTime)}</a>
                            </p>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <p class="seeMore neiNian11" onclick="window.open('${ctx}/notify/index?pageNum=1')">
                查看更多
            </p>
        </div>

        <div class="withLine" id="weather">
            <div class="withLine1">
                <div class="withLineLeft ">今天</div>
                <div class="withLineRight neiNian12">2016年7月5日 星期二</div>
            </div>
            <div class="neiNian13"><img src="${ctxStatic}/image/weather.png" class="neiNian14"></div>
            <p class="neiNian15">第十九教学周</p>
            <p class="neiNian16">北京，多云，闷热，不适合外出</p>
            <p class="neiNian17">32℃ <br> <a class="neiNian18">34℃/21℃</a></p>
        </div>

        <div class="withLine" id="myApp">
            <div class="withLine1">
                <div class="withLineLeft" id="myAppEnter"><a class="neiNian19" href="app_store.html">我的应用</a></div>
                <div class="withLineRight"><img src="${ctxStatic}/image/set.png"></div>
            </div>
            <table class="myAppTable" width="95%" height="75%"  style=""	>
                <tr class="myAppTr">
                    <td width="18%" class="myAppTd">
                        <img src="${ctxStatic}/image/mail.png">
                        <div class="neiNian20">
                            <a class="appTitle">邮件</a><br>
                            <a class="appType">办公管理</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div>
                    </td>
                    <td width="18%" class="myAppTd" onclick="window.open('${ctx}/class/index')">
                        <img src="${ctxStatic}/image/xueji.png"/>
                        <div class="neiNian20">
                            <a class="appTitle">学籍管理</a><br>
                            <a class="appType">教学教务</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                    <td width="18%"  class="myAppTd"><img src="${ctxStatic}/image/richeng.png">
                        <div class="neiNian20">
                            <a class="appTitle">日程管理</a><br>
                            <a class="appType">教学教务</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                    <td width="18%"  class="myAppTd"><img src="${ctxStatic}/image/shejiao.png">
                        <div class="neiNian20" >
                            <a class="appTitle">社交广场</a><br>
                            <a class="appType">互动成长</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                </tr>
                <tr class="myAppTr">
                    <td  class="myAppTd"><img src="${ctxStatic}/image/xuexi.png">
                        <div class="neiNian20">
                            <a class="appTitle">学习中心</a><br>
                            <a class="appType">学习成长</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                    <td class="myAppTd" onclick="window.open('${ctx}/renShi/rsIndex')"><img src="${ctxStatic}/image/renshi.png">
                        <div class="neiNian20">
                            <a class="appTitle">人事管理</a><br>
                            <a class="appType">教学教务</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                    <td  class="myAppTd"><img src="${ctxStatic}/image/yingyong.png">
                        <div class="neiNian20">
                            <a class="appTitle">应用商店</a><br>
                            <a class="appType">互动成长</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                    <td  class="myAppTd" onclick="window.open('${ctx}/notify/index?pageSize=10')"><img src="${ctxStatic}/image/gonggao.png">
                        <div class="neiNian20">
                            <a class="appTitle">通知公告</a><br>
                            <a class="appType">办公管理</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div>
                     </td>
                </tr>
                <tr class="myAppTr">
                    <td  class="myAppTd" onclick="window.open('${ctx}/contact/contactIndex')"><img src="${ctxStatic}/image/tongxun.png">
                        <div class="neiNian20">
                            <a class="appTitle">通讯录</a><br>
                            <a class="appType">办公管理</a><br>
                            <a><img src="${ctxStatic}/image/star.png"></a>
                        </div></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </div>
        <!--  -->

        <!--  -->
        <div class="withLine" id="whatToDo">
            <div class="withLine1">
                <div class="withLineLeft ">代办事项</div>
                <div class="withLineRight"></div>
            </div>
            <div class="withLine2 list neiNian21">
                <ul>
                    <li>
                        <div class="daibanDiv" >
                            <img class="headheadPicPic" src="${ctxStatic}/image/none.png">
                            <div class="neiNian22">
                                <a class="aForUnderLine neiNian23">您有一个新的审批事项,主题为：请假申请</a>
                                <br><a class="neiNian24">7-01&nbsp;&nbsp;11:25</a>
                                <!-- <a style="position:absolute;margin:4px 185px;font-size:12px;color:#1ab394;width:100px;">去处理</a> -->
                            </div>

                        </div>
                    </li>
                    <li>
                        <div class="daibanDiv" >
                            <img class="headheadPicPic" src="${ctxStatic}/image/none.png">
                            <div  class="neiNian22">
                                <a  class="aForUnderLine neiNian23">您有一个新投票,主题为：班级建设用品</a>
                                <br><a  class="neiNian24">6-28&nbsp;&nbsp;10-40</a>
                                <!-- <a style="position:absolute;margin:4px 185px;font-size:12px;color:#1ab394;width:100px;">去处理</a> -->
                            </div>

                        </div>
                    </li>

                    <li>
                        <div class="daibanDiv">
                            <img class="headheadPicPic" src="${ctxStatic}/image/none.png">
                            <div class="neiNian22">
                                <a class="aForUnderLine neiNian23">您有一个新的审批事项,主题为：办公用品申请</a>
                                <br><a class="neiNian24">6-27&nbsp;&nbsp;14:25</a>
                                <!-- <a style="position:absolute;margin:4px 185px;font-size:12px;color:#1ab394;width:100px;">去处理</a> -->
                            </div>

                        </div>
                    </li>

                </ul>
            </div>
            <p  class="seeMore neiNian25" >
                查看更多
            </p>
        </div>

        <!-- 流程跟踪		-->
        <div class="withLine" id="genzong">
            <div class="withLine1 gengzong111">
                <div class="withLineLeft">流程跟踪</div>
            </div>
            <div class="withLine2 list11 neiNian26">
                <ul>
                    <li>
                        <div class="neiNian27">
                            <img class="headheadPicPic" src="${ctxStatic}/image/qingjia.png">
                            <div class="neiNian28">
                                <a class="aForUnderLine neiNian29">请假申请</a>
                                <a class="neiNian30">7-05&nbsp;&nbsp;11:25</a>

                            </div>
                            <div class="neiNian31"><a >当前进度：</a>部门负责人(2/5)</div>
                        </div>
                    </li>
                    <li>
                        <div class="neiNian27">
                            <img class="headheadPicPic" src="${ctxStatic}/image/tiaoKe.png">
                            <div class="neiNian28">
                                <a class="aForUnderLine neiNian29">调课申请</a>
                                <a class="neiNian30">7-23&nbsp;&nbsp;11:25</a>

                            </div>
                            <div class="neiNian31"><a>当前进度：</a>年级组长(2/5)</div>
                        </div>
                    </li>
                    <li>
                        <div class="neiNian27">
                            <img class="headheadPicPic" src="${ctxStatic}/image/shiyan.png">
                            <div  class="neiNian28">
                                <a class="aForUnderLine neiNian29">物理实验室使用申请</a>
                                <a class="neiNian30">7-23&nbsp;&nbsp;10:25</a>

                            </div>
                            <div  class="neiNian31"><a >当前进度：</a>管理处(2/5)</div>
                        </div>
                    </li>
                </ul>
            </div>
            <p  class="seeMore neiNian32">
                查看更多
            </p>
        </div>


        <!-- 我的课程-->
        <div class="withLine" id="myCourse">
            <div class="withLine1">
                <div class="withLineLeft">我的课程</div>
            </div>
            <div class="neiNian33 withLine2 mycourseLi">
                <!-- <div style="padding-top:3px;padding-left:12px;font-size:12px;color:#999999">本学期共有课程5门，超过99%的同事，全校课程排行榜第三名</div> -->
                <ul >
                    <li>
                        <div class="neiNian34">
                            <div class="aForUnderLine">语文课，高一三班（69人）
                                <!-- <div style="padding-right:18%;float:right;font-size:12px;color:#1ab394;">去备课</div>
                                </div> -->

                            </div>
                    </li>

                    <li>
                        <div class="neiNian34">
                            <div class="aForUnderLine">语文课，高一五班（62人）
                                <!-- <div style="padding-right:18%;float:right;font-size:12px;color:#1ab394;">去备课</div>
                                </div> -->

                            </div>
                    </li>

                    <li>
                        <div class="neiNian34">
                            <div class="aForUnderLine">语文课，高一七班（61人）
                                <!-- <div style="padding-right:18%;float:right;font-size:12px;color:#1ab394;">去备课</div>
                                </div> -->

                            </div>
                    </li>
                </ul>
            </div>
            <p class="seeMore neiNian35">
                查看更多
            </p>
        </div>


        <!-- 我的微课-->
        <div class="withLine" id="myWeiCourse">
            <div class="withLine1">
                <div class="withLineLeft">我的微课</div>
                <div class="withLineRight aForUnderLine neiNian36">
                    <!-- <input style="color:#ffffff;font-size:12px;width:80;height:25px;background-color:#1AB394;border:none;border-radius:4px;" type="button" value="制作微课"/> -->

                    制作微课

                    <!-- <img style="position:relative;margin:-2px 0" src="${ctxStatic}/image/dayuhao.png"> -->
                </div>
            </div>
            <div class="neiNian37 withLine2 myweicourseLi">
                <!-- <div style="padding-top:5px;padding-left:12px;font-size:12px;color:#999999">本学期共有课程5门，超过99%的同事，全校课程排行榜第三名</div> -->
                <ul>
                    <li>
                        <div class="neiNian38">
                            <div class="aForUnderLine">
                                <img src="${ctxStatic}/image/video.png"/>&nbsp;&nbsp;&nbsp;第三单元小结：莎士比亚文学成就
                                <!-- <div style="padding-right:16%;float:right;font-size:12px;color:#1ab394;">查看微课</div>
                                </div> -->

                            </div>
                    </li>
                    <li>
                        <div class="neiNian38">
                            <div class="aForUnderLine">
                                <img src="${ctxStatic}/image/video.png"/>&nbsp;&nbsp;&nbsp;必修二  第六课：《孔雀东南飞》
                                <!-- <div style="padding-right:16%;float:right;font-size:12px;color:#1ab394;">查看微课</div>
                                </div> -->

                            </div>
                    </li>
                    <li>
                        <div class="neiNian38">
                            <div class="aForUnderLine">
                                <img src="${ctxStatic}/image/video.png"/>&nbsp;&nbsp;&nbsp;古诗词欣赏《秋兴八首》
                                <!-- <div style="padding-right:16%;float:right;font-size:12px;color:#1ab394;">查看微课</div>
                                </div> -->

                            </div>
                    </li>
                    <li>
                        <div class="neiNian38">
                            <div class="aForUnderLine">
                                <img src="${ctxStatic}/image/video.png"/>&nbsp;&nbsp;&nbsp;古诗词欣赏：《咏怀古迹》其三
                                <!-- <div style="padding-right:16%;float:right;font-size:12px;color:#1ab394;">查看微课</div>
                                </div> -->

                            </div>
                    </li>
                    <li>
                        <div class="neiNian38">
                            <div class="aForUnderLine">
                                <img src="${ctxStatic}/image/video.png"/>&nbsp;&nbsp;&nbsp;必修二 第12课：《过秦论》
                                <!-- <div style="padding-right:16%;float:right;font-size:12px;color:#1ab394;">查看微课</div>
                                </div> -->

                            </div>
                    </li>
                    <li>
                        <div class="neiNian38">
                            <div class="aForUnderLine">
                                <img src="${ctxStatic}/image/video.png"/>&nbsp;&nbsp;&nbsp;第四单元小结：威尼斯商人
                                <!-- <div style="padding-right:16%;float:right;font-size:12px;color:#1ab394;">查看微课</div>
                                </div> -->

                            </div>
                    </li>
                </ul>
            </div>
            <p class="seeMore neiNian35">
                查看更多
            </p>
        </div>

        <!-- 我的直播课程 -->
        <div class="withLine" id="myZhibo">
            <div class="withLine1">
                <div class="withLineLeft ">我的直播课程</div>
                <div class="withLineRight aForUnderLine neiNian39">进入小豆云课堂
                    <img src="${ctxStatic}/image/dayuhao.png">
                </div>
            </div>
            <div><img  class="neiNian40" src="${ctxStatic}/image/course.png"></div>
            <p class="neiNian41">
                <a class="neiNian42">初一暑期课程</a>
                <br><a class="neiNian43">上次授课时间:7-01  13：00</a>
            </p>
            <input type="button" class="neiNian44" value="进入直播"/>
        </div>


        <!-- 热门资源 -->
        <div class="withLine" id="hotSource">
            <div class="withLine1">
                <div class="withLineLeft">热门资源</div>
            </div>
            <!-- <div class="buttonGroup">
            <input type="button" class="hoverButton" value="课件"/>
            <input type="button" class="hoverButton" value="教案"/>
            <input type="button" class="hoverButton" value="视频"/>
            <input type="button" class="hoverButton" value="题库"/>
            <input type="button" class="hoverButton" value="微课"/>
            <input type="button" class="hoverButton" value="测验"/>
            </div> -->
            <div class="withLine2 hotSourceLi neiNian45">

                <ul>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/word.png">  高二物理第三单元小结</div>

                        </div>
                    </li>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/ppt.png">  高三化学第五课教案</div>

                        </div>
                    </li>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/video.png">  高一数学--函数与解析</div>

                        </div>
                    </li>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/video.png">  高一语文13课课件</div>

                        </div>
                    </li>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/word.png">  高三英语第五单元测试</div>

                        </div>
                    </li>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/ppt.png">  高一数学第三单元总结教案</div>

                        </div>
                    </li>
                    <li>
                        <div class="neiNian46">
                            <div class="aForUnderLine"><img class="neiNian47" src="${ctxStatic}/image/video.png">  高二数学第一单元课件</div>

                        </div>
                    </li>

                </ul>
            </div>
            <p  class="seeMore neiNian35">
                查看更多
            </p>
        </div>


        <!-- 学习动态 -->
        <div class="withLine" id="dongtai">
            <div class="withLine1">
                <div class="withLineLeft">学习动态</div>
            </div>
            <div class="neiNian48 withLine2 dongtaiList">
                <ul>
                    <li>

                        <div class="neiNian49">
                            <img src="${ctxStatic}/image/head/wangsiy.png">
                            <div class="neiNian50">
                                <a class="aForUnderLine neiNian51">王思远同学提交了一个7月5日的作业</a>
                                <br><a class="neiNian52">4-23&nbsp;&nbsp;11-25</a>

                            </div>
                        </div>
                    </li>
                    <li>

                        <div class="neiNian49">
                            <img src="${ctxStatic}/image/head/zhangxiao.png">
                            <div class="neiNian50">
                                <a class="aForUnderLine neiNian51">张晓晨同学提交了一个7月5日的作业</a>
                                <br><a class="neiNian52">4-23&nbsp;&nbsp;11-25</a>

                            </div>
                        </div>
                    </li>
                    <li>

                        <div class="neiNian49">
                            <img src="${ctxStatic}/image/head/litingt.png">
                            <div class="neiNian50">
                                <a class="aForUnderLine neiNian51">李婷婷同学提交了一个7月5日的作业</a>
                                <br><a class="neiNian52">4-23&nbsp;&nbsp;11-25</a>

                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="neiNian49">
                            <img src="${ctxStatic}/image/head/fengbing.png">
                            <div class="neiNian50">
                                <a class="aForUnderLine neiNian51">冯斌同学提交了一个7月5日的作业</a>
                                <br><a class="neiNian52">4-23&nbsp;&nbsp;11-25</a>

                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="neiNian49">
                            <img src="${ctxStatic}/image/head/yangwei.png">
                            <div class="neiNian50">
                                <a class="aForUnderLine neiNian51">杨伟同学提交了一个7月5日的作业</a>
                                <br><a class="neiNian52">4-23&nbsp;&nbsp;11-25</a>

                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <p class="seeMore neiNian53">
                查看更多
            </p>
        </div>

        <!--begin 这是朋友圈的弹出遮层  -->
        <!-- 好友动态 -->
        <div class=" pengyq" id="pengYouQuan">
            <div class="withLine1">
                <div class="withLineLeft">好友动态</div>
                <div class="withLineRight"><img src="${ctxStatic}/image/flush.png"></div>
            </div>
            <div class="content">
                <ul class="contentUl">
                    <li>
                        <div  class="pyqPic" >
                            <img src="${ctxStatic}/image/head_small.png">
                            <a class="pyqName">刘思思</a>
                            <div class="whenSend">刚刚</div>
                            <div class="pyqTitle">
                                如果你无法直接的表达你的想法，那只说明你还不够了解他
                            </div>
                            <div class="pyqPicGroup">
                                <img src="${ctxStatic}/image/three.png"><img src="${ctxStatic}/image/three.png"><img src="${ctxStatic}/image/three.png">
                            </div>
                            <ul>
                                <li class="neiNian54">&nbsp;</li>
                                <li>
                                    <div class="caozuoDiv">

                                        <div id="zhuanfa" class="zhuanfaClass tubiaoClick"><img class="pic" id="zhuanfaId" src="${ctxStatic}/image/toOther.png">转发(<a class="howManyZf">2</a>)</div>
                                        <span class="item-line"></span>
                                        <div id="pinglun" class="pinglunClass  tubiaoClick"><img id="pinglunId" class="pic" src="${ctxStatic}/image/pinglun.png">评论(<a class="howManyZf">1</a>)</div>
                                        <span class="item-line"></span>
                                        <div id="zhan" class="zhanClass tubiaoClick"><img class="pic" id="zhanId" src="${ctxStatic}/image/zhan.png">赞(<a class="howManyZf">2</a>)</div>
                                    </div>
                                </li>
                                <li class="zhuanfaLi" id="zhuanfaLi">
                                    <div class="zhuanfaReason">
                                        <img src="${ctxStatic}/image/head_small.png">
                                        <input class="editInput" type="text" placeholder=" 说点什么吧" />
                                        <input class="submitButton rightButton" type="button"value="转发"/>

                                        <div class="zhuanfaSet">

                                            <select class="whoCanSee">
                                                <option >全校可见</option>
                                                <option>我的好友</option>
                                                <option>我的学生</option>
                                                <option>我的家长</option>
                                            </select>
                                            <input name="isOrNot"  type="checkbox" value=""/>
                                            <div class="toOwnner">
                                                &nbsp;&nbsp;&nbsp;&nbsp; 同时评论给 <a>张思思</a>
                                            </div>
                                        </div>
                                    </div>

                                </li>

                                <li class="pinglunLi" id="pinglunLi">
                                    <div class="zhuanfaReason pinglunReason">
                                        <img src="${ctxStatic}/image/head_small.png">
                                        <input class="editInput" type="text" placeholder=" 说点什么吧" />
                                        <input class="submitButton rightButton" type="button"value="评论"/>

                                        <div class="zhuanfaSet ">
                                            <ul class="pinglunUl">
                                                <a class="liHeaderAll">全部(3)</a><br>
                                                <li>
                                                    <img src="${ctxStatic}/image/head_small.png">
                                                    <div class="pinglunContent">
                                                        <a class="pinglunName">刘思思：</a>
                                                        <a class="pinglunWhat">如果你无法直接的表达你的想法，那只说明你还不够了解他</a>
                                                    </div><div style="width:100%;height:10px;"></div>
                                                    <div class="pinglunCaozuo">
                                                        <div class="pinglunTime">
                                                            <div  style="float:left;">昨天</div>
                                                            <div style="float:right; margin: -7px 0px;">
                                                                <div class="pinglunCz">
                                                                    <div id="huifu" class="huifuClass  tubiaoClick"><img class="pic" id="huifuId" src="${ctxStatic}/image/pinglun.png">回复</div>
                                                                    <span class="item-line"></span>
                                                                    <div id="shanchulun" class="shanchuClass  tubiaoClick"><img id="shanchuId" class="pic" src="${ctxStatic}/image/delete.png">删除</div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="huifuLi" id="huifuLi">
                                                        <input class="editInput pinglunXsDiv" type="text" placeholder=" 回复刘思思：" />
                                                        <input class="submitButton rightButton pinglunXsBu" type="button"value="回复"/>

                                                    </div>
                                                </li>
                                                <li>
                                                    <img src="${ctxStatic}/image/head_small.png">
                                                    <div class="pinglunContent">
                                                        <a class="pinglunName">刘思思：</a>
                                                        <a class="pinglunWhat">如果你无法直接的表达你的想法，那只说明你还不够了解他</a>
                                                    </div><div style="width:100%;height:10px;"></div>
                                                    <div class="pinglunCaozuo">
                                                        <div class="pinglunTime">
                                                            <div  style="float:left;">昨天</div>
                                                            <div style="float:right; margin: -7px 0px;">
                                                                <div class="pinglunCz">
                                                                    <div id="huifu1" class="huifuClass  tubiaoClick"><img class="pic" id="huifu1Id" src="${ctxStatic}/image/pinglun.png">回复</div>
                                                                    <span class="item-line"></span>
                                                                    <div id="shanchulun1" class="shanchuClass  tubiaoClick"><img id="shanchu1Id" class="pic" src="${ctxStatic}/image/delete.png">删除</div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="huifuLi" id="huifu1Li">
                                                        <input class="editInput pinglunXsDiv" type="text" placeholder=" 回复刘思思：" />
                                                        <input class="submitButton rightButton pinglunXsBu" type="button"value="回复"/>

                                                    </div>
                                                </li>
                                                <li>
                                                    <p class="seeMore11" style="text-align:center;font-size:12px;color:#999999">
                                                        查看更多
                                                    </p>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>


                    </li>

                    <!-- aaaaaaaaaaaaaaa -->
                    <li>
                        <div  class="pyqPic" >
                            <img src="${ctxStatic}/image/head_small.png">
                            <a class="pyqName">刘思思2</a>
                            <div class="whenSend">刚刚</div>
                            <div class="pyqTitle">
                                如果你无法直接的表达你的想法，那只说明你还不够了解他
                            </div>
                            <div class="pyqPicGroup">
                                <img src="${ctxStatic}/image/three.png"><img src="${ctxStatic}/image/three.png"><img src="${ctxStatic}/image/three.png">
                            </div>
                            <ul>
                                <li>&nbsp;</li>
                                <li>
                                    <div class="caozuoDiv">

                                        <div id="zhuanfaA" class="zhuanfaClass tubiaoClick"><img class="pic" id="zhuanfaAId" src="${ctxStatic}/image/toOther.png">转发(<a class="howManyZf">2</a>)</div>
                                        <span class="item-line"></span>
                                        <div id="pinglunA" class="pinglunClass  tubiaoClick"><img id="pinglunAId" class="pic" src="${ctxStatic}/image/pinglun.png">评论(<a class="howManyZf">1</a>)</div>
                                        <span class="item-line"></span>
                                        <div id="zhanA" class="zhanClass tubiaoClick"><img class="pic" id="zhanAId" src="${ctxStatic}/image/zhan.png">赞(<a class="howManyZf">2</a>)</div>
                                    </div>
                                </li>
                                <li class="zhuanfaLi" id="zhuanfaALi">
                                    <div class="zhuanfaReason">
                                        <img src="${ctxStatic}/image/head_small.png">
                                        <input class="editInput" type="text" placeholder=" 说点什么吧" />
                                        <input class="submitButton rightButton" type="button"value="转发"/>

                                        <div class="zhuanfaSet">

                                            <select class="whoCanSee">

                                                <option >全校可见</option>
                                                <option>我的好友</option>
                                                <option>我的学生</option>
                                                <option>我的家长</option>
                                            </select>
                                            <input name="isOrNot"  type="checkbox" value=""/>
                                            <div class="toOwnner">
                                                &nbsp;&nbsp;&nbsp;&nbsp; 同时评论给 <a>张思思</a>
                                            </div>
                                        </div>
                                    </div>

                                </li>
                                <!--aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa-->
                                <li class="pinglunLi" id="pinglunALi">
                                    <div class="zhuanfaReason pinglunReason">
                                        <img src="${ctxStatic}/image/head_small.png">
                                        <input class="editInput" type="text" placeholder=" 说点什么吧" />
                                        <input class="submitButton rightButton" type="button"value="评论"/>

                                        <div class="zhuanfaSet">
                                            <ul class="pinglunUl">
                                                <a class="liHeaderAll">全部(3)</a><br>
                                                <li>
                                                    <img src="${ctxStatic}/image/head_small.png">
                                                    <div class="pinglunContent">
                                                        <a class="pinglunName">刘思思：</a>
                                                        <a class="pinglunWhat">如果你无法直接的表达你的想法，那只说明你还不够了解他</a>
                                                    </div><div style="width:100%;height:10px;"></div>
                                                    <div class="pinglunCaozuo">
                                                        <div class="pinglunTime">
                                                            <div  style="float:left;">昨天</div>
                                                            <div style="float:right; margin: -7px 0px;">
                                                                <div class="pinglunCz">
                                                                    <div id="huifuB" class="huifuClass  tubiaoClick"><img class="pic" id="huifuBId" src="${ctxStatic}/image/pinglun.png">回复</div>
                                                                    <span class="item-line"></span>
                                                                    <div id="shanchulunB" class="shanchuClass  tubiaoClick"><img id="shanchuBId" class="pic" src="${ctxStatic}/image/delete.png">删除</div>
                                                                </div>
                                                            </div>

                                                        </div>



                                                    </div>
                                                    <div class="huifuLi" id="huifuBLi">
                                                        <input class="editInput pinglunXsDiv" type="text" placeholder=" 回复刘思思：" />
                                                        <input class="submitButton rightButton pinglunXsBu" type="button"value="回复"/>

                                                    </div>
                                                </li>
                                                <li>
                                                    <img src="${ctxStatic}/image/head_small.png">
                                                    <div class="pinglunContent">
                                                        <a class="pinglunName">刘思思：</a>
                                                        <a class="pinglunWhat">如果你无法直接的表达你的想法，那只说明你还不够了解他</a>
                                                    </div><div style="width:100%;height:10px;"></div>
                                                    <div class="pinglunCaozuo">
                                                        <div class="pinglunTime">
                                                            <div  style="float:left;">昨天</div>
                                                            <div style="float:right; margin: -7px 0px;">
                                                                <div class="pinglunCz">
                                                                    <div id="huifuC" class="huifuClass  tubiaoClick"><img class="pic" id="huifuCId" src="${ctxStatic}/image/pinglun.png">回复</div>
                                                                    <span class="item-line"></span>
                                                                    <div id="shanchulunC" class="shanchuClass  tubiaoClick"><img id="shanchuCId" class="pic" src="${ctxStatic}/image/delete.png">删除</div>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="huifuLi" id="huifuCLi">
                                                        <input class="editInput pinglunXsDiv" type="text" placeholder=" 回复刘思思：" />
                                                        <input class="submitButton rightButton pinglunXsBu" type="button"value="回复"/>

                                                    </div>
                                                </li>
                                                <li>
                                                    <p class="seeMore11" style="text-align:center;font-size:12px;color:#999999">
                                                        查看更多
                                                    </p>
                                                </li>
                                            </ul>


                                        </div>

                                    </div>

                                </li>

                            </ul>

                        </div>

                    </li>


                    <!-- aaaaaaaaaaaaaaaaaaaaaaaa -->

                    <!-- aaaaaaaaaaaaaaaaaaaaaaaaa -->

                    <br>
                    <p class="seeMore2" style="text-align:center;font-size:12px;color:#999999">
                        <input class="changButton" type="button"value="进入社交广场"/>
                    </p>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br>
                    <!-- aaaaaaaaaaaaaaaaaaa -->
                </ul>

            </div>


        </div>

        <!--end 这是朋友圈的弹出遮层-->

        <!-- 制作一些弹出框。。。。。。。。。。。。 -->
        <div id="running">
            <table border=0 margin=0 padding=0 cellspacing="0" cellpadding="0" width="40%" height="103%" style="position:absolute;font-size:14px;color:#565656;background:#ffffff;margin:-1px 1px" >
                <tr class="runningTr">
                    <td class="needNotCss" width="8%">正在运行</td>
                    <td width="13%">
                        <img class="runningPic" src="${ctxStatic}/image/menuHead.png">
                        <a class="runningTitle"> 课表管理</a>
                        <img class="closePic" src="${ctxStatic}/image/closePic.png">
                    </td>
                    <td width="13%">
                        <img class="runningPic" src="${ctxStatic}/image/menuHead.png">
                        <a class="runningTitle"> 课表管理</a>
                        <img class="closePic" src="${ctxStatic}/image/closePic.png">
                    </td>
                    <td width="13%">
                        <img class="runningPic" src="${ctxStatic}/image/menuHead.png">
                        <a class="runningTitle"> 课表管理</a>
                        <img class="closePic" src="${ctxStatic}/image/closePic.png">
                    </td>

                </tr>
            </table>
        </div>

        <!-- begin右上角的点击菜单 -->
        <div class="menuDialog">
            <ul>
                <li class="usuallyMain">
                    <img class="menuImg" src="${ctxStatic}/image/personIndex.png"> 个人主页
                </li>
                <li class="usually">
                    <img class="menuImg" src="${ctxStatic}/image/userInfo.png"> 用户信息
                </li>
                <li class="usually">
                    <img class="menuImg" src="${ctxStatic}/image/setting.png"> 账户设置
                </li>
                <li class="usually">
                    <img class="menuImg" src="${ctxStatic}/image/safeMan.png"> 安全管理
                </li class="usually">
                <li>
                    <img class="menuImg" src="${ctxStatic}/image/help.png"> 帮助中心
                </li class="usually">
                <li class="usuallyExit">
                    <img class="menuImg" src="${ctxStatic}/image/exit.png"> 退出账户
                </li>
            </ul>
        </div>
        <!-- end 右上角的点击菜单-->

        <!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->
        <!-- begin 好友动态模块 -->


        <!-- <div class="pengyq">
        </div> -->
        <!-- end 好友动态模块 -->
        <!-- end 弹出框制作 -->

        <!-- sssasa -->

    </div>

</div>




<div class="guding">
    <div class="forever" id="recodeI"><img class="picpic" src="${ctxStatic}/image/recode.png"></div>
    <div class="forever" id="messageI"><img class="picpic"  src="${ctxStatic}/image/message.png"></div>
    <div class="forever" id="toTopI"><img  class="picpic" src="${ctxStatic}/image/toTop.png"></div>
</div>
<br><br><br><br>

</body>
</html>

