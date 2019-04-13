<%@ include file="../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" type="text/css" href="${ctxStatic}/ueditor/xiumi/xiumi-ue-v5.css">
<script type="text/javascript" src="${ctxStatic}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${ctxStatic}/ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="${ctxStatic}/ueditor/xiumi/xiumi-ue-dialog-v5.js"></script>

<div class="pageContent" id="h5PageText">
    <form id="hahaOk" style="overflow-x: hidden" method="post" action="${ctx}/doc/saveh5" class="pageForm required-validate"
          onsubmit="return validateCallback(this, dialogAjaxDone)">
        <input style="display: none;" type="text" name="id" value="${source.id}"/>
        <input style="display: none;" type="text" name="type" value="7"/>

        <div class="unit">
            <label>资源名称</label>
            <input type="text" class="required" name="name" value="${source.name}" size="30"/>
        </div>
        <div class="unit">
            <label>请编辑资源内容</label>
            <script id="h5content" name="content" type="text/plain">

            </script>
        </div>



        <div class="formBar">
            <ul>
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="button" onclick="okHaha()">提交</button>
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
        var ue = UE.getEditor('h5content',{
            initialFrameWidth :500,//设置编辑器宽度
            initialFrameHeight:300,//设置编辑器高度
            scaleEnabled:true//设置不自动调整高度
        });
        ue.ready(function () {
            ue.setContent('${source.htmlContent}');
        });
        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
        UE.Editor.prototype.getActionUrl = function (action) {
            if (action == 'uploadimage' || action == 'uploadfile') {
                return getRootPath()+'/ueFile/uploadimage';  //此处改需要把图片上传到哪个Action（Controller）中
            }else if(action == 'catchimage'){

                return getRootPath()+'/ueFile/uploadRemoteImage';
            } else {
                return this._bkGetActionUrl.call(this, action);
            }
        }

        function getRootPath(){
            //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
            var curWwwPath=window.document.location.href;
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName=window.document.location.pathname;
            var pos=curWwwPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8083
            var localhostPaht=curWwwPath.substring(0,pos);
            //获取带"/"的项目名，如：/uimcardprj
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            return(localhostPaht+projectName);
        }
        
        function okHaha() {
            $("#hahaOk").submit();
        }

    </script>


</div>

