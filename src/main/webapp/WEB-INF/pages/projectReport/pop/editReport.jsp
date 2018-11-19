<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/diyUpload/css/diyUpload.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/diyUpload/css/webuploader.css">
<script type="text/javascript" src="${ctxStatic}/js/diyUpload/js/diyUploadmore.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/diyUpload/js/webuploader.html5only.min.js"></script>

<link href="${ctxStatic}/fileUpload/css/iconfont.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/fileUpload/css/fileUpload.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctxStatic}/fileUpload/js/fileUpload.js"></script>
<style>
    .fileUploadContent i{
        line-height: normal !important;
    }
</style>
<div class="pageContent">
    <form method="post" action="${ctx}/projectReport/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${projectReport.id}"/>

            <div class="unit">
                <label>工程全名</label>
                <input ${disabled} type="text" name="projectName" value="${projectReport.projectName}" size="30"/>
            </div>

            <div class="unit">
                <label>简称</label>
                <input ${disabled} type="text" name="projectSimpleName" value="${projectReport.projectSimpleName}" size="30"/>
            </div>


            <div class="unit">
                <label>完成描述</label>
                <textarea ${disabled} name="projectDesc" class="required textInput" cols="60" rows="2">${projectReport.projectDesc}</textarea>
            </div>


                <div class="unit">
                    <label>完成报告图片：
                    </label>
                    <label title="选择文件后请记得上传再提交否则报错" style="background: url(${ctxStatic}/images/notice.png) no-repeat center center; width: 33px;height: 33px"></label>
                    <input type="hidden" name="projectPic" id="sourceUrl" value="">
                    <div id="fileUploadContent" class="fileUploadContent"></div>
                </div>


            <%--<div class="unit">--%>
                <%--<label>附件文档：</label>--%>
                <%--<input type="hidden" name="configValue1" id="sourceUrl1" value="">--%>
                <%--<input type="hidden" name="fileName1" id="sourceName1" value="">--%>
                <%--<input type="hidden" name="ctx" value="${ctx}">--%>
                <%--<div style="display: inline-block;vertical-align: top" id="sourceUpload1" class="webuploader-container ">--%>
                    <%--<div class="webuploader-pick">上传资源</div>--%>
                    <%--<div style="position: absolute; top: 0px; left: 0px; width: 126px; height: 44px; overflow: hidden; bottom: auto; right: auto;">--%>
                        <%--<input type="file" name="file" class="webuploader-element-invisible">--%>
                        <%--<label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="unit">
                <span id="result"></span>
            </div>
        </div>
        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">提交</button>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>

    <script>
        $("#fileUploadContent").initUpload({
            "uploadUrl":"http://localhost:8081/ligu/file/uploadMuti",//上传文件信息地址
            //"size":350,//文件大小限制，单位kb,默认不限制
            //"maxFileNumber":3,//文件个数限制，为整数
            //"filelSavePath":"",//文件上传地址，后台设置的根目录
            "beforeUpload":beforeUploadFun,//在上传前执行的函数
            "onUpload":afterUpload,//在上传后执行的函数
            //autoCommit:true,//文件是否自动上传
            "fileType":['png','jpg','docx','doc','txt']//文件类型限制，默认不限制，注意写的是文件后缀
        });

        function beforeUploadFun(opt){
           // alert("before");
        }
        function afterUpload(opt,data) {
            var url = "";
            for (var i = 0; i < data.data.length; i++) {
                url +=data.data[i]+",";
            }
            $("#sourceUrl").val(url);
        }

        /*function testUpload(){
            var opt = uploadTools.getOpt("fileUploadContent");
            uploadEvent.uploadFileEvent(opt);
        }*/

    </script>
</div>

