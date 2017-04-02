package cn.px.action;

import cn.px.mail.MailBean;
import cn.px.mail.MailService;
import cn.px.mail.MyAuthor;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.*;
/**
 * Created by zhengjq on 2017/4/1.
 */
public class HelloStruts  {
    private MailBean bean=null;
    private MyAuthor author;
    public MyAuthor getAuthor() {
        return author;
    }

    public void setAuthor(MyAuthor author) {
        this.author = author;
    }

    public MailBean getBean() {
        return bean;
    }

    public void setBean(MailBean bean) {
        this.bean = bean;
    }

    public String login(){

        HttpServletRequest request= ServletActionContext.getRequest();
        request.getSession().setAttribute("author",author);
        if("".equals(author.getName()))
            return "error";
        else {
            return "success";
        }
    }

    public String send(){
        HttpServletRequest request= ServletActionContext.getRequest();
        author=(MyAuthor)request.getSession().getAttribute("author");
        if(!"".equals(bean.getReceiver()))
        {
           System.out.print(author.getName());
            MailService p=new MailService();
            p.sendMail(bean,author);
            return "success";
    }
        else return "error";
    }


}
