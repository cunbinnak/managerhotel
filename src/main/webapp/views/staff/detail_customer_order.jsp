<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
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
                    <a href="<c:url value='/rooms'/>" ><span class="las la-table"></span>
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
                    <a href="/search_bill"><span class="las la-table"></span>
                        <span>Bill</span></a>
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
            Trang qu???n l??
        </h2>
        <div class="wrapuser">
            <div>
                <h4>${userName}</h4>
            </div>
            <div class="sigout" *ngIf="username">
                <a href="/authen/logout">????ng xu???t</a>
            </div>
        </div>
    </header>
    <main>

        <legend>T??m ki???m</legend>
        <form method="post" action="">
            <table class="table">
                <tr>
                    <td>T??n ????n h??ng</td>
                    <td>
                        <select name="statusOrder" class="form-control" >
                            <option value="pending">Ch??? ?????t</option>
                            <option value="confirm">X??c nh???n</option>
                            <option value="success">Ho??n th??nh</option>
                            <option value="cancel">H???y</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Lo???i</td>
                    <td>
                        <select name="orderType" class="form-control">
                            <option value="0">Ph??ng</option>
                            <option value="1">D???ch v???</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="T??m ki???m" class="btn btn-success"></td>
                    <br> ${ message } <br>
                </tr>
            </table>
        </form>

        <br>
        <h3>Danh ????n h??ng</h3>
        <table class="table .table-bordered">
            <tr>
                <td>T??n ????n h??ng</td>
                <td>T??n kh??ch h??ng</td>
                <td>Lo???i</td>
                <td>Tr???ng th??i</td>
            </tr>
            <c:forEach var="order" items="${detailOrders}">
                <tr>
                    <td>${ order.orderName }</td>
                    <td>${ order.customerName }</td>
                    <c:if test="${ order.orderType ==0}" >
                        <td>?????t ph??ng</td>
                    </c:if>
                    <c:if test="${ order.orderType ==1}" >
                        <td>?????t d???ch v???</td>
                    </c:if>
                    <c:set var="sts" value="${ order.status}"/>
                    <c:choose>
                        <c:when test="${ sts ==pending}">
                            <td>Ch???</td>
                        </c:when>
                        <c:when test="${ sts ==confirm}">
                            <td>X??c nh???n</td>
                        </c:when>
                        <c:when test="${sts ==success}">
                            <td>Th??nh c??ng</td>
                        </c:when>
                        <c:otherwise >
                            <td>H???y</td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <a href="/update_order?orderId=${order.id}" style="margin: 10px">C???p nh???t ????n h??ng</a>
                        <a href="/update_order_detail?orderId=${order.id}" style="margin: 10px">Chi ti???t</a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </main>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
