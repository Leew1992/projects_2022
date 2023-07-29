package learning_1.week_21;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 闭锁：主人等客人吃完了再吃
 * 应用：一般用于汇总。
 */
public class CountDownLatchTest {

    static class TaskThread extends Thread {

        CountDownLatch countDownLatch;

        public TaskThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + " 到达栅栏 A");
                countDownLatch.countDown();
                Thread.sleep(1000);
                System.out.println(getName() + " 冲破栅栏 A");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int threadNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i = 0; i < threadNum; i++) {
            new TaskThread(countDownLatch).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 完成最后任务");
    }

}