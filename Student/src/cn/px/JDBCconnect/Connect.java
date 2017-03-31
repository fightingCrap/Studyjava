package cn.px.JDBCconnect;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

/**
 * Created by zhengjq on 2017/3/27.
 */
/*
* MongoDB的链接库
* 主要功能有着插入，删除，修改，查询4个功能，正对不同的环境运用不同的函数
* */
public class Connect {
    //Mongodb的插入操作函数，只是简单的插入
    //插入单个文件，如果有需要多个插入传入list
    public boolean save(Document person){
       //由于id有着唯一性主键，所以插入的时候一旦是重复的，就会报出异常
        try{
            dbCollection.insertOne(person);
            System.out.println("插入成功");
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean save(List<Document> personLists){
        //由于id有着唯一性主键，所以插入的时候一旦是重复的，就会报出异常
        try{
            dbCollection.insertMany(personLists);
            System.out.println("插入成功");
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //Mongodb的删除函数，指定特定的一个输入选项进行删除。
    public boolean remove(String targetDocument,String value){
       try{
           dbCollection.deleteOne(Filters.eq(targetDocument,value));

           System.out.println("删除成功");
           return true;
       }catch (Exception e)
       {
           e.printStackTrace();
           return false;
       }
    }
    public boolean remove(Document targetDocument){
        try{
            dbCollection.deleteOne(targetDocument);

            System.out.println("删除成功");
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //Mongodb的修改函数，针对不同情况对函数进行选择,
    //更新特定的一个
    public boolean updata(Document targetDocument,Document updataDocument){ //targetDocument指的是查找条件，updataDocument指的是更新的内容
        try {
            dbCollection.updateOne(targetDocument, updataDocument);
            System.out.println("更新成功");
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updata(String targetDocument,String value,Document updataDocument){ //targetDocument指的是查找条件，updataDocument指的是更新的内容
        try {
            Document a=new Document();
            a.append(targetDocument,value);
            dbCollection.replaceOne(a, updataDocument);
            System.out.println("更新成功");
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    //Mongodb的查询函数，通过不同的场景进行查询，选择是查询单个还是某一特定的情况。
    //查找全部的内容
    public FindIterable<Document> findall(){

        return dbCollection.find();
    }
    public FindIterable<Document> find(Document targetDocument){
        try{
            return dbCollection.find(targetDocument);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public FindIterable<Document> find(String targetDocument,String value){
        try{
            return dbCollection.find(new Document().append(targetDocument,value));
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    //构造函数
 public Connect(){
     try {
         connect = new MongoClient("localhost", 27017);
         db = connect.getDatabase("px_student");
         dbCollection = db.getCollection("student");
     }catch (Exception e)
     {
         e.printStackTrace();
     }
    }
 //有参构造函数
 public Connect(String ip,int port,String databaseName,String collection) {
     try {
         connect = new MongoClient(ip, port);
         db = connect.getDatabase(databaseName);
         dbCollection = db.getCollection(collection);
     }catch(Exception e)
     {
         e.printStackTrace();
     }
 }
    //链接Mongodb
    private MongoClient connect;
    //链接Mongodb的数据库
    private MongoDatabase db;
    //链接Mongodb的集合，即表格
    private MongoCollection<Document> dbCollection;
}
