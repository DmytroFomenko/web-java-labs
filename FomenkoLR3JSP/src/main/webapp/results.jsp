<%@ page import="java.util.Map" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
</head>
<style>
    .data {
        margin-left: 47%;
        margin-top: 50px;
        font-family: "Gill Sans MT";
    }
</style>
<body bgcolor="#edfaff">
<%@ include file="menu.jsp" %>
<h1 align="center">Results of voiting</h1>
<p class="data">
<%
    java.util.Map<String, Integer> res = (java.util.Map<String, Integer>) request.getAttribute("results");
    for (Map.Entry<String, Integer> e : res.entrySet()) {%>
        +--------------+<br>
        | <%=e.getKey()%> | <%=e.getValue()%> |<br>
    <% }%>
    +--------------+
</p>
<form action="voiting_free.jsp" class="data">
    <input type="submit" value="Back to voiting" />
</form>

</body>
</html>
