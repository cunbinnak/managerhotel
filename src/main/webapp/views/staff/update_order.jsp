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

        <legend>Chi ti???t ????n h??ng</legend>
        <div class="alert alert-primary" role="alert">
            <p id="msg"></p>
        </div>
        <br>

        <form method="post" action="">
            <table class="table .table-bordered">
                <tr>
                    <td></td>
                    <td>T??n ????n h??ng</td>
                    <td>T??n kh??ch h??ng</td>
                    <td>S??? ??i???n tho???i</td>
                    <td>Lo???i</td>
                    <td>Tr???ng th??i</td>
                </tr>
                <c:forEach var="order" items="${detailOrders}">
                <c:set var="itemOrder" value="${order}"/>

                <tr>
                    <td><input type="text" value="${order.id}" hidden id="orderid"></td>
                    <td><input type="text" name="orderName" value="${ order.orderName }" class="form-control" readonly></td>
                    <td>
                        <input type="text" name="customerName" value="${ order.customerName }" class="form-control" readonly>
                    </td>
                    <td>
                        <input type="text" name="customerPhone" value="${ order.customerPhone }" class="form-control" readonly>
                    </td>
                    <c:choose>
                        <c:when test="${order.orderType==1}">
                            <td>
                                <input type="text" name="orderType" value="?????t d???ch v???" class="form-control" readonly>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <input type="text" name="orderType" value="?????t ph??ng" class="form-control" readonly>
                            </td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <select name="status" id="status" class="form-control">
                            <c:if test="${ order.status =='pending'}">
                                <option value="pending">Ch???</option>
                                <option value="confirm">X??c nh???n</option>
                                <option value="success">Th??nh C??ng</option>
                                <option value="cancel">H???y</option>
                            </c:if>
                            <c:if test="${ order.status =='confirm'}">
                                <option value="confirm">X??c nh???n</option>
                                <option value="pending">Ch???</option>
                                <option value="success">Th??nh C??ng</option>
                                <option value="cancel">H???y</option>
                            </c:if>
                            <c:if test="${ order.status =='success'}">
                                <option value="success">Th??nh c??ng</option>
                                <option value="confirm">X??c nh???n</option>
                                <option value="pending">Ch???</option>
                                <option value="cancel">H???y</option>
                            </c:if>
                            <c:if test="${ order.status =='cancel'}">
                                <option value="cancel">H???y</option>
                                <option value="pending">Ch???</option>
                                <option value="confirm">X??c nh???n</option>
                                <option value="success">Th??nh C??ng</option>
                            </c:if>
                        </select>
                    </td>
                </tr>
                <tr>
                    </table>
                    <br>
                    <br>
                    <c:if test="${itemOrder.orderType==0}">
                        <h4>Danh s??ch ph??ng chi ti???t</h4>
                        <table class="table table-striped">
                            <tr>
                                <td></td>
                                <td>T??n ph??ng</td>
                                <td>Gi??</td>
                                <td>H??nh ?????ng</td>
                            </tr>
                            <c:forEach items="${order.orderDetails}" var="it" varStatus="i">
                                <tr>
                                    <td><input type="text" hidden name="orderDetailId" class="orderDetailId${i.index}"  value="${it.id}"></td>
                                    <c:set var="orderDetailId" value="${it.id}" />
                                    <td><input type="text" name="nameRef" value="${it.nameRef}" class="form-control" readonly></td>
                                    <td><input type="text" name="priceRef" value="${it.priceRef}" class="form-control" readonly>
                                    </td>
                                    <td>
                                        <button class="btn btn-danger" onclick="huyPhong(${i.index})"> H???y</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
            <c:if test="${itemOrder.orderType==1}">
                <h4>Danh s??ch d???ch v??? chi ti???t</h4>
                <table class="table table-striped">
                    <tr>
                        <td></td>
                        <th>T??n d???ch v???</th>
                        <th>Gi??</th>
                        <th>????n v??? ti???n</th>
                        <th>S??? l?????ng</th>
                    </tr>
                    <c:forEach items="${order.orderDetails}" var="it" varStatus="i">
                        <tr>
                            <td><input type="text" hidden name="orderDetailId" class="orderDetailId${i.index}"  value="${it.id}"
                                       id="orderDetailId"></td>
                            <c:set var="orderDetailId" value="${it.id}" />
                            <td><input type="text" name="nameRef" value="${it.nameRef}" class="form-control" readonly></td>
                            <td><input type="text" name="priceRef" value="${it.priceRef}" class="form-control" readonly>
                            </td>
                            <td><input type="text" name="unit" value="${it.unit}" class="form-control" readonly></td>
                            <c:set var="value" value="${it.amount}" />
                            <td><input type="number" id="amount" name="amount" value="${it.amount}"
                                       onchange="myFunction(this.value,${i.index})" class="form-control"></td>

                        </tr>
                    </c:forEach>
                </table>
            </c:if>

                </tr>
                </c:forEach>
            </table>

        </form>
        <button onclick="updateOder()" class="btn btn-primary">C???p nh???t ????n h??ng</button>
        <br>
        <hr>
        <c:if test="${itemOrder.orderType==1}">
            <legend>Th??m d???ch v???</legend>
            <h5>Danh s??ch d???ch v???</h5>
            <div class="add-service">
                <table class="table table-striped">
                    <tr>
                        <th>T??n d???ch v???</th>
                        <th>????n v???</th>
                        <th>S??? l?????ng</th>
                        <th>
                            H??nh ?????ng
                        </th>
                    </tr>
                    <c:forEach var="sv" items="${listService}">
                        <form action="create_OrderDetail"  method="post">
                        <tr>
                            <td>
                                <select name="nameRef" id="" class="form-control">
                                    <option value="${sv.name}">${sv.name}</option>
                                </select>
                            </td>
                            <td>
                                <input type="text" name="unit" value="${sv.unit}" class="form-control" readonly>

                            </td>
                            <td>
                                <input type="number" name="amount" id="actualInput"  class="form-control" onchange="alertThanAmount()" required>
                                <p style="margin-left: 20px" id="soluong">C??n l???i: ${sv.amount}</p> <span id="anounce"></span>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-success" style="margin-right: 15px">Th??m</button>
                            </td>
                        </tr>

                        <input type="hidden" name="refType" value="1">
                        <input type="hidden" name="refId" value="${sv.id}">
                        <input type="hidden" name="orderId" value="${itemOrder.id}">
                        <input type="hidden" name="priceRef" value="${sv.price}">
                        </form>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <c:if test="${itemOrder.orderType==0}">
            <legend>Th??m ph??ng</legend>
            <h5>Danh s??ch ph??ng</h5>
            <div class="add-service">
                <table class="table table-striped">
                    <tr>
                        <td>T??n ph??ng</td>
                        <td>Di???n t??ch</td>
                        <td>S??? gi?????ng</td>
                        <td>S??? ng?????i</td>
                        <td>Gi??</td>
                        <td>Gi???m gi??</td>
                        <td>Th??ng tin th??m</td>
                        <td>H??nh ???nh</td>
                        <td>Tr???ng th??i</td>
                        <td>H??nh ?????ng</td>
                    </tr>
                    <c:forEach var="r" items="${listRooms}">
                        <form action="create_OrderDetail"  method="post">
                            <tr>
                                <td>
                                    <input type="text" name="nameRef" value="${r.name}" readonly class="form-control">
                                </td>
                                <td>
                                    <input type="text" name="square" value="${r.square}" class="form-control" readonly>

                                </td>
                                <td>
                                    <input type="number" name="bedNumber" value="${r.bedNumber}" class="form-control" readonly>
                                    <p style="margin-left: 20px">C??n l???i: ${r.bedNumber}</p>
                                </td>
                                <td>
                                    <input type="text" name="peopleNumber" value="${r.peopleNumber}" class="form-control" readonly>
                                </td>
                                <td>
                                    <input type="text" name="price" value="${r.price}" class="form-control" readonly>
                                </td>
                                <td>
                                    <input type="text" name="discountPrice" value="${r.discountPrice}" class="form-control" readonly>
                                </td>
                                <td>
                                    <input type="text" name="description" value="${r.description}" class="form-control" readonly>
                                    <input type="hidden" name="amount" value="1" class="form-control" readonly>
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-success" style="margin-right: 15px">Th??m</button>
                                </td>
                            </tr>

                            <input type="hidden" name="refType" value="0">
                            <input type="hidden" name="refId" value="${r.id}">
                            <input type="hidden" name="orderId" value="${itemOrder.id}">
                            <input type="hidden" name="priceRef" value="${r.price}">
                        </form>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </main>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

<script>
    function myFunction(val,idx) {
        var id = $('#orderid').val();
        var orderDetailId = $('.orderDetailId'+idx).val();
        var amount = val;
        var delayInMilliseconds = 1000; //1 second
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/update_order_detail",
            data: {
                amount: amount,
                orderId: id,
                orderDetailId: orderDetailId
            },
            async: false,
            success: function (response) {
                data = response;
                $('#msg').html('Update Th??nh C??ng');
                setTimeout(function() {
                    $('#msg').html('');
                },delayInMilliseconds);
                return response;
            },
            error: function () {
                $('#msg').html('C?? l???i, vui l??ng th??? l???i sau!');
                setTimeout(function() {
                    $('#msg').html('');
                },delayInMilliseconds);
            }
        });
    }

    var delayInMilliseconds = 1000; //1 second

    function updateOder() {

        var id = $('#orderid').val();
        var status = $('#status').val();
        var delayInMilliseconds = 1000; //1 second
        $.ajax({
            url: 'http://localhost:8080/update_order',
            method: 'POST',
            data: {
                orderId: id,
                statusOrder: status,
            },
            success: function (resultText) {
                $('#msg').html('Update Th??nh C??ng');
                setTimeout(function() {
                    $('#msg').html('');
                },delayInMilliseconds);
            },
            error: function (resultText) {
                $('#msg').html('C?? l???i, vui l??ng th??? l???i sau!');
                setTimeout(function() {
                    $('#msg').html('resultText');
                },delayInMilliseconds);
            }
        });
    }

    function huyPhong(idx){
        var id = $('#orderid').val();
        var orderDetailId = $('.orderDetailId'+idx).val();
        var amount = 0;
        var delayInMilliseconds = 1000; //1 second
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/update_order_detail",
            data: {
                amount: amount,
                orderId: id,
                orderDetailId: orderDetailId
            },
            async: false,
            success: function (response) {
                data = response;
                $('#msg').html('Update Th??nh C??ng');
                setTimeout(function() {
                    $('#msg').html('');
                },delayInMilliseconds);
                return response;
            },
            error: function () {
                $('#msg').html('C?? l???i, vui l??ng th??? l???i sau!');
                setTimeout(function() {
                    $('#msg').html('');
                },delayInMilliseconds);
            }
        });
    }


    function alertThanAmount(){
        var soluong = $("#soluong").text();
        var index = soluong.indexOf(":");
        var actualSoluong = soluong.substring(index+1);
        var inputSelect =  $('#actualInput').val();
        if(Number(actualSoluong < inputSelect)){
            $('#anounce').html('Kh??ng ???????c l??n h??n s??? c??n l???i')
        }else {
            $('#anounce').html('')
        }
    }

</script>
</body>
</html>
