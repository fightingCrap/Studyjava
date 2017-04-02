<%--
  Created by IntelliJ IDEA.
  User: zhengjq
  Date: 2017/4/1
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
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
    <h3>邮件内容</h3>
    <form action="/send.action" method="post">
        <table border="0" align="center">
            <tr>
                <td colspan="2"align="center">
                    <label style="text-align: center">邮件发送者：<s:property value="author.name"></s:property></label>
                </td>
            </tr>
            <tr>
                <td width="50%" align="right">
                    <label for="receiver" class="text" >接受人邮件地址：</label>
                </td>
                <td>
                    <input type="email" name="bean.receiver" id="receiver"/>
                </td>
            </tr>
            <tr>
                <td width="50%" align="right">
                    <label for="message" class="text" >邮件内容：</label>
                </td>
                <td >
                    <textarea name="bean.message" id="message" placeholder="邮件内容"></textarea>
                </td>
            </tr>
            <tr>
                <td width="50%" align="right">
                    <label class="text" for="file">附件:</label>
                </td>
                <td>
                    <input type="file"  id="file" name="bean.path">
                </td>
            </tr>

                <td colspan="2" align="center">
                    <input type="submit" value="提交"/>
                    <input type="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</main>
</body>
</html>
