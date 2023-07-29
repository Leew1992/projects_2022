package learning_2.week_18;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列，也叫配对队列
 * 不存储元素，每一个put操作，必须等待一个take操作，否则不能添加元素。
 */
public class SynchronousQueueTest {
    static SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
    public static void main(String[] args) throws Exception {
        synchronousQueue.put("1");
        /*new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t 入队列 1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t 入队列 2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t 入队列 3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAAAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t 出队列 " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t 出队列 " + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t 出队列 " + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBBBB").start();*/
    }
}
