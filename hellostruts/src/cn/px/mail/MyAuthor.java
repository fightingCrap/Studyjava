package cn.px.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by zhengjq on 2017/4/1.
 */
public class MyAuthor extends Authenticator {

    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(name,password);
    }
    public MyAuthor(String name,String password)
    {
        this.name=name;
        this.password=password;
    }

    public MyAuthor()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    private String name;
    private String password;
}
