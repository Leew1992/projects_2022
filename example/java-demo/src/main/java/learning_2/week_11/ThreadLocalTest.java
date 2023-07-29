package learning_2.week_11;

import java.util.concurrent.*;

public class ThreadLocalTest {

    public static void main(String[] args) {
        try {
            new ThreadLocalTest().test5();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class RunnableThread implements Runnable {
        @Override
        public void run() {

        }
    }

    class CallableThread implements Callable {
        @Override
        public Object call() throws Exception {
            return null;
        }
    }

    private void test() {
        RunnableThread thread = new RunnableThread();
        Callable<Object> callable = Executors.callable(thread);
    }

    private void test1() throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) ThreadLocalTest.newFixedThreadPool(1);
        // 无返回值
        executor.execute(new RunnableThread());
        // 有返回值
        Future<?> future = executor.submit(new RunnableThread());
        Object o = future.get();
    }

    private static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    private void test2() throws Exception {
        CompletableFuture<String> feature = CompletableFuture.supplyAsync(() -> "hello");
        System.out.println(feature.get()); // 有结果，需要异常检查
    }

    private void test3() {
        CompletableFuture<String> feature = CompletableFuture.supplyAsync(() -> "hello");
        System.out.println(feature.join()); // 有结果，不需要异常检查
    }

    class Client extends Thread {
        CompletableFuture<Integer> f;
        Client(String threadName, CompletableFuture<Integer> f) {
            super(threadName);
            this.f = f;
        }
        @Override
        public void run() {
            try {
                System.out.println(this.getName() + ": " + f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private void test4() throws Exception {
        CompletableFuture<Integer> f = new CompletableFuture<>();
        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        //设置Future.get()获取到的值
        f.complete(100);
        //以异常的形式触发计算
        //f.completeExceptionally(new Exception());
        Thread.sleep(1000);
    }

    private void test5() throws Exception {
        // CountDownLatch countDownLatch = new CountDownLatch(1);

        CompletableFuture<String> feature = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
        feature.complete("100"); // 结束阻塞，给一个固定值
        System.out.println(feature.get());
        /*CompletableFuture<String> feature1 = feature.whenComplete((v, e) -> {
            System.out.println("v:" + v + ",e:" + e);
        });*/
//        System.out.println(feature1.get());
        /*countDownLatch.await();
        System.out.println(1);*/
    }

}
