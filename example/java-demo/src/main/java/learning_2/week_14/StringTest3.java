package learning_2.week_14;

import java.util.UUID;

public class StringTest3 {

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        final String h1 = "hello";
        String h2 = "hello";
        /**
         * h1被final修饰，是常量，加上 "Hydra"常量，满足常量折叠
         * 编译后是 "helloHydra"
         */
        String s1 = h1 + "Hydra";
        /**
         * h2没有被final修饰，不是常量，不满足常量折叠
         * 会在堆中生成一个新对象
         */
        String s2 = h2 + "Hydra";
        System.out.println((s1 == "helloHydra"));
        System.out.println((s2 == "helloHydra"));
    }

    private static void test2() {
        String h ="hello";
        final String h2 = h;
        /**
         * h2 初始化时，没有使用常量表达式（赋的值不是常量）
         */
        String s = h2 + "Hydra";
        System.out.println(s=="helloHydra");
    }

    private static void test3() {
        /**
         * 编译期常量
         */
        final String s1="hello "+"Hydra";
        /**
         * 运行期常量
         * UUID.randomUUID().toString() 不是字面量，到运行期才有结果
         */
        final String s2= UUID.randomUUID().toString()+"Hydra";
    }
}
