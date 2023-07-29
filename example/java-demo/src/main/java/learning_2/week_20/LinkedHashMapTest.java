package learning_2.week_20;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        System.out.println(map.get("a"));
        System.out.println(map);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }
}
