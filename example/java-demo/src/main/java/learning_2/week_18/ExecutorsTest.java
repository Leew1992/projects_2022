package learning_2.week_18;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;

public class ExecutorsTest {
    private static DelayQueue delayQueue  = new DelayQueue();

    public static void main(String[] args) throws InterruptedException {
        // 线程数固定，任务队列最大Integer.MAX_VALUE
        // 当任务数过多，可能会导致OOM异常
        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();

        // 线程数最大Integer.MAX_VALUE，任务队列最大Integer.MAX_VALUE
        // 当线程数过多，可能会导致OOM异常
        // 创建一个线程，默认消耗1M的内存
        Executors.newCachedThreadPool();
        Executors.newSingleThreadScheduledExecutor();

        new Thread(() -> {
            delayQueue.offer(new MyDelayedTask("task1", 10000));
            delayQueue.offer(new MyDelayedTask("task2", 3900));
            delayQueue.offer(new MyDelayedTask("task3", 1900));
            delayQueue.offer(new MyDelayedTask("task4", 5900));
            delayQueue.offer(new MyDelayedTask("task5", 6900));
            delayQueue.offer(new MyDelayedTask("task6", 7900));
            delayQueue.offer(new MyDelayedTask("task7", 4900));
        }).start();

        while (true) {
            Delayed take = delayQueue.take();
            System.out.println(take);
            if (delayQueue.size() == 0) {
                break;
            }
        }
    }
}
