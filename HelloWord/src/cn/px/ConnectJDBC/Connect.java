package cn.px.ConnectJDBC;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengjq on 2017/3/26.
 */
public class Connect {
    private MongoClient connect;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    public Connect(){
        try {
            //通过端口链接mongodb
            connect = new MongoClient("localhost",27017);
            System.out.println("链接mongodb成功");
            db=connect.getDatabase("test");
            //链接数据库
            System.out.println("链接mongodb数据库成功");
            collection = db.getCollection("user");
            //链接对应的集合
            System.out.println("链接mongodb集合成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Connect(String databaseName,String collectionBase){
        try {
            connect = new MongoClient("localhost",27017);
            System.out.println("链接mongodb成功");
            db=connect.getDatabase(databaseName);
            System.out.println("链接mongodb数据库成功");
            collection = db.getCollection(collectionBase);
            System.out.println("链接mongodb集合成功");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //插入函数
    public boolean insert(Document document){
        //通过已经链接好的集合集，插入相应的新的文档,
        try {
//        List<Document> documentsList=new ArrayList<Document>();
//        documentsList.add(document);
            collection.insertOne(document);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean insert(List<Document> documentsList){
        //通过已经链接好的集合集，插入相应的新的文档集合,
        try {
            collection.insertMany(documentsList);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public FindIterable<Document> find(){
        //暂时查找全部数据
       return collection.find();
    }
    public boolean update( String oldFieldName,String oldvalue,String newFieldName,String newValue){
        try {
            //指定刷新目标和原来的值，相当于where oldFieldName=oldvalue,找到后变为新的
            collection.updateMany(Filters.eq(oldFieldName, oldvalue), new Document("$set", new Document(newFieldName, newValue)));
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean remove(String deleteFieldName,String value){
        try {
            collection.deleteOne(Filters.eq(deleteFieldName, value));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
