<%--
  Created by IntelliJ IDEA.
  User: zhengjq
  Date: 2017/3/31
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        header{
            width: 900px;
            height: 200px;
            margin: 0 auto;
        }
        header img{
            width: 900px;
            height: 155px;
        }
        header ul{
            background-color: gainsboro;
            height: 45px;
            text-align: center;
            margin-top: 0;
        }
        header ul li{
            display: inline;
            margin-left: 20px;
        }
    </style>
</head>
<body>
<header>
    <img src="image/header.jpg">
    <ul>
        <li>个人首页</li>
        <li><a href="find.jsp">学员列表</a></li>
        <li><a href="add.jsp">添加学员</a></li>
    </ul>
</header>
</body>
</html>
