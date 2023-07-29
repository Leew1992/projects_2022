package learning_1.week_24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ConcurrentTest {

    private static final ExecutorService executorService;

    static {
         executorService = Executors.newCachedThreadPool();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("CPU核心数：" + Runtime.getRuntime().availableProcessors());
        testParallWithTime();
    }

    private static void testExecutorsWithTime() throws Exception {
        long start = System.currentTimeMillis();
        testExecutors();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void testExecutors() throws Exception {
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 50; i ++) {
            Future<?> future = executorService.submit(() -> testSleep());
            futureList.add(future);
        }
        for (Future future : futureList) {
            future.get();
        }
    }

    private static void testParallWithTime() {
        long start = System.currentTimeMillis();
        testParall();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    // 默认电脑的核心数
    private static void testParall() {
        IntStream.range(0, 4).parallel().forEach(x -> {
            // System.out.println(x);
            testSleep();
        });
    }

    private static void testSleep() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
    }
}
