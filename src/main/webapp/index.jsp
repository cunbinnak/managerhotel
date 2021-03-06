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
                            <h2 class="mb-0 site-logo"><a href="/">Dev Hotel</a></h2>
                        </div>
                        <div class="col-10">
                            <nav class="site-navigation text-right" role="navigation">
                                <div class="container">

                                    <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                    <ul class="site-menu js-clone-nav d-none d-lg-block">
                                        <li class="active">
                                            <a href="<c:url value='/'/>">Trang ch???</a>
                                        </li>
                                        <li class="has-children">
                                            <a href="<c:url value=''/>">D???ch v???</a>
                                            <ul class="dropdown arrow-top">
                                                <c:forEach items="${services}" var="ser" >
                                                <li><a href="/">${ser.name}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="/user/order_list">Th??ng tin ????n h??ng</a> </li>
                                        <li>
                                            <a href="/search_bill">Th??ng tin h??a ????n</a> </li>
                                        <c:choose>
                                            <c:when test="${username !=null}">
                                                <li><a href="/authen/logout">${username} - ????ng xu???t</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="<c:url value='/authen/login'/>">????ng nh???p</a></li>
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
                    <h2 class="mb-5">Danh s??ch ph??ng</h2>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${rooms}" var="r">
                    <div class="col-md-6 col-lg-4 mb-5">
                        <div class="hotel-room text-center">
                            <a href="/room_detail?idroom=${r.id}" class="d-block mb-0 thumbnail"><img src="images/${r.image}" alt="Image" class="img-fluid"></a>
                            <div class="hotel-room-body">
                                <h3 class="heading mb-0"><a href="/room_detail?idroom=${r.id}">${r.name}</a></h3>
                                <strong class="price">${r.price} / m???t ????m</strong>
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
                        <h2 class="mb-5">Th??ng tin</h2>
                    </div>
                    <p class="mb-4">Kh??ch s???n Ho??ng H??n lu??n mang v??? ?????p hi???n ?????i xen l???n n??t c??? k??nh. ?????t kh??ch s???n s???m nh???t ????? h?????ng tr???n ??u ????i, h???a h???n m???t k?? ngh??? v???i nh???ng ...</p>
                    <p><a href="https://vimeo.com/28959265" class="popup-vimeo text-uppercase">Xem Video <span class="icon-arrow-right small"></span></a></p>
                </div>
            </div>
        </div>
    </div>

    <div class="site-section">
        <div class="container">
            <div class="row">
                <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                    <h2 class="mb-5">D???ch V???</h2>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${services}" var="sv">
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="text-center p-4 item">
                        <img src="image/${sv.image}" alt="" class="img-fluid">
                        <h2 class="h5">${sv.name}</h2>
                    </div>
                </div>
                </c:forEach>
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



    <div class="py-5 quick-contact-info">
        <div class="container">
            <div class="row">
                <div class="col-md-4 text-center">
                    <div>
                        <span class="icon-room text-white h2 d-block"></span>
                        <h2>?????a ch???</h2>
                        <p class="mb-0">Kinh ???? Tower <br>  93 L?? ????c - Hai B?? Tr??ng - H?? N???i</p>
                    </div>
                </div>
                <div class="col-md-4 text-center">
                    <div>
                        <span class="icon-clock-o text-white h2 d-block"></span>
                        <h2>Th???i gian ph???c v???</h2>
                        <p class="mb-0">T???t c??? c??c ng??y trong tu???n t??? 6:30 - 19:30 <br>
                    </div>
                </div>
                <div class="col-md-4 text-center">
                    <div>
                        <span class="icon-comments text-white h2 d-block"></span>
                        <h2>L???y li??n h???</h2>
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
                    <h3 class="footer-heading mb-4 text-white">V??? ch??ng t??i</h3>
                    <p>Ch??ng t??i v???i ph????ng ch??m ??em ?????n s??? ti???n nghi v?? sang tr???ng cho qu?? kh??ch</p>
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="footer-heading mb-4 text-white">Trang Ch??nh</h3>
                            <ul class="list-unstyled">
                                <li><a href="/">Trang ch???</a></li>
                                <li><a href="/">d???ch v???</a></li>
                            </ul>
                        </div>
                    </div>
                </div>


                <div class="col-md-2">

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