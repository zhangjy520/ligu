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
                <label>生活费</label>
                <input ${disabled} type="text" name="salaryLife" value="${person.salaryLife}"
                       size="30"/>
            </div>
            <div class="unit">
                <label>生活费发放年月：</label>
                <input ${disabled} type="text" name="timeLife" value="${person.timeLife}"
                                   size="30"/>
            </div>

            <div class="unit">
                <label>工资：</label>
                <input ${disabled} type="text" name="salarySum" value="${person.salarySum}" size="30"/>
            </div>

            <div class="unit">
                <label>工资发放年月：</label>
                <input ${disabled} type="text" name="timeSum" value="${person.timeSum}" size="30"/>
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

