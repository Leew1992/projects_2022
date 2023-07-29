package org.example.demo.collection;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
public class DropingCollection {

    public static void main( String args[] ) {
        // 检索集合
        MongoCollection<Document> collection = SelectingCollection.select("tutorial");
        // 删除集合
        collection.drop();
        System.out.println("集合删除成功");
    }
}