package cn.px.mail;

/**
 * Created by zhengjq on 2017/4/1.
 */
public class MailBean {
    private String sender;
    private String receiver;
    private String message;
    private String[] path;
public MailBean(){

}
    public MailBean(String sender,String receiver,String message,String[] path)
    {
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.path=path;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

}
