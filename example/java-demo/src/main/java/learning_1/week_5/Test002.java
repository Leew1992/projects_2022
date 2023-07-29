package learning_1.week_5;

import java.util.*;
import java.util.stream.Stream;

public class Test002 {
    public static final int N = 50000;
    public static List values;

    /*static {
        Integer vals[] = new Integer[N];
        for (int i = 0; i < N; i ++) {
            vals[i] = i;
        }
        values = Arrays.asList(vals);
    }*/

    static long timeList(List lst) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i ++) {
            int index = Collections.binarySearch(lst, values.get(i));
            if (index != i) {
                System.out.println("error");
            }
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        // System.out.println("consume times: " + timeList(new ArrayList(values)));
        // System.out.println("consume times: " + timeList(new LinkedList(values)));

        Queue<String> queue = new LinkedList<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");

        for (String s : queue) {
            System.out.println(s);
        }

        Queue<String> queue2 = new LinkedList<>();
        queue2.offer("1");
        queue2.offer("2");
        queue2.offer("3");
        queue2.offer("4");
        queue2.offer("5");

        for (String s : queue2) {
            System.out.println(s);
        }
    }
}
