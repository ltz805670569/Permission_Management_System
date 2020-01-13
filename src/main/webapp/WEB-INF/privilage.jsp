<%--
  Created by IntelliJ IDEA.
  User: ltz80
  Date: 2020/1/7
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <title>权限管理</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/sytle.css"/>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/privilage.js"></script>
</head>
<body class="userBody">
<div>
    <input id="mySelBtn" type="text" class="btn btn-large" style="border: 2px #1E9FFF;border-radius: 3px" placeholder="请输入编号"><input type="button" class="btn btn-large btn-info" onclick="selOne()" value="查询">
</div>
<div class="userDiv">
    <table  id="userTable" class="table table-bordered">
        <tr>
            <th>编号</th>
            <th>权限名</th>
            <th>权限信息</th>
            <th>操作</th>
        </tr>
        <jsp:useBean id="pageInfo" scope="request" type="com.github.pagehelper.PageInfo"/>
        <c:forEach items="${privilages }" var="privilage">
            <tr>
                <td>${privilage.privilageid }</td>
                <td>${privilage.name }</td>
                <td>${privilage.privilage_info }</td>
                <td>
                    <button id='myUpdateBtn' class='btn btn-primary btn-sm' onclick='updateOne(this)'>
                        <span class="glyphicon glyphicon-pencil" aria-hidden='true'></span>
                        修改
                    </button>
                    <button id='myDeleteBtn' class='btn btn-danger btn-sm' onclick='deleteOne(this)'>
                        <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>
                        删除
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="user_row">
    <div class="user_row_one">
        <span id="pageNum">第${pageInfo.pageNum}页， </span> <span>共${pageInfo.pages}页， </span><span>共${pageInfo.total}条记录</span>
    </div>
    <div class="user_row_two">
        <nav aria-label="Page navigation example">
            <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" onclick="paging('first')">首页</a></li>
                <li class="page-item"><a class="page-link" onclick="paging('pre')">上一页</a></li>
                <li class="page-item"><a class="page-link" onclick="paging('pnext')">下一页</a></li>
                <li class="page-item"><a class="page-link" onclick="paging('end')">末页</a></li>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
