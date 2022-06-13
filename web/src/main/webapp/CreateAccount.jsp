<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>CreateAccount</strong>
<form action="CreateAccount" method="post">
    <input name="username" type="text" placeholder="username..." /><br><p></p>
    <input name="key" type="password" placeholder="password..." /><br><p></p>
    <input name="age" type="text" placeholder="age..." /><br><p></p>
    <input name="phone" type="text" placeholder="phone..." /><br><p></p>
    <input name="email" type="text" placeholder="email..." /><br><p></p>
    <input name="wallet" type="text" placeholder="wallet..." /><br><p></p>
    <input type="submit"><br><p></p>
</form>
<p> </p>
<a href="/web/login.jsp">Voltar para Login</a>
</body>
</html>