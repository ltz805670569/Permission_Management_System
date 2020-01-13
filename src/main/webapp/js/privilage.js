var pageNum = 0;
var pages = 0;
var pageSize = 0;
var pagePre = 0;
var pageNext = 0;
var first = 1;

$(function () {
    $.ajax({
        url:"selPrivilagePageMessage",
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
        selPrivilagePage(first);
    }
    if(message === "end"){
        selPrivilagePage(pages);
    }
    if(message === "pre"){
        if(pageNum === 1){
            selPrivilagePage(first);
        }else{
            pageNum = pageNum -1;
            selPrivilagePage(pageNum);
        }
    }
    if(message === "pnext"){
        if(pageNum === pages){
            selPrivilagePage(pages);
        }else {
            pageNum = pageNum +1;
            selPrivilagePage(pageNum);
        }
    }
}

function selOne() {
    var privilageid = $('#mySelBtn').val();
    $.ajax({
        url:'selOnePrivilage/'+privilageid,
        type:'get',
        success:function (data) {
            if(data != null){
                var html = "<table  id='userTable' class='table table-bordered'><tr>" +
                    "               <th>编号</th>" +
                    "               <th>权限名</th>" +
                    "               <th>权限信息</th>" +
                    "               <th>操作</th>" +
                    "           </tr>"+
                    "           <tr>"+
                    "            <td>"+data.privilageid+"</td>"+
                    "            <td>"+data.name+"</td>"+
                    "            <td>"+data.privilage_info+"</td>"+
                    "            <td><button id='myUpdateBtn' class='btn btn-primary btn-sm' onclick='updateOne(this)'>" +
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

// function selPrivilagePageFirst(){
//     $('.iframe_page_three').load('privilage');
// }

function selPrivilagePage(num) {
    $.ajax({
        url:'selPrivilagePage',
        type:'get',
        data:{"page":num},
        success:function (data) {
            var html = null;
            for(var i=0;i<data.length;i++) {
                html += "<tr class='mytr'><td>" + data[i].privilageid + "</td><td>" + data[i].name + "</td>"
                    + "<td>" + data[i].privilage_info + "</td>"
                    + "<td>" +
                    " <button id='myUpdateBtn' class='btn btn-primary btn-sm' onclick='updateOne(this)'>" +
                    " <span class=\"glyphicon glyphicon-pencil\" aria-hidden='true'></span>" +
                    "    修改" +
                    " </button>" +
                    " <button id='myDeleteBtn' class='btn btn-danger btn-sm' onclick='deleteOne(this)'>" +
                    " <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>" +
                    "   删除" +
                    " </button>" +
                    " </td></tr>";
            }
            var newHtml =  html.replace('null',"<table  id='userTable' class='table table-bordered'>"+ "<tr>" +
                "<th>编号</th>"+
                "<th>权限名</th>"+
                "<th>权限信息</th>"+
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
    var privilageid = $(myUpdateBtn).parents("tr").children("td").eq(0).text();
    var name = $(myUpdateBtn).parents("tr").children("td").eq(1).text();
    var privilage_info = $(myUpdateBtn).parents("tr").children("td").eq(2).text();
    $.ajax({
        url:'toUpdatePrivilageTransfer',
        type:'post',
        data:{
            "privilageid":privilageid,
            "name":name,
            "privilage_info":privilage_info,
        },
        success:function (data) {
            if(data.msg === "success"){
                $('.iframe_page_three').load('toUpdatePrivilage');
            }
        }
    });
}


function updatePrivilage() {
    var privilageid = $('input:eq(0)').val();
    var name = $('input:eq(1)').val();
    var privilage_info = $('input:eq(2)').val();
    $.ajax({
        url:'updatePrivilage',
        type:'post',
        data:{
            "privilageid":privilageid,
            "name":name,
            "privilage_info":privilage_info,
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




function addPrivilage() {
    var privilageid = $('input:eq(0)').val();
    var name = $('input:eq(1)').val();
    var privilage_info = $('input:eq(2)').val();
    $.ajax({
        url:'addPrivilage',
        type:'post',
        data:{
            "privilageid":privilageid,
            "name":name,
            "privilage_info":privilage_info,
        },
        success:function (data) {
            if(data.msg === "success"){
                alert("添加成功");
                $('.iframe_page_three').load('toAddPrivilage');
            }else{
                alert("添加失败");
            }
        }
    });
}

function deleteOne(myDeleteBtn) {
    var privilageid = $(myDeleteBtn).parents("tr").children("td").eq(0).text();
    $.ajax({
        url:'deletePrivilage',
        type:'post',
        data:{"privilageid":privilageid},
        success:function (data) {
            if(data.msg === "success"){
                alert("删除成功");
                // window.location.reload();
                $('.iframe_page_three').load('privilage');
            }else {
                alert("删除失败");
            }
        }
    });
}