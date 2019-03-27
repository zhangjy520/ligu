<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/personSalary/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${person.id}"/>
            <div class="unit">
                <label>姓名：</label>
                <input ${disabled} type="text" name="personName" value="${person.personName}" size="30"/>
            </div>
            <div class="unit">
                <label>身份证号：</label>
                <input ${disabled} type="text" name="personNum" value="${person.personNum}" size="30"/>
            </div>
            <div class="unit">
                <label>费用类别：</label>
                <input ${disabled} type="text" name="feeType" value="${person.feeType}" size="30"/>
            </div>

            <div class="unit">
                <label>金额：</label>
                <input ${disabled} type="text" name="sendMuch" value="${person.sendMuch}" size="30"/>
            </div>

            <div class="unit">
                <label>发放日期：</label>
                <input ${disabled} type="text" name="sendTime" value="${person.sendTime}" size="30"/>
            </div>

            <div class="unit">
                <label>发放证明：</label>
                <input ${disabled} type="text" name="zhengJuUrls" value="${person.zhengJuUrls}" size="30"/>
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

