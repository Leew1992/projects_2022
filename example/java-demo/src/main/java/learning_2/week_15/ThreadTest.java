package learning_2.week_15;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) throws Exception {
        // testFutureTask();
        testCallable();
    }

    public static void testFutureTask() throws Exception {
        FutureTask futureTask = new FutureTask<>(() -> "aa");
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    public static void testCallable() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new CallableImpl());
        System.out.println(future.get());
    }

    static class CallableImpl implements Callable {
        @Override
        public Object call() throws Exception {
            return "aa";
        }
    }
}
