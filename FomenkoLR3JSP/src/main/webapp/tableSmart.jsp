<%@ page import="smartphones.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#f2feff">
<%@ include file="menu.jsp"%>
<%! smartphones.SmartphoneSet s1 = new smartphones.SmartphoneSet();%>
<br><br><br><br>
<h2 align="center">Table of characteristics and cost of smartphones</h2>
<br>
<table border="1" border-style="solid" align="center">
    <tr bgcolor="#e4e0ff">
        <th> Name of smartphone</th>
        <th>Processor</th>
        <th> Performance, %</th>
        <th> Price, $</th>
    </tr>
    <%
        for (Smartphone s : s1) {
    %>
    <tr>
        <td><%=s.getName()%>
        </td>
        <td><%=s.getProcessor()%>
        </td>
        <td><%=s.getPerformance()%>
        </td>
        <td><%=s.getPrice()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br><br>
<p align="center">Table creation date - 07.10.2022</p>
</body>
</html>
