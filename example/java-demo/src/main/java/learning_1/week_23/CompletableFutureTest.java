package learning_1.week_23;

import com.google.common.util.concurrent.RateLimiter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        // testAllOf();
        testParallelStream();
    }

    private static void testParallelStream() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            numbers.add(i);
        }
        long start = System.currentTimeMillis();
        RateLimiter rateLimiter = RateLimiter.create(10);
        numbers.parallelStream().forEach(x -> {
            rateLimiter.acquire();
            System.out.println(x);
        });
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void testAllOf() throws Exception {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> test());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> test());
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> test());
        long start = System.currentTimeMillis();
        CompletableFuture.allOf(future1, future2, future3).whenComplete((x,y) -> {
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }).get();
    }

    private static void test() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }
}
