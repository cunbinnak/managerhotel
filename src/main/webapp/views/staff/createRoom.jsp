<%--
  Created by IntelliJ IDEA.
  User: manhk
  Date: 6/28/2022
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<body bgcolor="#ffffff">--%>
<%--<fieldset>--%>
<%--    <legend>Tạo tài khoản quản trị</legend>--%>
<%--    <form method="post" action="">--%>
<%--        <table cellpadding="2" cellspacing="2">--%>
<%--            <tr>--%>
<%--                <td>Username</td>--%>
<%--                <td><input type="text" name="username"></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Họ tên</td>--%>
<%--                <td><input type="text" name="name"></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Ngày sinh</td>--%>
<%--                <td><input type="date" name="birthDay"></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Địa chỉ</td>--%>
<%--                <td><input type="text" name="address"></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Email</td>--%>
<%--                <td><input type="email" name="email"></td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td>Số điện thoại</td>--%>
<%--                <td><input type="number" name="phone"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <label for="roleCode">Chức Vụ:</label>--%>
<%--                <select name="roleCode" id="roleCode">--%>
<%--                    <option value="ADMIN">Quản lý</option>--%>
<%--                    <option value="STAFF">Nhân viên</option>--%>
<%--                </select>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>&nbsp;</td>--%>
<%--                <td><input type="submit" value="Đăng ký"></td>--%>
<%--                <br> ${ message } <br>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</fieldset>--%>
<%--</body>--%>
<%--</html>--%>
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
                    <a href="<c:url value='/rooms'/>" class="active"><span class="las la-table" ></span>
                        <span>Room</span></a>
                </li>
                <li>
                    <a href="/admin/order"><span class="la la-opencart"></span>
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
                <p ><a href="<c:url value='logout'/>"> Đăng xuất</a></p>
            </div>
        </div>
    </header>
    <main>


            <h3>Thêm mới thông tin phòng</h3>
            <form action="" enctype="multipart/form-data" method="post" >
                <table class="table table-striped">
                    <tr>
                        <td>Tên phòng</td>
                        <td><input type="text" name="roomName" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Diện tích</td>
                        <td><input type="text" name="square" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Số giường</td>
                        <td><input type="text" name="bedNumber" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Số người</td>
                        <td><input type="text" name="peopleNumber" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Giá</td>
                        <td><input type="text" name="price" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Giảm giá (%)</td>
                        <td><input type="text" pattern="^[0-9]{1,2}$" name="discountPrice" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Thông tin thêm</td>
                        <td><input type="text" name="description" class="form-control"></td>
                    </tr>
                    <tr>
                        <td><label for="status">Trạng thái</label></td>
                        <td>
                            <select name="status" id="status" class="form-control">
                            <option value="0">Đã đặt</option>
                            <option value="1">Còn phòng</option>
                            <option value="2">Đang tu sửa</option>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Hình ảnh</td>
                        <td>
                            <div class="mb-3">
                                <input class="form-control" name="fileimage" type="file" >
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="add_room" class="btn btn-danger">Tạo Phòng</td>
                        <br> ${ message } <br>
                    </tr>
                </table>
            </form>

    </main>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>