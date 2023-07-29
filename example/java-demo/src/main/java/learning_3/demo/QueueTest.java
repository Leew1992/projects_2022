package learning_3.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class QueueTest {
    public static void main(String[] args) {
        testMultiThreads();
    }

    private static void testMultiThreads() {
        ArrayBlockingQueue objects = new ArrayBlockingQueue(3);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        IntStream.range(1, 9).forEach(x -> {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    if (objects.poll() != null) {
                        System.out.println("success");
                    } else {
                        System.out.println("failure");
                    }
                } catch (Exception e) {

                }
                System.out.println(x + " : ");
            }).start();
        });
    }
}
