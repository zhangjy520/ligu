<%@ include file="common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/diyUpload/css/diyUpload.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/diyUpload/css/webuploader.css">
<script type="text/javascript" src="${ctxStatic}/js/diyUpload/js/diyUploadmore.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/diyUpload/js/webuploader.html5only.min.js"></script>

<div class="pageContent">
    <form method="post" action="${ctx}/person/changePwdSave" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">

            <div class="unit">
                <label>原密码：</label>
                <input type="password" class="required" name="sourcePwd" value="" size="30"/>
            </div>
            <div class="unit">
                <label>新密码：</label>
                <input name="newPwd" id="sourcePassword" type="password" class="required alphanumeric" minlength="6" maxlength="20" alt="字母、数字、下划线 6-20位"  size="30"/>
            </div>
            <div class="unit">
                <label>确认新密码：</label>
                <input type="password" class="required" equalto="#sourcePassword"/>
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
</div>

