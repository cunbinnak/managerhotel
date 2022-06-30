<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/28/2022
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Room Detail</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700|Work+Sans:300,400,700" rel="stylesheet">
  <link rel="stylesheet" href="fonts/icomoon/style.css">
  <link rel="stylesheet" href="<c:url value='/template/css/bootstrap.min.css'/> ">
  <link rel="stylesheet" href="<c:url value='/template/css/magnific-popup.css'/>">
  <link rel="stylesheet" href="<c:url value='/template/css/jquery-ui.css'/>">
  <link rel="stylesheet" href="<c:url value='/template/css/owl.carousel.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/template/css/owl.theme.default.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/template/css/bootstrap-datepicker.css'/>">
  <link rel="stylesheet" href="<c:url value='/template/css/animate.css'/>">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">



  <link rel="stylesheet" href="<c:url value='/template/fonts/flaticon/font/flaticon.css'/>">

  <link rel="stylesheet" href="<c:url value='/template/css/aos.css'/>">

  <link rel="stylesheet" href="<c:url value='/template/css/style.css'/>">

</head>
<body>
<div class="site-wrap">

  <div class="site-mobile-menu">
    <div class="site-mobile-menu-header">
      <div class="site-mobile-menu-close mt-3">
        <span class="icon-close2 js-menu-toggle"></span>
      </div>
    </div>
    <div class="site-mobile-menu-body"></div>
  </div> <!-- .site-mobile-menu -->


  <div class="site-navbar-wrap js-site-navbar bg-white">

      <div class="container">
          <div class="site-navbar bg-light">
              <div class="py-1">
                  <div class="row align-items-center">
                      <div class="col-2">
                          <h2 class="mb-0 site-logo"><a href="index.html">Dev Hotel</a></h2>
                      </div>
                      <div class="col-10">
                          <nav class="site-navigation text-right" role="navigation">
                              <div class="container">

                                  <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                  <ul class="site-menu js-clone-nav d-none d-lg-block">
                                      <li class="active">
                                          <a href="<c:url value='/home'/>">Trang chủ</a>
                                      </li>
                                      <li class="has-children">
                                          <a href="<c:url value='/user'/>">Phòng</a>
                                          <ul class="dropdown arrow-top">
                                              <li><a href="rooms.html">Hiện có</a></li>
                                              <li><a href="rooms.html">Phòng đơn</a></li>
                                              <li><a href="rooms.html">Phòng đôi</a></li>
                                              <li><a href="rooms.html">Phòng gia đình</a></li>
                                              <li class="has-children">
                                                  <a href="rooms.html">Dịch vụ</a>
                                                  <ul class="dropdown">
                                                      <li><a href="rooms.html">Phòng cao cấp</a></li>
                                                      <li><a href="rooms.html">Tắm hơi</a></li>
                                                      <li><a href="rooms.html">Ăn uống</a></li>

                                                  </ul>
                                              </li>

                                          </ul>
                                      </li>
                                      <%--                                        <li><a href="events.html">Sự kiện</a></li>--%>
                                      <%--                                        <li><a href="about.html">Thông tin</a></li>--%>
                                      <li><a href="contact.html">Liên hệ</a></li>
                                      <li><a href="<c:url value='/authen/login'/>">Đăng nhập</a></li>

                                  </ul>
                              </div>
                          </nav>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>

    <c:if test="${msg}">
        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">Well done!</h4>
            <hr>
            <p class="mb-0">${msg}</p>
        </div>
    </c:if>
  <div class="site-blocks-cover overlay" style="background-image: url(<c:url value='/template/images/hero_1.jpg'/>);" data-aos="fade" data-stellar-background-ratio="0.5">
    <div class="container">
      <div class="row align-items-center justify-content-center">
        <div class="col-md-7 text-center" data-aos="fade">
          <span class="caption mb-3">Luxurious Rooms</span>
          <h1 class="mb-4">Hotel Rooms</h1>
        </div>
      </div>
    </div>
  </div>


  <div class="site-section bg-light">
    <div class="container">
      <div class="row">
        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
          <h2 class="mb-5">Rooms detail</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-md">
          <div class="card">
            <div class="row">
              <div class="col-md-6">
                <div class="images p-3">
                  <a href="#" class="d-block mb-0 thumbnail"><img src="<c:url value='/template/images/img_1.jpg'/>" alt="Image" class="img-fluid"></a>
                </div>
              </div>
              <div class="col-md-6">
                <div class="product p-4">
                  <div class="mt-4 mb-3"> <span class="text-uppercase text-muted brand">Phòng vip</span>
                    <h5 class="text-uppercase">${roomdetail.description}</h5>
                    <div class="price d-flex flex-row align-items-center"> <span class="act-price">$20</span>
                      <div class="ml-2"> <small class="dis-price">${roomdetail.price}</small> <span>40% OFF</span> </div>
                    </div>
                  </div>
                  <p class="about">phòng này chỉ dành cho dân chơi, không dành cho các dân chơi nữa mùa</p>

                  <div class="cart mt-4 align-items-center">
                          <a href="<c:url value='/user/add-to-cart?idroom=${roomdetail.id}'/> " class="btn btn-danger text-uppercase mr-2 px-4">Đặt phòng</a>
                      <i class="fa fa-heart text-muted"></i>
                      <i class="fa fa-share-alt text-muted"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

<%--      <div class="row mt-5">--%>
<%--        <div class="col-md-12 text-center">--%>
<%--          <div class="site-block-27">--%>
<%--            <ul>--%>
<%--              <li><a href="#">&lt;</a></li>--%>
<%--              <li class="active"><span>1</span></li>--%>
<%--              <li><a href="#">2</a></li>--%>
<%--              <li><a href="#">3</a></li>--%>
<%--              <li><a href="#">4</a></li>--%>
<%--              <li><a href="#">5</a></li>--%>
<%--              <li><a href="#">&gt;</a></li>--%>
<%--            </ul>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
    </div>
  </div>
  <footer class="site-footer">
    <div class="container">


      <div class="row">
        <div class="col-md-4">
          <h3 class="footer-heading mb-4 text-white">About</h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellat quos rem ullam, placeat amet.</p>
          <p><a href="#" class="btn btn-primary pill text-white px-4">Read More</a></p>
        </div>
        <div class="col-md-6">
          <div class="row">
            <div class="col-md-6">
              <h3 class="footer-heading mb-4 text-white">Quick Menu</h3>
              <ul class="list-unstyled">
                <li><a href="#">About</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Approach</a></li>
                <li><a href="#">Sustainability</a></li>
                <li><a href="#">News</a></li>
                <li><a href="#">Careers</a></li>
              </ul>
            </div>
            <div class="col-md-6">
              <h3 class="footer-heading mb-4 text-white">Ministries</h3>
              <ul class="list-unstyled">
                <li><a href="#">Children</a></li>
                <li><a href="#">Women</a></li>
                <li><a href="#">Bible Study</a></li>
                <li><a href="#">Church</a></li>
                <li><a href="#">Missionaries</a></li>
              </ul>
            </div>
          </div>
        </div>


        <div class="col-md-2">
          <div class="col-md-12"><h3 class="footer-heading mb-4 text-white">Social Icons</h3></div>
          <div class="col-md-12">
            <p>
              <a href="#" class="pb-2 pr-2 pl-0"><span class="icon-facebook"></span></a>
              <a href="#" class="p-2"><span class="icon-twitter"></span></a>
              <a href="#" class="p-2"><span class="icon-instagram"></span></a>
              <a href="#" class="p-2"><span class="icon-vimeo"></span></a>

            </p>
          </div>
        </div>
      </div>
      <div class="row pt-5 mt-5 text-center">
        <div class="col-md-12">
          <p>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy; <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All Rights Reserved | This template is made with <i class="icon-heart text-primary" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          </p>
        </div>

      </div>
    </div>
  </footer>
</div>

<script src="<c:url value='/template/js/jquery-3.3.1.min.js'/> "></script>
<script src="<c:url value='/template/js/jquery-migrate-3.0.1.min.js'/>"></script>
<script src="<c:url value='/template/js/jquery-ui.js'/>"></script>
<script src="<c:url value='/template/js/popper.min.js'/>"></script>
<script src="<c:url value='/template/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/js/owl.carousel.min.js'/>"></script>
<script src="<c:url value='/template/js/jquery.stellar.min.js'/>"></script>
<script src="<c:url value='/template/js/jquery.countdown.min.js'/>"></script>
<script src="<c:url value='/template/js/jquery.magnific-popup.min.js'/>"></script>
<script src="<c:url value='/template/js/bootstrap-datepicker.min.js'/>"></script>
<script src="<c:url value='/template/js/aos.js'/>"></script>


<script src="<c:url value='/template/js/mediaelement-and-player.min.js'/>"></script>

<script src="<c:url value='/template/js/main.js'/>"></script>



<script>
    document.addEventListener('DOMContentLoaded', function() {
        var mediaElements = document.querySelectorAll('video, audio'), total = mediaElements.length;

        for (var i = 0; i < total; i++) {
            new MediaElementPlayer(mediaElements[i], {
                pluginPath: 'https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/',
                shimScriptAccess: 'always',
                success: function () {
                    var target = document.body.querySelectorAll('.player'), targetTotal = target.length;
                    for (var j = 0; j < targetTotal; j++) {
                        target[j].style.visibility = 'visible';
                    }
                }
            });
        }
    });
</script>
</body>
</html>
