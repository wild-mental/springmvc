<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<html>
<head>
    <title>JSTL Sample Page</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>1. JSP 기본 문법 사용하기</h1>
    <%--  JSP 기본 문법 사용하기  --%>
    <%!
        int a = 1;
        int b = 2;
    %>
    <%
        int c = a + b;
    %>
    <%= a + " + " + b  + " = " + c %>
    <br><hr><br>
    <h1>2. Core 태그 사용하기</h1>
    <h2>(1) 변수 & 반복문</h2>
    <c:set var="numbers" value="${[1, 2, 3, 4, 5]}" />
    <ul>
        <c:forEach var="number" items="${numbers}">
            <li>Number: <c:out value="${number}" /></li>
        </c:forEach>
    </ul>
    <h2>(2) 함수 호출 및 조건 판별</h2>
    <%-- 1. message 데이터 수신 여부 검사 --%>
    <c:if test="${not empty message}">
        <%-- 2. 문자열 길이를 계산하여 변수에 할당 --%>
        <c:set var="messageLength" value="${fn:length(message)}" />
        <p>Message Length: <c:out value="${messageLength}" /></p>
        <%--  3. 메시지 길이가 10 이상인 경우 isLongMsg 가 true --%>
        <c:set var="isLongMsg" value="${messageLength ge 10}" />
        <%--  4. isLongMsg 검사 및 출력 --%>
        <c:if test="${isLongMsg}">
            <p>Message is long!</p>
            <c:out value="Message content : ${message}"/>
        </c:if>
    </c:if>
    <br><hr><br>
    <h1>3. fmt 태그 사용하기</h1>
    <h2>(1) 날짜 및 시간 formatting</h2>
    <fmt:formatDate var="currentDate" value="${now}" pattern="yyyy-MM-dd HH:mm:ss" />
    <p>Current Date and Time: <c:out value="${currentDate}" /></p>
    <h2>(2) 숫자 및 통화 formatting</h2>
    <fmt:formatNumber var="formattedNumber" value="${123456.789}" type="number" pattern="#,##0.00" />
    <p>Formatted Number: <c:out value="${formattedNumber}" /></p>
    <fmt:formatNumber var="formattedCurrency" value="${123456.789}" type="currency" currencyCode="USD" />
    <p>Formatted Currency: <c:out value="${formattedCurrency}" /></p>
    <br><hr><br>
    <h1>4. sql 태그 사용하기</h1>
    <h2>포켓몬 DB: poke_dex 테이블 데이터</h2>
    <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://mysql_poke.docker:12345/pokemon_game" user="root" password="12341234" />
    <sql:query dataSource="${dataSource}" var="result">
        SELECT * FROM poke_dex LIMIT 10;
    </sql:query>
    <table>
        <tr>
            <th>Monster ID</th>
            <th>Monster Name</th>
            <th>Monster Type</th>
            <th>Max HP</th>
            <th>Evolution Stage</th>
            <th>Evolves From</th>
            <th>Is Legendary</th>
        </tr>
        <!-- Sample Row 1 -->
        <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.monster_id}" /></td>
            <td><c:out value="${row.monster_name}" /></td>
            <td><c:out value="${row.monster_type}" /></td>
            <td><c:out value="${row.max_hp}" /></td>
            <td><c:out value="${row.evolution_stage}" /></td>
            <td><c:out value="${row.evolves_from}" /></td>
            <td><c:out value="${row.is_legendary}" /></td>
        </tr>
        </c:forEach>
</body>
</html>
