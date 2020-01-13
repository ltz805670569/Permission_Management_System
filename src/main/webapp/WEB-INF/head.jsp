<%--
  Created by IntelliJ IDEA.
  User: ltz80
  Date: 2020/1/6
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
</head>
<body>
    <div class="head">
        <div class="head_image"></div>
        <div class="head_font"><b><span class="head_font">PMS&nbsp;XDL</span></b></div>
        <div class="head_message">
            <span>${user.username}</span>
        </div>
        <div class="head_btn">
            <a class="btn btn-info btn-large" onclick="toExit()">Exit</a>
        </div>
    </div>
</body>
</html>
