<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manhk
  Date: 6/28/2022
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body bgcolor="#ffffff">
<fieldset>
    <legend>Cập nhập thông tin tài khoản</legend>
    <form method="post" action="">
            <table cellpadding="2" cellspacing="2">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" value="${ userDetail.username }" readonly></td>
                </tr>
                <tr>
                    <td>Họ tên</td>
                    <td><input type="text" name="name"  value="${ userDetail.name }"></td>
                </tr>
                <tr>
                    <td>Ngày sinh</td>
                    <td><input type="date" name="birthDay" value="${ userDetail.birthDay }"></td>
                </tr>
                <tr>
                    <td>Địa chỉ</td>
                    <td><input type="text" name="address" value="${ userDetail.address }"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" value="${ userDetail.email }"></td>
                </tr>

                <tr>
                    <td>Số điện thoại</td>
                    <td><input type="number" name="phone" value="${ userDetail.phone }"></td>
                </tr>
                <tr>
                    <label for="roleCode">Chức Vụ:</label>
                    <select name="roleCode" id="roleCode" value="${ userDetail.roleCode }">
                        <option value="ADMIN">Quản lý</option>
                        <option value="STAFF">Nhân viên</option>
                    </select>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Đăng ký"></td>
                    <br> ${ message } <br>
                </tr>
            </table>
    </form>
</fieldset>
</body>
</html>
