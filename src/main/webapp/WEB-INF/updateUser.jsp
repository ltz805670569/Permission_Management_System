<%--
  Created by IntelliJ IDEA.
  User: ltz80
  Date: 2020/1/7
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/sytle.css"/>
    <script type="text/javascript" src="layer/layer.js"></script>
    <link href="jqueryxtiper/css/xtiper.css" type="text/css" rel="stylesheet"/>
    <script src="jqueryxtiper/js/xtiper.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/user.js"></script>
    <script type="text/javascript">
          $(function () {
              $.ajax({
                  url:'insertPageRoles',
                  type:'get',
                  success:function (data) {
                      var html;
                      for(var i=0;i<data.length;i++){
                          html = "<label class='checkbox-inline'>"+"<input type='checkbox' id='inlineCheckbox"+i+"' value='"+data[i].rolename+"' name='roles'> "+data[i].rolename+"</label>";
                          $('#checkbox').append(html);
                      }
                      $('.head_message').css('right','120px');
                      $('.head_btn').css('right','13px');
                      insertUpdateUserPage();
                  }
              });
          });
    </script>
</head>
<body>
  <div class="update_form">
  <form class="form-horizontal" role="form">
      <div class="form-group">
          <label for="id" class="col-sm-1 control-label">编号</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="id" disabled='disabled'>
          </div>
      </div>
      <div class="form-group">
          <label for="username" class="col-sm-1 control-label">姓名</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="username">
          </div>
      </div>
      <div class="form-group">
          <label for="password" class="col-sm-1 control-label">密码</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="password">
          </div>
      </div>
      <div class="form-group">
          <label for="sex" class="col-sm-1 control-label">性别</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="sex">
          </div>
      </div>
      <div class="form-group">
          <label for="phone" class="col-sm-1 control-label">联系方式</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="phone">
          </div>
      </div>
      <div class="form-group">
          <label for="email" class="col-sm-1 control-label">邮箱</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="email">
          </div>
      </div>
      <div class="form-group">
          <label for="status" class="col-sm-1 control-label">状态</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="status" disabled='disabled'>
          </div>
      </div>
      <div class="form-group">
          <label class="col-sm-1 control-label" >角色</label>
          <div id="checkbox" aria-required="true">

          </div>
      </div>
      <div class="form-group">
          <div class="col-sm-offset-1 col-sm-10">
              <button type="button" class="btn btn-default btn-info" onclick="updateUser()">修改</button>
          </div>
      </div>
  </form>
  </div>
</body>
</html>
