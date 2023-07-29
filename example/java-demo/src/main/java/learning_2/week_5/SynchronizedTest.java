package learning_2.week_5;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class SynchronizedTest {

    // 挨个拿，没有同时使用
    private static int sum = 0;

    public static void main(String[] args) throws Exception {

        Thread[] threads = new Thread[100];
        Object obj = new Object();
        CountDownLatch latch = new CountDownLatch(threads.length);


        for (int i = 0; i < 100; i ++) {
            threads[i] = new Thread(() -> {
                synchronized (obj) {
                    for (int j = 0; j < 10000; j ++) {
                        sum ++;
                    }
                    System.out.println(sum);
                    latch.countDown();                }
            });
        }

        Arrays.asList(threads).forEach((t) -> t.start());

        latch.await();

        System.out.println(sum);
    }
}
