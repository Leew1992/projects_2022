package learning_1.week_6;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

    public static void main(String[] args) {
        // testForkJoinPool();
        testForkJoinPool2();
    }

    public static void testForkJoinPool() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        // 包含任务拆分逻辑
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);

        forkJoinPool.invoke(myRecursiveAction);
    }

    public static void testForkJoinPool2() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);

        MyRecursiveTask tasks = new MyRecursiveTask(128);

        long result = forkJoinPool.invoke(tasks);

        System.out.println(result);
    }

}
