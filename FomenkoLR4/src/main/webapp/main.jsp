<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <meta charset="UTF-8">
    <title>Lab 4 - main </title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1><b><i><font color="#00b5a0">Lab 4 FDV Main page</font></i></b></h1>
<br>

<H2>Today: ${time}</H2>

<br>
<br>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</body>
</html>
