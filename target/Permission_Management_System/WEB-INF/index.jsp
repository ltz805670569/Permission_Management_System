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
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/iframe.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.iframe_page_one').load('toHead');
            $('.iframe_page_two').load('toMenu');
            $('.iframe_page_three').load('toMain');
        });
    </script>
</head>
<body>
    <div class="iframe_page_one"  id="frameTop" >
    </div>
    <div class="iframe_page_two" id="frameContentLeft">
    </div>
    <div class="iframe_page_three" id="frameContentRight">
    </div>
</body>
</html>
