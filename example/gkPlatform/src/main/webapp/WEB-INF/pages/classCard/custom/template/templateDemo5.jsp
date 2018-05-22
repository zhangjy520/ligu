<%--
  Created by IntelliJ IDEA.
  User: Lee-Yaoheng
  Date: 2018/2/4
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.min.js"></script>
<%--空白页面的模板，没有添加图片和视频的容器
只能进行图文的编辑--%>
<div id="bgImage">
    <%--图文--%>
    <div style="display: none">
    </div>
        <%--轮播图--%>
    <div style="display: none">
        <div class="custom-container">
            <div class="custom-main">
                <div class="banner swiper-container">
                    <div class='swiper-wrapper' id="img_container">
                        <div class="swiper-slide" id="my-img">
                            <img src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2557141815,3257565825&fm=27&gp=0.jpg"
                                 alt="">
                        </div>
                    </div>
                    <!-- Add Pagination 页码-->
                    <div class="swiper-pagination"></div>
                    <!-- Add Arrows 箭头-->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>
            </div>
        </div>
    </div>
        <%--视频--%>
    <div style="display: none;">
        <video id="my-video" autoplay loop height="90%">
            <source src="http://121.42.168.14:10012/video/test.mp4" type='video/mp4'>
        </video>
    </div>
</div>
