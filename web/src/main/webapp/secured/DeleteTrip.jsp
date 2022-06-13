<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>Delete Trip</strong>
<form action="DeleteTrip" method="post">
    <input name="tripId" type="text" placeholder="Insert the trip ID..." /><br><p></p>
    <input type="submit" value ="Delete"><br><p></p>
</form>
<pre><%= request.getAttribute("warning") %></pre>
<p> </p>
<a href="/web/secured/indexManager.jsp"><- Go back</a>
</body>
</html>