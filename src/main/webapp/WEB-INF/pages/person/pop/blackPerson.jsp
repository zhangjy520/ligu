<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/person/save_black" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${person.id}"/>
            <div class="unit">
                <label>姓名：</label>
                <input ${disabled} type="text" name="name" value="${person.name}" size="30"/>
            </div>
            <div class="unit">
                <label>身份证号码：</label>
                <input ${disabled} type="text" name="identityNum" value="${person.identityNum}" size="30"/>
            </div>
            <div class="unit">
                <label>拉黑原因：</label>
                <textarea ${disabled} name="remark" class="textInput" cols="80" rows="2">${person.remark}</textarea>
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
        $(function () {
            fuzhi();
        });
        function fuzhi() {
            $('input[name="itemName"]').val($('select[name="itemId"] option:selected').text());
        }
    </script>
</div>

