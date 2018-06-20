<%@ page import="cn.gukeer.platform.common.ConstantUtil" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="../../../common/common.jsp" %>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title>轮播图图片管理</title>
        <script src="${ctxStatic}/js/jquery-1.7.2.js"></script>
        <link rel="stylesheet" href="${ctxStaticNew}/css/classCard.min.css"/>
        <link rel="stylesheet" href="${ctxStaticNew}/css/classspace.css"/>
    </head>
    <style>
        li {
            list-style-type:none;
            margin-left: 10px !important;
        }

        li > div{
            height: 35px;
        }

        li > div input{
            /*display: none;*/
        }
        li input{
            border: none;
            outline: none;
            background: none;
            cursor: pointer;
        }
        li input:hover{
            color: #fc4c71 !important;
        }

    </style>
    <body>
        <div id="imgs" align="center">
            <ul class="hj-container over ul_bgImage">
                <%--<li class="left">
                    <img src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2557141815,3257565825&fm=27&gp=0.jpg" alt="" width="302px" height="170px">
                    <div class="dele">del</div>
                </li>--%>
            </ul>
        </div>
    </body>
    <script>
        function getImgs() {
            var fatherImg = window.parent.getContent('img_container');
            var imgs = $(fatherImg).children('img');
            $.each(imgs,function (index) {
                // jquery对象和dom对象的相互转换
                var dateSrc = imgs.get(index).getAttribute("src");
                var tempHtml = "<li class=\"left\">\n" +
                    "<img src=\" "+ dateSrc +" \" alt=\"\" width=\"302px\" height=\"170px\">\n" +
                    "<div><input class=\"dele\" type='button' value='删除'></div></li>"
                $("#imgs").children('ul').append(tempHtml);
            })
        }
        getImgs();

        // $('.hj-container li ').on('mouseover', function () {
        //     $(this).children('div').children().show();
        // });
        // $('.hj-container li ').on('mouseout', function () {
        //     $(this).children('div').children().hide();
        // });

        $('.dele').on('click', function () {
            console.log($(this).parent('li'))
            $(this).parents('li').remove();
        });

        //获取管理之后的所有图片的src。
        function getImgSrc() {
            var srclist = new Array();
            var imglist = $('img');
            $.each(imglist,function (index) {
                srclist.push(imglist.get(index).getAttribute("src"));
            });
            return srclist;
        }
        function doSubmit() {
            window.parent.resultImgLBT(getImgSrc());
            window.parent.closeAlertDiv();
            return false;
        }
    </script>
</html>
