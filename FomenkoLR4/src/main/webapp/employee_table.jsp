<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Employee table</title>
</head>
<body bgcolor="#f2feff">
<%@ include file="menu.jsp" %>
<br>
<h1 align="center">Table of employees</h1>
<br>
<table border="2" width="14%" align="center">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Vac code</th>
    </tr>
    <c:forEach var="empl" items="${EmployeeList}">
        ${empl.toStringJSP()}
    </c:forEach>
</table>
</body>
</html>
