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
    <form id="inputForm" action="${ctx}/personSalary/import/save" class="pageForm required-validate" method="post" enctype="multipart/form-data" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <div class="unit">
                tips:批量录入，需要此批人员使用的证明文件是同一个。如果每个人有每个人单独的证明文件，可以单个修改上传
                <br>
                <br>
                <label>上传该批薪资的证明文件：</label>

                <label title="选择文件后请记得上传再提交否则报错"
                       style="background: url(${ctxStatic}/images/notice.png) no-repeat center center; width: 33px;height: 33px"></label>
                <input type="hidden" name="projectPic" id="sourceUrl" value="">
                <div id="projectPicContent" class="fileUploadContent"></div>
            </div>

            <div class="unit">
                <label>上传模版数据文件(excel)：</label>
                <input type="file" name="file" value="请选择上传文件"/>
            </div>
        </div>


        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="button" onclick="doSubmit()">提交</button>
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

    <script type="">
        $("#projectPicContent").initUpload({
            "uploadUrl": "${ctx}/file/uploadMuti?basePath=salary",//上传文件信息地址
            "beforeUpload": beforeUploadFun,//在上传前执行的函数
            "onUpload": function (opt, data) {
                var url = "";
                for (var i = 0; i < data.data.length; i++) {
                    url += data.data[i] + ",";
                }
                $("#sourceUrl").val(url);
            },//在上传后执行的函数
            // "fileType": ['png', 'jpg', 'gif', 'bmp', 'jpeg']//文件类型限制，默认不限制，注意写的是文件后缀
        });

        function doSubmit(par) {
            $.ajax({
                url: '${ctx}/personSalary/import/save',
                type: 'POST',
                cache: false,
                data: new FormData($('#inputForm')[0]),
                processData: false,
                contentType: false
            }).done(function (res) {
                return dialogAjaxDone(res);
            }).fail(function (res) {
                //
            });
        }
        function beforeUploadFun(opt) {
            // alert("before");
        }
    </script>
</div>


