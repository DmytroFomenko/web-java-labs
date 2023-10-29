<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Formatting</title>
</head>
<body bgcolor="#f2feff">
<%@ include file="menu.jsp" %>
<br>
<h2>
    <c:set var="now" value="${dateTime}"/>
    <p>Time: <font color="#008c96"><fmt:formatDate type="time" value="${now}"/></font></p>
    <p>Date: <font color="#008c96"><fmt:formatDate pattern="yyyy.MM.dd" value="${now}"/></font></p>
    <p>Full time moment: <font color="#008c96"><fmt:formatDate pattern="yyyy.MM.dd " value="${now}"/>
        <fmt:formatDate type="time" value="${now}"/></font></p>
    <p>Long date: <font color="#008c96"><fmt:formatDate type="date" value="${now}"/></font></p>
    <br>

    <p>Sum in UAH: <font color="#008c96"><fmt:formatNumber type="currency" currencySymbol="грн." value="${uah}" /></font><p>
    <fmt:setLocale value="en_US"/>
    <p>Sum in dollars: <font color="#008c96"><fmt:formatNumber type="currency" currencySymbol="$" value="${dollar}" /></font><p>
    <fmt:setLocale value="de_DE"/>
    <p>Sum in EURO: <font color="#008c96"><fmt:formatNumber type="currency" currencySymbol="€" value="${euro}" /></font><p>

</h2>

</body>
</html>
