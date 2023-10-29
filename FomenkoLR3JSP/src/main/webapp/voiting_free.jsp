<%@ page import="java.util.Map" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voiting free</title>
</head>
<style>
    .data {
        margin-left: 47%;
        margin-top: 50px;
        font-family: "Gill Sans MT";
    }
</style>
<body bgcolor="#fdffed">
<%@ include file="menu.jsp"%>
<h1 align="center">Student voiting</h1>

<form action="voiting" method="POST" class="data">
    <br>
    <p><label>Java</label><input type="checkbox" name="Java" value="on"></p>
    <p><label>Mobile</label><input type="checkbox" name="Mobile" value="on"></p>
    <p><label>Python</label><input type="checkbox" name="Python" value="on"></p>
    <br>
    <input type="submit" value="Vote">
</form>


</body>
</html>
