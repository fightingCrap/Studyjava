<%@ page import="org.bson.Document" %>
<%@ page import="com.mongodb.client.FindIterable" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="cn.px.JDBCconnect.Connect" %><%--
  Created by IntelliJ IDEA.
  User: zhengjq
  Date: 2017/3/28
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            margin: 0 auto;
            width: 900px;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<%@include file="left.jsp"%>
<div style="float: left;margin: 0 auto">
    <a href="add.jsp">添加信息</a>
    <table border="1" align="center">
    <tr>
        <th>姓名</th>
        <th>班级</th>
        <th>成绩</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <%
        FindIterable<Document> list=( FindIterable<Document>)request.getAttribute("document");
        if(list==null)
        {
            Connect a=new Connect();
            list=a.findall();
        }
        Iterator<Document> iterator=list.iterator();
        while (iterator.hasNext())
        {
            Document a=iterator.next();
    %>
            <tr>
                <td><%=a.getString("id")%></td>
                <td><%=a.getString("clas")%></td>
                <td><%=a.getDouble("score")%></td>
                <td><a href='add.jsp?id=<%=a.getString("id")%>'>修改</a></td>
                <td><a href='ControlServlet?path=remove&id=<%=a.getString("id")%>'>删除</a></td></tr>
    <%
        }
    %>

</table>
</div>
</body>
</html>
