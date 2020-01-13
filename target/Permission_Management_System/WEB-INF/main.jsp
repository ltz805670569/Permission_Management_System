<%--
  Created by IntelliJ IDEA.
  User: ltz80
  Date: 2020/1/6
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的主页</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/sytle.css"/>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"toSelMainNumer",
                type:'get',
                success:function (data) {
                    $("#user_number").text(data.userNumber);
                    $("#role_number").text(data.roleNumber);
                    $("#privilage_number").text(data.privilageNumber);
                }
            });
        });
    </script>
</head>
<body>
     <div class="main_number">
         <div  class="panel panel-primary number">
             <div class="panel-heading">
                 <h3 class="panel-title">用户数量</h3>
             </div>
             <div id="user_number" class="panel-body">
                 这是一个基本的面板
             </div>
         </div>
         <div  class="panel panel-success number">
             <div class="panel-heading">
                 <h3 class="panel-title">角色数量</h3>
             </div>
             <div id="role_number" class="panel-body">
                 这是一个基本的面板
             </div>
         </div>
         <div class="panel panel-info number">
             <div class="panel-heading">
                 <h3 class="panel-title">权限数量</h3>
             </div>
             <div id="privilage_number" class="panel-body">
                 这是一个基本的面板
             </div>
         </div>
     </div>
</body>
</html>
