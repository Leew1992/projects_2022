package learning_2.week_11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    final Lock rLock = lock.readLock(); // AQS共享锁
    final Lock wLock = lock.writeLock(); // AQS排它锁

    volatile Integer i = 0;

    private void inc() {
        wLock.lock();
        try {
            i ++;
        } finally {
            wLock.unlock();
        }
    }

    private int get() {
        rLock.lock();
        try {
            return i;
        } finally {
            rLock.unlock();
        }
    }

    final ReentrantLock lock1 = new ReentrantLock();
    final Condition condition1 = lock1.newCondition();
    final List list = new ArrayList();

    private void put1() throws Exception {
        lock1.lock();
        try {
            list.add(1);
            System.out.println("put1");
            condition1.signal();
        } catch (Exception e) {

        } finally {
            lock1.unlock();
        }
    }

    private void get1() {
        lock1.lock();
        try {
            while (list.isEmpty()) {
                condition1.await();
            }
            list.remove(0);
            System.out.println("get1");
        } catch (Exception e) {

        } finally {
            lock1.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        new ReentrantReadWriteLockTest().put1();
        new ReentrantReadWriteLockTest().put1();
        new ReentrantReadWriteLockTest().get1();

    }
}
