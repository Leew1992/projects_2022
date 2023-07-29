package org.example.demo.document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.Iterator;
import org.bson.Document;
import org.example.demo.collection.SelectingCollection;

public class DeletingDocuments {

    public static void main( String args[] ) {
        // 检索集合
        MongoCollection<Document> collection = SelectingCollection.select("tutorial");
        System.out.println("成功选择了集合 tutorial");
        // 删除文档
        collection.deleteOne(Filters.eq("title", "html"));
        System.out.println("文档删除成功...");

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
