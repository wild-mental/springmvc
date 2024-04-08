<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fruit List</title>
</head>
<body>
<h1>Fruit List</h1>
<ul>
    <c:forEach var="fruit" items="${fruits}">
        <li>${fruit}</li>
    </c:forEach>
</ul>
</body>
</html>