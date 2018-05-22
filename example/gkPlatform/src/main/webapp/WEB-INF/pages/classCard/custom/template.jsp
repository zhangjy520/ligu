<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>自定义界面模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" type="text/css" href="${ctxStaticNew}/css/jquery.autocomplete.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/addTemplate.css"/>
    <script type="text/javascript" src="${ctxStatic}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${ctxStatic}/upload/h5upload.js"></script>
    <script type="text/javascript" src="${ctxStatic}/js/layer/layer.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxStatic}/js/openDialog.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="${ctxStaticNew}/js/jquery.autocomplete.js"></script>

    <style>
        * {
            box-sizing: border-box;
        }
        .la-contianer{
            padding: 30px;
            padding-top: 10px;
        }
        .la-contianer span{
            display: inline-block;
            width: 130px;
            padding: 9px 10px;
            text-align: right;
            color: #555;
            font-size: 13px;
        }
        .la-contianer input,
        .la-contianer select{
            width: 190px;
            height: 28px;
            padding: 0;
            padding-left: 5px;
            border-radius: 2px;
            border: 1px solid #a9a9a9;
            outline: none;
        }
    </style>
</head>
<body>
<div class="container">
    <%--<h3>选择模板</h3>--%>
    <div>
        <%--<div class="content temp-container">--%>
            <%--<ul>--%>
                <%--&lt;%&ndash;<c:forEach items="${templateList}" var="templateView">--%>
                    <%--<li>--%>
                        <%--<div>--%>
                            <%--&lt;%&ndash;默认选中循环中的第一个&ndash;%&gt;--%>
                            <%--<img src="${ctxStaticNew}/images/${templateView.preview}" alt="${templateView.detailed}">--%>
                        <%--</div>--%>
                        <%--<p><input checked type="radio" name="templateId" value="${templateView.id}">${templateView.name}</p>--%>
                    <%--</li>--%>
                <%--</c:forEach>&ndash;%&gt;--%>

                <%--&lt;%&ndash;上下结构/左右结构暂时没有进行开发，功能入口隐藏&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li style="text-align: left !important;">--%>
                    <%--<div class="module-tb">--%>
                        <%--<div style="width: 100%;height: 50%;border-bottom: 1px solid #ddd">上</div>--%>
                        <%--<div style="width: 100%;height: 50%;">下</div>--%>
                    <%--</div>--%>
                    <%--<p style="text-align: center;"><input type="radio" name="templateId" value="${templateView.id}"><span>上下结构</span></p>--%>
                <%--</li>--%>
                <%--<li style="text-align: left !important;">--%>
                    <%--<div class="module-lr">--%>
                        <%--<div style="float:left;width: 50%;height: 100%;border-right: 1px solid #ddd">左</div>--%>
                        <%--<div style="float:left;width: 50%;height: 100%;">右</div>--%>
                    <%--</div>--%>
                    <%--<p style="text-align: center;">--%>
                        <%--<input type="radio" name="templateId" value="${templateView.id}"><span>左右结构</span></p>--%>
                <%--</li>&ndash;%&gt;--%>
            <%--</ul>--%>
        <%--</div>--%>
        <div class="la-contianer">
            <p>
                <span>自定义界面名称：</span>
                <input type="text" value="" id="customName" placeholder="" />
            </p>
            <p><span>模板类型：</span>
                <select id="templateId">
                    <c:forEach items="${templateList}" var="templateView">
                        <option value="${templateView.id}">${templateView.name}</option>
                    </c:forEach>
                </select>
            </p>
        </div>
    </div>
</div>

<script>

    function chooseTemplate() {
        var templateId = "";
        $('input[name="templateId"]:checked').each(function () {
            templateId = $(this).val();
        });
        if(templateId == "") {
            //防止空指针异常，给定缺省值
            templateId = "1c0204e3e6519185f048bae0dd55a266";
        }
        return templateId;
    }

    function doSubmit() {
        //获取选中模板的信息
        //拼接好参数，可以使用隐藏字段保存
        var url = "${ctx}/classcard/custom/createPageByTemplate";
        $.post(url,{
            templateId:$("#templateId option:selected").val(),
            customName:$("#customName").val()
        },function (retJson){
            console.log(retJson);
            if(retJson.code == '0') {
                window.parent.location.href = '${ctx}'+ retJson.data;
            } else {
                layer.msg(retJson.msg);
            }
        });
    }
</script>
</body>
</html>

