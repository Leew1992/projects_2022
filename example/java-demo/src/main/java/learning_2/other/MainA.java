package learning_2.other;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MainA {
    public static void main(String[] args) {
/*        ObjectA a1 = new ObjectA();
        ObjectA a2 = new ObjectA();

        System.out.println(a1);
        System.out.println(a2);

        System.out.println();

        System.out.println(a1.innerA);
        System.out.println(a2.innerA);

        System.out.println();

        System.out.println(OuterA.var);*/

        /*String s1 = "abc";
        String ss = "abc";
        String s2 = new String("abc");

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(ss));
        System.out.println(s1 == ss);
        System.out.println(System.identityHashCode(s2));

        System.out.println(s1 == s2);*/

        /*String aa = "a";
        String bb = "bc";

        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String("abc");
        String s4 = "a" + new String("bc");
        String s5 = "a" + "bc";
        String s6 = new String(s4);
        String s7 = aa + bb;
        System.out.println(s1 == s5);
        System.out.println(s7 == s7.intern());

        new StringBuilder("abc").toString();*/

        /*Integer a = new Integer(127); // 堆上分配
        Integer b = new Integer(127); // 堆上分配
        Integer c = 127; // 常量池

        System.out.println(a == b);
        System.out.println(b == c);*/

        /*User user = new User();
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getAgeObj());

        try (FileInputStream fis = new FileInputStream(new File("D:/111.txt"));
             BufferedInputStream bis = new BufferedInputStream(fis)) {

        } catch (Exception e) {

        }*/

        /*User user = new User();
        user.setAge(10);
        user.setAgeObj(20);
        user.setTrans(1);
        user.setName("张三");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/111.java")))) {
            oos.writeObject(user);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/111.java")))) {
            User userObj = (User) ois.readObject();
            System.out.println(userObj);
        } catch (Exception e) {

        }*/

        /*try {
            Class<?> aClass = Class.forName("com.example.demo.other.User");
            Object aObject = aClass.newInstance();
            Method method = aClass.getDeclaredMethod("getAge");
            method.setAccessible(true);
            Object result = method.invoke(aObject);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.forEach(x -> {
            System.out.println(x);
            list.remove("b");
        });*/

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if ("b".equals(next)) {
                iterator.remove();
            }
        }*/

        /*List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list.forEach(x -> {
            System.out.println(x);
            if (x.equals("4")) {
                list.remove(x);
            }
        });*/

        /*for (String item : list) {
            System.out.println(item);
            if (item.equals("4")) {
                list.remove(item);
            }
        }*/

        /*LinkedList<Object> objects = new LinkedList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);

        for (Object object : objects) {
            System.out.println(object);
        }*/

        /*String arr[] = new String[2];
        arr[0] = "a";
        arr[1] = "b";

        List<String> list = Arrays.asList(arr);
        System.out.println(list);

        List<String> list1 = new ArrayList<>();
        list1.add("a");

        System.out.println(list1);*/

        /*LinkedList ll = new LinkedList();
        ll.add("1");
        ll.get(1);*/

        /*ArrayList<Object> list = new ArrayList<>(1);
        list.add(0, 1);
        list.add(1, 1);*/

        /*System.out.println(7 >> 1);
        System.out.println(6 >> 1);*/

        /*HashMap<String, String> map = new HashMap<>(2);
        map.put("b", "b");
        map.put("d", "b");

        HashMap<String, String> map1 = new HashMap<>();
        map1.putAll(map);*/

        ConcurrentHashMap map = new ConcurrentHashMap(2);
        map.put("b", "b");
        map.put("d", "d");
    }

}
