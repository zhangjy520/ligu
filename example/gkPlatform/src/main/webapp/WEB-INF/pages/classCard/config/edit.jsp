<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>班牌配置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jedate.css">
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/jquery.autocomplete.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <script type="text/javascript" src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/jquery.jedate.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/laydate/laydate.js"></script>
    <script type="text/javascript" src="${ctxStatic}/upload/h5upload.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxStatic}/js/openDialog.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/jquery.autocomplete.js"></script>

    <style>
        * {
            box-sizing: border-box;
        }

        .container {
            width: 800px;
            margin: 0 auto;
            /*padding-top: 30px;*/
            font: 13px '微软雅黑';
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

        .stuMsg {
            overflow: hidden;
        }

        ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        #checkedEquipment{
            width: auto;
            max-width: 525px;
            margin-right: 10px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            vertical-align: middle;
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

        .stuMsg input[type=radio] {
            margin: 0 20px;
        }

        .stuMsg input[class=laydate-icon] {
            width: 190px;
            border: 1px solid #dadada;
        }

        /*.stuMsg label {*/
            /*margin-right: 61px;*/
        /*}*/

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

        .uploading {
            display: inline-block;
            vertical-align: -600%;
            width: 60%;
            text-align: center;
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

        .addContent {
            font-size: 16px;
            color: #999;
            padding-left: 15px;
        }

        div input[type='checkbox'] {
            position: relative;
            top: 2px;
        }

        div > i {
            font-style: normal;
            margin-right: 22px;
        }

        .time-conatiner {
            padding-left: 60px;
            margin-top: 20px;
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

        .wicon {
            background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAAQCAYAAADj5tSrAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAALEgAACxIB0t1+/AAAABZ0RVh0Q3JlYXRpb24gVGltZQAwNi8xNS8xNGnF/oAAAAAcdEVYdFNvZnR3YXJlAEFkb2JlIEZpcmV3b3JrcyBDUzVxteM2AAAAoElEQVQ4jWPceOnNfwYqAz9dYRQ+E7UtwAaGjyUsDAyYYUgJ2HT5LXZLcEmSCnA6duOlN///////H0bDALl8dPH/////Z8FuNW6Qtvw2nL3lyjsGBgYGhlmRqnj1kGwJuqHIlhJlCXq8EOITEsdqCXLEbbr8FisfFkTo+vBZRFZwERNEFFkCiw90nxJtCalxQmzegltCzVyP1RJq5HZ8AABuNZr0628DMwAAAABJRU5ErkJggg==") no-repeat right center;
        }

        .row {
            margin-bottom: 20px;:
        }

        .row p, .row label {
            width: 20%;
            display: inline-block;
            text-align: right;
        }

        #autoComplete {
            height: 23px;
            width: 150px;
            padding-left: 5px;
            border: 1px solid #dadada;
            border-radius: 3px;
            padding-left: 5px;
            outline: none;
        }

        #autoComplete {
            height: 28px;
        }
        .jeinpbox{
            margin-top: 2px;
            /*width: auto !important;*/
        }

        .btn-ad, .btn-de{
            width: 20px;
            height: 20px;
            line-height: 18px;
            border-radius: 50%;
            text-align: center;
            color: #fff;
            margin-top: 8px;
        }
        .btn-ad{
            background: #54AB37;
            border: 1px solid #54AB37;
        }
        .btn-de{
            background: #fc4c71;
            border: 1px solid #fc4c71;
        }
        #screenOffTimes{
            width: 500px;
        }
        i{
            font-size: 14px;
            font-style: normal;
        }
        .adddele-time{
            margin-left: 130px;
        }
        .adddele-time input[name='sStartTimeView']{
            margin-left: 130px;
        }
        .adddele-time .btn-ad{
            margin-left: 130px;
        }
        .jeitem ol{
            font-size: 13px;
            color: #666;
        }
        .jeitem ol li{
            margin: 3px;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>班牌配置</h3>
    <div class="stuMsg">

        <div class="content">
            <div style="overflow: hidden;">
            <div class="jeitem">
                <label class="jelabel">配置名称:</label>
                <div class="jeinpbox">
                    <input type="text" class="jeinput" id="name" value="${classCardConfig.name}" name="name">
                    <input type="hidden" id="id" value="${classCardConfig.id}" name="id">
                </div>
            </div>

                <%--适用时间段的配置，需求暂时取消--%>
            <%--<div class="jeitem">
                <label class="jelabel">适用时间设置:</label>
                <div class="jeinpbox">
                    <input type="text" class="jeinput" id="startDate" onfocus="dateShow(this)"
                           placeholder="" readonly
                           value="${classCardConfig.startDateView}" name="startDate">
                </div>
                <div class="jeinpbox">
                    <input type="text" class="jeinput" id="endDate" onfocus="dateShow(this)"
                           placeholder="" readonly
                           value="${classCardConfig.endDateView}" name="endDate">
                </div>
            </div>--%>

            <div class="jeitem">
                <label class="jelabel">开机星期设置:</label>
                <div class="jeinpbox" style="width: auto;margin-top: 9px;">
                    <i><input type="checkbox" name="week" value="1">
                        星期一 </i>
                    <i><input type="checkbox" name="week" value="2">
                        星期二 </i>
                    <i><input type="checkbox" name="week" value="3">
                        星期三 </i>
                    <i><input type="checkbox" name="week" value="4">
                        星期四 </i>
                    <i><input type="checkbox" name="week" value="5">
                        星期五 </i>
                    <i><input type="checkbox" name="week" value="6">
                        星期六 </i>
                    <i><input type="checkbox" name="week" value="7">
                        星期日 </i>
                    <input type="hidden" value="${classCardConfig.week}" id="checkWeeks">
                </div>
                <h3 style="margin-top: 10px;font-size: 12px;font-weight: normal;color: #555;">未勾选的默认为整天关机状态</h3>
            </div>
            <div class="jeitem">
                <label class="jelabel">开机时间设置:</label>
                <div class="jeinpbox">
                    <input type="text" class="jeinput" id="startTime" placeholder="" onfocus="timeShow(this)"
                           value="${classCardConfig.startTimeView}" name="startTime" readonly>
                </div>
                <label class="jelabel">关机时间设置:</label>
                <div class="jeinpbox">
                    <input type="text" class="jeinput" id="endTime" placeholder="" onfocus="timeShow(this)"
                           value="${classCardConfig.endTimeView}" name="endTime" readonly>
                </div>
            </div>

                <%--开屏星期设置，需求更改为和开关机星期一样，不单独设置--%>
            <%--<div class="jeitem">
                <label class="jelabel">开屏星期设置:</label>
                &lt;%&ndash;${classCardConfigRef.screenOffWeek.contains('星期一')&ndash;%&gt;
                <div class="jeinpbox" style="width: auto;margin-top: 9px;">
                    <i><input type="checkbox" name="screenOffWeek" value="1">
                        星期一 </i>
                    <i><input type="checkbox" name="screenOffWeek" value="2">
                        星期二 </i>
                    <i><input type="checkbox" name="screenOffWeek" value="3">
                        星期三 </i>
                    <i><input type="checkbox" name="screenOffWeek" value="4">
                        星期四 </i>
                    <i><input type="checkbox" name="screenOffWeek" value="5">
                        星期五 </i>
                    <i><input type="checkbox" name="screenOffWeek" value="6">
                        星期六 </i>
                    <i><input type="checkbox" name="screenOffWeek" value="7">
                        星期日 </i>
                    <input type="hidden" value="${classCardConfigScreen.get(0).screenOffWeek}" id="screenOffWeek">
                </div>
            </div>--%>


                <%--设备开机默认亮屏，需要先设置熄屏的时间点--%>
            <div class="jeitem" id="screenOffTimes" style="width: 800px;">
                <c:forEach items="${classCardConfigScreen}" var="temp">
                    <div class="jeitem">
                        <label class="jelabel">熄屏时间设置:</label>
                        <div class="jeinpbox">
                            <div class="jeinpbox">
                                <input type="text" class="jeinput" placeholder=""
                                       onfocus="timeShow(this)" readonly
                                       value="${temp.sStartTimeView}" name="sEndTimeView">
                            </div>
                        </div>
                        <label class="jelabel">亮屏时间设置:</label>
                        <div class="jeinpbox">
                            <div class="jeinpbox">
                                <input type="text" class="jeinput" placeholder=""
                                       onfocus="timeShow(this)" readonly
                                       value="${temp.sEndTimeView}" name="sStartTimeView">
                            </div>
                        </div>
                        <button onclick="addScreenOffTime(this)" class="btn-ad">+</button>
                        <button onclick="delScreenOffTime(this)" class="btn-de">-</button>
                    </div>
                </c:forEach>
                <c:if test="${option == addconfig}">
                    <div class="jeitem">
                        <label class="jelabel">熄屏时间设置:</label>
                        <div class="jeinpbox">
                            <div class="jeinpbox">
                                <input type="text" class="jeinput" placeholder=""
                                       onfocus="timeShow(this)" readonly
                                       value="${temp.sEndTimeView}" name="sEndTimeView">
                            </div>
                        </div>
                        <label class="jelabel">亮屏时间设置:</label>
                        <div class="jeinpbox">
                            <div class="jeinpbox">
                                <input type="text" class="jeinput" placeholder=""
                                       onfocus="timeShow(this)" readonly
                                       value="${temp.sStartTimeView}" name="sStartTimeView">
                            </div>
                        </div>
                        <button onclick="addScreenOffTime(this)" class="btn-ad">+</button>
                    </div>
                </c:if>
            </div>

                <div class="jeitem">
                    <label class="jelabel">
                        <%--<c:if test="${option=='addconfig'}">
                            选择设备
                        </c:if>
                        <c:if test="${option=='edit'}">
                            查看设备
                        </c:if>--%>
                        查看设备:
                    </label>
                    <div class="jeinpbox">
                        <button id="selectButton" class="roll-add" style="height: 30px;padding: 0 15px;margin-right: 4px;border:
                            1px solid #54ab37; background: #54ab37; color: #fff;border-radius: 2px;"
                        <%--<c:if test="${option=='addconfig'}">
                            onclick="openDialog('选择','${ctx}/classcard/config/chooseclasscardConfig?option=${option}&checkedIds=${checkedIds}','800px','500px');">选择
                        </c:if>
                        <c:if test="${option=='edit'}">
                            onclick="openDialog('查看','${ctx}/classcard/config/chooseclasscardConfig?option=${option}&checkedIds=${checkedIds}','800px','500px');">查看
                        </c:if>--%>
                                onclick="openDialog('选择','${ctx}/classcard/config/chooseclasscardConfig?option=${option}&checkedIds=${checkedIds}','80%','75%');">选择
                        </button>
                        <input type="hidden" value="${checkedIds}" id="checkedIds">
                        <input type="hidden" value="" id="unCheckedIds">
                    </div>
                </div>
            </div>
            <%--<div class="jeitem" style="display: block;float:none;">
                <label class="jelabel" style="float: none;display: inline-block;padding-top: 10px;">已选择的设备:</label>
                <div class="jeinpbox" style="float: none;display: inline-block;">
                    <i id="checkedEquipment"></i>
                </div>
            </div>--%>

            <div class="jeitem" style="padding-left: 50px;">
                <h4>温馨提示：</h4>
                <ol start="1" type="1">
                    <li> 1.熄亮屏时间必须包含在开关机时间段内。（关机后不可进行熄亮屏操作）</li>
                    <li> 2.熄亮屏时间段从上到下必须按照从小到大排列。</li>
                    <li> 3.开机后默认亮屏所以先配置熄屏时间点。</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<script>

    $(function () {
        $(":checkbox[name='week']").prop("checked", false);
        var weeks = $("#checkWeeks").val().split(",");
        $.each(weeks, function (index, val) {
            $(":checkbox[name='week'][value=" + val + "]").prop("checked", true);
        });

        //熄亮屏的周配置取消
        /*$(":checkbox[name='screenOffWeek']").prop("checked", false);
        var screenOffWeeks = $("#screenOffWeek").val().split(",");
        $.each(screenOffWeeks, function (index, val) {
            $(":checkbox[name='screenOffWeek'][value=" + val + "]").prop("checked", true);
        });*/
    });

    /**
     * 验证息屏时间段是否正确，，在选择结束失去焦点的时候进行验证。。时刻保证列表数据的正确性
     */

    /**
     * 验证开关机时间，关机时间输入框失去焦点的时候触发
     */
    function verityPower() {

        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        if(startTime.length == 0 || startTime == "" || endTime.length == 0) {
            layer.msg("开关机时间配置不能为空");
            return false;
        }
        if(startTime >= endTime) {
            layer.msg("开关机时间配置错误");
            //修改一些样式，做视觉上的提醒
            return false;
        } else {
            //恢复输入框的样式
            return true;
        }
    }

    //全局：保存熄亮屏的时间段数据
    var screenOffTimes = "";

    function verifyScreenTime() {

        //先调用一下开关机时间验证
        if(!verityPower()){
            return false;
        }

        //每次验证清空数据，返回验证的最新结果
        screenOffTimes = "";

        //开屏时间
        var startTimes = new Array();
        //熄屏时间
        var endTimes = new Array();

        $('input[name="sStartTimeView"]').each(function () {
            startTimes.push($(this).val());
        });
        $('input[name="sEndTimeView"]').each(function () {
            endTimes.push($(this).val());
        });

       /* if (!verifyDate(startTimes,endTimes)){
            //熄亮屏时间段的验证不通过
            layer.msg("熄亮屏时间段配置错误");
            return false;
        }*/

        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        //验证开关机与熄亮屏时间段
       /* if(startTime > endTimes[0] || endTime < startTimes[startTimes.length-1]) {
            layer.msg("熄亮屏时间与开关机时间冲突");
            return false;
        }*/

        for (var i = 0; i < startTimes.length; i++ ) {
            screenOffTimes += endTimes[i] + "," + startTimes[i] + ";";
        }
        return true;
    }

    /**
     * 验证熄亮屏时间是否按照时间点顺序从小到大排列
     */
    function verifyDate(startTimes,endTimes) {
        if(startTimes.length == 0 || endTimes.length == 0 || startTimes.length != endTimes.length) {
            return false;
        }
        if(startTimes.length<2) {
            if(endTimes[0] < startTimes[0]) {
                return true;
            } else {
                return false;
            }
        }
        for ( var i = 1; i < startTimes.length; i++) {
            if(startTimes[i-1] < endTimes[i-1] || startTimes[i-1] > endTimes[i]) {
                return false;
            }
        }
        if(endTimes[endTimes.length-1] > startTimes[startTimes.length-1]) {
            return false;
        }
        return true;
    }

    function getScreenTimeList() {
        if(!verifyScreenTime()) {
            return "";
        } else {
            return screenOffTimes;
        }
    }


    //添加息屏时间段的输入框。dom
    function addScreenOffTime(addButton) {
        var html = "<div class=\"jeitem adddele-time\">" +
            "<div class=\"jeinpbox\">" +
            "<div class=\"jeinpbox\">" +
            "<input type=\"text\" class=\"jeinput\" placeholder=\"\" onfocus=\"timeShow(this)\" readonly name=\"sEndTimeView\">" +
            "</div></div>" +
            "<div class=\"jeinpbox\">" +
            "<div class=\"jeinpbox\">" +
            "<input type=\"text\" class=\"jeinput\" placeholder=\"\" onfocus=\"timeShow(this)\" readonly name=\"sStartTimeView\">" +
            "</div></div><button onclick=\"addScreenOffTime(this)\" class='btn-ad'>" +
            "+</button>" +
            " <button onclick=\"delScreenOffTime(this)\" class='btn-de'>" +
            "-</button>" +
            "</div>";
        //$("#screenOffTimes").append(html);
        $(addButton).closest('div').after(html);
    }
    //删除已添加的息屏时间段输入框
    function delScreenOffTime(delButton) {
        //alert("删除时间输入框");
        //$("#screenOffTimes").remove(this);
        delButton.parentNode.remove();
    }


    function checkWeek() {
        var week = "";
        $('input[name="week"]:checked').each(function () {
            week += $(this).val() + ',';
        });
        return week;
    }

    /*function checkScreenWeek() {
        var screenOffWeek = "";
        $('input[name="screenOffWeek"]:checked').each(function () {
            screenOffWeek += $(this).val() + ',';
        });
        return screenOffWeek;
    }*/

    function doSubmit() {
        //1.获取需要提交的数据
        var id = $('#id').val();
        var configName = $('#name').val();
        // var startDate = $('#startDate').val();
        // var endDate = $('#endDate').val();
        var startTime = $('#startTime').val();
        var endTime = $('#endTime').val();
        var week = checkWeek();
        // var screenOffTimeList = screenOffTimes;
        var screenOffTimeList = getScreenTimeList();
        var classCardList = $('#checkedIds').val();

        //2.判断数据的合理性
        if(screenOffTimeList == "" || screenOffTimeList.length == 0) {
            return false;
        }

        //3.ajax提交数据
        var url = "${ctx}/classcard/config/save";
        $.post(url, {
            configId: id,
            name: configName,
            startTime: startTime,
            endTime: endTime,
            week: week,
            screenOffTimeList: screenOffTimeList,
            classCardList: classCardList,
            oldClassCardList: '${checkedIds}'
        }, function (retJson) {
            if (retJson.code == '0') {
                layer.msg('保存成功', {
                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                }, function(){
                    window.parent.location.reload(true);
                });

            } else {
                layer.msg(retJson.msg);
            }
        });
        return true;
    }

    //时间插件
    function timeShow(element) {
        $.jeDate(element, {
            format: "hh:mm",
            okfun: function(object){
                var obj = object[0];
                if(obj.id == "endTime"){
                    verityPower();
                }
                if(obj.name == "sStartTimeView") {
                    verifyScreenTime();
                }
            }
        });
    }

    function dateShow(element) {
        $.jeDate(element, {
            format: "YYYY-MM-DD"
        });
    }


    function chooseResult(checkedIds, unCheckedIds, checkedName) {
        //显示已选择设备的名字
        /*$("#checkedEquipment").empty();
        var names = "";
        var checkedName = checkedName.split(",");
        for (var i = 0; i < checkedName.length; i++) {
            names += "<i>" + checkedName[i] + "</i> &nbsp;";
            if ((i+1) % 5 == 0){
                names += "<br>";
            }
        }
        $('#unCheckedIds').val(unCheckedIds);
        $("#checkedEquipment").append(names);*/
        $('#checkedIds').val(checkedIds);
        $("#selectButton").attr("onclick", "openDialog('修改','${ctx}/classcard/config/chooseclasscardConfig?option=edit&checkedIds=" + checkedIds + "','800px','500px')");
    }
</script>
</body>
</html>

