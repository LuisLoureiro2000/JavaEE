<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Enter the ID of the trip you want and the place</strong>
<form action="BuyTicket" method="post">
    <input name="trip" type="text" placeholder="ID of the trip..." /><br><p></p>
    <input name="place" type="text" placeholder="place..." /><br><p></p>
    <input type="submit" value="Buy"><br><p></p>
</form>
<%= session.getAttribute("error") %>
<p> </p>
<a href="/web/secured/indexStudent.jsp"><- Go back</a>
</body>
</html>