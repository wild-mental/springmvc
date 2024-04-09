<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<%--    <fmt:setLocale value="en" />--%>
<%--    <fmt:message key="hello.message" var="helloMessage" />--%>
    <p><c:out value="${helloMessage}" /></p>
</body>
</html>
