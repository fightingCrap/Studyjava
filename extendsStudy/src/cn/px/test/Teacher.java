package cn.px.test;

/**
 * Created by zhengjq on 2017/3/28.
 */
public class Teacher extends Person {
    public void getDescription(){
        System.out.println("我是老师");
    }
    public Teacher(String name)
    {
        super(name);
    }
}
