<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Smartphones</title>
</head>
<body style="background-image: url(bgpage.png); font-family: Gill Sans, sans-serif; text-align: center">
<h1>My Smartphones</h1>
<div style="height: 50px"></div>

<c:if test="${error != null}">
    <div class="red">${error}</div>
</c:if>

<c:if test="${searchData != null}">
    <table align="center">
        <tr>
            <th>Company</th>
            <th>Model</th>
            <th>Performance</th>
            <th>Price, $</th>
        </tr>
        <tr>
            <td><c:out value="${searchData.company}"/></td>
            <td><c:out value="${searchData.model}"/></td>
            <td><c:out value="${searchData.performance}"/></td>
            <td><c:out value="${searchData.price}"/></td>
        </tr>
    </table>
</c:if>

<div style="margin: 15px">
    <form action="SmartphoneSearchServlet" method="post" class="inline">
        <div class="divcolumn1" style="width: 150px">
            Search by model
        </div>
        <div class="divcolumn2">
            <input name="model" value="${model}" placeholder="model" required>
        </div>
        <input type="submit" value="Search" class="tinybutton2">
    </form>
    <form action="smartphones" method="post" class="inline">
        <input type="submit" value="Refresh" class="tinybutton2">
    </form>
</div>

<div style="margin: 15px">
    <form action="SmartphoneFilterServlet" method="post" class="inline">
        <div class="divcolumn1" style="width: 150px">
            Filter by company
        </div>
        <div class="divcolumn2">
            <input name="companyFilter" value="${companyFilter}" placeholder="company" required>
        </div>
        <input type="submit" value="Filter" class="tinybutton2">
    </form>
    <form action="smartphones" method="post" class="inline">
        <input type="submit" value="Refresh" class="tinybutton2">
    </form>
</div>

<a class="btn" href="addSmartphone"><span>Insert smartphone</span></a>

<a class="btn" href="SmartphoneRemoveServlet"><span>Remove smartphone</span></a>


<table align="center">
    <tr>
        <th>Company</th>
        <th>Model</th>
        <th>Performance</th>
        <th>Price, $</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${smartphones}" var="smart">
        <tr>
            <td><c:out value="${smart.company}"/></td>
            <td><c:out value="${smart.model}"/></td>
            <td><c:out value="${smart.performance}"/></td>
            <td><c:out value="${smart.price}"/></td>
            <td>
                <form action="SmartphoneEditButtonServlet" method="get">
                    <input type="hidden" name="id" value="${smart.id}">
                    <input type="hidden" name="company" value="${smart.company}">
                    <input type="hidden" name="model" value="${smart.model}">
                    <input type="hidden" name="performance" value="${smart.performance}">
                    <input type="hidden" name="price" value="${smart.price}">
                    <input type="submit" value="Edit" class="tinybutton">
                </form>
            </td>
            <td>
                <form action="SmartphoneRemoveButtonServlet" method="post">
                    <input type="hidden" name="id" value="${smart.id}">
                    <input type="checkbox" name="deleteConfirm">
                    <input type="submit" value="Delete" class="tinybutton">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<div style="height: 100px"></div>
</body>
</html>
