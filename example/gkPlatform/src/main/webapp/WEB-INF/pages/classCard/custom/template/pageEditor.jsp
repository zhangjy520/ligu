<%@ include file="../../../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>自定义界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classspace.css"/>
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/css/jedate.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/diyUploadCustom/css/webuploader.css">
    <link type="text/css" rel="stylesheet" href="${ctxStaticNew}/diyUploadCustom/css/diyUpload.css">
    <script type="text/javascript" src="${ctxStaticNew}/diyUploadCustom/js/webuploader.html5only.min.js"></script>
    <script type="text/javascript" src="${ctxStaticNew}/diyUploadCustom/js/diyUploadmore.js"></script>
</head>
<style>

    .mode-name input{
        border: none;
    }
    /*main.container{*/
        /*margin-bottom: 5% !important;*/
    /*}*/
    .row{
        margin: 0 !important;
    }
    /*-------------------------------------------------*/
    .mode-name{
        margin: 10px;
        margin-left: 0;
        overflow: hidden;
        display: inline-block;
    }
    .mode-container{
        width: 100%;
        height:62%;
        border: 5px solid #ddd;
    }
    .check-btnp button,.btn-back{
        height: 30px;
        padding: 0 15px;
        margin-right: 4px;
        border: 1px solid #54ab37;
        background: #54ab37;
        color: #fff;
        border-radius: 2px;
    }
    .edit-range>div{
        display: none;
    }
    .imgAtext button{
        background: #54AB37;
        height: 30px;
        padding: 0 15px;
        border: 1px solid #54AB37;
        outline: none;
        border-radius: 2px;
        color: #fff;
    }
    .mode-name select{
        height: 30px;
        width: 130px;
        border-radius: 2px;
        padding-left: 5px;
        color: #525252;
        font-size: 14px;
    }
    .edit-range{
        display: inline-block;
        vertical-align: top;
        margin: 10px 0;
    }
    #imgButton-upload,#videoButton-upload{
        display: inline-block;
    }

    .check-btnp{
        overflow: hidden;
        margin: 10px 0;
    }

    #img-upload input[type='radio'],
    #video-upload input[type='radio']{
        position: relative;
        top:2px;
        margin: 5px;
    }
    .parentFileBox{
        width: 100% !important;
    }
    .fileBoxUl li {
        margin: 0 30px 23px 0 !important;
    }
    .fileBoxUl li:nth-child(6n){
        margin-right: 0 !important;
    }
    sub{
        line-height: normal !important;
        font-size: 100% !important;
        bottom: 0 !important;
    }
    .mode-name > span{
        width: auto !important;
    }
    #modle-name, #pageName{
        background: none;
        width: 145px;
    }
    #pageName{
        border: 1px solid #ddd;
        height: 28px;
        margin-right: 20px;
    }
    #img-container{
        margin-bottom: 20px;
    }
    #bgImage{
        height: 100% !important;
    }
    .txt_diy_bg{
        background: none;
        border-color: #dadada !important;
        background: url(${ctxStaticNew}/images/upload_videobj.png) no-repeat center !important;
    }
    h1,h2,h3, h4, h5, p{
        margin-top: 0;
        margin-bottom: 0;
    }
    .swiper-slide{
        width: 100% !important;
    }
    #headline{
        word-break: break-all;
        word-wrap: break-word;
    }
    p span:first-child{
        width: auto;
    }
</style>
<body>
<%@ include file="../../../common/sonHead/classCardHead.jsp" %>
<main class="container">

    <div>
        <%--<c:if test="${option == 'disabled'}">--%>
            <%--<p style="margin-top: 15px;">已发布不能修改</p>--%>
        <%--</c:if>--%>
        <p class="mode-name">
            <span>自定义界面名称：</span><input ${option} type="text" value="${pageName}" id="pageName" placeholder="输入页面标题">
            <span>模板类型：</span>
            <c:choose>
                <c:when test="${templateType == 'tw'}"> <input type="text" value="图文模板" id="modle-name" disabled></c:when>
                <c:when test="${templateType == 'lbt'}"> <input type="text" value="轮播图模板" id="modle-name"  disabled></c:when>
                <c:when test="${templateType == 'sp'}"> <input type="text" value="视频模板" id="modle-name"  disabled></c:when>
            </c:choose>
            <select class="editR-sl" disabled style="display: none;">
                <option value="0" <c:if test="${templateType == 'kb'}">selected</c:if>>请选择类型</option>
                <option value="1" <c:if test="${templateType == 'tw'}">selected</c:if>>图文模板</option>
                <option value="2" <c:if test="${templateType == 'lbt'}">selected</c:if>>轮播图模板</option>
                <option value="3" <c:if test="${templateType == 'sp'}">selected</c:if>>视频模板</option>
            </select>
            <span>
                <c:if test="${option == 'disabled'}">
                    发布时间：${loopTime}
                    <span style="display: inline-block; width: 50px;"></span>
                    发布周期：
                    <c:if test="${loopMark == null}">
                    未设置
                     </c:if>
                    <c:if test="${loopMark == 'D'}">
                        每天
                    </c:if>
                    <c:if test="${loopMark == 'W'}">
                        周 [${loopDate}]
                    </c:if>
                    <c:if test="${loopMark == 'M'}">
                        月 [${loopDate}]
                    </c:if>
                    <c:if test="${loopMark == 'N'}">
                        不循环
                    </c:if>
                </c:if>
            </span>
        </p>
    </div>

    <div>
        <c:if test="${option != 'disabled'}">
            <div class="mode-name">
                <a href="${ctx}/classcard/custom/index"><button style="margin-right: 0" class="btn-back">返回</button></a>
            </div>
        </c:if>
        <div class="check-btnp" style="float: right;">
            <c:if test="${option != 'disabled'}">
                <span class="check-mode"><button onclick="chooseBG()">选择背景图</button></span>
            </c:if>
            <%--<span class="check-mode"><button onclick="preview()">预览</button></span>--%>
            <c:if test="${option != 'disabled'}">
                <span class="check-mode"><button onclick="doSubmit()">保存</button></span>
            </c:if>
        </div>
        <div class="edit-range"  style="float: right;margin-right: 8px;">
            <div></div>
            <%--图文--%>
            <div class="imgAtext">
                <button onclick="openEditor('编辑内容','bgImage')">编辑内容</button>
            </div>

            <%--轮播图--%>
            <div id="img-upload" class="imgAtext">
                <div id="imgButton-upload"></div>
                <%--<span style="position: relative;bottom: 4px;">
                <span>图片是否自动播放：</span>
                    <input type="radio" name="imgPlay">是
                    <input type="radio" name="imgPlay">否
                </span>--%>
                <div style="float: right;">
                    &nbsp;&nbsp;<button onclick="openEditor('编辑标题','headline')">修改标题文字</button>
                    &nbsp;&nbsp;<button onclick="managerImg('img_container')">轮播图片管理</button>
                </div>
            </div>
            <%--视频--%>
            <div id="video-upload" class="imgAtext">
                <div id="videoButton-upload"></div>
                <div style="float: right;">
                    &nbsp;&nbsp;<button onclick="openEditor('编辑标题','headline')">修改标题文字</button>
                </div>
            </div>

        </div>
    </div>
    <div id="img-container"></div>

    <%--班牌编辑预览容器，将模板子页面嵌套在这里--%>
    <div class="mode-container" id="pageContent" style="overflow: auto">
        <c:if test="${empty pageContent}">
            <jsp:include page="${templateFilePath}.jsp" flush="true"/>
        </c:if>
        <c:if test="${not empty pageContent}">
            ${pageContent}
        </c:if>
    </div>

</main>
</body>
<script>
    activeMenu("base",4);
    picVheight();
    /*视频以及图片根据标题文字高度问题*/
    function picVheight() {
        var aheight = $('#bgImage').height();
//        var aheightt = $('#stu-manage').height();
        var headHight;
        if($('#headline').height() != 0){
            headHight = $('#headline').height();
            $('#headline').siblings('div').height(aheight - headHight);
//            $('.swiper-container').height(aheightt - headHight);
//            $('.swiper-wrapper').height(aheightt - headHight);
        }
    }
    
    function chooseResult(content,nameId) {
        $("#"+nameId).empty();
        $("#"+nameId).html(content);
    }

    /*需求：编辑器只能修改模板为图文模块的内容，name为图文模块的div的name。。。目前情况:修改整个模板的内容（单图文模式）*/
    function openEditor(option,name) {
        openDialogWithoutReload(option,'${ctx}/classcard/custom/richEditor?name='+name,'75%','75%');
    }
    function preview(pageId) {
        openDialogView('','${ctx}/classcard/custom/preview?pageId'+pageId,'70%','80%');
    }
    function managerImg(imgContainerId) {
        if(!$.isEmptyObject($('#'+imgContainerId))) {
            openDialogWithoutReload('轮播图片管理','${ctx}/classcard/custom/managerImg','75%','83%');
        }
    }

    function resultImgLBT(imgSrcList) {
        //轮播图片管理的弹窗管理图片后返回剩余图片的src数组，在这里进行循环替换原imgs
        var $object = $('#img_container');
        if(!$.isEmptyObject($object)) {
            $object.empty();
            for (var i = 0; i < imgSrcList.length; i++) {
                var imgNode = "<div class=\"swiper-slide\">\n" +
                    "                    <img src=\" "+ imgSrcList[i] +"\"> \n" +
                    "                </div>";
                // $object.append(imgNode);
                swiper.appendSlide(imgNode);
            }
        } else {
            console.log("非轮播图模板页面");
        }
        //更新swiper对象
        swiper.update();
    }
    function chooseBG() {
        //选择自定义界面的背景图
        openDialogWithoutReload('选择背景图','${ctx}/classcard/custom/chooseBG','50%','75%');
    }
    function changeBGImage(bgImageUrl) {
        if(bgImageUrl == "") {
            layer.msg("背景图选择错误");
        } else if (bgImageUrl == "no") {
            $("#bgImage").attr("style","overflow: auto;width: 100%;height:100%;");
        } else if(bgImageUrl.indexOf("$") == 0) {
            var imageDefaultUrl = bgImageUrl.replace("$","");
            $("#bgImage")
                .attr("style","background:url('${ctxStaticNew}/images/customPageBGImages/"+imageDefaultUrl+"') no-repeat ;background-size: 100% auto;overflow: auto;width: 100%;height:100%;");
        } else {
            $("#bgImage")
                .attr("style","background:url('"+bgImageUrl+"') no-repeat ;background-size: 100% auto;overflow: auto;width: 100%;height:100%;");
        }
    }

    function doSubmit() {
        var names = "pageContent";
        var contents = $("#pageContent").html();
        var pageName = $("#pageName").val();
        var templateId = '${templateId}';
        var pageId = '${pageId}';
        var option = '${option}';
        var url = "${ctx}/classcard/custom/save";
        $.post(url, {
            names: names,
            contents: contents,
            pageName: pageName,
            templateId: templateId,
            pageId: pageId,
            option: option
        }, function (retJson) {
            if (retJson.code == '0') {
                window.location.href = "${ctx}/classcard/custom/index";
            } else {
                layer.msg(retJson.msg);
            }
        },"json");
    }

    /*弹窗子页面调用读取父页面数据*/
    function getContent(name) {
        return $("#"+name).html();
    }

    function startUpload() {
        /*图片上传*/
        $('#imgButton-upload').diyUpload({
            url:'${ctx}/file/upload',
            success:function( data ) {
                /*上传成功后在pageContent中预览，添加返回的url*/
                var imgContainer = $("#img_container");
                var childImg = "<div class=\"swiper-slide\"><img src=\"${fullPath}/file/pic/show?picPath="+data.data.imgRequestUrl+"\" alt=\"\"></div>";
                //单张上传成功添加到轮播图容器，全部上传结束执行successFinished的回调函数更新swiper对象。
                // imgContainer.append(childImg);
                swiper.appendSlide(childImg);
            },
            successFinished : function () {
                //更新swiper对象
                swiper.update();
                $("#img-container").empty();
                console.log("all success function");
            },
            error:function( err ) {
                console.info( err );
            },
            buttonText : '选择图片',
            chunked: false,
            // 分片大小
            chunkSize: 50 * 1024 * 1024,
            //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
            fileNumLimit: 20,
            fileSizeLimit: 1000 * 1024 * 1024,
            fileSingleSizeLimit: 50 * 1024 * 1024,
            accept: {
                title: "Images",
                extensions: "gif,jpg,jpeg,ico,bmp,png",
            },
        });

        /*视频上传*/
        $('#videoButton-upload').diyUpload({
            url:'${ctx}/file/upload',
            success:function( data ) {
                /*上传成功后修改 模板中video的 src*/
                console.info( data );
                /*<source src="http://121.42.168.14:10012/video/test.mp4" type='video/mp4'>*/
                $("#my-video").attr("src","http://${serverName}:${serverPort}/video/"+data.data.transformFinalUrl);//更新url
                $("#my-video").attr("autoplay","true");//直接播放
                layer.msg('视频转码需要几分钟,请先保存稍后查看视频～～', {time:10000});
            },
            error:function( err ) {
                console.info( err );
            },
            buttonText : '选择视频',
            chunked: false,
            // 分片大小
            chunkSize: 50 * 1024 * 1024,
            //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
            fileNumLimit: 1,
            fileSizeLimit: 100 * 1024 * 1024,
            fileSingleSizeLimit: 100 * 1024 * 1024,
            accept: {
                title: "Images",
                extensions: "rmvb,rm,flv,mp4"
            },
        });

        //视频和图片的高度
        picVheight();
    }

    /*下拉框的选择事件*/
    sele();
    function sele() {
        var index_op = $(".editR-sl").find('option').index($(".editR-sl").find('option:selected'))
        $(".edit-range").children('div').eq(index_op).show().siblings().hide();
        $('#modle-name').val($(".editR-sl").find('option:selected')[0].innerHTML)
        startUpload();
    }

</script>
</html>