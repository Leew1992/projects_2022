package learning_3.week_3;

import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // test();
        test3();
    }

    /**
     * lock 支持公平和非公平，阻塞获取。（阻塞等待）
     *
     * 当锁空闲，获取，state加1
     * 当锁被自己持有，获取，state加1
     * 当锁被别人持有，一直阻塞到可以获取。
     *
     * 在使用阻塞等待获取锁的方式中，必须在try代码块之外；（避免加锁失败后，解锁导致抛出异常）
     * 并且加锁方法与try代码块之间没有任何可能抛出异常的方法调用；（避免加锁成功后，发生异常，导致无法解锁）
     */
    private static void test() {
        lock.lock();
        // 中间不允许有可能抛异常的逻辑
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * tryLock 非公平获取，非阻塞获取。（尝试机制）
     *
     * 当锁空闲，获取，state加1
     * 当锁被自己持有，获取，state加1
     * 当锁被别人持有，立即返回false
     *
     * 注：在阻塞获取锁之前，要判断锁是否已被当前线程获取
     */
    private static void test2() {
        // tryLock 是否被当前线程获取
        // isLocked 是否被任何线程获取
        boolean locked = lock.tryLock();
        if (locked) {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * JDK8推荐使用LongAddr对象，比AtomicInteger性能更好（减少乐观锁的重试次数）
     */
    private static void test3() {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        System.out.println(longAdder.longValue());
    }

}
