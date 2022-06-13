<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Login</strong>
<form action="main" method="post">
    <input name="email" type="text" placeholder="email..." /><br><p></p>
    <input name="key" type="password" placeholder="password..." /><br><p></p>
    <input type="submit"><br><p></p>
</form>
<p> </p>
<a href="/web/CreateAccount.jsp">I dont have an account yet</a>
</body>
</html>