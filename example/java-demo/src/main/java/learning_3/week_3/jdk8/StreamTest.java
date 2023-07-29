package learning_3.week_3.jdk8;

import com.google.common.cache.Weigher;
import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

    }

    /**
     * 《Stream》
     *
     * Stream 提供了丰富的API，使得集合操作更加简洁。
     * reduce 提供了丰富的中间函数、归并函数。
     * 注：不要觉得奇怪，就是一种固有的写法，让人容易理解，并且简洁
     *
     * 解释：接收两个参数，产生一个结果，只是它的三个参数都是同一个数据类型，这个函数式接口就是BinaryOperator
     */
    private static void testStream() {
        // testReduce();
        testGeneralFunc();
    }

    /**
     * 《Reduce》
     * 归并函数（终止函数）
     */
    private static void testReduce() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        // 一个构造参数
        // BinaryOperator.minBy/maxBy 归并函数
        Optional<Integer> reduce = integerStream.reduce(BinaryOperator.maxBy(Integer::compareTo));
        System.out.println(reduce.get());

        // 两个构造参数
        // 每个元素，都和-1比较，取最小值
        // BinaryOperator.minBy/maxBy 归并函数
        Integer reduce1 = new ArrayList<Integer>().stream().reduce(-1, BinaryOperator.minBy(Integer::compareTo));
        System.out.println(reduce1);

        // 三个构造参数（identity-初始值，accumulator-累加器，combiner-组合器）
        // 第三个参数 combiner 只有当并行（parallel）时，才会用到
        ArrayList<Integer> reduce2 = integerStream.parallel().reduce(
                new ArrayList<>(),
                (ArrayList<Integer> integers, Integer integer) -> {
                    integers.add(integer);
                    // System.out.println(Thread.currentThread().getName() + "; apply1-integers: " + integers + "; apply1-integer: " + integer);
                    return integers;
                },
                (ArrayList<Integer> integers, ArrayList<Integer> integers2) -> {
                    System.out.println(Thread.currentThread().getName() + "; apply2-integers: " + integers + "; apply2-integers2: " + integers2);
                    return integers;
                });
        System.out.println(reduce2);
    }

    private static void testGeneralFunc() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        // 计数
        /*long count = integerStream.count();
        System.out.println(count);*/

        // 求和
        // 基于Stream的求和运算，Integer.sum 是一个 BinaryOperator
        // Integer integer = integerStream.reduce((x, y) -> x + y).get();
        /*Integer reduce3 = integerStream.reduce(0, Integer::sum);
        System.out.println(reduce3);*/

        // 遍历
        // 基于Stream的遍历输出
        // Stream.of(1,2,3,4).forEach((x) -> System.out.println(x));
        // integerStream.forEach(System.out::println);

        // 分页
        // integerStream.skip(1).limit(2).forEach(System.out::println);

        // 过滤
        // integerStream.filter(x -> x >= 2).forEach(System.out::println);

        // 转换
        integerStream.map(x -> x + "-").forEach(System.out::println);
    }

    /**
     * Stream的创建
     */
    private static void testStreamCreate() {
        // 1、通过 Collection 提供的 stream() 或者 parallelStream() 创建
        // Stream<Object> stream = new ArrayList<>().stream();

        // 2、通过 Arrays 的表态方法 stream() 获取数组流
        /*String[] strings = new String[10];
        Stream<String> stream1 = Arrays.stream(strings);

        // 3、通过 Stream 类中的静态方法 of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        // 4、创建无限流
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);*/

        // 5、创建随机流（无限）
        Stream<Double> stream4 = Stream.generate(() -> Math.random());
        stream4.forEach(System.out::println);
    }

    /**
     * Stream的中间操作
     */
    private static void testStreamMiddle() {
        Stream<Integer> integerStream = Stream.of(2, 1, 3, 4);

        /**
         * 筛选、过滤、去重
         */
        /*integerStream.filter(x -> x > 2)
                .limit(4)
                .skip(1)
                .distinct()
                .forEach(System.out::println);*/

        /**
         * 通过 map 生成新的流
         */
        // integerStream.map(x -> x + "-").forEach(System.out::println);

        /**
         * 自然排序、定制排序
         */
        // integerStream.sorted().forEach(System.out::println);
        // 支持倒序
        // integerStream.sorted(Comparator.comparing(Integer::intValue)).forEach(System.out::println);
        integerStream.sorted(Integer::compare).forEach(System.out::println);
        integerStream.sorted((x, y) -> x.compareTo(y)).forEach(System.out::println);
    }

    /**
     * Stream的终止操作
     *
     * 查找和匹配
     * allMatch-都匹配，返回true
     * anyMatch-任意一个匹配，返回true
     * noneMatch-都不匹配，返回true
     *
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     *
     * count-返回流中元素的总个数
     * max-返回流中最大值
     * min-返回流中最小值
     */
    private static void testStreamEnd() {
        Stream<Integer> integerStream = Stream.of(2, 1, 3, 4, 5, 6, 7, 8, 9);

        // 匹配
        // allMatch
        /*boolean match = integerStream.allMatch(x -> x == 2);
        System.out.println(match);*/

        // anyMatch
        /*boolean match1 = integerStream.anyMatch(x -> x == 2);
        System.out.println(match1);*/

        // noneMatch
        /*boolean match2 = integerStream.noneMatch(x -> x == 2);
        System.out.println(match2);*/

        // 查找
        // findFirst
        /*Integer integer = integerStream.findFirst().get();
        System.out.println(integer);*/

        // findAny
        /*Integer integer1 = integerStream.findAny().get();
        System.out.println(integer1);*/

        // 计算
        // count
        /*long count = integerStream.count();
        System.out.println(count);*/

        // min
        /*Integer integer2 = integerStream.min(Comparator.comparing(Integer::intValue)).get();
        System.out.println(integer2);*/

        // max
        /*Integer integer3 = integerStream.max(Comparator.comparing(Integer::intValue)).get();
        System.out.println(integer3);*/

        // 并行流
        // findAny（具备了随机性）
        /*Integer integer = integerStream.parallel().findAny().get();
        System.out.println(integer);*/

        // reduce/collect
    }
}
