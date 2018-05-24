<%@ include file="../../common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx }/user/add.json" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">

            <div class="unit">
                <label>name：</label>
                <input type="text" name="loginName" size="30" minlength="3" maxlength="20" class="required" />
            </div>
            <div class="unit">
                <label>真实姓名：</label>
                <input type="text" name="name" size="30" class="required"/>
            </div>
            <div class="unit">
                <label>角色：</label>

            </div>

        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>

</div>

