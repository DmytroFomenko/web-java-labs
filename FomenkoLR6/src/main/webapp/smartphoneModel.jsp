<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Input model</title>
</head>
<body style="background-image: url(bgpage.png); font-family: Gill Sans, sans-serif; text-align: center">
<h1>Insert smartphone model for deleting</h1>
<div style="height: 50px"></div>

<c:if test="${error != null}">
    <div>
        <div class="red">${error}</div>
    </div>
</c:if>

<a class="btn" href="smartphones"><span>Back to Smartphones list</span></a>

<form action="SmartphoneRemoveServlet" method="post">
    <div class="wrapper">
        <div class="divcolumn1">
            Model
        </div>
        <div class="divcolumn2">
            <input name="model" value="${model}" placeholder="model" required>
        </div>
    </div>

    <br>
    <input type="submit" value="Confirm" class="tinybutton">
    <p></p>

</form>

</body>
</html>
