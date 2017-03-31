<%@ page import="org.bson.Document" %>
<%@ page import="cn.px.JDBCconnect.Connect" %>
<%@ page import="org.bson.FieldNameValidator" %>
<%@ page import="com.mongodb.client.FindIterable" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: zhengjq
  Date: 2017/3/28
  Time: 14:32
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
<%
String id=request.getParameter("id");
if(id==null){
%>
<div style="float: left;margin: 50px auto;">
<form action="ControlServlet?path=insert" method="post">
    <table>
        <tr>
            <td><label for="user">用户名</label></td>
            <td><input type="text" name="id"  id="user"></td>
        </tr>
        <tr>
            <td><label for="clas">班级</label></td>
            <td><input type="text" name="clas"  id="clas"></td>
        </tr>
        <tr>
            <td><label for="score">成绩</label></td>
            <td><input type="text" name="score"  id="score"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
    <%
}
else {
    Connect a=new Connect();
    FindIterable<Document> person=a.find("id",id);
    Iterator f=person.iterator();
    %>
<form action="ControlServlet?path=update&id=<%=id%>" method="post">
    <table>

        <%
    while (f.hasNext())
    {
        Document g=(Document) f.next();
    %>
        <tr>
        <td><label for="user">用户名</label></td>
        <td><input type="text" name="id"  id="user" value="<%=g.getString("id")%>"></td>
        </tr>
                <tr>
                    <td><label for="clas">班级</label></td>
                    <td><input type="text" name="clas"  id="clas" value="<%=g.getString("clas")%>"></td>
                </tr>
                <tr>
                    <td><label for="score">成绩</label></td>
                    <td><input type="text" name="score"  id="score" value="<%=g.getDouble("score")%>"></td>
                </tr>
                <tr>
                    <%
                        }
                    %>
                    <td><input type="submit" value="提交"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    <%
}
    %>
</div>
</body>
</html>
