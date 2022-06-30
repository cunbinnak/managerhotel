<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> >
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dev &mdash; Hotel</title>
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
                                        <c:choose>
                                            <c:when test="${username !=null}">
                                                <li><a href="/authen/logout">Xin Chào: ${username}</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="<c:url value='/authen/login'/>">Đăng nhập</a></li>
                                            </c:otherwise>
                                        </c:choose>


                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="slide-one-item home-slider owl-carousel">

        <div class="site-blocks-cover overlay" style="background-image: url(<c:url value='template/images/hero_1.jpg'/>);" data-aos="fade" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-7 text-center" data-aos="fade">

                        <h1 class="mb-2">Welcome To Suites</h1>
                        <h2 class="caption">Hotel &amp; Resort</h2>
                    </div>
                </div>
            </div>
        </div>

        <div class="site-blocks-cover overlay" style="background-image: url(<c:url value='template/images/hero_2.jpg'/>);" data-aos="fade" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-7 text-center" data-aos="fade">
                        <h1 class="mb-2">Unique Experience</h1>
                        <h2 class="caption">Enjoy With Us</h2>
                    </div>
                </div>
            </div>
        </div>

        <div class="site-blocks-cover overlay" style="background-image: url(<c:url value='template/images/hero_3.jpg'/>);" data-aos="fade" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-7 text-center" data-aos="fade">
                        <h1 class="mb-2">Relaxing Room</h1>
                        <h2 class="caption">Your Room, Your Stay</h2>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="site-section bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                    <h2 class="mb-5">Danh sách phòng</h2>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${rooms}" var="r">
                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="hotel-room text-center">
                            <a href="/room_detail?idroom=${r.id}" class="d-block mb-0 thumbnail"><img src="<c:url value='template/images/img_1.jpg'/>" alt="Image" class="img-fluid"></a>
                            <div class="hotel-room-body">
                                <h3 class="heading mb-0"><a href="#">${r.name}</a></h3>
                                <strong class="price">${r.price} / một đêm</strong>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>


    <div class="site-section">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-6 mb-5 mb-md-0">

                    <div class="img-border">
                        <a href="<c:url value='https://vimeo.com/28959265'/>" class="popup-vimeo image-play">
                  <span class="icon-wrap">
                    <span class="icon icon-play"></span>
                  </span>
                            <img src="<c:url value='/template/images/img_2.jpg'/>" alt="" class="img-fluid">
                        </a>
                    </div>

                    <img src="<c:url value='/template/images/img_1.jpg'/>" alt="Image" class="img-fluid image-absolute">

                </div>
                <div class="col-md-5 ml-auto">


                    <div class="section-heading text-left">
                        <h2 class="mb-5">Thông tin</h2>
                    </div>
                    <p class="mb-4">Khách sạn Hoàng Hôn luôn mang vẻ đẹp hiện đại xen lẫn nét cổ kính. Đặt khách sạn sớm nhất để hưởng trọn ưu đãi, hứa hẹn một kì nghỉ với những ...</p>
                    <p><a href="https://vimeo.com/28959265" class="popup-vimeo text-uppercase">Xem Video <span class="icon-arrow-right small"></span></a></p>
                </div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                    <h2 class="mb-5">Dịch Vụ</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-pool display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Hồ bơi</h2>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-desk display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Gọi thức ăn nhanh</h2>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-exit display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Thoát hiểm an toàn</h2>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-parking display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Bãi đổ xe</h2>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-hair-dryer display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Tạo mẫu tóc</h2>
                    </div>
                </div>

                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-minibar display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Quầy bar</h2>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-drink display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Thức uống</h2>
                    </div>
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <span class="flaticon-cab display-3 mb-3 d-block text-primary"></span>
                        <h2 class="h5">Thuê ô tô</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="py-5 upcoming-events" style="background-image: url('images/hero_1.jpg'); background-attachment: fixed;">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-6">
                    <h2 class="text-white">Summer Promo 50% Off</h2>
                    <a href="#" class="text-white btn btn-outline-warning rounded-0 text-uppercase">Avail Now</a>
                </div>
                <div class="col-md-6">
                    <span class="caption">The Promo will start in</span>
                    <div id="date-countdown"></div>
                </div>
            </div>

        </div>
    </div>

<%--    <div class="site-section">--%>
<%--        <div class="container">--%>
<%--            <div class="row">--%>
<%--                <div class="col-md-6 mx-auto text-center mb-5 section-heading">--%>
<%--                    <h2 class="mb-5">Phòng còn trống</h2>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="row no-gutters">--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_1.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_1.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_2.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_2.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_3.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_3.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_4.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_4.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>

<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_4.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_4.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_5.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_5.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_6.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_6.jpg'/>" alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>
<%--                <div class="col-md-6 col-lg-3">--%>
<%--                    <a href="images/img_7.jpg" class="image-popup img-opacity"><img src="<c:url value='/template/images/img_7.jpg'/> " alt="Image" class="img-fluid"></a>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

    <div class="site-section block-14 bg-light">

        <div class="container">

            <div class="row">
                <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                    <h2>Phản hồi khách hàng</h2>
                </div>
            </div>

            <div class="nonloop-block-14 owl-carousel">

                <div class="p-4">
                    <div class="d-flex block-testimony">
                        <div class="person mr-3">
                            <img src="images/person_1.jpg" alt="Image" class="img-fluid rounded">
                        </div>
                        <div>
                            <h2 class="h5">Katie Johnson</h2>
                            <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                        </div>
                    </div>
                </div>
                <div class="p-4">
                    <div class="d-flex block-testimony">
                        <div class="person mr-3">
                            <img src="images/person_2.jpg" alt="Image" class="img-fluid rounded">
                        </div>
                        <div>
                            <h2 class="h5">Jane Mars</h2>
                            <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                        </div>
                    </div>
                </div>
                <div class="p-4">
                    <div class="d-flex block-testimony">
                        <div class="person mr-3">
                            <img src="images/person_3.jpg" alt="Image" class="img-fluid rounded">
                        </div>
                        <div>
                            <h2 class="h5">Shane Holmes</h2>
                            <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                        </div>
                    </div>
                </div>
                <div class="p-4">
                    <div class="d-flex block-testimony">
                        <div class="person mr-3">
                            <img src="images/person_4.jpg" alt="Image" class="img-fluid rounded">
                        </div>
                        <div>
                            <h2 class="h5">Mark Johnson</h2>
                            <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>


    <div class="py-5 quick-contact-info">
        <div class="container">
            <div class="row">
                <div class="col-md-4 text-center">
                    <div>
                        <span class="icon-room text-white h2 d-block"></span>
                        <h2>Location</h2>
                        <p class="mb-0">New York - 2398 <br>  10 Hadson Carl Street</p>
                    </div>
                </div>
                <div class="col-md-4 text-center">
                    <div>
                        <span class="icon-clock-o text-white h2 d-block"></span>
                        <h2>Service Times</h2>
                        <p class="mb-0">Wednesdays at 6:30PM - 7:30PM <br>
                            Fridays at Sunset - 7:30PM <br>
                            Saturdays at 8:00AM - Sunset</p>
                    </div>
                </div>
                <div class="col-md-4 text-center">
                    <div>
                        <span class="icon-comments text-white h2 d-block"></span>
                        <h2>Get In Touch</h2>
                        <p class="mb-0">Email: info@yoursite.com <br>
                            Phone: (123) 3240-345-9348 </p>
                    </div>
                </div>
            </div>
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