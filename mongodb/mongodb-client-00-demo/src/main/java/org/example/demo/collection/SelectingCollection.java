package org.example.demo.collection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.demo.db.ConnectToDB;

public class SelectingCollection {

    public static void main(String[] args) {
        MongoCollection<Document> tutorial = select("tutorial");
        System.out.println("集合选择成功");
    }

    public static MongoCollection<Document> select(String collectionName) {
        // 访问数据库
        MongoDatabase database = ConnectToDB.connect();
        // 检索集合
        return database.getCollection(collectionName);
    }
}
