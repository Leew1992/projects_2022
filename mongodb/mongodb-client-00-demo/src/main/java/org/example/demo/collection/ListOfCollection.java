package org.example.demo.collection;

import com.mongodb.client.MongoDatabase;
import org.example.demo.db.ConnectToDB;

public class ListOfCollection {

    public static void main( String args[] ) {
        MongoDatabase database = ConnectToDB.connect();
        System.out.println("集合创建成功");
        for (String name : database.listCollectionNames()) {
            System.out.println(name);
        }
    }
}