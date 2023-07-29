package org.example.demo.db;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
public class ConnectToDB {

    public static void main( String args[] ) {
        connect();
    }

    public static MongoDatabase connect() {
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("test", "test", "test".toCharArray());
        System.out.println("Connected to the database successfully");
        System.out.println("Credentials ::"+ credential);
        // 访问数据库
        return mongo.getDatabase("test");
    }
}