package learning_1.week_6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorTest {

    public static void main(String[] args) {
        // testFixedThreadPool();
        // testSingleThreadPool();
        // testCacheThreadPool();
        // testScheduledThreadPool();

        // testFutureRunnable();
        // testFutureCallable();

        // testInvokeAny();

        testInvokeAll();
    }

    // 固定数量线程池
    public static void testFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...2");
        });

        pool.execute(t1);
        pool.execute(t2);

        pool.shutdown();
    }

    // 单一线程池
    public static void testSingleThreadPool() {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...2");
        });

        pool.execute(t1);
        pool.execute(t2);

        pool.shutdown();
    }

    // 可变线程池
    public static void testCacheThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...2");
        });

        pool.execute(t1);
        pool.execute(t2);

        pool.shutdown();
    }

    // 延迟线程池
    public static void testScheduledThreadPool() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...1");
        });
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "  running...2");
        });

        pool.schedule(t1, 5, TimeUnit.SECONDS);
        pool.schedule(t2, 10, TimeUnit.SECONDS);

        pool.shutdown();
    }

    // submit Runnable 测试
    public static void testFutureRunnable() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Future future = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("asynchronous task");
                }
            });

            System.out.println(future.get());

            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // submit Callable 测试
    public static void testFutureCallable() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            Future future = executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return "Success";
                }
            });

            System.out.println(future.get());

            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // invokeAny 测试
    public static void testInvokeAny() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        try {
            Set<Callable<String>> callables = new HashSet<Callable<String>>();

            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Task 1";
                }
            });

            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Task 2";
                }
            });

            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Task 3";
                }
            });

            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Task 4";
                }
            });

            callables.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Task 5";
                }
            });

            String result = executorService.invokeAny(callables);

            System.out.println("result = " + result);

            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // invokeAll
    public static void testInvokeAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 1";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 2";
            }
        });

        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "task 3";
            }
        });

        try {
            List<Future<String>> futures = executorService.invokeAll(callables);

            for (Future<String> future : futures) {
                System.out.println("future.get = " + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
