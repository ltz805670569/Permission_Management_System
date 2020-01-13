<%--
  Created by IntelliJ IDEA.
  User: ltz80
  Date: 2020/1/7
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/sytle.css"/>
    <script type="text/javascript" src="js/user.js"></script>
    <script type="text/javascript">
        $(function () {
             $.ajax({
                 url:'insertPageUserId',
                 type:'get',
                 success:function (data) {
                      $('input:eq(0)').val(data.nextUserId);
                 }
             });
        });
        $(function () {
            $.ajax({
                url:'insertPageRoles',
                type:'get',
                success:function (data) {
                    var html;
                    for(var i=0;i<data.length;i++){
                        html = "<label class='checkbox-inline'>"+"<input type='checkbox' id='inlineCheckbox"+i+"' value='"+data[i].rolename+"' name='roles'> "+data[i].rolename+"</label>"
                        $('#checkbox').append(html);
                    }
                }
            });
        })
    </script>
</head>
<body>
<div class="add_form">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="id" class="col-sm-1 control-label">编号</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="id" name="id" disabled='disabled'>
            </div>
        </div>
        <div class="form-group">
            <label for="username" class="col-sm-1 control-label">姓名</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="username" name="username">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-1 control-label">密码</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="password" name="password">
            </div>
        </div>
        <div class="form-group">
            <label for="sex" class="col-sm-1 control-label">性别</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="sex" name="sex">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-1 control-label">联系方式</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="phone" name="phone">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-1 control-label">邮箱</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="email" name="email">
            </div>
        </div>
        <div class="form-group">
            <label for="status" class="col-sm-1 control-label">状态</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="status" name="status" disabled='disabled' value="1">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">角色</label>
            <div id="checkbox">
<%--                <label class="checkbox-inline">--%>
<%--                    <input type="checkbox" id="inlineCheckbox1" value="总裁" name="roles"> 总裁--%>
<%--                </label>--%>
<%--                <label class="checkbox-inline">--%>
<%--                    <input type="checkbox" id="inlineCheckbox2" value="总监" name="roles"> 总监--%>
<%--                </label>--%>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="button" class="btn btn-default btn-info" onclick="addUser()">新增</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
