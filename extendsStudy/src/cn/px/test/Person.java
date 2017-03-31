package cn.px.test;

/**
 * Created by zhengjq on 2017/3/28.
 */
public abstract class Person {
    public abstract void getDescription();
    private String name;
    public String getName(){
        return this.name;
    }
    public Person(String name)
    {
        this.name=name;
    }
}
