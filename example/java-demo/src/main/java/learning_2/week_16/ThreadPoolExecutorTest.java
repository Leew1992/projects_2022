package learning_2.week_16;

import com.google.common.util.concurrent.RateLimiter;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTest {

    private static ThreadPoolExecutor threadPoolExecutor;
    private static RateLimiter clientRateLimiter = RateLimiter.create(100);
    private static RateLimiter serverRateLimiter = RateLimiter.create(100);
    private static OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private static volatile Integer total = 99;
    private static volatile AtomicInteger totalAtomic = new AtomicInteger(99);
    private static final Integer count = 100;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        // testClientRateLimit();
        testClientRateLimit();
    }

    // 创建线程池
    private static void initThreadPoolExecutor() {
        // int coreCount = Runtime.getRuntime().availableProcessors(); 2*coreCount ~ 5*coreCount
        threadPoolExecutor = new ThreadPoolExecutor(10, 50
                , 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(60));
    }

    // 客户端并发
    private static void testClientConcurrency() {
        initThreadPoolExecutor();
        // 1000个线程并发
        IntStream.range(0, 1000).forEach(x -> threadPoolExecutor.execute(() -> serverMethod()));
        threadPoolExecutor.shutdown();
    }

    // 客户端突发限流
    private static void testClientRateLimit() {
        initThreadPoolExecutor();
        Timer timer = new Timer();
        // schedule 如果指定的startDate过期，会立即执行一次，并以当前为开始时间，重新计算下一次。
        // scheduleAtFixRate 如果指定的startDate过期，会补全之前缺少的执行次数，仍按之前计算来。
        timer.schedule(new TimerTask1(100), 0, 1000);
        try {
            latch.await();
        } catch (Exception e) {

        } finally {
            timer.cancel();
            threadPoolExecutor.shutdown();
        }
    }

    // 客户端平滑限流
    private static void testClientRateLimit1() {
        initThreadPoolExecutor();
        while (totalAtomic.intValue() > 0) {
            clientRateLimiter.acquire();
            threadPoolExecutor.execute(() -> serverMethod());
            totalAtomic.decrementAndGet();
        }
        threadPoolExecutor.shutdown();
    }

    // 服务端限流，100/1s
    private static void serverMethod() {
        double acquire = serverRateLimiter.acquire();
        System.out.println(new SimpleDateFormat("hh:mm:ss.SSS").format(new Date()) + "_" + acquire + "_" + Thread.currentThread().getName());
    }

    private static void clientPerHundred(int count) {
        IntStream.range(0, count).forEach(x -> threadPoolExecutor.execute(() -> serverMethod()));
    }

    static class TimerTask1 extends TimerTask {
        private int runCount;

        TimerTask1(int count) {
            this.runCount = count;
        }

        @Override
        public void run() {
            int count = total > runCount ? runCount : total;
            total = total - count;
            clientPerHundred(count);
            System.out.println("timer:" + new SimpleDateFormat("hh:mm:ss.SSS").format(new Date()) + "_" + total);
            if (total <= 0) {
                latch.countDown();
            }
        }
    }

}
