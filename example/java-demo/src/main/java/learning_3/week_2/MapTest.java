package learning_3.week_2;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {
        // testConcurrentHashMap();
        // testHashMap();
        testHashtable();
    }

    private static void testHashMap() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map);
    }

    private static void testHashtable() {
        Hashtable<Object, Object> map = new Hashtable<>();
        map.put(null, "a");
        System.out.println(map);
    }

    private static void testConcurrentHashMap() {
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>(4);
        Object put = map.put("a", "a");
        System.out.println(put);
    }
}
