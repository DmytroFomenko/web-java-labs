<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Edit Smartphone</title>
</head>
<body style="background-image: url(bgpage.png); font-family: Gill Sans, sans-serif; text-align: center">
<h1>Insert data to edit Smartphone</h1>
<div style="height: 50px"></div>

<c:if test="${error != null}">
    <div>
        <div class="red">${error}</div>
    </div>
</c:if>

<a class="btn" href="smartphones"><span>Back to Smartphones list</span></a>

<%--<form action="SmartphoneEditButtonServlet" method="post" class="inp">--%>
<%--    <input type="hidden" name="id" value="${id}">--%>
<%--    <p>Company<input name="company" value="${company}" required></p>--%>
<%--    <p>Model<input name="model" value="${model}" required></p>--%>
<%--    <p>Performance<input name="performance" value="${performance}" required></p>--%>
<%--    <p>Price<input name="price" value="${price}" required></p>--%>
<%--    <br>--%>
<%--    <input type="submit" value="Save" class="tinybutton">--%>
<%--    <p></p>--%>

<%--</form>--%>

<form action="SmartphoneEditButtonServlet" method="post" class="inp">
    <input type="hidden" name="id" value="${id}">
    <div class="wrapper">
        <div class="divcolumn1">
            Company
        </div>
        <div class="divcolumn2">
            <input name="company" value="${company}" placeholder="company" required>
        </div>
    </div>
    <div class="wrapper">
        <div class="divcolumn1">
            Model
        </div>
        <div class="divcolumn2">
            <input name="model" value="${model}" placeholder="model" required>
        </div>
    </div>
    <div class="wrapper">
        <div class="divcolumn1">
            Performance
        </div>
        <div class="divcolumn2">
            <input name="performance" value="${performance}" placeholder="performance" required>
        </div>
    </div>
    <div class="wrapper">
        <div class="divcolumn1">
            Price
        </div>
        <div class="divcolumn2">
            <input name="price" value="${price}" placeholder="price" required>
        </div>
    </div>
    <br>
    <input type="submit" value="Save" class="tinybutton">
    <p></p>

</form>

</body>
</html>
