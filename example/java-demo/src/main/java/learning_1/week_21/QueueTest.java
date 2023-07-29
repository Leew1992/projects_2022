package learning_1.week_21;

import java.util.concurrent.SynchronousQueue;

/**
 * 有界阻塞队列：
 * ArrayBlockingQueue（数组、ReentrantLock）
 * 配对队列：
 * SynchronousQueue（公平模式、CAS）
 * 无界阻塞队列：
 * LinkedBlockingQueue（单向链表、ReentrantLock）
 * LinkedBlockingDeque（双向链表、ReentrantLock）
 * PriorityBlockingQueue（优先级、ReentrantLock）
 * DelayQueue（延时、ReentrantLock）
 * 无界无阻塞队列：
 * LinkedTransferQueue（单向链表、CAS、默认无阻塞、支持定时阻塞）
 * ConcurrentLinkedQueue（单向链表、CAS、无阻塞）
 */
public class QueueTest {
    public static void main(String[] args) throws Exception {
        SynchronousQueue queue = new SynchronousQueue();
        queue.put("2");
    }
}
