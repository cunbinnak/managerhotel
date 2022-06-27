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
<%--    <legend>Login</legend>--%>
<%--    <form method="post" action="">--%>
<%--        <table cellpadding="2" cellspacing="2">--%>
<%--            <tr>--%>
<%--                <td>Username</td>--%>
<%--                <td><input type="text" name="username"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Password</td>--%>
<%--                <td><input type="password" name="password"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>&nbsp;</td>--%>
<%--                <td><input type="submit" value="Đăng nhập"></td>--%>
<%--                <br> ${ message } <br>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</fieldset>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0px;
        }
        body {
            background-color: lightgreen;
        }
        header {
            background-color: black;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 15vh;
            box-shadow: 5px 5px 10px rgb(0,0,0,0.3);
        }
        h1 {
            letter-spacing: 1.5vw;
            font-family: 'system-ui';
            text-transform: uppercase;
            text-align: center;
        }
        main {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 75vh;
            width: 100%;
            background: url(https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Mountains-1412683.svg/1280px-Mountains-1412683.svg.png) no-repeat center center;
            background-size: cover;
        }
        .form_class {
            width: 500px;
            padding: 40px;
            border-radius: 8px;
            background-color: white;
            font-family: 'system-ui';
            box-shadow: 5px 5px 10px rgb(0,0,0,0.3);
        }
        .form_div {
            text-transform: uppercase;
        }
        .form_div > label {
            letter-spacing: 3px;
            font-size: 1rem;
        }
        .info_div {
            text-align: center;
            margin-top: 20px;
        }
        .info_div {
            letter-spacing: 1px;
        }
        .field_class {
            width: 100%;
            border-radius: 6px;
            border-style: solid;
            border-width: 1px;
            padding: 5px 0px;
            text-indent: 6px;
            margin-top: 10px;
            margin-bottom: 20px;
            font-family: 'system-ui';
            font-size: 0.9rem;
            letter-spacing: 2px;
        }
        .submit_class {
            border-style: none;
            border-radius: 5px;
            background-color: #FFE6D4;
            padding: 8px 20px;
            font-family: 'system-ui';
            text-transform: uppercase;
            letter-spacing: .8px;
            display: block;
            margin: auto;
            margin-top: 10px;
            box-shadow: 2px 2px 5px rgb(0,0,0,0.2);
            cursor: pointer;
        }
        footer {
            height: 10vh;
            background-color: black;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            box-shadow: -5px -5px 10px rgb(0,0,0,0.3);
        }
        footer > p {
            text-align: center;
            font-family: 'system-ui';
            letter-spacing: 3px;
        }
        footer > p > a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>
<header>
    <h1>Wellcome to DEV Hotel</h1>
</header>
<main>

    <form id="login_form" class="form_class" name="loginform" action="" method="post">
        <h3> ${ message } <h3>
        <div class="form_div">
            <label>Tên Tài Khoản:</label>
            <input class="field_class" name="username" type="text" placeholder="nhập tài khoản" autofocus>
            <label>Mật khẩu:</label>
            <input id="pass" class="field_class" name="password" type="password" placeholder="nhập mật khẩu">
            <button class="submit_class" type="submit" form="login_form" onclick="return validarLogin()">Đăng nhập</button>
        </div>
        <div class="info_div">
            <p>Bạn đã có tài khoản chưa? <a href="<c:url value='/register'/>">Đăng ký ngay!</a></p>
        </div>
    </form>
</main>

</body>
</html>