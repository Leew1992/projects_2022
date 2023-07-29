package learning_1.week_21;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        System.out.println(map.size());
        System.out.println(map.mappingCount());
    }
}
