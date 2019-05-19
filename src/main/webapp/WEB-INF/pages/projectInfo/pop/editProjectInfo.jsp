<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/projectInfo/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${projectInfo.id}"/>

            <div class="unit">
                <label>区县：</label>
                <input type="text" name="area" value="${projectInfo.area}" size="30"/>
            </div>
            <div class="unit">
                <label>专业：</label>
                <input type="text" name="profession" value="${projectInfo.profession}" size="30"/>
            </div>
            <div class="unit">
                <label>工程年份：</label>
                <input type="text" name="projectYear" value="${projectInfo.projectYear}" size="30"/>
            </div>
            <div class="unit">
                <label>工程名称：</label>
                <input type="text" name="projectName" value="${projectInfo.projectName}" size="30"/>
            </div>
            <div class="unit">
                <label>施工单位名称：</label>
                <input type="text" name="companyUnit" value="${projectInfo.companyUnit}" size="30"/>
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

