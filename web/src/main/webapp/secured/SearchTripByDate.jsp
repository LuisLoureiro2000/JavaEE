<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Search Trip By Date</strong>
<form action="SearchTripByDate" method="post">
    <input name="searchDate" type="date" placeholder="Date..." /><br><p></p>
    <select name="showPassengers">
        <option value="1" selected="selected">Show Trips</option>
        <option value="2">Show Passengers in Trips</option>
    </select>
    <input type="submit"><br><p></p>
</form>
<p> </p>
<a href="/web/secured/indexManager.jsp"><- Go back</a>
<pre><%= request.getAttribute("trip_list") %></pre>
</body>
</html>