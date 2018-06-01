<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/item/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${item.id}"/>
            <div class="unit">
                <label>项目名称：</label>
                <input type="text" name="name" value="${item.name}" size="30"/>
            </div>

            <div class="unit">
                <label>所属项目：</label>
                <select class="combox" name="parentId">
                    <c:forEach items="${itemList}" var="pItem">
                        <option value="${pItem.id}" <c:if test="${pItem.id==item.parentId}">selected</c:if>>${pItem.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="unit">
                <label>项目排序：</label>
                <input type="text" name="sort" class="digits" value="${item.sort}"/>
            </div>

            <div class="unit">
                <label>项目编号：</label>
                <textarea name="code" class="required textInput" cols="80" rows="2">${item.code}</textarea>
            </div>

            <div class="unit">
                <label>项目负责人id：</label>
                <input type="text" name="master" value="${item.master}" class="digits textInput valid">
            </div>

            <div class="unit">
                <label>项目负责人姓名：</label>
                <input type="text" class="required" name="masterName" value="${item.masterName}" size="30"/>
            </div>

            <div class="unit">
                <label>施工单位名称：</label>
                <input type="text" class="required" name="companyName" value="${item.companyName}" size="30"/>
            </div>
            <div class="unit">
                <label>项目标识：</label>
                <input type="text" class="required" name="itemFlag" value="${item.itemFlag}" size="30"/>
            </div>
            <div class="unit">
                <label>项目周期：</label>
                <input type="text" class="required" name="itemCycle" value="${item.itemCycle}" size="30"/>
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

