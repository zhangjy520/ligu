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
    .fileUploadContent i {
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
                <input ${disabled} type="text" name="projectSimpleName" value="${projectReport.projectSimpleName}"
                                   size="30"/>
            </div>


            <div class="unit">
                <label>完成描述</label>
                <textarea ${disabled} name="projectDesc" class="required textInput" cols="60"
                                      rows="2">${projectReport.projectDesc}</textarea>
            </div>


            <c:if test="${'view' eq type}">
                <div class="unit">
                    <label>完成报告图片：
                    </label>
                    <div style="width: 429px;float: right">
                        <ul>
                            <c:forEach items="${projectReport.picList}" var="pic">
                                <li><a href="${pic}" target="view_window">${pic}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>

                <div class="unit">
                    <label>附件文档：
                    </label>
                    <div style="width: 429px;float: right">
                        <ul>
                            <c:forEach items="${projectReport.attchList}" var="attach">
                                <li><a href="${attach}" target="view_window">${attach}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:if>
            <c:if test="${'view' ne type}">
                <div class="unit">
                    <label>完成报告图片：
                    </label>
                    <label title="选择文件后请记得上传再提交否则报错"
                           style="background: url(${ctxStatic}/images/notice.png) no-repeat center center; width: 33px;height: 33px"></label>
                    <input type="hidden" name="projectPic" id="sourceUrl" value="">
                    <div id="projectPicContent" class="fileUploadContent"></div>
                </div>

                <div class="unit">
                    <label>附件文档：
                    </label>
                    <label title="选择文件后请记得上传再提交否则报错"
                           style="background: url(${ctxStatic}/images/notice.png) no-repeat center center; width: 33px;height: 33px"></label>
                    <input type="hidden" name="projectAttach" id="attachUrl" value="">
                    <div id="projectAttachContent" class="fileUploadContent"></div>
                </div>
            </c:if>

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
        <c:if test="${'view' ne type}">
        $("#projectPicContent").initUpload({
            "uploadUrl": "${ctx}/file/uploadMuti",//上传文件信息地址
            "beforeUpload": beforeUploadFun,//在上传前执行的函数
            "onUpload": function (opt, data) {
                var url = "";
                for (var i = 0; i < data.data.length; i++) {
                    url += data.data[i] + ",";
                }
                $("#sourceUrl").val(url);
            },//在上传后执行的函数
            "fileType": ['png', 'jpg', 'gif', 'bmp', 'jpeg']//文件类型限制，默认不限制，注意写的是文件后缀
        });

        $("#projectAttachContent").initUpload({
            "uploadUrl": "${ctx}/file/uploadMuti",//上传文件信息地址
            "beforeUpload": beforeUploadFun,//在上传前执行的函数
            "onUpload": function (opt, data) {
                var url = "";
                for (var i = 0; i < data.data.length; i++) {
                    url += data.data[i] + ",";
                }
                $("#attachUrl").val(url);
            },//在上传后执行的函数
            "fileType": ['txt', 'xls', 'xlsx', 'doc', 'ppt', 'pptx', 'docx', 'pdf', 'png', 'jpg', 'gif', 'bmp', 'jpeg']//文件类型限制，默认不限制，注意写的是文件后缀
        });
        </c:if>


        function beforeUploadFun(opt) {
            // alert("before");
        }

        /*function testUpload(){
            var opt = uploadTools.getOpt("fileUploadContent");
            uploadEvent.uploadFileEvent(opt);
        }*/

    </script>
</div>

