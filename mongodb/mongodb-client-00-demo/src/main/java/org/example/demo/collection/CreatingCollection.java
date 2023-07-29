package org.example.demo.collection;

import com.mongodb.client.MongoDatabase;
import org.example.demo.db.ConnectToDB;

public class CreatingCollection {

    public static void main( String args[] ) {
        // 访问数据库
        MongoDatabase database = ConnectToDB.connect();

        // 创建集合
        database.createCollection("tutorial");
        System.out.println("集合创建成功");
    }
}