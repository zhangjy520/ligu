<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form id="inputForm" action="${ctx}/person/import/save" class="pageForm required-validate" method="post" enctype="multipart/form-data" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <div class="unit">
                <label>上传文件：</label>
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
        function doSubmit(par) {
            $.ajax({
                url: '${ctx}/person/import/save',
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
    </script>
</div>


