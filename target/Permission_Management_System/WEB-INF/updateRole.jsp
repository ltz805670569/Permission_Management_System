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
    <script type="text/javascript" src="js/role.js"></script>
    <script type="text/javascript">
          $(function () {
              $.ajax({
                  url:'insertPagePrivilages',
                  type:'get',
                  success:function (data) {
                      var html;
                      for(var i=0;i<data.length;i++){
                          html = "<label class='checkbox-inline'>"+"<input type='checkbox' id='inlineCheckbox"+i+"' value='"+data[i].name+"' name='privilages'> "+data[i].name+"</label>";
                          $('#checkbox').append(html);
                      }
                      $('.head_message').css('right','120px');
                      $('.head_btn').css('right','13px');
                      insertUpdateRolePage();
                  }
              });
          });
    </script>
</head>
<body>
  <div class="update_form">
  <form class="form-horizontal" role="form">
      <div class="form-group">
          <label for="roleid" class="col-sm-1 control-label">编号</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="roleid" disabled='disabled'>
          </div>
      </div>
      <div class="form-group">
          <label for="rolename" class="col-sm-1 control-label">角色名</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="rolename">
          </div>
      </div>
      <div class="form-group">
          <label for="roleinfo" class="col-sm-1 control-label">角色信息</label>
          <div class="col-sm-4">
              <input type="text" class="form-control" id="roleinfo">
          </div>
      </div>
      <div class="form-group">
          <label class="col-sm-1 control-label">权限</label>
          <div id="checkbox">

          </div>
      </div>
      <div class="form-group">
          <div class="col-sm-offset-1 col-sm-10">
              <button type="button" class="btn btn-default btn-info" onclick="updateRole()">修改</button>
          </div>
      </div>
  </form>
  </div>
</body>
</html>
