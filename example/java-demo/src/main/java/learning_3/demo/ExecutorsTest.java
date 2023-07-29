package learning_3.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTest {

    private static final ExecutorService executorService;

    static {
        executorService = Executors.newFixedThreadPool(2);
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 2; i ++) {
            Future<?> future = executorService.submit(() -> {
                try {
                    test();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            futureList.add(future);
        }
        for (Future future : futureList) {
            future.get();
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void test() throws Exception {
        Thread.sleep(100);
    }
}
