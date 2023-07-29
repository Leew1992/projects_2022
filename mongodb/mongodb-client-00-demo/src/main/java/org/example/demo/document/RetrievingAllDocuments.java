package org.example.demo.document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.example.demo.collection.SelectingCollection;

public class RetrievingAllDocuments {
    public static void main( String args[] ) {
        // 检索集合
        MongoCollection<Document> collection = SelectingCollection.select("tutorial");
        System.out.println("成功选择了集合 tutorial");
        Document document1 = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.biancheng.net/mongodb/")
                .append("by", "编程帮");
        Document document2 = new Document("title", "html")
                .append("description", "database")
                .append("likes", 200)
                .append("url", "http://www.biancheng.net/html/")
                .append("by", "编程帮");
        List<Document> list = new ArrayList<Document>();
        list.add(document1);
        list.add(document2);
        collection.insertMany(list);
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // 获取迭代器
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }
}