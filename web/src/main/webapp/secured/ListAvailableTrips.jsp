<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<strong>List of all available trips:</strong>
<pre><%= request.getAttribute("available_trips") %></pre>
<p> </p>
<a href="/web/secured/indexStudent.jsp"><- Go back</a>
</body>
</html>