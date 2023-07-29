package org.example.demo.document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.Iterator;
import org.bson.Document;
import org.example.demo.collection.SelectingCollection;

public class UpdatingDocuments {

    public static void main( String args[] ) {
        // 检索集合
        MongoCollection<Document> collection = SelectingCollection.select("tutorial");
        System.out.println("成功选择了集合 tutorial");
        collection.updateOne(Filters.eq("title", "MongoDB"), Updates.set("likes", 150));
        System.out.println("文档更新成功...");

        // 更新后检索文档
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