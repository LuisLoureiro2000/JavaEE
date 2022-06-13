<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<strong>Your Trips:</strong>
<p></p>
<p></p>

<pre><%= request.getAttribute("trips") %></pre>

<p></p>
<p></p>
<a href="/web/secured/indexStudent.jsp"><- Go back</a>
</body>
</html>