package learning_2.week_7;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    private static class Worker extends Thread {
        private CyclicBarrier cyclicBarrier;

        private Worker(CyclicBarrier barrier) {
            this.cyclicBarrier = barrier;
        }

        @Override
        public void run() {
            super.run();

            try {
                System.out.println(Thread.currentThread().getName() + "开始等待其它线程");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "开始执行");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);

        for (int i = 0; i < 3; i ++) {
            System.out.println("创建工作线程" + i);
            Worker worker = new Worker(barrier);
            worker.start();
        }
    }
}
