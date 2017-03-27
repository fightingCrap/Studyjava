package cn.px.action;

import cn.px.ConnectJDBC.Connect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhengjq on 2017/3/27.
 */
@WebServlet(name = "Delete",value = "/Delete")
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value=request.getParameter("id");
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        response.setContentType("charset=GBK,text/html");
        PrintWriter pw=response.getWriter();
        Connect a=new Connect();
        if(a.remove("user",value))
        {
            pw.write("删除成功");
        }
    }
}
