package learning_3.week_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

    public static void main(String[] args) throws Exception {
        new ThreadTest().testCallable();
    }

    private void testRunnable() {
        new Thread(() -> {
            System.out.println("ok");
        }).start();
    }

    private void testCallable() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            Future<String> future = executorService.submit(() -> {
                System.out.println("oo");
                return "ok";
            });
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
