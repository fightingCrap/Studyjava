package cn.px.action;

import cn.px.ConnectJDBC.Connect;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Created by zhengjq on 2017/3/26.
 */
@WebServlet(name = "Login",value = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter pw = response.getWriter();
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        Connect connect=new Connect();
        Document document = new Document();
        String user=request.getParameter("user");
        String password=request.getParameter("password");

        document.append("user",user);
        document.append("password",password);
        if(connect.insert(document))
        {

            FindIterable<Document> resultList=connect.find();
            Iterator<Document> iterator=resultList.iterator();
            pw.write("<table align='center' border='1'><tr><td>用户名</td><td>密码</td><td>修改</td><td>删除密码</td></tr>");
            while (iterator.hasNext())
            {
                Document a=iterator.next();
                pw.write("<tr><td>"+a.getString("user")+"</td><td>"+a.getString("password")
                        +"</td>");
                pw.write("<td><a href='Change?id="+a.getString("user")+"'>修改</a></td><td><a href='Delete?id="
                        +a.getString("user")+"'>删除</a></td></tr>"
                        );
            }

            pw.write("</table>");
        }
        else pw.write("<p>插入失败</p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
