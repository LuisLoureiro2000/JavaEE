<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Create Trip</strong>
<form action="CreateTrip" method="post">
    <input name="departure" type="text" placeholder="Departure Point..." /><br><p></p>
    <input name="departureDate" type="date" placeholder="Date..." /><br><p></p>
    <input name="departureHour" type="text" placeholder="hours:minutes" /><br><p></p>
    <input name="destination" type="text" placeholder="Destination..." /><br><p></p>
    <input name="capacity" type="text" placeholder="Capacity..." /><br><p></p>
    <input name="price" type="text" placeholder="Price..." /><br><p></p>
    <input type="submit"><br><p></p>
</form>
<p> </p>
<a href="/web/secured/indexManager.jsp"><- Go back</a>
</body>
</html>