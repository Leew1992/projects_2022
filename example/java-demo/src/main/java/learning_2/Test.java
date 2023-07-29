package learning_2;

import javafx.concurrent.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) throws Exception {
        /*ThreadLocal<String> local = new ThreadLocal<>();
        ThreadLocal<Integer> IntLocal = new ThreadLocal<>();

//        IntStream.range(0, 5).forEach(a -> new Thread(() -> {
//            local.set(a + "   " + a);
//            System.out.println(local.get());
//        }).start());

        new Thread(() -> {
           local.set("aa");
           IntLocal.set(1);
           System.out.println(local.get());
           System.out.println(IntLocal.get());
        }).start();

        List<String> aa = new ArrayList<>();
        aa.add(null);*/

        /*LinkedHashMap map = new LinkedHashMap();

        map.put("a", "a");

        map.remove("a");

        map.get(1);

        TreeMap tMap = new TreeMap();
        tMap.put("", "");

        tMap.remove("");*/


        /*TreeSet set = new TreeSet();
        set.add(5);
        set.add(1);
        set.add(2);

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Object obj = new Object();
        synchronized (obj) {

        }

        CountDownLatch latch = new CountDownLatch(5);
        latch.countDown();

        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*Map map = new HashMap();
        map.put("aa", null);

        map.put(null, null);*/

        /**
         * Thread 是一个载体
         * Runnable 是具体实现
         */
        // runnable
//        new Thread(() -> System.out.println("ok")).start();

        /**
         * 实现了Runnable接口，重写了run方法，执行 callable.call 产生返回值
         * 实现了Feature接口，通过get方法，获取返回值
         */
        // callable & feature
        /*FutureTask task = new FutureTask(() -> "aa");
        new Thread(task).start();
        System.out.println(task.get());*/

        /**
         * thenAccept 可以设置结果回调函数
         * exceptionaly 可以设置异常处理
         */
        // thenAccept
        /*CompletableFuture<Object> feature = CompletableFuture.supplyAsync(() -> "bb");
        feature.thenAccept((result) -> System.out.println("ok")); // 回调函数
        System.out.println(feature.get());*/

        // exceptionally
        /*CompletableFuture<Integer> feature1 = CompletableFuture.supplyAsync(() -> {
            int i = 4 / 0;
            return i;
        });
        feature1 = feature1.exceptionally((result) -> {
            System.out.println(result.getMessage());
            return -1;
        });
        System.out.println(feature1.get());*/

        // complete
        /*CompletableFuture<Object> feature2 = CompletableFuture.supplyAsync(() -> "cc");
        feature2.complete("123");
        // complete完成-回调处理
        feature2.whenComplete((x, y) -> System.out.println("whenComplete"));
        feature2.thenAccept((x) -> System.out.println(x));
        // 额外处理-可以改写结果
        CompletableFuture<String> feature3 = feature2.handle((x, y) -> "456");
        System.out.println(feature3.get());*/


        /**
         * 用于对多个CompletableFeature并行处理
         */
        // anyof, allof
        /*CompletableFuture<String> feature4 = CompletableFuture.supplyAsync(() -> "dd");
        CompletableFuture<String> feature5 = CompletableFuture.supplyAsync(() -> "ee");
        CompletableFuture<Object> anyFeature = CompletableFuture.anyOf(feature4, feature5);
        System.out.println(anyFeature.get());

        CompletableFuture<Void> allFeature = CompletableFuture.allOf(feature4, feature5);
        allFeature.whenComplete((x, y) -> System.out.println("all complete"));*/

        /**
         * 拆成多个子任务，执行完后再重组成一个结果
         * 基于“分治”的算法
         * RecursiveTask - 有返回值
         * RecursiveAction - 没有返回值
         */
        // fork/join
        /*SumTask sumTask = new SumTask(0, 1000);
        Long result = ForkJoinPool.commonPool().invoke(sumTask);
        System.out.println(result);*/

        /**
         * 线程的局部变量
         */
        // threadLocal
        ThreadLocal threadLocal = new ThreadLocal();
        try {
            threadLocal.set("aa");
            System.out.println(threadLocal.get());
        } finally {
            threadLocal.remove();
        }

    }

    final static int THRESHOLD = 50;
    static class SumTask extends RecursiveTask<Long> {
        private int start;
        private int end;

        SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long total = 0;
                for (int i = start; i < end; i ++) {
                    total = total + i;
                }
                return total;
            }
            int mid = (start + end) / 2;
            System.out.println("mid: " + mid);
            SumTask task1 = new SumTask(start, mid);
            SumTask task2 = new SumTask(mid, end);
            invokeAll(task1, task2);
            Long result1 = task1.join();
            Long result2 = task2.join();
            return result1 + result2;
        }
    }
}
