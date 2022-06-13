<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Search Trip By Interval</strong>
<p>Search all trips that exist in between these two dates:</p>
<form action="SearchTripByInterval" method="post">
    <input name="date1" type="date" placeholder="Date..." /><br><p></p>
    <input name="date2" type="date" placeholder="Date..." /><br><p></p>
    <select name="showPassengersInInterval">
        <option value="1" selected="selected">Show Trips</option>
        <option value="2">Show Passengers in Trips</option>
    </select>
    <input type="submit"><br><p></p>
</form>
<p> </p>
<a href="/web/secured/indexManager.jsp"><- Go back</a>
<pre><%= request.getAttribute("interval") %></pre>
</body>
</html>