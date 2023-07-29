package learning_2.week_11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest2 {

    public static void main(String[] args) throws Exception {
        new ThreadLocalTest2().test3();
    }

    public void test3() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "进行一连串操作1....");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        //whenComplete方法,返回的future的结果还是1
        CompletableFuture<Integer> future = future1.whenComplete((x, y) -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "whenComplete,future返回:" + x);
        });

        //handler返回的future结果是字符串"2"
        CompletableFuture<String> handle = future.handle((x, y) -> {
            System.out.println(Thread.currentThread().getName() + "handle接收的结果:" + x);
            countDownLatch.countDown();
            return "2";
        });
        CompletableFuture<Integer> handle1 = handle.handle((x, y) -> {
            System.out.println(Thread.currentThread().getName() + "handle返回的结果:" + x);
            countDownLatch.countDown();
            return 2;
        });
        countDownLatch.await();
        System.out.println(1);

    }
}
