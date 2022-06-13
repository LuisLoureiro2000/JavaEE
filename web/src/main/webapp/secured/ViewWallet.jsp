<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<strong>You Have:</strong>
<%= session.getAttribute("Wallet") %>
<p></p>
<strong>How much money you want to add?</strong>
<form action="ChargeWallet" method="post">
    <input name="wallet" type="text" placeholder="50..." /><br><p></p>
    <input type="submit"><br><p></p>
</form>

<p></p>
<p></p>
<a href="/web/secured/indexStudent.jsp"><- Go back</a>
</body>
</html>