<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/iCompany/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${insuranceCompany.id}"/>
            <div class="unit">
                <label>保险公司名称：</label>
                <input type="text" name="name" value="${insuranceCompany.name}" size="30"/>
            </div>
            <div class="unit">
                <label>保险公司主页：</label>
                <input type="text" name="urlIndex" value="${insuranceCompany.urlIndex}" size="30"/>
            </div>
            <div class="unit">
                <label>保单号查询页面：</label>
                <input type="text" name="urlForQuery" value="${insuranceCompany.urlForQuery}" size="30"/>
            </div>
            <div class="unit">
                <label>保险公司电话：</label>
                <input type="text" class="required" name="phone" value="${insuranceCompany.phone}" size="30"/>
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

