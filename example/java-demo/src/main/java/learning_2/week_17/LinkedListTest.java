package learning_2.week_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class LinkedListTest {
    public static void main(String[] args) {
        // test();

        Map<Long, Integer> map = new HashMap<>();
        map.put(10L, 1);
        long i = 10L;
        System.out.println(map.get(i));
    }

    private static void test() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);
        IntStream.range(0, 30).forEach(x -> queue.offer(x));
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            try {
                Thread.sleep(1000);
                System.out.println(queue.poll());
            } catch (Exception e) {

            }
        }
        System.out.println("end...");
    }
}
