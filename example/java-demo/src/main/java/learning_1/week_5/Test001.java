package learning_1.week_5;

import learning_1.week_4.UserObj;

import java.util.*;
import java.util.stream.Collectors;

public class Test001 {

    public static void main(String[] args) {

        /*Calendar birth = Calendar.getInstance();
        birth.set(1975, Calendar.MAY, 26);
        Calendar now = Calendar.getInstance();
        System.out.println(daysBetween(birth, now));
        System.out.println(daysBetween(birth, now));*/

        // test();

        sortUser();

    }

    private static void bytetest() {
        String s = "一"; // Unicode编码:4E00
        String s1 = "龥"; // Unicode编码:9FA5
        //?是汉字扩展字符,占两个字符，也就是两个char，也就是4字节，也就是32位
        String s2 = "?";//Unicode编码:20000
        System.err.println("测试字符s:" + s);
        System.err.println("测试字符s2:" + s2);
        System.err.println("测试字符s长度:" +s.length());
        System.err.println("测试字符s2长度:" +s2.toCharArray().length);
        System.out.println("s转为二进制-:" + Integer.toBinaryString(s.charAt(0)));
        System.out.println("s2转为二进制-:" + Integer.toBinaryString(s2.charAt(0)) + "-" + Integer.toBinaryString(s2.charAt(1)));
    }

    private static long daysBetween(Calendar begin, Calendar end) {
        long daysBetween = 0;
        while (begin.before(end)) {
            begin.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween ++;
        }
        return daysBetween;
    }

    // 对象序列化到文件
    private static void sortUser() {
        Map<Integer, UserObj> objs = new HashMap<>();
        objs.put(1, new UserObj("a", 1));
        objs.put(3, new UserObj("c", 3));
        objs.put(2, new UserObj("b", 2));

        List<Integer> ages = objs.values().stream().map(x -> x.getAge())
                .sorted(Comparator.comparing(Integer::intValue).reversed()).distinct().collect(Collectors.toList());
        Map objss = new LinkedHashMap();
        for (Integer age : ages) {
            objs.forEach((x, y) -> {
                if (y.getAge() == age.intValue()) {
                    objss.put(x, y);
                }
            });
        }

        System.out.println(Objects.toString(objss));


        Set<Map.Entry<Integer, UserObj>> entrySet = objs.entrySet();

        List<Map.Entry<Integer, UserObj>> list = new ArrayList<>(entrySet);

        Collections.sort(list, (Map.Entry<Integer, UserObj> o1, Map.Entry<Integer, UserObj> o2) -> {
            return o2.getValue().getAge() - o1.getValue().getAge();
        });

        LinkedHashMap<Integer, UserObj> linkedHashMap = new LinkedHashMap<Integer, UserObj>();

        for (Map.Entry<Integer, UserObj> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(Objects.toString(linkedHashMap));

        Collections.synchronizedList(new ArrayList<>());
    }
}
