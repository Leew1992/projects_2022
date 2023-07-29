package learning_3.demo;

import java.util.LinkedHashMap;

public class JavaDemo {
    public static void main(String[] args) throws Exception {
        // System.out.println(testFinally());
//        BigInteger bigInteger = new BigInteger("43242342343242");
//        System.out.println(bigInteger);
//
//        ConcurrentHashMap map = new ConcurrentHashMap();
//        map.put(null, null);

//        String key = "1230000";
//        System.out.println(key.hashCode());
//        System.out.println(key.hashCode() >>> 0);

        // Collectors.toMap 如果value为null，则会抛出NPE异常。
//        User user = new User(null, 12);
//        List<User> userList = new ArrayList<>();
//        userList.add(user);
//        Map<String, Integer> collect = userList.stream().collect(Collectors.toMap(User::getName, User::getAge));
//        System.out.println(collect);

//        List<String> list = new ArrayList<>();
//        list.add("aa");
//        list.add("bb");
//        String[] strings = list.toArray(new String[0]);
//        System.out.println(strings.length);

        LinkedHashMap linkedHashMap = new LinkedHashMap(4, 0.75f, false);
        linkedHashMap.put("a", 1);
        linkedHashMap.put("b", 2);
        linkedHashMap.put("c", 3);
        linkedHashMap.put("d", 4);

        System.out.println(linkedHashMap);

        linkedHashMap.get("b");

        System.out.println(linkedHashMap);

        linkedHashMap.put("e", 5);

        System.out.println(linkedHashMap);
    }

    private static int testFinally() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("error");
            return 2;
        }
    }

    private static void testThread() {
        Thread ta = new Thread(() -> {
            boolean interrupted = Thread.interrupted();
            System.out.println(interrupted);
            interrupted = Thread.interrupted();
            System.out.println(interrupted);
            testJoin1();
        });
        ta.start();
        ta.interrupt();
        System.out.println(ta.isInterrupted());
        System.out.println("main");
    }

    private static void testJoin1() {
        System.out.println("join1");
    }

    private static void testJoin2() {
        System.out.println("join2");
    }

    public void testRedission() {

    }
}
