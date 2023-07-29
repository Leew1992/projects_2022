package learning_3.week_2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {
        new AtomicTest().testAtomic();
    }

    /**
     * 原子性：
     * CAS 或 加1并获取
     * 注：两步操作不会被中断
     */
    private void testAtomic() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1,2);
        atomicInteger.incrementAndGet();
    }
}
