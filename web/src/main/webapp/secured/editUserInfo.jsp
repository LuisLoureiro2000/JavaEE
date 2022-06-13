<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Edit User Info</strong>
<form action="EditUserInfo" method="post">
    <input name="field" type="text" placeholder="field..." /><br><p></p>
    <input name="change" type="text" placeholder="change..." /><br><p></p>
    <input type="submit"><br><p></p>
</form>
<p> </p>
<a href="/web/secured/indexStudent.jsp"><- Go back</a>
</body>
</html>