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
    <a href="/web/secured/editUserInfo.jsp">Edit User Info</a>
    <p></p><p></p>
    <a href="/web/secured/BuyTicket.jsp">Buy Ticket</a>
    <p></p><p></p>
    <a href="/web/secured/RemoveTicket.jsp">Remove Ticket</a>
    <p></p><p></p>

    <form action="ListTrips" method="get">
        <input type="submit" value="List my Trips"><br><p></p>
    </form>

    <form action="ListAvailableTrips" method="get">
        <input type="submit" value="List Available Trips"><br><p></p>
    </form>

    <form action="Logout" method="get">
        <input type="submit" value="Logout"><br><p></p>
    </form>
    <form action="ViewWallet" method="get">
        <input type="submit" value="View/Charge Wallet"><br><p></p>
    </form>

</body>
</html>