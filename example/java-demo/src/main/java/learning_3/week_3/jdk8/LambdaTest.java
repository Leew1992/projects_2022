package learning_3.week_3.jdk8;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Lambda表达式
 *
 * 两种实现方式：
 * 1、函数式接口 (x,y) -> x+y;
 * 2、方法引用 Integer::sum;
 *
 */
public class LambdaTest {

    public static void main(String[] args) {
        testLambda();
    }

    /**
     * 《Lambda》
     *
     * 本质上是一段匿名内部类，使得代码编写更加简洁。
     */
    private static void testLambda() {
        // 匿名内部类
        Comparator cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // Lambda 表达式（更简洁）
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }
}
