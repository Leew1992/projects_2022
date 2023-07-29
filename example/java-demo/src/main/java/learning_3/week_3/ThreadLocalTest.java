package learning_3.week_3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class ThreadLocalTest {
    // 线程安全
    private static final ThreadLocal<DateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private static void test() {
        // 简单的日期对象
        System.out.println("--------简单的日期对象--------");
        // old
        Date date = new Date();
        System.out.println(date);
        // JDK8
        Instant now = Instant.now();
        System.out.println(now);

        // 支持日期的增减
        System.out.println("--------支持日期的增减--------");
        // old
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 1);
        System.out.println(instance.getTime());
        // JDK8
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime res = localDateTime.plusYears(1);
        System.out.println(res);

        // 支持日期格式化
        // old
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));
        // JDK8
        String format = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(res);
        System.out.println(format);
    }

    private static void test2() {
        try {
            DateFormat dateFormat1 = dateFormat.get();
            String format = dateFormat1.format(new Date());
            System.out.println(format);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dateFormat.remove();
        }
    }

    private static volatile ThreadLocal<LongAdder> threadLocal = new ThreadLocal();
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);
    private static void test4() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 3, TimeUnit.SECONDS, blockingQueue);
        threadPoolExecutor.execute(() -> {
            increment();
            countDownLatch.countDown();
        });
        threadPoolExecutor.execute(() -> {
            increment();
            countDownLatch.countDown();
        });
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!threadPoolExecutor.isShutdown()) {
                threadPoolExecutor.shutdown();
            }
        }
    }

    private static void increment() {
        LongAdder longAdder = threadLocal.get();
        if (longAdder == null) {
            longAdder = new LongAdder();
        }
        longAdder.increment();
        threadLocal.set(longAdder);
        System.out.println(longAdder.longValue());
    }

    public static void main(String[] args) {
        // test();
        test4();
    }
}
