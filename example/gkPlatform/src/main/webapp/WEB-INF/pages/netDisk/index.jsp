<%@ include file="../common/headerXf.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>教师云盘</title>
    <link rel="stylesheet" href="${ctxStaticNew}/css/personnel.min.css"/>
    <link rel="stylesheet" href="${ctxStaticNew}/css/netTeacher.css"/>
    <style>
        .layui-layer.layui-layer-iframe.layer-anim {
            top: 6% !important;
        }

        .search-box > button.notice-search {
            border-top-left-radius: 0px !important;
            border-bottom-left-radius: 0px !important;
        }

        td input[type='text'] {
            margin: 0 5px 0 25px !important;
            padding-left: 5px;
        }

        .trAdd {
            background: url(${ctxStaticNew}/images/school-roll-icon2.png) no-repeat center;
        }

        .trDecrease {
            background: url(${ctxStaticNew}/images/icon-c-1.png) no-repeat center;
        }

        nav > .container div.netdisk-title:before {
            content: '';
            display: block;
            width: 36px;
            height: 36px;
            position: absolute;
            left: -7px;
            top: -4px;
            background: url(${ctxStaticNew}/images/netdisk.png) no-repeat center center;
            background-size: 100% 100%;
        }

        .trAddRename {
            background: url(${ctxStaticNew}/images/school-roll-icon2.png) no-repeat center;

        }

        .trAddRename, .trDecreaseRename {
            height: 20px;
            width: 20px;
            float: left;
            position: relative;
            top: 3px;
            left: 0;
        }

        .trDecreaseRename {
            background: url(${ctxStaticNew}/images/icon-c-1.png) no-repeat center;

        }

        .renameInput {
            float: left;
            height: 28px;
        }

        .recycle:before {
            background: url(${ctxStaticNew}/images/recycle_empty.jpg) no-repeat center;
        }

        .tableparentdiv td .emptys {
            margin-right: 15px !important;
        }
    </style>
</head>
<body>

<%@ include file="../common/sonHead/netDiskHead.jsp" %>

<main class="container">
    <div id="inform-notice">
        <aside class="col-xs-3" style="padding-top: 0">
            <div class="tree-menu  table-left">
                <div class="widget-main padding-8">
                    <ul class="aaaul">
                        <li>
                            <span class="my-file-icon">我的文件</span>
                            <p style="margin-bottom: 10px;">
                                <span class="all-space">
                                    <i></i>
                                </span>
                                <span class="space-num">
                                    <i class="space-num-one"></i>/
                                    <i class="space-num-two"></i>
                                </span>
                            </p>
                            <div class="little-table">
                                <p class="left-a all active" onclick="categoryDocuments('allFile')">全部</p>
                                <p value="documents" class="left-a documents" onclick="categoryDocuments('documents')">
                                    文档</p>
                                <p value="images" class="left-a images" onclick="categoryDocuments('images')">图片</p>
                                <p value="audios" class="left-a audios" onclick="categoryDocuments('audios')">音频</p>
                                <p value="videos" class="left-a videos" onclick="categoryDocuments('videos')">视频</p>
                                <p value="others" class="left-a others" onclick="categoryDocuments('others')">其他</p>
                            </div>
                        </li>


                        <li class="shareli">
                            <span value="shares" class="left-a my-file-share my-file-icon"
                            <%--onclick="openDialog('选择要分享的人员','${ctx}/net/disk/share/pop?chooseIds=','860px','620px');"--%>>共享文件</span>
                            <div class="little-table">
                                <p class="sshares" onclick="shareType(0)">分享的文件</p>
                                <p class="roger" onclick="shareType(1)">收到的文件</p>
                            </div>
                        </li>

                        <%--<c:forEach items="${fileFromSeafileEntityList}" var="seafileEntity" varStatus="status">--%>
                        <%--<c:if test="${seafileEntity.name =='回收站'}">--%>
                        <li class="recycleli">
                            <%--<span class="left-a my-file-share recycle"--%>
                            <%--fileId="${seafileEntity.id}" fileType="${seafileEntity.type}" fileName="${seafileEntity.name}">${seafileEntity.name}</span>--%>
                        </li>
                        <%--</c:if>--%>
                        <%--</c:forEach>--%>
                    </ul>
                </div>
            </div>
        </aside>
        <main class="col-xs-9">
            <div class="search-box">
                <div class="directoryPathDiv" id="directoryPathDiv">
                    <input type="hidden" id="hiddenCurrentfolederName">
                </div>
                <button onclick="openDialogView('上传文件','${ctx}/net/disk/upload/pop?url=${ctx}/net/disk/upload/','500px','360px');"
                        class="">上传文件
                </button>
                <button onclick="mkdiradd()" class="">新建文件夹
                </button>
                <button class="notice-search summitButton" id="search" onclick="categoryDocuments('search')"></button>
                <input type="text" class="searchInput " placeholder="搜索文件" value="" name="searchTitle"/>
            </div>
            <input type="hidden" value="${repositoryId}" class="repositoryId">
            <input type="hidden" value="${totalFileUrl}" class="totalFileUrl">
            <input type="hidden" value="${repositoryUrl}" class="repositoryUrl">
            <input type="hidden" value="${token}" class="token">
            <div class="operating-containt-bigdiv">
                <p style="margin-bottom: 15px;">全部</p>
                <div class="operating-containt">
                    <i class="operationSibling-i"><input type="checkbox" class="all"/>已经选择 <i class="selectedLen">0</i>
                        个文件(夹)</i>
                    <span class="down" onclick="download()">下载</span>
                    <span class="delete"
                          <%--onclick="deleteF()"--%>onclick="alertTipsDel(500,250,'删除','确定要删除选中的文件或者文件夹吗？','deleteF()')">删除</span>
                    <span class="move"
                          onclick="openDialogMove('移动','${ctx}/net/disk/move/pop?flag=move','1000px','800px');">移动</span>
                    <span class="copy"
                          onclick="openDialogMove('复制','${ctx}/net/disk/move/pop?flag=copy','400px','500px');">复制</span>
                    <span class="rename" onclick="rename()">重命名</span>
                    <span class="share" id="chooseWhoTell" onclick="share()">分享</span>
                    <input type="hidden" id="whichDepartMent" name="bumens"/>
                </div>
                <%--<div class="operating-containt-recycle operating-containt" style="display: none">--%>
                <%--<i style="display: none" class="restore-span"><input type="checkbox" class="all"/>已经选择 <i--%>
                <%--class="selectedLen">0</i> 个文件(夹)</i>--%>
                <%--<span class="restore restore-span" style="display: none">还原</span><span--%>
                <%--class="restore-span emptyDelete" style="display: none">删除</span>--%>
                <%--</div>--%>
                <div class="operating-containt-recycle" style="display: none">
                    <i><input type="checkbox" class="all"/>已经选择 <i class="selectedLen">0</i> 个文件(夹)</i>
                    <span class="restore">还原</span><span class="emptyDelete">删除</span>
                </div>
            </div>
            <div class="tableparentdiv">
                <table>
                    <thead>
                    <tr style="height: auto;">
                        <th width="2%"></th>
                        <th width="2%"></th>
                        <th width="24%"></th>
                        <th width="12%"></th>
                        <th width="10%"></th>
                    </tr>
                    </thead>
                    <tbody class="allfileTbody">
                    <c:if test="${fileFromSeafileEntityList.size()==0||null==fileFromSeafileEntityList}">
                        <i style="color: red;">请检查网络是否连接</i>
                    </c:if>
                    <c:if test="${fileFromSeafileEntityList.size()>0||null==fileFromSeafileEntityList}">
                        <c:forEach items="${fileFromSeafileEntityList}" var="seafileEntity" varStatus="status">
                            <tr class="allFileTr">
                                <td><input name="oneCheckbox" type="checkbox" class="oneCheckbox emptys" id=""
                                           filetype="${seafileEntity.type}"
                                           val="fileName"
                                           value="${seafileEntity.name}" fileName="${seafileEntity.name}"/></td>
                                <td><img src="" alt=""></td>
                                <td class="file-type"
                                    onclick="onefileFunction('${seafileEntity.id}','${seafileEntity.type}','${seafileEntity.name}')">${seafileEntity.name}</td>
                                <td onclick="onefileFunction('${seafileEntity.id}','${seafileEntity.type}','${seafileEntity.name}')">
                                    <c:if test="${seafileEntity.sizeStr !=null}">${seafileEntity.sizeStr}</c:if></td>
                                <td onclick="onefileFunction('${seafileEntity.id}','${seafileEntity.type}','${seafileEntity.name}')">
                                    <c:if test="${seafileEntity.time !=null}">${seafileEntity.time}</c:if></td>
                                <td><input type="hidden" value="${seafileEntity.name}" oldName="${seafileEntity.name}"
                                           class="renameInput" fileType="${seafileEntity.type}">
                                    <i class="trAddRename" style="display: none"></i><i class="trDecreaseRename"></i>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</main>
<script type="text/javascript">
    $(".operating-containt").on("click", ".shareDownload", function () {
        var inputs = $("input[name='oneCheckbox']:checked");
        var len = inputs.length;
        var link = "";
        if (len == 0 || len == undefined) {
            layer.msg("请选择文件");
            return;
        }

        var ids = "";
        inputs.each(function (e) {
            if (len == 1) {
                ids = $(this).attr("id");
            } else {
                ids += "," + $(this).attr("id");
            }
        })

        $.post("${ctx}/net/disk/share/download",{
            ids:ids
        },function (data) {
            var netDiskShareLinks = data.data;
            if(netDiskShareLinks.length>0){
                for (var i=0;i<netDiskShareLinks.length;i++){
                    window.open(netDiskShareLinks[i].link);
                }
            }
        })


    })

    $(".allfileTbody").on("click", ".shareparams", function () {
        console.log(this)
        var link = $(this).attr("link");
        window.open(link);
    });

    $(function () {
        $(".operating-containt-bigdiv").on("click", ".checkSharePerson", function () {
            var inputs = $("input[name='oneCheckbox']:checked");
            var len = inputs.length;
            var link = "";
            if (len == 0 || len == undefined) {
                layer.msg("请选择文件");
                return;
            }
            if (len > 1) {
                layer.msg("查看分享人员的时候只能选择一个文件");
                return;
            } else {
                link = $(this).attr("link");
            }
            openDialogView("分享人员", "${ctx}/net/disk/share/people", "500px", "500px");
        })
    })

    $(".operating-containt").on("click", ".all", function () {
        console.log(this)
        if (this) {
            $("input[type='checkbox']").prop("checked", true);
            var len = $("input[name='oneCheckbox']:checked").length;
            $(".selectedLen").text(len);
        } else {
            $("input[type='checkbox']").prop("checked", false);
            var len = $("input[name='oneCheckbox']:checked").length;
            $(".selectedLen").text(len);
        }
    });

    $(".allfileTbody").on("click", ".oneCheckbox", function () {
        var len = $("input[name='oneCheckbox']:checked").length;
        console.log(len);
        $(".selectedLen").text(len);
    })
    /*普通的内容提示框*/
    function alertTipsDel(width, height, title, content, clickUrl) {
        var inputs = $("input[name='oneCheckbox']:checked");
        var len = inputs.length;
        var ids = "";

        var fileName = "";
        if (len == 0) {
            layer.msg("请选择文件");
            return;
        }
        var html = '<div class="" style="height:' + height + ';width:' + width + '"><div class="alertDivHeader"><label>' + title + '</label></div><div class="alertDivContent"><label>' + content + '</label><br><br><p style="padding-left: 25px;">删除后将自动保存到回收站</p><div class="alertButtons"><input type="button" onclick="closeAlertDiv()" value=" 取消 " /><input type="button" value=" 确定 " onclick="' + clickUrl + '" /></div></div></div>';
        //页面层-自定义
        layer.open({
            type: 1,
            area: [width, height],
            title: false,
            closeBtn: 0,
            shadeClose: true,
            skin: 'yourclass',
            content: html
        });

    }

    function shareType(type) {
        $(".allFileTbody").empty();
        $(".operating-containt").empty();
        var operationHtml = "";
        if (type == 0) {
            operationHtml = '<i class="operationSibling-i"><input type="checkbox" class="all oneCheckbox"/>已经选择<i class="selectedLen">0</i>个文件(夹)</i><span style="width: 194px;" class="shareDownload">下载(点击文件名即可下载)</span><span style="width: 88px;" class="checkSharePerson">查看人员</span><span class="shareCancelSpan" style="width: 88px;">取消分享</span>';
        } else {
            operationHtml = '<i class="operationSibling-i"><input type="checkbox" class="all oneCheckbox"/>已经选择<i class="selectedLen">0</i>个文件(夹)</i><span  style="width: 194px;">下载(点击文件名即可下载)</span><span class="shareCancelSpan" style="width: 88px;">删除</span>';
        }
        $(".operating-containt").append(operationHtml);
        $.get("${ctx}/net/disk/share/type", {
            type: type
        }, function (data) {
            console.log(data)
            if (data.code == 0) {
                var links = data.data;
                var html = "";
                if (links.length != 0) {
                    for (var i = 0; i < links.length; i++) {
                        var shareType = links[i].shareType;
                        var fileName = links[i].fileName;
                        var time = links[i].timeStrCreate;
                        var id = links[i].id;
                        var fileType = links[i].isDir;
                        var link = links[i].link;
                        var size=links[i].fileSize;
                        var sizeStr = links[i].fileSize;
                        if (sizeStr!="null"){
                            size = parseFloat(size);
                            sizeStr =ConvertSize(size,"");
                        }

                        if (sizeStr == null || sizeStr == ""||sizeStr == "null") {
                            sizeStr = "";
                        }
                        html += '<tr class="allFileTr">' +
                                '<td><input type="checkbox" name="oneCheckbox" class="oneCheckbox emptys" shareType=' + shareType + 'fileName=' + fileName + '"value="' + fileName + '" fileSize="' + size + '" id="' + id + '" link="' + link + '"/></td>' +
                                '<td><img src="" alt=""></td>' +
                                '<td class="shareparams  file-type"  shareType="' + shareType + '" fileName="' + fileName + '" link="' + link + '" fileType="' + fileType + '">' + fileName + '</td> ' +
                                '<td><input type="hidden" link="' + link + '" value="' + fileName + '" oldName="' + fileName + '" class="renameInput" shareType="' + shareType + '">' + sizeStr + '</td>' +
                                '<td><input type="hidden" link="' + link + '" value="' + fileName + '" oldName="' + fileName + '" class="renameInput" shareType="' + shareType + '">' + time + '</td>' +
                                '</tr>';
                    }
                } else {
                    html = '<p style="width: 100px;line-height: 45px;font-size: 13px;">暂无数据<p>';
                }
                $(".allfileTbody").append(html);
                isFileType();
            } else {

            }
        })
    }

    $(".operating-containt").on("click", ".shareCancelSpan", function () {
        alert(111)
        var inputs = $("input[name='oneCheckbox']:checked");
        var len = inputs.length;
        var ids = "";
        if (len == 0 || len == undefined) {
            layer.msg("请选择文件");
            return;
        }
        if (len > 1) {
            inputs.each(function () {
                ids += "," + $(this).attr("id");
            })
        } else {
            ids = $(inputs).attr("id");
        }

        $.post("${ctx}/net/disk/share/cancel", {
            ids: ids
        }, function (data) {

        })
    })


    function ConvertSize(size, flag) {
        var strSize = "";
//        if (size >= 1000 * 1000 * 1000) {
//            tem = Math.ceil(size / (1000 * 1000 * 1000));
//            strSize = tem + "GB"
//        } else if (size < (1000 * 1000 * 1000) && size >= (1000 * 1000)) {
//            tem = Math.ceil(size / (1000 * 1000));
//            strSize = tem + "MB";
//        } else {
//            tem = Math.ceil(size / 1000);
//            strSize = tem + "kb"
//        }
        strSize =(size/1024/1024).toFixed(2)+"MB";
        return strSize;
    }

    $(function () {
        var totalSize = '${sessionScope.totalSize}';
        var usage = '${sessionScope.usage}';
        var strTotal = ConvertSize(totalSize);
        var strUsage = ConvertSize(usage);
        $(".space-num-two").text(strTotal);
        $(".space-num-one").text(strUsage);

        var percentagee = usage / totalSize;
        if (percentagee <= 1) {
            percentagee = 1;
        }
        if (percentagee >= 100) {
            $('.all-space i').css('border-radius', '8px')
        }
        var percentage = percentagee + "%";
        $('.all-space i').width(percentage);
        var totalUrl = '${totalFileUrl}';
        var currentFolederName = "";
        partflush(totalUrl, currentFolederName);
//        var percentage = parseFloat(((usage/totalSize)*100).toFixed(2))+"%";
    })

    function share() {
        var divAs = $(".directoryPathDiv>a");
        var directoryPath = directoryPathF(divAs);
        var arr = [];
        var fileType = "file";
        var inputs = $('input[val="fileName"]:checked');

        var fileName = "";
        var inputsLength = inputs.length;
        if (inputsLength == 0) {
            layer.msg("请选择文件");
            return;
        } else if (inputsLength == 1) {
            arr = oneFileIsChecked(fileName, fileType, inputs, arr);
        } else {
            arr = multiFileChecked(inputs, arr);
        }

        var jsonArr = JSON.stringify(arr);
        openDialog('选择要分享的人', '${ctx}/net/disk/share/pop?chooseIds=&totalFileUrl=' + directoryPath, '860px', '620px', "", jsonArr);
    }

    function chooseResult(depratmentIds, depratmentNames) {
        var names = "";
        var departNames = depratmentNames.split(",");
        for (var i = 0; i < departNames.length; i++) {
            if (departNames[i].trim() != "") {
                names += "<span class='receive'>" + departNames[i] + "</span>";
            }
        }
//        $("#chooseWhoTell").html(names + " <input type='button' value='更改'>");
        $("#whichDepartMent").val(depratmentIds);

        $("#chooseWhoTell").attr("onclick", "openDialog('选择人员','${ctx}/notify/chooseperson/show?chooseIds=" + depratmentIds + "','950px','620px')");

    }

    $(".allfileTbody").on("click", ".trAddRename", function () {
        var divAs = $(".directoryPathDiv>a");
        var directoryPath = directoryPathF(divAs);
        var oldName = $(this).siblings("input").attr("oldName");
        var newName = $(this).siblings("input").val();
        var fileType = $(this).siblings("input").attr("fileType");

        $.post("${ctx}/net/disk/rename", {
            directoryPath: encodeURI(directoryPath),
            oldName: encodeURI(oldName),
            newName: encodeURI(newName),
            fileType: fileType
        }, function (data) {
            if (data.code == 0) {
                layer.msg("操作成功");
            } else {
                layer.msg("操作失败");
            }
            var currentFolederName = $("#hiddenCurrentfolederName").val();
            var totalUrl = $(".totalFileUrl").val();
            partflush(totalUrl, currentFolederName);
        })
    })


    function directoryPathF(divas) {
        var aLength = 0;
        if (divas != undefined && divas != "") {
            aLength = divas.length
        }

        var directoryPath = "";
        if (aLength > 0) {
            directoryPath = $(".directoryPathDiv a").last().attr("hre");
        }
        return directoryPath;
    }

    function rename() {
        var inputs = $('input[val="fileName"]:checked');
        if (inputs.length > 1) {
            layer.msg("请选择要修改名称的文件");
            return;
        }
        if (inputs.length == 0) {
            layer.msg("目前没有选中的文件");
            return;
        }

        $(inputs).parents("td").siblings().last().children("input").attr("type", "text");
        console.log($(inputs).parents("td").siblings().last().children("i"))
        $(inputs).parents("td").siblings().last().children("i").css("display", "inline-block");
    }

    var indexFor = 0;
    function multiFileChecked(inputs, arr) {
        var id = "";
        var fileName = "";
        var fileType = "";
        var fileSize = "";
        inputs.each(function (i) {
            fileName = $(this).attr("fileName");
            fileType = $(this).attr("fileType");
            fileSize = $(this).attr("fileSize");
            var json = {"fileName": encodeURI(fileName), "fileType": fileType, "fileSize": fileSize};
            arr.push(json);
        })
        return arr;
    }
    //移动到回收站
    function deleteF(isEmpty, isRestore) {
        var divAs = $(".directoryPathDiv>a");
        var directoryPath = directoryPathF(divAs);
        var arr = [];
        var fileType = "file";

        var inputs = $("input[name='oneCheckbox']:checked");
        var len = inputs.length;
        var ids = "";

        var fileName = "";
        if (len == 0) {
            layer.msg("请选择文件");
            return;
        } else if (len == 1) {
            arr = oneFileIsChecked(fileName, fileType, inputs, arr);
        } else {
            arr = multiFileChecked(inputs, arr);
        }

        if (isEmpty == "" || isEmpty == undefined) {
            //在普通条件下下删除相当于移动操作，移动感到根文件下的回收站目录
            $.post("${ctx}/net/disk/move", {
                flag: "move",
                parent_dir: encodeURI("/回收站"),
                directoryPath: encodeURI(directoryPath),
                arr: JSON.stringify(arr),
            }, function (data) {
                if (data.code == 0) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.layer.closeAll();

                    layer.msg("删除成功");
                    top.layer.close();
                    var currentFolederName = parent.$("#hiddenCurrentfolederName").val();
                    var totalfile = parent.$(".totalFileUrl").val();
                    parent.partflush(totalfile, currentFolederName);
                }
            })
        } else if (isEmpty == "recycle" && (isRestore == undefined || isRestore == "")) {
            //原来删除的代码 现在为回收站删除
            $.post("${ctx}/net/disk/delete", {
                directoryPath: encodeURI(directoryPath),
                arr: encodeURI(JSON.stringify(arr))
            }, function (data) {
                var currentFolederName = $("#hiddenCurrentfolederName").val();
                var totalUrl = $(".totalFileUrl").val();
                partflush(totalUrl, currentFolederName);
            })
        } else if (isRestore == "restore") {
            //回收站中文件还原 相当于移动操作
            $.post("${ctx}/net/disk/move", {
                flag: "move",
                parent_dir: encodeURI("/"),
                directoryPath: encodeURI(directoryPath),
                arr: JSON.stringify(arr),
            }, function (data) {
                if (data.code == 0) {
                    layer.msg("还原成功");
                    var currentFolederName = parent.$("#hiddenCurrentfolederName").val();
                    var totalfile = parent.$(".totalFileUrl").val();
                    partflush(totalfile, currentFolederName);
                }
            })
        }
    }

    //第三个参数仅仅作为创建回收站文件夹时 判断拼接的位置用的  回收站拼接的地方为左侧菜单栏
    function partflush(totalUrl, currentName) {
        $(".allFileTbody").empty();
        $.get("${ctx}/net/disk/dir/fils", {
            url: encodeURI(totalUrl),
        }, function (data) {
            var fileFromSeafiles = data.fileFromSeafileEntityList;
            $(".totalFileUrl").val(data.url);
            var html = "";
            var recyclehtml = "";
            for (var i = 0; i < fileFromSeafiles.length; i++) {
                var fileId = fileFromSeafiles[i].id;
                var fileType = fileFromSeafiles[i].type;
                var fileName = fileFromSeafiles[i].name;
                var sizeStr = fileFromSeafiles[i].sizeStr;
                var size = fileFromSeafiles[i].size;
                var time = fileFromSeafiles[i].time;
                if (size!=null &&size!=""&size>0) {
                    sizeStr = ConvertSize(size,"");
                }
                if(null==sizeStr||sizeStr==""){
                    sizeStr="";
                }

                if (time == null) {
                    time = "";
                }

                var len = 0;
                if (fileName == "回收站") {
                    len = $(".recycleli .recycle").length;
                    if (len == 0) {
                        recyclehtml = '<span  class="left-a my-file-share recycle"   value="' + fileName + '"  fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '" fileSize="' + size + '">' + fileName + '</span>';
                    } else {
                        continue;
                    }
                } else {
                    html += '<tr class="allFileTr">' +
                            '<td><input type="checkbox" name="oneCheckbox" class="oneCheckbox emptys" id="" fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '" val="fileName" value="' + fileName + '" fileSize="' + size + '"/></td>' +
                            '<td><img src="" alt=""></td>' +
                            '<td class="params file-type" fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '">' + fileName + '</td> ' +
                            '<td>' + sizeStr + '</td>' +
                            '<td>' + time + '</td>' +
                            '<td><input type="hidden" value="' + fileName + '" oldName="' + fileName + '" class="renameInput" fileType="' + fileType + '">' +
                            '<i class="trAddRename" style="display: none" ></i><i class="trDecreaseRename" style="display: none"></i></td>' +
                            '</tr>';
                }
            }
            ;
            if (len == 0) {
                $(".recycleli").append(recyclehtml);
            }
            $(".allfileTbody").append(html);
            isFileType();
        });
    }


    //    左侧菜单点击效果
    $('.little-table p').on('click', function () {
        $('.little-table p').removeClass('active');
        $(this).addClass('active');
    });
    var flag_table = 1;
    $('.my-file-icon').on('click', function () {
        flag_table = !flag_table;
        if (!flag_table) {
            $(this).siblings('.little-table').slideUp(100);
            $(this).addClass('my-file-iconn');
        } else {
            $(this).siblings('.little-table').slideDown(100);
            $(this).removeClass('my-file-iconn');
        }
    });

    isFileType();
    //      判断文件类型
    function isFileType() {
        var flieTypes = $('.tableparentdiv .file-type');
        flieTypes.each(function (a, b) {
            var ty = $(b).text().split('.'),
                    ty_length = ty.length,
                    ty_last = ty[ty_length - 1],
                    ty_img = $(b).parent().children('td').eq(1).children();
            if (ty_length <= 1) {
                ty_img.attr('src', '${ctxStaticNew}/images/net_disk_files.png');
                ty_img.parents('td').siblings('.file-type').css('cursor', 'pointer');
            }
            if (ty_length > 1 && (ty_last == 'png' || ty_last == 'jpg' || ty_last == 'gif')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_img.png');
            }
            if (ty_length > 1 && (ty_last == 'txt')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_txt.png');
            }
            if (ty_length > 1 && (ty_last == 'doc' || ty_last == 'docx')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_do.png');
            }
            if (ty_length > 1 && (ty_last == 'xlsx')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_xls.png');
            }
            if (ty_length > 1 && (ty_last == 'xls')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_xls.png');
            }
            if (ty_length > 1 && (ty_last == 'pdf')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_pdf.png');
            }
            if (ty_length > 1 && (ty_last == 'ppt')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_ppt.png');
            }
            if (ty_length > 1 && (ty_last == 'zip' || ty_last == 'rar')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_zip.png');
            }
            if (ty_length > 1 && (ty_last == 'rmvb' || ty_last == 'mp4')) {
                ty_img.attr('src', '${ctxStaticNew}/images/op_list_rmvb.png');
            } else {

            }
        })
    }


    function oneFileIsChecked(fileName, fileType, inputs, arr) {
        if ($(inputs).attr("filetype") == "dir") {
            fileType = "dir";
        }
        fileName = $(inputs).attr("fileName");
        var fileSize = $(inputs).attr("fileSize");
        var json = {"fileName": encodeURI(fileName), "fileType": fileType, "fileSize": fileSize};
        arr.push(json);
        return arr;
    }


    //下载
    function download() {
        var divAs = $(".directoryPathDiv>a");
        var directoryPath = directoryPathF(divAs);
        var arr = [];
        var fileType = "file";
        var inputs = $('input[val="fileName"]:checked');
        var fileName = "";
        var inputsLength = inputs.length;
        if (inputsLength == 0) {
            layer.msg("请选择文件");
            return;
        } else if (inputsLength == 1) {
            arr = oneFileIsChecked(fileName, fileType, inputs, arr);
        } else {
            arr = (inputs, arr);
        }

        $.get("${ctx}/net/disk/download", {
            directoryPath: directoryPath,
            fileName: fileName,
            fileType: fileType,
            arr: JSON.stringify(arr)
        }, function (data) {
            if (data.code == 0) {
                var downloadUrls = data.data;
                for (var i = 0; i < downloadUrls.length; i++) {
                    window.open(downloadUrls[i]);
                }

                var currentFolederName = $("#hiddenCurrentfolederName").val();
                var totalUrl = $(".totalFileUrl").val();

                partflush(totalUrl, currentFolederName);
            }
        })
    }

    //移动pop
    function openDialogMove(title, url, width, height, target, operation) {
        var divAs = $(".directoryPathDiv>a");
        var directoryPath = directoryPathF(divAs);
        var arr = [];
        var fileType = "file";
        var inputs = $('input[val="fileName"]:checked');
        var fileName = "";
        var inputsLength = inputs.length;
        if (inputsLength == 0) {
            layer.msg("请选择文件");
            return;
        } else if (inputsLength == 1) {
            arr = oneFileIsChecked(fileName, fileType, inputs, arr);
        } else {
            arr = multiFileChecked(inputs, arr);
        }


        layer.open({
            type: 2,
            area: [width, height],
            title: title,
            maxmin: false, //开启最大化最小化按钮
            content: url,
            btn: ['确定', '关闭'],
            yes: function (index, layero) {
                var body = top.layer.getChildFrame('body', index);
                var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                var inputForm = body.find('#inputForm');
                var top_iframe;
                /*if(target){
                 top_iframe = target;//如果指定了iframe，则在改frame中跳转
                 }
                 inputForm.attr("target",top_iframe);//表单提交成功后，从服务器返回的url在当前tab中展示*/
                if (iframeWin.contentWindow.doSubmit(directoryPath, arr)) {
                    //debugger;
                    setTimeout(function () {
                        parent.location.reload();
                    }, 400);
                    /*刷新父级页面,延迟保证页面刷新的时候数据已经更新完毕*/
                    setTimeout(function () {
                        top.layer.close(index)
                    }, 300);//延时0.1秒，对应360 7.1版本bug
                }

            },
            cancel: function (index) {
                top.layer.close(index);
            }
        });
    }


    $(".allfileTbody").on('click', '.params', function () {
        console.log(this)
        $('.tableparentdiv').html();
        var fileId = $(this).attr("fileId");
        var fileName = $(this).attr("fileName");
        var fileType = $(this).attr("fileType");
        onefileFunction(fileId, fileType, fileName);
    });

    $(".recycleli").on('click', '.recycle', function () {
        var fileId = $(this).attr("fileId");
        var fileName = $(this).attr("fileName");
        var fileType = $(this).attr("fileType");
        onefileFunction(fileId, fileType, fileName);
    });
    /*
     *   这个是点击当前文件夹 查看文件夹下文件的方法
     * */

    //id 文件的id  type:文件的类型  name:当前点击的文件夹的名称  url这个参数只是为点击文件夹拼出来的路径的时候用的
    $(".directoryPathDiv").on("click", ".directoryPathAForClick", function () {
        var seaFileServer = "${seaFileServer}";
        var directoryPath = $(this).attr("hre");
        console.log($(this).nextAll().length);
        if ($(this).nextAll().length > 0) {
            $(this).nextAll().each(function () {
                $(this).remove();
            })
        }
//        $(this).nextAll().delete();
        var name = $(this).attr("name");
        var url = "http://120.27.46.200:60001/api2/repos/" + "${repositoryId}" + "/dir/?p=" + directoryPath;
        onefileFunction("", "dir", name, url);
    })

    var directoryPath = "";
    function onefileFunction(id, type, name, url) {
        $('.tableparentdiv').html();
        if (type == "dir") {
            $("#hiddenCurrentfolederName").val(name);
            $(".allFileTbody").empty();
            directoryPath += name + '/';
            $(".directoryPathDiv").val(directoryPath).hide();
            if (url == undefined || url == "") {
                $(".directoryPathDiv").append('<a hre="' + directoryPath + '" class="directoryPathAForClick" name="' + name + '" type="' + type + '">' + name + '/</a>');
                console.log($(".totalFileUrl").val());
                url = $(".totalFileUrl").val() + name + "/";
            }
            ;
            if (name == "回收站") {
                $(".directoryPathDiv").empty();
                $(".operating-containt").empty();
                var operationHtml = '<i class="restore-span"><input type="checkbox" class="all oneCheckbox"/>已经选择 <i class="selectedLen">0</i>个文件(夹)</i><span class="restore restore-span">还原</span><span class="restore-span emptyDelete">删除</span>';
                $(".operating-containt").append(operationHtml);
                url = "http://120.27.46.200:60001/api2/repos/${repositoryId}/dir/?p=/回收站/";
            }
            ;

            $.get("${ctx}/net/disk/dir/fils", {
                url: encodeURI(url),
            }, function (data) {
                var fileFromSeafiles = data.fileFromSeafileEntityList;
                $(".totalFileUrl").val(data.url);
                var html = "";
                if (fileFromSeafiles.length > 0) {
                    for (var i = 0; i < fileFromSeafiles.length; i++) {
                        var fileId = fileFromSeafiles[i].id;
                        var fileType = fileFromSeafiles[i].type;
                        var fileName = fileFromSeafiles[i].name;
                        var sizeStr = fileFromSeafiles[i].sizeStr;
                        var size = fileFromSeafiles[i].size;
                        var time = fileFromSeafiles[i].time;
                        if (sizeStr == null || sizeStr == "0kb") {
                            sizeStr = "";
                        }
                        if (time == null) {
                            time = "";
                        }
                        if (name == "回收站") {
                            html += '<tr class="allFileTr">' +
                                    '<td><input name="oneCheckbox" class="emptyCheckBox oneCheckbox emptys"type="checkbox" id="" fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '" val="fileName" value="' + fileName + '" fileSize="' + size + '"/></td>' +
                                    '<td><img src="" alt=""></td>' +
                                    '<td class="emptyTd file-type" fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '">' + fileName + '</td> ' +
                                    '<td>' + sizeStr + '</td>' +
                                    '<td>' + time + '</td>' +
                                    '<td><input type="hidden" value="' + fileName + '" oldName="' + fileName + '" class="renameInput" fileType="' + fileType + '">' +
                                    '<i class="trAddRename" style="display: none" ></i><i class="trDecreaseRename" style="display: none"></i></td>' +
                                    '</tr>';
                        } else {
                            html += '<tr class="allFileTr">' +
                                    '<td><input name="oneCheckbox" type="checkbox" class="oneCheckbox" id="" fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '" val="fileName" value="' + fileName + '" fileSize="' + size + '"/></td>' +
                                    '<td><img src="" alt=""></td>' +
                                    '<td class="params file-type" fileId="' + fileId + '" fileType="' + fileType + '" fileName="' + fileName + '">' + fileName + '</td> ' +
                                    '<td>' + sizeStr + '</td>' +
                                    '<td>' + time + '</td>' +
                                    '<td><input type="hidden" value="' + fileName + '" oldName="' + fileName + '" class="renameInput" fileType="' + fileType + '">' +
                                    '<i class="trAddRename" style="display: none" ></i><i class="trDecreaseRename" style="display: none"></i></td>' +
                                    '</tr>';
                        }
                    }
                    $(".allfileTbody").append(html);
                    isFileType();
                } else {
                    html = '<div><img src="${ctxStaticNew}/images/empty_tishi.png"/></div>';
                    $(".allfileTbody").append(html);
                }

            });
        } else {
            <%--openDialog('查看文件','${ctx}/net/disk/review','500px','350px')--%>
//            layer.msg("当前为文件，请选择文件的相关操作");
            <%--$.post("${ctx}/net/disk/review",{},function () {--%>
            <%----%>
            <%--})--%>
            window.open("http://120.27.46.200:60001/lib/3b1ff921-0579-4188-9fe1-f9b9926dcf87/file/%E7%8C%AB%E5%92%AA-01.jpg");
        }
    }

    //回收站的删除
    $(".operating-containt").on("click", ".emptyDelete", function () {
        deleteF("recycle")
    })

    //回收站的还原函数
    $(".operating-containt").on("click", ".restore", function () {
        deleteF("recycle", "restore")
    })
    activeMenu("tzmenu", 0);

    function acquireUrl() {
        $.get("${ctx}/net/disk/acquire/upload/url", {}, function (data) {
            if (data.code == 0) {
                var uploadUrl = data.data;
                var url = "${ctx}/net/disk/file/pop?url=${ctx}/net/disk/upload";
                openDialogUploadFile("上传文件", url, '500px', '350px');
            } else {
                layer.msg("获取上传文件的路径失败");
            }
        })
    }
    ;

    //新建文件夹时候拼接新建文件夹的样式展现
    function mkdiradd() {
        var html = '<p class="mkdirTr"><input  type="text"><i class="trAdd"  onclick="mkdir(this)"></i><i class="trDecrease"></i></p>';
        $(html).appendTo($('.tableparentdiv'));
    }

    $('.tableparentdiv').on("click", ".trDecrease", function () {
        $(this).parent("p").remove();
    })
    //    function deletr(thiso) {
    //        console.log($(this).parent("p"));
    //        console.log($(this));
    //        $(this).parent("p").remove();
    //    }

    //点击拼接的新建文件夹对号的时候
    function mkdir(thiso) {
        var folderName = $(thiso).siblings('input').val();
        if (folderName.indexOf("回收站") > 0) {
            layer.msg("该文件夹为系统预留文件类型，请重新命名");
            return;
        }
        var divAs = $(".directoryPathDiv>a");
        var directoryPath = directoryPathF(divAs);
        console.log(folderName);
        console.log($(thiso));
        $.post("${ctx}/net/disk/mkdir", {
                    folderName: encodeURI(folderName),
                    directoryPath: directoryPath
                }, function (data) {
                    if (data.code == 0) {
                        $(".mkdirTr").empty();
                        var totalUrl = $(".totalFileUrl").val();
                        partflush(totalUrl, directoryPath, data.data);
                    } else {
                        if (data.msg == "recycle") {
                            layer.msg("该文件夹为系统预留文件类型，请重新命名");
                            return;
                        } else {
                            layer.msg("网络开小差了,刷新试试呢");
                            return;
                        }

                    }
                }
        )
    }
    function openDialogUploadFile(title, url, width, height, target) {
        layer.open({
            type: 2,
            area: [width, height],
            title: title,
            maxmin: false, //开启最大化最小化按钮
            content: url,
            btn: ['确定', '关闭'],
            yes: function (index, layero) {
                var body = top.layer.getChildFrame('body', index);
                var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                var inputForm = body.find('#inputForm');
                if (iframeWin.contentWindow.doSubmit()) {
                    //debugger;
                    setTimeout(function () {
                        parent.location.reload();
                    }, 400);
                    /*刷新父级页面,延迟保证页面刷新的时候数据已经更新完毕*/
                    setTimeout(function () {
                        top.layer.close(index)
                    }, 300);//延时0.1秒，对应360 7.1版本bug
                }

            },
            cancel: function (index) {
                top.layer.close(index);
            }
        });
    }
    function categoryDocuments(str) {
        $(".operating-containt").empty();
        var operationHtml = '<i style="display: none" class="restore-span"><input type="checkbox" class="all oneCheckbox" name="oneCheckbox"/>已经选择 <iclass="selectedLen">0</i> 个文件(夹)</i><span class="restore restore-span" style="display: none">还原</span><span class="restore-span emptyDelete" style="display: none">删除</span>';
        $(".operating-containt").append(operationHtml);
        $('.allfileTbody').empty();
        $(".directoryPathDiv").empty();
        var imagesHtml = "";
        var documentsHtml = "";
        var audiosHtml = "";
        var videosHtml = "";
        var ohersHtml = "";
        var allHtml = "";
        var searchHtml = "";
        $.post("${ctx}/net/disk/all/files", {}, function (data) {
            var images = data.images;
            var documents = data.documents;
            var audios = data.audios;
            var videos = data.videos;
            var others = data.others;
            var shares = data.shares;
            var allFile = data.allFiles;
            if (str == "images") {
                $(".allFileTbody").empty();
                if (images != "[]") {
                    for (var i = 0; i < images.length; i++) {
                        imagesHtml += '<tr class="imagesFileTr"><td><input name="oneCheckbox" class="oneCheckbox" filetype="' + images[i].type + '" val="fileName" type="checkbox"  id="" value="' + images[i].name + '"/></td><td><img src="" alt=""></td><td class="file-type" onclick="onefileFunction(' + images[i].id + '",' + images[i].type + ')">' + images[i].name + '</td><td onclick="onefileFunction(' + images[i].id + '",' + images[i].type + ')">' + images[i].sizeStr + '</td><td onclick="onefileFunction(' + images[i].id + '",' + images[i].type + ')">' + images[i].time + '</td></tr>';
                    }
                }
                $(".allfileTbody").append(imagesHtml);
            }

            if (str == "documents") {
                $(".allFileTbody").empty();
                if (documents != "[]") {
                    for (var i = 0; i < documents.length; i++) {
                        documentsHtml += '<tr class="documentsFileTr"><td><input name="oneCheckbox" class="oneCheckbox" filetype="' + documents[i].type + '" val="fileName" type="checkbox"  id="" value="' + documents[i].name + '"/></td><td><img src="" alt=""></td><td class="file-type" onclick="onefileFunction(' + documents[i].id + '",' + documents[i].type + ')">' + documents[i].name + '</td><td onclick="onefileFunction(' + documents[i].id + '",' + documents[i].type + ')">' + documents[i].sizeStr + '</td><td onclick="onefileFunction(' + documents[i].id + '",' + documents[i].type + ')">' + documents[i].time + '</td></tr>';
                    }
                }
                $(".allfileTbody").append(documentsHtml);
            }

            if (str == "audios") {
                $(".allFileTbody").empty();
                if (audios != "[]") {
                    for (var i = 0; i < audios.length; i++) {
                        audiosHtml += '<tr class="audiosFileTr"><td><input name="oneCheckbox" class="oneCheckbox" filetype="' + audios[i].type + '" val="fileName" type="checkbox"  id="" value="' + audios[i].name + '"/></td><td><img src="" alt=""></td><td class="file-type" onclick="onefileFunction(' + audios[i].id + '",' + audios[i].type + ')">' + audios[i].name + '</td><td onclick="onefileFunction(' + audios[i].id + '",' + audios[i].type + ')">' + audios[i].sizeStr + '</td><td onclick="onefileFunction(' + audios[i].id + '",' + audios[i].type + ')">' + audios[i].time + '</td></tr>';
                    }
                }
                $(".allfileTbody").append(audiosHtml);
            }

            if (str == "videos") {
                $(".allFileTbody").empty();
                if (videos != "[]") {
                    for (var i = 0; i < videos.length; i++) {
                        videosHtml += '<tr class="videosFileTr"><td><input name="oneCheckbox" val="fileName" class="oneCheckbox" filetype="' + videos[i].type + '" type="checkbox"  id="" value="' + videos[i].name + '"/></td><td><img src="" alt=""></td><td class="file-type filename" onclick="onefileFunction(' + videos[i].id + '",' + videos[i].type + ')">' + videos[i].name + '</td><td onclick="onefileFunction(' + videos[i].id + '",' + videos[i].type + ')">' + videos[i].sizeStr + '</td><td onclick="onefileFunction(' + videos[i].id + '",' + videos[i].type + ')">' + videos[i].time + '</td></tr>';
                    }
                }
                $(".allfileTbody").append(videosHtml);
            }
            if (str == "others") {
                $(".allFileTbody").empty();
                if (others != "[]") {
                    for (var i = 0; i < others.length; i++) {
                        ohersHtml += '<tr class="othersFileTr"><td><input name="oneCheckbox" class="oneCheckbox" filetype="' + others[i].type + '" val="fileName" type="checkbox"  id="" value="' + others[i].name + '"/></td><td><img src="" alt=""></td><td class="file-type" onclick="onefileFunction(' + others[i].id + '",' + others[i].type + ')">' + others[i].name + '</td><td onclick="onefileFunction(' + others[i].id + '",' + others[i].type + ')">' + others[i].sizeStr + '</td><td onclick="onefileFunction(' + others[i].id + '",' + others[i].type + ')">' + others[i].time + '</td></tr>';
                    }
                }
                $(".allfileTbody").append(ohersHtml);
            }

            if (str == "allFile") {
                $(".allFileTbody").empty();
                if (allFile != "[]") {
                    for (var i = 0; i < allFile.length; i++) {
                        allHtml += '<tr class="othersFileTr"><td><input name="oneCheckbox" class="oneCheckbox" val="fileName"  filetype="' + allFile[i].type + '" type="checkbox"  id="" value="' + allFile[i].name + '"/></td><td><img src="" alt=""></td><td class="file-type" onclick="onefileFunction(' + allFile[i].id + '",' + allFile[i].type + ')">' + allFile[i].name + '</td><td onclick="onefileFunction(' + allFile[i].id + '",' + allFile[i].type + ')">' + allFile[i].sizeStr + '</td><td onclick="onefileFunction(' + allFile[i].id + '",' + allFile[i].type + ')">' + allFile[i].time + '</td></tr>';
                    }
                }
                $(".allfileTbody").append(allHtml);

            }

            if (str == "shares") {
                $(".allFileTbody").empty();
            }

            if (str == "search") {
                var fileName = $(".searchInput").val();
                $(".allFileTbody").empty();
                if (allFile != "[]") {
                    for (var i = 0; i < allFile.length; i++) {
                        console.log(allFile[i].name);
                        console.log(allFile[i].name.indexOf(fileName) + "======");
                        if (allFile[i].name.toLowerCase().indexOf(fileName) != -1) {
                            searchHtml += '<tr class="othersFileTr"><td><input name="oneCheckbox" class="oneCheckbox" val="fileName" type="checkbox"  id="" value="' + allFile[i].name + '" filetype="' + allFile[i].type + '"/></td><td><img src="" alt=""></td><td class="file-type" onclick="onefileFunction(' + allFile[i].id + '",' + allFile[i].type + ')">' + allFile[i].name + '</td><td onclick="onefileFunction(' + allFile[i].id + '",' + allFile[i].type + ')">' + allFile[i].sizeStr + '</td><td onclick="onefileFunction(' + allFile[i].id + '",' + allFile[i].type + ')">' + allFile[i].time + '</td></tr>';
                        }
                    }
                    $(".allfileTbody").append(searchHtml);
                }
            }
            isFileType();
        })
    }
</script>
</body>
</html>
