package learning_2.week_12;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    public static void main(String[] args) throws Exception {
//        testTimer();
        testScheduledThreadPoolExecutor();
    }

    public static void testTimer() throws Exception {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        timer.schedule(task, delay);
    }

    public static void testScheduledThreadPoolExecutor() throws Exception {
        // 示例代码：
        TimerTask repeatedTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        TimerTask repeatedTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间1: " + new Date() + "n" +
                        "线程名称1: " + Thread.currentThread().getName());
            }
        };
        TimerTask repeatedTask2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间2: " + new Date() + "n" +
                        "线程名称2: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long delay  = 1000L;
        long period = 1000L;
        executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(repeatedTask1, delay, period, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(repeatedTask2, delay, period, TimeUnit.MILLISECONDS);
        Thread.sleep(delay + period * 5);
        executor.shutdown();
    }
}
