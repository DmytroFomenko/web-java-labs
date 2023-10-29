<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>multiply_table</title>
</head>
<body bgcolor="#f2feff">
<%@ include file="menu.jsp" %>
<br>
<h1 align="center">Multiply table</h1>
<br>

<table border="2" width="17%" align="center">
    <tr style="background-color: darkgrey">
        <th></th>
        <c:forEach var="k" begin="${min}" end="${max}">
            <th><c:out value="${k}"/></th>
        </c:forEach>
    </tr>
    <c:forEach var="i" begin="${min}" end="${max}">
        <tr>
            <td style="background-color: darkgrey"><b><c:out value="${i}"/></b></td>

            <c:forEach var="j" begin="${min}" end="${max}">
                <td><c:out value="${i*j}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>