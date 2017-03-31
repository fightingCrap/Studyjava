package cn.px.test;

/**
 * Created by zhengjq on 2017/3/28.
 */
public class PersonTest {
    public static void main(String[] args)
    {
        Person[] people=new Person[2];
        people[0]=new Student("ssss");
        people[1]=new Teacher("5");
        for(Person a:people)
        {
            a.getDescription();
            System.out.println(a.getName());
            if(a instanceof Student)
            {
             ((Student) a).say();
            }
        }
    }
}
