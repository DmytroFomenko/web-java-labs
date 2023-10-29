<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
<h1>Login to Smartphones</h1>
<div style="height: 50px"></div>

<div>
    <form action="loginFDV" method="post">
        <div style="margin: 15px">
            <div class="divcolumn1" style="width: 160px">
                Input your username
            </div>
            <div class="divcolumn2">
                <input type="text" name="username" placeholder="username" required>
            </div>
        </div>
        <div style="margin: 15px">
            <div class="divcolumn1" style="width: 160px">
                Input your password
            </div>
            <div class="divcolumn2">
                <input type="password" name="password" placeholder="password" required>
            </div>
        </div>
        <input type="submit" value="Log in" class="tinybutton2">
    </form>
</div>

<%--<form action="loginFDV" method="POST">--%>
<%--    <p><label>Input your username</label></p>--%>
<%--    <input type="text" name="username">--%>
<%--    <p><label>Password</label></p>--%>
<%--    <input type="password" name="password">--%>
<%--    <br>--%>
<%--    <p><input type="submit" value="Go to tasks"></p>--%>
<%--</form>--%>
</body>
</html>
