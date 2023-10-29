<%@ page import="java.time.LocalDate" %>
<%@ page import="model.WeekInSemester" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab 3 - main </title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1><b><i><font color="#00b5a0">FDV Work with JSP (main page)</font></i></b></h1>
<br>
<%--  Використання скриплетів (для обробки та виведення коду Java, використовуючи теги <%= %>)  --%>
<H2>Today: <%=LocalDate.now().toString()%>
</H2>
<br>

<%--  Використання скриплетів (для обробки коду Java, використовуючи теги <% %>)  --%>
<h2>This week in semester is <font color="#00b5a0">
    <% int nWeek = WeekInSemester.numOfWeekInSemester();%>

    <% if (nWeek % 2 == 0) {%>
    even
    <%} else {%>
    odd
    <%}%>

    </font></h2>
<br>

<footer>
    <%@ include file="footer.jsp" %>
</footer>

</body>
</html>
