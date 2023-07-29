package learning_2.week_15;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueTest {
    public static void main(String[] args) {
        testConcurrentLinkedQueue();
    }

    private static void testConcurrentLinkedQueue() {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer("1");
        Object poll = queue.poll();
        Object value = queue.peek();
        System.out.println(value);
    }
}
