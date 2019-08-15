<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/question/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${question.id}"/>

            <div class="unit">
                <label>考试名称：</label>
                <input type="text" name="name" value="${question.name}" size="30"/>
            </div>

            <div class="unit">
                <label>考试开始日期：</label>
                <input type="text" name="name" value="${question.name}" size="30"/>
            </div>
            <div class="unit">
                <label>考试结束日期：</label>
                <input type="text" name="name" value="${question.name}" size="30"/>
            </div>

        </div>
        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">发布</button>
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

