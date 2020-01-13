var pageNum = 0;
var pages = 0;
var pageSize = 0;
var pagePre = 0;
var pageNext = 0;
var first = 1;
$(function () {
    $.ajax({
        url:"selRolePageMessage",
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
        selRolePage(first);
    }
    if(message === "end"){
        selRolePage(pages);
    }
    if(message === "pre"){
        if(pageNum === 1){
            selRolePage(first);
        }else{
            pageNum = pageNum -1;
            selRolePage(pageNum);
        }
    }
    if(message === "pnext"){
        if(pageNum === pages){
            selRolePage(pages);
        }else {
            pageNum = pageNum +1;
            selRolePage(pageNum);
        }
    }
}

function selOne() {
    var roleid = $('#mySelBtn').val();
    $.ajax({
        url:'selOneRole/'+roleid,
        type:'get',
        success:function (data) {
            if(data != null){
                var myArray=new Array();
                var privilages = data.privilages;
                for(var j=0;j<privilages.length;j++){
                    myArray[j] = privilages[j].name;
                }
                var privilages = myArray;
                var privilageString = myArray.toString();
                var newPrivilageString = privilageString.replace(/,/g,"&nbsp;");
                var html = "<table  id='userTable' class='table table-bordered'><tr>" +
                    "               <th>编号</th>" +
                    "               <th>角色</th>" +
                    "               <th>角色信息</th>" +
                    "               <th>权限</th>" +
                    "               <th>操作</th>" +
                    "           </tr>"+
                    "           <tr>"+
                    "            <td>"+data.roleid+"</td>"+
                    "            <td>"+data.rolename+"</td>"+
                    "            <td>"+data.roleinfo+"</td>"+
                    "            <td>"+newPrivilageString+"</td>"+"<td><button id='myUpdateBtn' class='btn btn-primary btn-sm' onclick='updateOne(this)'>" +
                    "                           <span class=\"glyphicon glyphicon-pencil\" aria-hidden='true'></span>" +
                    "                           修改" +
                    "                       </button>" +
                    "                       <button id='myDeleteBtn' class='btn btn-danger btn-sm' onclick='deleteOne(this)'>" +
                    "                           <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>" +
                    "                           删除" +
                    "                       </button></td></tr></table>";
                $('#userTable').html(html);
                $(".user_row").css('display','none');
            }else{
                alert(data);
                var html = null;
                $('#userTable').html(html);
            }
        }
    });
}

// function selRolePageFirst(){
//     $('.iframe_page_three').load('role');
// }

function selRolePage(num) {
    $.ajax({
        url:'selRolePage',
        type:'get',
        data:{"page":num},
        success:function (data) {
            var html = null;
            for(var i=0;i<data.length;i++){
                var myArray=new Array();
                var privilages = data[i].privilages;
                for(var j=0;j<privilages.length;j++){
                    myArray[j] = privilages[j].name;
                }
                var privilages = myArray;
                var privilageString = myArray.toString();
                var newPrivilageString = privilageString.replace(/,/g,'&nbsp;');
                html += "<tr class='mytr'><td>"+data[i].roleid+"</td><td>"+data[i].rolename+"</td>"
                    + "<td>"+data[i].roleinfo+"</td>"
                    + "<td>"+newPrivilageString+"</td>"
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
                "<th>角色名</th>"+
                "<th>角色信息</th>"+
                "<th>权限</th>"+
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
    var roleid = $(myUpdateBtn).parents("tr").children("td").eq(0).text();
    var rolename = $(myUpdateBtn).parents("tr").children("td").eq(1).text();
    var roleinfo = $(myUpdateBtn).parents("tr").children("td").eq(2).text();
    var oldprivilages = $(myUpdateBtn).parents("tr").children("td").eq(3).html();
    var privilages = oldprivilages.replace(/&nbsp;/ig,',');
    // alert(roles);
    $.ajax({
        url:'toUpdateRoleTransfer',
        type:'post',
        data:{
            "roleid":roleid,
            "rolename":rolename,
            "roleinfo":roleinfo,
            "privilages":privilages
        },
        success:function (data) {
            if(data.msg === "success"){
                $('.iframe_page_three').load('toUpdateRole');
            }
        }
    });
}

function updateRole() {
    var roleid = $('input:eq(0)').val();
    var rolename = $('input:eq(1)').val();
    var roleinfo = $('input:eq(2)').val();
    var privilages = [];
    $('input[name="privilages"]:checked').each(function(){
        privilages.push($(this).val());
    });
    if(privilages.length===0){
        privilages = ["1","2"];
    }
    $.ajax({
        url:'updateRole',
        type:'post',
        data:{
            "roleid":roleid,
            "rolename":rolename,
            "roleinfo":roleinfo,
            "privilages":privilages
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

function insertUpdateRolePage(){
    $.ajax({
        url:'toUpdateRoleFront',
        type:'post',
        success:function (data) {
            $('input:eq(0)').val(data.roleid);
            $('input:eq(1)').val(data.rolename);
            $('input:eq(2)').val(data.roleinfo);
            var privilages = data.privilages;
            var size = $('input:checkbox').length;
            for(var i=0;i<privilages.length;i++){
                $('input:checkbox').each(function(){
                    var privilagename = $(this).val();
                    var newprivilagename = $.trim(privilagename);
                    // alert(newprivilagename);
                    if($.trim(privilages[i].name) === newprivilagename){
                        // alert(rolenames[i].rolename);
                        $(this).attr("checked",'true');
                    }
                });
            }
        }
    });
}

function addRole() {
    var roleid = $('input:eq(0)').val();
    var rolename = $('input:eq(1)').val();
    var roleinfo = $('input:eq(2)').val();
    var privilages = [];
    $('input[name="privialges"]:checked').each(function(){
        privilages.push($(this).val());
    });
    $.ajax({
        url:'addRole',
        type:'post',
        data:{
            "roleid":roleid,
            "rolename":rolename,
            "roleinfo":roleinfo,
            "privilages":privilages
        },
        success:function (data) {
            if(data.msg === "success"){
                alert("添加成功");
                $('.iframe_page_three').load('toAddRole');
            }else{
                alert("添加失败");
            }
        }
    });
}

function deleteOne(myDeleteBtn) {
    var roleid = $(myDeleteBtn).parents("tr").children("td").eq(0).text();
    $.ajax({
        url:'deleteRole',
        type:'post',
        data:{"roleid":roleid},
        success:function (data) {
            if(data.msg === "success"){
                alert("删除成功");
                // window.location.reload();
                $('.iframe_page_three').load('role');
            }else {
                alert("删除失败");
            }
        }
    });
}