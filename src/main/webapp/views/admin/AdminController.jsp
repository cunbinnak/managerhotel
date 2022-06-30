<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhk
  Date: 6/27/2022
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Controller</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="./assets/customstyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css" integrity="sha512-vebUliqxrVkBy3gucMhClmyQP9On/HAWQdKDXRaAlb/FKuTbxkjPKUyqVOxAcGwFDka79eTF+YXwfke1h3/wfg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/template/css/adminstyle.css'/> ">
</head>
<body>
<input type="checkbox" id="nav-toggle">
<div class="sidebar">
    <div class="sidebar-brand">
        <h2><span class="lab la-accusoft"></span><span>Dev Hotel</span> </h2>
    </div>
    <div class="sidebar-menu">
        <ul>
            <li>
                <a href="<c:url value='/admin'/>" class="active"><span class="las la-igloo"></span>
                    <span>Dashboard</span></a>
            </li>
            <li>
                <a href="<c:url value='/admin/search/user'/>"><span class="las la-users"></span>
                    <span>User</span></a>
            </li>
            <li>
                <a href="<c:url value='/rooms'/>"><span class="las la-table"></span>
                    <span>Room</span></a>
            </li>
            <li>
                <a href="/admin/order"><span class="la la-opencart"></span>
                    <span>Order</span></a>
            </li>
            <li>
                <a href=""><span class="la la-opencart"></span>
                    <span>Home Page</span></a>
            </li>
        </ul>
    </div>
</div>
<div class="maincontent">
    <header>
        <h2>
            <label for="nav-toggle">
                <span class="las la-bars"></span>
            </label>
            Dasboard
        </h2>
        <div class="wrapuser">
            <img src="../../../assets/images/person_1.jpg" width="30px" height="30px" alt="">
            <div>
                <h4>${userName}</h4>
            </div>
            <div class="sigout" *ngIf="username">
                <a href="/authen/logout">Đăng xuất</a>
            </div>
        </div>
    </header>
    <main>
        <div class="cards">
            <div class="card-single">
                <div>
                    <h1>54</h1>
                    <span>Customer</span>
                </div>
                <div>
                    <span class="la la-users"></span>
                </div>
            </div>
            <div class="card-single">
                <div>
                    <h1>54</h1>
                    <span>project</span>
                </div>
                <div>
                    <span class="la la-table"></span>
                </div>
            </div>
            <div class="card-single">
                <div>
                    <h1>54</h1>
                    <span>Shopping</span>
                </div>
                <div>
                    <span class="las la-shopping-bag"></span>
                </div>
            </div>
        </div>
        <div class="recent-grid">
            <div class="project">
                <div class="card">
                    <div class="card-header">
                        <h3>Recent Order</h3>
                        <button>See All <span class="las la-arrow-right"></span></button>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table width="100%">
                                <thead>
                                <tr>
                                    <td>Order ID</td>
                                    <td>Full Name</td>
                                    <td>Last Name</td>
                                    <td>Address</td>
                                    <td>status</td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Nguyen Thanh Cong</td>
                                    <td>Cong</td>
                                    <td>Kim Hoa</td>
                                    <td><span class="status pupple"></span>
                                        review
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Nguyen Thanh Cong</td>
                                    <td>Cong</td>
                                    <td>Kim Hoa</td>
                                    <td><span class="status pink"></span>
                                        pending
                                    </td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Nguyen Thanh Cong</td>
                                    <td>Cong</td>
                                    <td>Kim Hoa</td>
                                    <td><span class="status green"></span>
                                        inprogess
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
            <div class="customer">
                <div class="card">
                    <div class="card-header">
                        <h3>New Customer</h3>
                        <a class="las la-arrow-right" href="<c:url value='/admin/search/user'/>"><button>See All </button></a>
                    </div>
                    <div class="card-body">
                        <c:forEach items="${listUser}" var="u">
                            <div class="customer">
                                <div class="infor" >
                                    <div class="infor-name">
                                        <h4>${u.username}</h4>
<%--                                        <small>hihi</small>--%>
                                    </div>
                                </div>
                                <div class="contact">
                                    <span class="las la-user-circle"></span>
                                    <span class="las la-comment"></span>
                                    <span class="las la-phone"></span>
                                </div>
                            </div>
                        </c:forEach>
                </div>
            </div>
        </div>
    </main>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
