<%--
  Created by IntelliJ IDEA.
  User: zhengjq
  Date: 2017/4/1
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="cn.px.mail.MyAuthor" %>
<html>
  <head>
    <title>登入</title>
      <style>
          body{
              width: 1200px;
              height: 900px;
              margin: 0 auto;
              background-color: darksalmon;
          }
          main {
              width: 400px;
              height: 300px;
              background-color: azure;
              margin: 100px auto;
              border-radius: 10px;
          }
          h3{
              text-align: center;
              font-family: Candara;
          }
      </style>
  </head>
  <body>
  <main>
      <h3>邮件发送系统</h3>
      <form action="/login.action" method="post">
          <table border="0" align="center" style="margin-top: 30px">
              <tr>
                  <td>
                      <label for="name">邮箱账号：</label>
                  </td>
                  <td>
                      <input type="email" name="author.name" id="name"/>
                  </td>
              </tr>
              <tr>
                  <td>
                      <label for="name">邮箱密码：</label>
                  </td>
                  <td>
                      <input type="password" name="author.password" id="password"/>
                  </td>
              </tr>
              <tr style="margin-top: 60px">
                  <td colspan="2" align="center" >
                      <input type="submit" value="提交"/>
                      <input type="reset" value="重置"/>
                  </td>
              </tr>
          </table>
      </form>
  </main>

  </body>
</html>
