package learning_3.week_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition EMPTY = LOCK.newCondition();
    private static final Condition FULL = LOCK.newCondition();
    private static final long TOTAL = 10;
    private static long STOCK = 0;

    public static void main(String[] args) {
        new LockTest().testReentrantLock();
    }

    private void testReentrantLock() {
        new Thread(() -> {
            try {
                take();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
                put();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void take() throws Exception {
        LOCK.lock();
        if (STOCK == 0) {
            System.out.println("stock empty");
            EMPTY.await();
        }
        STOCK --;
        System.out.println("take 1");
        FULL.signal();
        LOCK.unlock();
    }

    private void put() throws Exception {
        LOCK.lock();
        if (STOCK >= TOTAL) {
            System.out.println("stock full");
            FULL.await();
        }
        STOCK ++;
        System.out.println("put 1");
        EMPTY.signal();
        LOCK.unlock();
    }
}
