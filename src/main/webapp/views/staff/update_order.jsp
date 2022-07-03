<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/2/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#ffffff">

</body>
</html>
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
                    <a href="/search_service" ><span class="las la-table"></span>
                        <span>Service</span></a>
                </li>
                <li>
                    <a href="/order_list" class="active"><span class="la la-opencart"></span>
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

        <legend>Chi tiết đơn hàng</legend>
        <div class="alert alert-primary" role="alert">
            <p id="msg"></p>
        </div>
        <form method="post" action="">
            <table class="table .table-bordered">
                <tr>
                    <td>Tên đơn hàng</td>
                    <td>Tên khách hàng</td>
                    <td>Loại</td>
                    <td>Trạng thái</td>
                </tr>
                <c:forEach var="order" items="${detailOrders}">
                    <c:set var="itemOrder" value="${order}"/>
                    <tr>
                        <td><input type="text" name="orderName" value="${ order.orderName }" class="form-control"> </td>
                        <td><input type="text" name="customerName" value="${ order.customerName }"></td>
                        <c:set var="type" value="${order.orderType}"/>
                        <c:if test="${type ==0}">
                           <td> <input type="text" name="orderType" > Đặt phòng</td>
                        </c:if>
                        <c:if test="${ typee ==1}" >
                            <td><input type="text" name="orderType" > Đặt dịch vụ</td>
                        </c:if>
                        <c:set var="sts" value="${ order.status}"/>
                        <td>
                        <select name="status" id="" class="form-control">
                            <option value="${sts}">${sts}</option>
                            <option value="confirm">Xác nhận</option>
                            <option value="success">Thành Công</option>
                            <option value="cancel">Hủy</option>
                        </select>
                        </td>
                    </tr>
                    <tr>
            </table>
            <br>
            <br>
            <h4>Danh sách dịch vụ chi tiết</h4>
            <table class="table table-striped">
                <tr>
                    <th>Tên dịch vụ</th>
                    <th>Giá</th>
                    <th>Đơn vị tiền</th>
                    <th>Số lượng</th>
                </tr>
                <c:forEach items="${order.orderDetails}" var="it">
                    <tr>
                        <td><input type="text" name="nameRef" value="${it.nameRef}" class="form-control" readonly></td>
                        <td><input type="text" name="priceRef" value="${it.priceRef}" class="form-control" readonly></td>
                        <td><input type="text" name="unit" value="${it.unit}" class="form-control" readonly></td>
                        <td><input type="text" name="txt" value="Hello" onchange="myFunction(this.value)"></td>
                    </tr>
                </c:forEach>
            </table>
                    </tr>
                </c:forEach>
            </table>

        </form>


    </main>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<script>
    function myFunction(val) {
        alert("The input value has changed. The new value is: " + val);
        $.ajax({
            type:"POST",
            url : "update_order_detail",
            data : "amount"+$(this).val(),
            async: false,
            success : function(response) {
                data = response;
                return response;
            },
            error: function() {
                alert('Error occured');
            }
        });
    }


</script>
</body>
</html>
