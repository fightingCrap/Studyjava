package cn.px.servlet;

import cn.px.JDBCconnect.Connect;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.DoubleSummaryStatistics;

/**
 * Created by zhengjq on 2017/3/27.
 */
@WebServlet(name="ControlServlet",value = "/ControlServlet")
public class ControlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getParameter("path");
        switch (path)
        {
            case "update":
                updata(request,response);
                break;
            case "remove":
                remove(request,response);
                break;
            case "insert":
                insert(request,response);
                break;
            case "find":
                find(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
    public void updata(HttpServletRequest request, HttpServletResponse response){
        String id=request.getParameter("id");
        String clas=request.getParameter("clas");
        double score=Double.parseDouble(request.getParameter("score"));
        Connect connect=new Connect();
        Document result=new Document();
        result.append("id",id);
        result.append("clas",clas);
        result.append("score",score);
        connect.updata("id",id,result);
        find(request,response);
    }
    public void insert(HttpServletRequest request, HttpServletResponse response){
        String id=request.getParameter("id");
        String clas=request.getParameter("clas");
        double score=Double.parseDouble(request.getParameter("score"));
        Connect connect=new Connect();
        Document result=new Document();
        result.append("id",id);
        result.append("clas",clas);
        result.append("score",score);
        connect.save(result);

        find(request,response);
    }
    public void remove(HttpServletRequest request, HttpServletResponse response){
        String id=request.getParameter("id");
        Connect connect=new Connect();
        connect.remove("id",id);
        find(request,response);
    }
    public FindIterable<Document> find(HttpServletRequest request, HttpServletResponse response){
        try {
            Connect connect=new Connect();
        System.out.print("");
        HttpSession session=request.getSession();
        session.setAttribute("document",connect.findall());
        request.getRequestDispatcher("/find.jsp").forward(request, response);
    }catch (Exception e)
    {
        e.printStackTrace();
    }
        Connect connect=new Connect();
      return connect.findall();
    }
}
