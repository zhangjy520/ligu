<%--
  Created by IntelliJ IDEA.
  User: Lee-Yaoheng
  Date: 2018/1/29
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../../common/common.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<link rel="stylesheet" href="${ctxStaticNew}/css/swiper.min.css">
<script src="${ctxStaticNew}/js/swiper.min.js"></script>

<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.min.js"></script>--%>
<style>
    .swiper-container {
        width: 100%;
    }
    .swiper-slide img {
        display: block;
        max-width: 100%;
        height: 100%;
        margin: 0 auto;
    }

    #stu-manage {
        height: 100% !important;
    }
</style>
<div class="" id="bgImage">
    <div id="stu-manage">
        <div id="headline">
            <%--<h5>这是一行文字</h5>--%>
        </div>
        <div class="swiper-container">
            <div class='swiper-wrapper' id="img_container">
                <%-- <div class="swiper-slide">
                     <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520397576491&di=a99191a670d0d5c18357e0d4a26f773f&imgtype=0&src=http%3A%2F%2Fpic35.photophoto.cn%2F20150619%2F0017030246656788_b.jpg">
                 </div>
                 <div class="swiper-slide">
                     <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1520397686586&di=2704aee2be3905e64f6644ff8db0eaf4&imgtype=0&src=http%3A%2F%2Fpic17.photophoto.cn%2F20101116%2F0020033039774237_b.jpg">
                 </div>--%>
            </div>
            <!-- Add Pagination 页码-->
            <div class="swiper-pagination"></div>
            <!-- Add Arrows 箭头-->
            <%--<div class="swiper-button-prev"></div>--%>
            <%--<div class="swiper-button-next"></div>--%>
        </div>
    </div>
</div>
<script>
    //图片轮播插件
    //slide更行，在父页面执行: swiper.update();
    document.getElementsByClassName('swiper-wrapper')[0].style.webkitTransform='translate3d(0,0,0)';
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
//       prevButton:'.swiper-button-prev',
//       nextButton:'.swiper-button-next',
        grabCursor:true,
        paginationClickable: true,
        spaceBetween: 0,
        centeredSlides: true,
        autoplay: 15000,
        autoplayDisableOnInteraction: false,
        observer:true,
        observeParents:true
    });

    picVheight();
    /*视频以及图片根据标题文字高度问题*/
    function picVheight() {
        var aheightt = $('#stu-manage').height();
        var headHight;
        //推送自定义时 在此增加 $('#bgImage').height('100%');
        var addsomething;

        if($('#headline').height() != 0){
            headHight = $('#headline').height();
            var per = headHight/aheightt;
            var per2 = 1 - per;
            var re_per = Math.floor(per2 * 10000) / 100;
            $('.swiper-container').height(re_per + '%');
            //alert(re_per + '% );
        }else{
            $('.swiper-container').height('100%');
        }
    }
</script>