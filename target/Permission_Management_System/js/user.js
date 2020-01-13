var pageNum = 0;
var pages = 0;
var pageSize = 0;
var pagePre = 0;
var pageNext = 0;
var first = 1;
$(function () {
    $.ajax({
        url:"selUserPageMessage",
        type:"get",
        success:function (data) {
            pageNum = data.pageNum;
            pages = data.pages;
            pageSize = data.pageSize;
            pagePre = data.pagePre;
            pageNext = data.pageNext;
        }
    });
});

function paging(message){
    if(message === "first"){
        selPage(first);
    }
    if(message === "end"){
        selPage(pages);
    }
    if(message === "pre"){
        if(pageNum === 1){
            selPage(first);
        }else{
            pageNum = pageNum -1;
            selPage(pageNum);
        }
    }
    if(message === "pnext"){
        if(pageNum === pages){
            selPage(pages);
        }else {
            pageNum = pageNum +1;
            selPage(pageNum);
        }
    }
}



function selOne() {
    var myId = $('#mySelBtn').val();
    $.ajax({
        url:'selOne/'+myId,
        type:'get',
        success:function (data) {
            var myArray=new Array();
            var roles = data.roles;
            for(var j=0;j<roles.length;j++){
                myArray[j] = roles[j].rolename;
            }
            var roles = myArray;
            var roleString = myArray.toString();
            // alert(roleString);
            var newRoleString = roleString.replace(/,/g,"&nbsp;");
            var html = "<table  id='userTable' class='table table-bordered'><tr>\n" +
                "               <th>编号</th>" +
                "               <th>姓名</th>" +
                "               <th>密码</th>" +
                "               <th>性别</th>" +
                "               <th>联系电话</th>" +
                "               <th>电子邮件</th>" +
                "               <th>状态</th>" +
                "               <th>角色</th>" +
                "               <th>操作</th>" +
                "           </tr>"+
                "           <tr>"+
                "            <td>"+data.id+"</td>"+
                "            <td>"+data.username+"</td>"+
                "            <td>"+data.password+"</td>"+
                "            <td>"+data.sex+"</td>"+
                "            <td>"+data.phone+"</td>"+
                "            <td>"+data.email+"</td>"+
                "            <td>"+data.status+"</td>"+
                "            <td>"+newRoleString+"</td>"+"<td><button id='myUpdateBtn' class='btn btn-primary btn-sm' onclick='updateOne(this)'>" +
                "                           <span class=\"glyphicon glyphicon-pencil\" aria-hidden='true'></span>" +
                "                           修改" +
                "                       </button>" +
                "                       <button id='myDeleteBtn' class='btn btn-danger btn-sm' onclick='deleteOne(this)'>" +
                "                           <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>" +
                "                           删除" +
                "                       </button></td></tr></table>";
            $('#userTable').html(html);
            // alert("查询成功");
            $(".user_row").css('display','none');
        }
    });

}

// function selFirst(){
//     $('.iframe_page_three').load('user');
// }

function selPage(num) {
    $.ajax({
        url:'selPage',
        type:'get',
        data:{"page":num},
        success:function (data) {
            var html = null;
            for(var i=0;i<data.length;i++){
                var myArray=new Array();
                var roles = data[i].roles;
                for(var j=0;j<roles.length;j++){
                    myArray[j] = roles[j].rolename;
                }
                var roles = myArray;
                var roleString = myArray.toString();
                var newRoleString = roleString.replace(/,/g,'&nbsp;');
                html += "<tr class='mytr'><td>"+data[i].id+"</td><td>"+data[i].username+"</td>"
                    + "<td>"+data[i].password+"</td><td>"+data[i].sex+"</td><td>"+data[i].phone+"</td><td>"
                    +  data[i].email+"</td><td>"+data[i].status+"</td><td>"+newRoleString+"</td>"
                    + "<td>" +
                    "                       <button id='myUpdateBtn' class='btn btn-primary btn-sm' onclick='updateOne(this)'>" +
                    "                           <span class=\"glyphicon glyphicon-pencil\" aria-hidden='true'></span>" +
                    "                           修改"+
                    "                       </button>" +
                    "                       <button id='myDeleteBtn' class='btn btn-danger btn-sm' onclick='deleteOne(this)'>" +
                    "                           <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>" +
                    "                           删除" +
                    "                       </button>" +
                    "                   </td></tr>";

            }
            var newHtml =  html.replace('null',"<table  id='userTable' class='table table-bordered'>"+ "<tr>" +
                "<th>编号</th>"+
                "<th>姓名</th>"+
                "<th>密码</th>"+
                "<th>性别</th>"+
                "<th>联系电话</th>"+
                "<th>电子邮件</th>"+
                "<th>状态</th>"+
                "<th>角色</th>"+
                "<th>操作</th>"+
                "</tr>");
            $("#userTable").html(newHtml+"</table>");
            var newnum = null;
            if(num === 0){
                num = 1;
                newnum = "第"+num+"页，";
            }
            newnum = "第"+num+"页，";
            $("#pageNum").text(newnum);
        }
    });
}

function updateOne(myUpdateBtn) {
    var id = $(myUpdateBtn).parents("tr").children("td").eq(0).text();
    var username = $(myUpdateBtn).parents("tr").children("td").eq(1).text();
    var password = $(myUpdateBtn).parents("tr").children("td").eq(2).text();
    var sex = $(myUpdateBtn).parents("tr").children("td").eq(3).text();
    var phone = $(myUpdateBtn).parents("tr").children("td").eq(4).text();
    var email = $(myUpdateBtn).parents("tr").children("td").eq(5).text();
    var status = $(myUpdateBtn).parents("tr").children("td").eq(6).text();
    var oldroles = $(myUpdateBtn).parents("tr").children("td").eq(7).html();
    var roles = oldroles.replace(/&nbsp;/ig,',');
    $.ajax({
        url:'toUpdateTransfer',
        type:'post',
        data:{
              "id":id,
              "username":username,
              "password":password,
              "sex":sex,
              "phone":phone,
              "email":email,
              "status":status,
              "roles":roles
        },
        success:function (data) {
            if(data.msg === "success"){
                $('.iframe_page_three').load('toUpdateUser');
            }
        }
    });
}

function updateUser() {
    var id = $('input:eq(0)').val();
    var username = $('input:eq(1)').val();
    var password = $('input:eq(2)').val();
    var sex = $('input:eq(3)').val();
    var phone = $('input:eq(4)').val();
    var email = $('input:eq(5)').val();
    var roles = [];
    $('input[name="roles"]:checked').each(function(){
        roles.push($(this).val());
    });
    if(roles.length===0){
        roles = ["1","2"];
    }
    $.ajax({
        url:'updateUser',
        type:'post',
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        data:{
             "id":id,
             "username":username,
             "password":password,
             "sex":sex,
             "phone":phone,
             "email":email,
             "status":status,
             "roles":roles
        },
        success:function (data) {
            if(data.msg === "success"){
                alert("修改成功");
            }else {
                alert("修改失败");
            }
        }
    });
}

function addUser() {
    var id = $('input:eq(0)').val();
    var username = $('input:eq(1)').val();
    var password = $('input:eq(2)').val();
    var sex = $('input:eq(3)').val();
    var phone = $('input:eq(4)').val();
    var email = $('input:eq(5)').val();
    var roles = [];
    $('input[name="roles"]:checked').each(function(){
        roles.push($(this).val());
    });
    $.ajax({
        url:'addUser',
        type:'post',
        data:{
            "id":id,
            "username":username,
            "password":password,
            "sex":sex,
            "phone":phone,
            "email":email,
            "roles[]":roles
        },
        success:function (data) {
             if(data.msg === "success"){
                 alert("添加成功");
                 $('.iframe_page_three').load('toAddUser');
             }else{
                 alert("添加失败");
             }
        }
    });
}

function deleteOne(myDeleteBtn) {
    var userid = $(myDeleteBtn).parents("tr").children("td").eq(0).text();
    $.ajax({
        url:'deleteUser',
        type:'post',
        data:{"userid":userid},
        success:function (data) {
            if(data.msg === "success"){
                alert("删除成功");
                // window.location.reload();
                $('.iframe_page_three').load('user');
            }else {
                alert("删除失败");
            }
        }
    });
}

function insertUpdateUserPage(){
    $.ajax({
        url:'toUpdateFront',
        type:'post',
        success:function (data) {
            $('input:eq(0)').val(data.id);
            $('input:eq(1)').val(data.username);
            $('input:eq(2)').val(data.password);
            $('input:eq(3)').val(data.sex);
            $('input:eq(4)').val(data.phone);
            $('input:eq(5)').val(data.email);
            $('input:eq(6)').val(data.status);
            var rolenames = data.roles;
            var size = $('input:checkbox').length;
            for(var i=0;i<rolenames.length;i++){
                $('input:checkbox').each(function(){
                    var rolename = $(this).val();
                    if(rolenames[i].rolename === rolename){
                        // alert(rolenames[i].rolename);
                        $(this).attr("checked",'true');
                    }
                });
            }
        }
    });
}

