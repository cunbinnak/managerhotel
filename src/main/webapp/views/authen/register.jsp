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
    <legend>Login</legend>
    <form method="post" action="/manager_hotel_war/authen/login">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td>Họ tên</td>
                <td><input type="text" name="name"></td>
            </tr>

            <tr>
                <td>Ngày sinh</td>
                <td><input type="date" name="birthDay"></td>
            </tr>

            <tr>
                <td>Địa chỉ</td>
                <td><input type="text" name="address"></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>

            <tr>
                <td>Số điện thoại</td>
                <td><input type="number" name="phone"></td>
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
