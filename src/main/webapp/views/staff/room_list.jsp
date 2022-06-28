<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhk
  Date: 6/26/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#ffffff">
<fieldset>
    <legend>Tìm kiếm</legend>
    <form method="post" action="">
        <tr>
            <td>Tên phòng</td>
            <td><input type="text" name="searchRoomByName"></td>
        </tr>
        <tr>
            <td>Giá</td>
            <td><input type="text" name="searchRoomByPrice"></td>
        </tr>
        <tr>
            <td>Số giường</td>
            <td><input type="text" attribute="searchRoomByBed"></td>
        </tr>
        <tr>
            <td>Số người</td>
            <td><input type="text" name="searchRoomByPeople"></td>
        </tr>
        <tr>
            <td>Trạng thái</td>
            <td><input type="text" name="searchRoomByStatus"></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Tìm kiếm"></td>
            <br> ${ message } <br>
        </tr>
    </form>
</fieldset>
<fieldset>
    <legend>Danh sách tài khoản</legend>
    <c:forEach var="room" items="${rooms}">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Tên phòng</td>
                <td>Diện tích</td>
                <td>Số giường</td>
                <td>Số người</td>
                <td>Giá</td>
                <td>Giảm giá</td>
                <td>Thông tin thêm</td>
                <td>Trạng thái</td>
            </tr>
            <tr>
                <td>${ room.name }</td>
                <td>${ room.square }</td>
                <td>${ room.bedNumber }</td>
                <td>${ room.peopleNumber }</td>
                <td>${ room.price }</td>
                <td>${ room.discountPrice }</td>
                <td>${ room.description }</td>
                <td>${ room.status }</td>
            </tr>
        </table>
    </c:forEach>
</fieldset>
</body>
</html>