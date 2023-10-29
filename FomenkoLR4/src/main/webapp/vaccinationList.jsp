
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
  <title>Vaccination list</title>
</head>
<body bgcolor="#f2feff">
<%@ include file="menu.jsp" %>
<br>
<h1 align="center">Vaccination table</h1>
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
      <c:if test="${empl.codVac == 0}">
        <td><b><font color="red">Not vaccinated</font></b></td>
      </c:if>
      <c:if test="${empl.codVac == 1}">
        <td><b><font color="#8a2be2">1-st vaccination</font></b></td>
      </c:if>
      <c:if test="${empl.codVac == 2}">
        <td><b><font color="green">Full vaccinated</font></b></td>
      </c:if>
    </tr>
  </c:forEach>

</table>
</body>
</html>
