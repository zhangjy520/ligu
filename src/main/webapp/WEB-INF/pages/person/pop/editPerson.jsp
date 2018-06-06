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
                <select class="combox" name="gender">
                    <option value="男" <c:if test="${person.gender eq '男'}">selected</c:if>>男</option>
                    <option value="女" <c:if test="${person.gender eq '女'}">selected</c:if>>女</option>
                </select>
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
                <label>保险情况：</label>
                <input type="text" name="insurancePurchases" value="${person.insurancePurchases}" size="30"/>
            </div>
            <div class="unit">
                <label>薪资情况：</label>
                <input type="text" name="salaryDetails" value="${person.salaryDetails}" size="30"/>
            </div>

            <div class="unit">
                <label>施工单位专业：</label>
                <input type="text" name="professionalUnit" value="${person.professionalUnit}" size="30"/>
                <%--<select class="combox" name="itemId" onchange="fuzhi()">
                    <c:forEach items="${itemList}" var="pItem">
                        <option value="${pItem.id}"
                                <c:if test="${pItem.id==person.itemId}">selected</c:if>>${pItem.name}</option>
                    </c:forEach>
                </select>
                <input style="display: none;" type="text" name="itemName" value="${person.itemName}"/>--%>
            </div>
            <%--<div class="unit">
                <label>人员类别：</label>
                <select class="combox" name="level">
                    <option value="2" <c:if test="${person.type==2}">selected</c:if>>人员审核管理员</option>
                    <option value="3" <c:if test="${person.type==3}">selected</c:if>>项目管理员</option>
                    <option value="4" <c:if test="${person.type==4}">selected</c:if>>施工管理员</option>
                    <option value="5" <c:if test="${person.type==5}">selected</c:if>>施工工人</option>
                </select>
            </div>--%>
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

