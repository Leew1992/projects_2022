package learning_3.week_3.jdk8;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ForkJoinTest {

    public static void main(String[] args) {
        testAccumulate();
    }

    /**
     * 《并行流》
     *
     * 定义：把内容切割成多个数据块，并使用多线程处理每个数据块的内容。
     * 使用：Stream.parallel()
     *
     * 注：并行流，要使用线程安全的集合类，避免并发修改异常（ConcurrentModificationException）。
     *
     * 原理：并行流使用的是fork/join框架进行并行操作。
     * 线程池：ForkJoinPool.commonPool
     */
    private static void testParallel() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        integerStream.parallel().forEach((x) -> {
            try {
                Thread.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + x);
        });

        /*CopyOnWriteArrayList<Integer> reduce2 = integerStream.parallel().reduce(
                new CopyOnWriteArrayList<>(),
                (CopyOnWriteArrayList<Integer> integers, Integer integer) -> {
                    integers.add(integer);
                    System.out.println(Thread.currentThread().getName() + "; apply1-integers: " + integers + "; apply1-integer: " + integer);
                    return integers;
                },
                (CopyOnWriteArrayList<Integer> integers, CopyOnWriteArrayList<Integer> integers2) -> {
                    // System.out.println(Thread.currentThread().getName() + "; apply2-integers: " + integers + "; apply2-integers2: " + integers2);
                    return integers;
                });
        System.out.println(reduce2);*/
    }

    /**
     * 《串行流》
     *
     * 定义：只采用一个线程，对数据进行处理。
     * 使用：Stream/Stream.sequential()
     */
    private static void testSequential() {

    }

    /**
     * 《Fork/Join框架》
     *
     * 定义：在必要情况下，将一个大任务，进行拆分（fork）成若干个小任务（拆到不能再拆时），
     * 再将一个个小任务运算的结果进行 join 汇总
     *
     * 关键字：递归分合，分页治之
     *
     * 特性：工作窃取（work-stealing）
     */
    private static void testForkJoin() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        for (int i = 0; i < 5; i ++) {
            forkJoinPool.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    /**
     * 《并行流》
     * 累加求和
     */
    private static void testAccumulate() {

        Instant start = Instant.now();

        OptionalLong reduce = LongStream.rangeClosed(1, 100).parallel().reduce(Long::sum);
        System.out.println(reduce.getAsLong());

        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).getNano());
    }
}
