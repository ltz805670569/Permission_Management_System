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
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootsrtrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/style.js"></script>
    <script type="text/javascript" src="js/page.js"></script>
</head>
<body>
   <div class="container">
       <div class="row">
           <div class="span">
               <ul class="nav nav-pills nav-stacked">
                   <li class="active"><a href="#" class="number_main">我的菜单</a></li>
                   <li id="tab1"><a href="#" class="tab1_a">用户管理</a>
                       <ul class="down-menu down-menu_one">
                           <li><a href="#" class="down-menu_one_a1">添加用户</a></li>
                           <li><a href="#" class="down-menu_one_a2">角色赋予</a></li>
                       </ul>
                   </li>
                   <li id="tab2"><a href="#" class="tab2_a">角色管理</a>
                       <ul class="down-menu down-menu_two">
                           <li><a href="#" class="down-menu_two_a1">角色添加</a></li>
                           <li><a href="#" class="down-menu_two_a2">权限赋予</a></li>
                       </ul>
                   </li>
                   <li id="tab3"><a href="#" class="tab3_a">权限管理</a>
                       <ul class="down-menu down-menu_three">
                           <li><a href="#" class="down-menu_three_a1">权限介绍</a></li>
                           <li><a href="#" class="down-menu_three_a2">权限添加</a></li>
                       </ul>
                   </li>
                   <li id="tab4"><a href="#">详细信息</a>
                   </li>
               </ul>
           </div>
       </div>
   </div>
</body>
</html>
