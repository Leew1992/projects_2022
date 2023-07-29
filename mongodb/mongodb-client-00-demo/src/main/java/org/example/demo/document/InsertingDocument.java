package org.example.demo.document;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.demo.collection.SelectingCollection;

public class InsertingDocument {

    public static void main(String args[]) {
        // 检索集合
        MongoCollection<Document> collection = SelectingCollection.select("tutorial");
        System.out.println("集合选择成功");
        Document document = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://org.example/mongodb/")
                .append("by", "测试");

        // 将文档插入到集合中
        collection.insertOne(document);
        System.out.println("文档插入成功");
    }
}