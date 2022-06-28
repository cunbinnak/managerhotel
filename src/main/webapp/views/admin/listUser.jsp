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
    <form method="GET" action="${ pathTomcat }/admin/create/user">
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Đăng ký"></td>
            <br> ${ message } <br>
        </tr>
    </form>
    <form method="post" action="">
        <tr>
            <td>Username</td>
            <td><input type="text" name="usernameSearchUser"></td>
        </tr>
        <tr>
            <label for="roleCodeSearchUser">Chức Vụ:</label>
            <select name="roleCodeSearchUser" id="roleCodeSearchUser">
                <option value="ADMIN">Quản lý</option>
                <option value="STAFF">Nhân viên</option>
                <option value="USER">Khách hàng</option>
            </select>
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
    <c:forEach var="user" items="${users}">
        <table cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <div>
                    <td>Chức vụ</td>
                </div>
            </tr>
            <tr>
                <td>${ user.username }</td>
                <td>
                <td>${ user.roleCode }</td>
                </td>
            </tr>
        </table>
    </c:forEach>
</fieldset>
</body>
</html>