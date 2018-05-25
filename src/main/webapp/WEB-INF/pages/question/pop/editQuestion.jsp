<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="pageContent">
    <form method="post" action="${ctx}/question/save" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="58">
            <input style="display: none;" type="text" name="id" value="${question.id}"/>
            <div class="unit">
                <label>题目类别：</label>
                <select class="combox" name="type">
                    <option value="1" <c:if test="${question.type==1}">selected</c:if> >单选题</option>
                    <option value="2" <c:if test="${question.type==2}">selected</c:if> >多选题</option>
                    <option value="3" <c:if test="${question.type==3}">selected</c:if> >其他</option>
                </select>
            </div>

            <div class="unit">
                <label>题目难度：</label>
                <select class="combox" name="level">
                    <option value="1" <c:if test="${question.level==1}">selected</c:if>>简单</option>
                    <option value="2" <c:if test="${question.level==2}">selected</c:if>>一般</option>
                    <option value="3" <c:if test="${question.level==3}">selected</c:if>>困难</option>
                </select>
            </div>

            <div class="unit">
                <label>题目简称：</label>
                <input type="text" name="name" value="${question.name}" size="30"/>
            </div>

            <div class="unit">
                <label>题目内容：</label>
                <textarea name="content" class="required textInput" cols="80" rows="2">${question.content}</textarea>
            </div>

            <div class="unit">
                <label>题目分值：</label>
                <input type="text" name="score" value="${question.score}" class="digits textInput valid">
            </div>

            <div class="unit">
                <label>选项A：</label>
                <input type="text" class="required" name="a" value="${question.a}" size="30"/>
            </div>
            <div class="unit">
                <label>选项B：</label>
                <input type="text" class="required" name="b" value="${question.b}" size="30"/>
            </div>
            <div class="unit">
                <label>选项C：</label>
                <input type="text" class="required" name="c" value="${question.c}" size="30"/>
            </div>
            <div class="unit">
                <label>选项D：</label>
                <input type="text" class="required" name="d" value="${question.d}" size="30"/>
            </div>

            <div class="unit">
                <label>正确答案：</label>
                <input type="text" class="required" name="answerCorrect" value="${question.answerCorrect}" size="30"/>
            </div>
            <div class="unit">
                <label>答案解析：</label>
                <textarea name="answerExplain" class="textInput" cols="80" rows="2">${question.answerExplain}</textarea>
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

