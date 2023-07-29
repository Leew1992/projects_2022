package test;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1、任意一个偶数（大于2）都可以由2个素数组成，而且组合情况有多种，编程实现输入一个偶数输出两个素数差值最小的素数对 ****
 * 备注：质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）。
 * 举例：输入：10；有2个素数对：3,7 以及 5 5；；；输出：5 - 5 = 0
 *
 * 2、用2种方式 实现 单例
 *
 * 3、启动4个线程，2个线程对变量i加一，2个线程对变量i减一 ；只要执行一次，不要求前后顺序。
 *
 * 联系人：13913542184 顾
 */
public class Test_03 {

    private static AtomicInteger i = new AtomicInteger(0);
    private static int incrementCount = 2;
    private static int decrementCount = 2;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = initThreadPool();
        try {
            while (incrementCount > 0 || decrementCount > 0) {
                boolean isIncrement = incrementCount > 0 ? true : false;
                threadPool.execute(() -> {
                    incrementOrDecrement(isIncrement);
                });
                int tmp = isIncrement ? incrementCount -- : decrementCount --;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!threadPool.isShutdown()) {
                threadPool.shutdown();
            }
        }

        while (!threadPool.isTerminated()) {

        }

        System.out.println("result: " + i.get());
    }

    private static ThreadPoolExecutor initThreadPool() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(100);
        return new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS, blockingQueue);
    }

    private static void incrementOrDecrement(boolean isIncrement) {
        int result = isIncrement ? i.incrementAndGet() : i.decrementAndGet();
        System.out.println(result);
    }
}
