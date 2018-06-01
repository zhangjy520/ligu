<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/person/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${person.id}"/>
            <div class="unit">
                <label>姓名：</label>
                <input type="text" name="name" value="${person.name}" size="30"/>
            </div>
            <div class="unit">
                <label>性别：</label>
                <input type="text" name="gender" value="${person.gender}" size="30"/>
            </div>
            <div class="unit">
                <label>身份证号码：</label>
                <input type="text" name="identityNum" value="${person.identityNum}" size="30"/>
            </div>
            <div class="unit">
                <label>联系方式：</label>
                <input type="text" name="contact" value="${person.contact}" size="30"/>
            </div>
            <div class="unit">
                <label>现住址：</label>
                <input type="text" name="address" value="${person.address}" size="30"/>
            </div>
            <div class="unit">
                <label>薪资情况：</label>
                <input type="text" name="salaryDetails" value="${person.salaryDetails}" size="30"/>
            </div>

            <div class="unit">
                <label>所属项目：</label>
                <select class="combox" name="itemId" onchange="fuzhi()">
                    <c:forEach items="${itemList}" var="pItem">
                        <option value="${pItem.id}"
                                <c:if test="${pItem.id==person.itemId}">selected</c:if>>${pItem.name}</option>
                    </c:forEach>
                </select>
                <input style="display: none;" type="text" name="itemName" value="${person.itemName}"/>
            </div>
            <div class="unit">
                <label>人员类别：</label>
                <select class="combox" name="level">
                    <option value="1" <c:if test="${person.type==1}">selected</c:if>>管理员</option>
                    <option value="2" <c:if test="${person.type==2}">selected</c:if>>施工人员</option>
                </select>
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

