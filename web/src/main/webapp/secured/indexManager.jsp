<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <p></p>
    <p>What would you like to do today?</p>

    <a href="/web/secured/CreateTrip.jsp">Create a Trip</a>
    <p></p>
    <a href="/web/secured/SearchTripByDate.jsp">Search Trip by Date</a>
    <p></p>
    <a href="/web/secured/SearchTripByInterval.jsp">Search Trip by Interval</a>
    <p></p>
    <a href="/web/secured/DeleteTrip.jsp">Delete a Trip</a>
    <p></p>
    <form action="TopFive" method="get">
        <input type="submit" value="Show Top5"><br><p></p>
    </form>
    <form action="Logout" method="get">
        <input type="submit" value="Logout"><br><p></p>
    </form>
</body>
</html>