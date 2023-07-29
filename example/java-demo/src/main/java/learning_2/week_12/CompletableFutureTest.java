package learning_2.week_12;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureTest {

    private static int count = 0;

    public static void main(String[] args) throws Exception {
        forTest();
    }

    public static void allOfTest() throws Exception {
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> testSleep());
            CompletableFuture<String> future1 = future.whenComplete((x, y) -> System.out.println(Thread.currentThread().getName() + ",response:" + x));
            futureList.add(future1);
        }
        // 并行执行
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[futureList.size()])).join();
        System.out.println("execute finish");
    }

    public static void streamTest() throws Exception {
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> testSleep());
            CompletableFuture<String> future1 = future.whenComplete((x, y) -> System.out.println(Thread.currentThread().getName() + ",response:" + x));
            futureList.add(future1);
        }
        // 并行执行
        List<String> result = futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(result);
    }

    // 线程池中有三个线程，轮询处理 future 任务，且会阻塞主线程。
    public static void forTest() throws Exception {
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> testSleep());
            CompletableFuture<String> future1 = future.whenComplete((x, y) -> System.out.println(Thread.currentThread().getName() + ",response:" + x));
            futureList.add(future1);
        }
        // 并行执行
        for (CompletableFuture<String> future : futureList) {
            future.join();
        }
    }

    public static void intStreamTest() {
        long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, 8)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> testSleep())
                        .whenComplete((x, y) -> System.out.println(Thread.currentThread().getName() + ",response:" + x)))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start);
    }

    private static String testSleep() {
        try {
            Thread.sleep(100);
            System.out.println(count ++);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
}
