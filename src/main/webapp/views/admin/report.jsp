<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhk
  Date: 6/26/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<body bgcolor="#ffffff">--%>
<%--<fieldset>--%>
<%--    <legend>Tìm kiếm</legend>--%>
<%--    <form method="GET" action="${ pathTomcat }/admin/create/user">--%>
<%--        <tr>--%>
<%--            <td>&nbsp;</td>--%>
<%--            <td><input type="submit" value="Đăng ký"></td>--%>
<%--            <br> ${ message } <br>--%>
<%--        </tr>--%>
<%--    </form>--%>
<%--    <form method="post" action="">--%>
<%--        <tr>--%>
<%--            <td>Username</td>--%>
<%--            <td><input type="text" name="usernameSearchUser"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <label for="roleCodeSearchUser">Chức Vụ:</label>--%>
<%--            <select name="roleCodeSearchUser" id="roleCodeSearchUser">--%>
<%--                <option value="ADMIN">Quản lý</option>--%>
<%--                <option value="STAFF">Nhân viên</option>--%>
<%--                <option value="USER">Khách hàng</option>--%>
<%--            </select>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>&nbsp;</td>--%>
<%--            <td><input type="submit" value="Tìm kiếm"></td>--%>
<%--            <br> ${ message } <br>--%>
<%--        </tr>--%>
<%--    </form>--%>
<%--</fieldset>--%>
<%--<fieldset>--%>
<%--    <legend>Danh sách tài khoản</legend>--%>
<%--    <c:forEach var="user" items="${users}">--%>
<%--        <table cellpadding="2" cellspacing="2">--%>
<%--            <tr>--%>
<%--                <td>Username</td>--%>
<%--                <div>--%>
<%--                    <td>Chức vụ</td>--%>
<%--                </div>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>${ user.username }</td>--%>
<%--                <td>--%>
<%--                <td>${ user.roleCode }</td>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </c:forEach>--%>
<%--</fieldset>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Controller</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="./assets/customstyle.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css"
          integrity="sha512-vebUliqxrVkBy3gucMhClmyQP9On/HAWQdKDXRaAlb/FKuTbxkjPKUyqVOxAcGwFDka79eTF+YXwfke1h3/wfg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
            <c:if test="${role=='ADMIN'}">
                <li>
                    <a href="<c:url value='/admin'/>" ><span class="las la-igloo"></span>
                        <span>Dashboard</span></a>
                </li>
                <li>
                    <a href="<c:url value='/admin/search/user'/>" ><span class="las la-users"></span>
                        <span>User</span></a>
                </li>
            </c:if>
            <c:if test="${role=='STAFF'}">
                <li>
                    <a href="<c:url value='/rooms'/>" class="active"><span class="las la-table"></span>
                        <span>Room</span></a>
                </li>
                <li>
                    <a href="/search_service"><span class="las la-table"></span>
                        <span>Service</span></a>
                </li>
                <li>
                    <a href="/customers"><span class="las la-table"></span>
                        <span>Customer</span></a>
                </li>
                <li>
                    <a href="/order_list"><span class="la la-opencart"></span>
                        <span>Order</span></a>
                </li>
            </c:if>
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


        <legend>Report</legend>

        <div style="display: flex; float: right">
            <form method="GET" action="${ pathTomcat }/admin/create/user">
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Đăng ký" class="btn btn-primary"></td>
                    <br> ${ message } <br>
                </tr>
            </form>
        </div>

        <h4>Tìm kiếm</h4>
        <form method="post" action="">
            <table class="table">
                <tr>
                    <td>Tháng</td>
                    <td><input type="text" name="month" class="form-control"></td>
                </tr>
                <tr>
                    <td>Năm</td>
                    <td><input type="text" name="year" class="form-control"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Tìm kiếm" class="btn btn-outline-success"></td>
                    <br> ${ message } <br>
                </tr>
            </table>
        </form>

        <h3>Danh sách tài khoản</h3>

        <table class="table table-striped">
            <tr>
                <td>Tháng</td>
                <td>Năm</td>
                <td>Doanh thu</td>
            </tr>
            <c:forEach var="report" items="${reports}">
                <tr>
                    <td>${ report.createdMonth }</td>
                    <td>${ report.createdYear }</td>
                    <td>${ report.total }</td>
                </tr>
            </c:forEach>
        </table>

    </main>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>