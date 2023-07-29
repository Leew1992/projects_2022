package learning_3.week_3;

import com.google.common.collect.Lists;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        test3();
    }

    private static void test() {
        System.out.println(Objects.equals(null, null));
    }

    private static void test2() {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);
    }

    private static void test3() {
        Map<Object, Object> map = new HashMap<>();
        map.put("a", "1");
        System.out.println(map.size());

        // 转iterator，map的get 两步操作，效率较低
        Iterator<Object> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(map.get(key));
        }

        // 推荐JDK7及以下版本
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        // 推荐JDK8及以上版本
        map.forEach((k, v) -> {
            System.out.println(k + ", " + v);
        });
    }

    private static void test4() {
        ArrayList<String> strings = Lists.newArrayList("a", "b", "c");
    }


}
