<%--
  Created by IntelliJ IDEA.
  User: ltz80
  Date: 2020/1/4
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>登录页面</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="login-title text-info" style="text-align:center;">
        权限管理系统
    </div>
    <div class="dowebok">
        <form action="login" method="post">
            <div class="logo"></div>
            <div class="form-item">
                <input id="username" type="text" autocomplete="off" placeholder="用户名" name="username">
<%--                <p class="tip">请输入合法的用户名</p>--%>
            </div>
            <div class="form-item">
                <input id="password" type="password" autocomplete="off" placeholder="登录密码" name="password">
<%--                <p class="tip">用户名或密码不正确</p>--%>
            </div>
            <div class="form-item"><button id="submit">登 录</button></div>
            <div class="form-msg">${msg}</div>
<%--            <div class="reg-bar">--%>
<%--                <a class="reg" href="javascript:">立即注册</a>--%>
<%--                <a class="forget" href="javascript:">忘记密码</a>--%>
<%--            </div>--%>
        </form>
    </div>

    <script>
        $(function () {
            $('input').val('');
            $('#submit').on('click', function () {
                $('.tip').show()
            });
        });
    </script>
</body>
</html>