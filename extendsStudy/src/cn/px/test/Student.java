package cn.px.test;

/**
 * Created by zhengjq on 2017/3/28.
 */
public class Student extends Person {
    public void getDescription(){
        System.out.println("我是学生");
        say();
    }
    public Student(String name)
    {
        super(name);
    }
    public void say()
    {
        System.out.print("我不会说话");
    }
}
