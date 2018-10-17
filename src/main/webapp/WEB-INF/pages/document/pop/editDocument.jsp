<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/diyUpload/css/diyUpload.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/diyUpload/css/webuploader.css">
<script type="text/javascript" src="${ctxStatic}/js/diyUpload/js/diyUploadmore.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/diyUpload/js/webuploader.html5only.min.js"></script>

<div class="pageContent">
    <form method="post" action="${ctx}/doc/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${source.id}"/>
            <div class="unit">
                <label>资源类型：</label>
                <select class="combox" name="type">
                    <option value="1" <c:if test="${source.type eq'1'}">selected</c:if> >安全生产视频课程</option>
                    <option value="2" <c:if test="${source.type eq '2'}">selected</c:if> >安全生产培训文档</option>
                    <option value="3" <c:if test="${source.type eq '3'}">selected</c:if> >安全生产安全守则</option>
                    <option value="4" <c:if test="${source.type eq '4'}">selected</c:if> >施工工艺视频课程</option>
                    <option value="5" <c:if test="${source.type eq '5'}">selected</c:if> >施工工艺培训文档</option>
                    <option value="6" <c:if test="${source.type eq '6'}">selected</c:if> >施工工艺工艺示例</option>
                </select>
            </div>

            <div class="unit">
                <label>资源名称</label>
                <input type="text" class="required" name="name" value="${source.name}" size="30"/>
            </div>

            <div class="unit">
                <label>上传文件：</label>
                <input type="hidden" name="fileUrl" id="sourceUrl" value="">
                <input type="hidden" name="fileName" id="sourceName" value="">
                <input type="hidden" name="ctx" value="${ctx}">
                <div style="display: inline-block;vertical-align: top" id="sourceUpload" data-flag='schoolCulture' data-flagtype='schoolculturevideo' class="webuploader-container ">
                    <div class="webuploader-pick">上传资源</div>
                    <div style="position: absolute; top: 0px; left: 0px; width: 126px; height: 44px; overflow: hidden; bottom: auto; right: auto;">
                        <input type="file" name="file" class="webuploader-element-invisible">
                        <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                    </div>
                </div>
           </div>

            <div class="unit">
                <label>资源地址(若为在线媒体请填写地址)：</label>
                <input type="text" class="required" name="url" value="${source.url}" size="30"/>
            </div>
            <div class="unit">
                <label>资源后缀：</label>
                <input type="text" class="required" name="suffix" value="${source.suffix}" size="30"/>
            </div>
            <div class="unit">
                <label>资源描述：</label>
                <textarea name="remark" class="textInput" cols="80" rows="2">${source.remark}</textarea>
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

        $('#sourceUpload').diyUpload({
            url: '${ctx}/file/upload',
            success: function (data) {
                $('#sourceUrl').val(data.data.fileRequestPath);
                $('#sourceName').val(data.data.fileName);
                $("input[name='suffix']").val(data.data.suffix);
                $("input[name='url']").val("已经上传，不需要填写路径");
                $("input[name='url']").attr("disabled",true);
            },
            error: function (err) {
                console.info(err);
            },
            buttonText: '上传资源',
            chunked: false,
            // 分片大小
            chunkSize: 50 * 1024 * 1024,
            //最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
            fileNumLimit: 1,
            fileSizeLimit: 250 * 1024 * 1024,
            fileSingleSizeLimit: 250 * 1024 * 1024,
            accept: {
                title: "files",
                extensions: "pptx,docx,xlsx,avi,rmvb,rm,flv,mp4,mov,pdf,wps,rtf,doc,txt,docx,ppt,xlsx,bmp,gif,jpg,pic,png,tif"
            },
        });

    </script>
</div>

