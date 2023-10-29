<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Employee table</title>
</head>
<body bgcolor="#f2feff">
<%@ include file="menu.jsp" %>
<br>
<h1 align="center">Table with highlighted old employees (60+)</h1>
<br>
<table border="2" width="14%" align="center">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Vac code</th>
    </tr>
    <c:forEach var="empl" items="${EmployeeList}">
        <tr>
            <td>${empl.name}</td>
            <c:if test="${empl.age >= 60}">
                <td><b><u><font color="red">${empl.age}</font></u></b></td>
            </c:if>
            <c:if test="${empl.age < 60}">
                <td>${empl.age}</td>
            </c:if>
            <td>${empl.codVac}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
