package cn.px.mail;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by zhengjq on 2017/4/1.
 */
public class MailService {
    private Properties sendParameter;
    public Properties getSendParameter(){
        if(sendParameter==null)
        {
            sendParameter=new Properties();
            //设定邮件的发送协议
            sendParameter.put("mail.transport.protocol","stmp");
            //设定邮件的发送端口
            sendParameter.put("mail.smtp.port","25");
            //设置邮件的服务器地址
            sendParameter.put("mail.smtp.host","smtp.163.com");
            //设置邮件登陆的安全认证
            sendParameter.put("mail.smtp.auth","true");
        }
         return sendParameter;
    }
    public void setSendParameter(Properties sendParameter){
        this.sendParameter=sendParameter;
    }
    public boolean sendMail(MailBean bean,MyAuthor author){
        //获取邮件配置信息
        Properties p=this.getSendParameter();
        //根据配置参数和认证对象，来获取会话对象
        Session session=Session.getDefaultInstance(p,author);
        //根据会话对象来获取信息
        MimeMessage message=new MimeMessage(session);
        try{
            //构建发送者的网络地址
            message.setSender(new InternetAddress(author.getName()));
            //构建接受者的网络地址
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(bean.getReceiver()));
            //构建带附件的消息题
            Multipart file=new MimeMultipart();
            MimeBodyPart body=new MimeBodyPart();
            //获取附件
            for(int i=0;i<bean.getPath().length;i++)
            {
                if(bean.getPath()[i].equals(""))
                    break;
                body=new MimeBodyPart();
                DataSource source=new FileDataSource(bean.getPath()[i]);
                DataHandler handler=new DataHandler(source);
                body.setDataHandler(handler);
                file.addBodyPart(body);
            }
            //获取信息
            body=new MimeBodyPart();
            body.setText(bean.getMessage());
            file.addBodyPart(body);
            message.setContent(file);
            Transport.send(message);
            System.out.print("发送成功！！");
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
