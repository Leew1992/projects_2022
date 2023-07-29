package learning_1.week_6;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    static int corePoolSize = 5; // 池中保存的线程数
    static int maxPoolSize = 10; // 池中允许的最大线程数
    static long keepAliveTime = 5000; // 线程大于核心时，多余的空闲线程等待新任务的最长时间

    public static void main(String[] args) {
        // testScheduledPoolExecutor();
        // testScheduledPool();

        testAtFixedDelay();
        testWithFixedDelay();
    }

    static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // test ThreadPoolExecutor
    public static void testScheduledPoolExecutor() {
        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MICROSECONDS,
                        new LinkedBlockingQueue<Runnable>()
                );
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        threadPoolExecutor.shutdown();
    }

    // test ScheduledExecutorService
    public static void testScheduledPool() {
        ScheduledFuture scheduledFuture =
        scheduledExecutorService.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "Called!";
            }
        },
        5,
         TimeUnit.SECONDS);
        try {
            System.out.println(scheduledFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

    public static void testAtFixedDelay() {
        try {
            executor.scheduleAtFixedRate(() -> {
                System.out.println("at===");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, 1000, 3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testWithFixedDelay() {
        try {
            executor.scheduleWithFixedDelay(() -> {
                System.out.println("with===");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, 1000, 3000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
