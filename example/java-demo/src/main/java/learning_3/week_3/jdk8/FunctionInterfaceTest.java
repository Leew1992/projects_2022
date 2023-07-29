package learning_3.week_3.jdk8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 */
public class FunctionInterfaceTest {

    public static void main(String[] args) {
        testFunctionInterface();
    }

    /**
     * 《函数式接口》
     *
     * 定义：只定义了一个抽象方法的接口（Object类的public方法除外），就是函数式接口，并且还提供了注解：@FunctionInterface
     *
     * 作用：是为了给Lambda提供更好的支持。（比如Comparator，可以自定义compare()逻辑，支持自定对象的比较）
     *
     * 常见的四大函数式接口：
     * 1、Consumer<T>：消费型接口，有参数，无返回值。
     * 2、Supplier<T>：供给型接口，无参数，有返回值。
     * 3、Function<T,R>：函数式接口，有参数，有返回值。
     * 4、Predicate<T>：断言型接口，有参数，有返回值。返回值是boolean类型
     *
     * 注：
     * 在四大核心函数式接口基础上，还提供了诸如BiFunction、BinaryOperator、toIntFunction等扩展的函数式接口，
     * 都是在这四种函数式接口上扩展而来的。
     */
    private static void testFunctionInterface() {
        // Consumer
        testConsumer("hello", (x) -> System.out.println(x));
        // Supplier
        String s = testSupplier(() -> "hello");
        System.out.println(s);
        // Function
        Long aLong = testFunction(100, (x) -> x + 200L);
        System.out.println(aLong);
        // Predicate
        boolean abc = testPredicate("abc", (x) -> x.length() > 5);
        System.out.println(abc);
    }

    /**
     * consumer 函数式接口，可以理解成一个新的参数品种
     * @param str 字符串
     * @param consumer 函数式接口
     */
    private static void testConsumer(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    private static String testSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    /**
     * Function<T,R> 函数式接口，T 入参类型，R 出参类型
     * @param num 数字
     * @param function 函数式接口
     * @return
     */
    private static Long testFunction(Integer num, Function<Integer, Long> function) {
        return function.apply(num);
    }

    /**
     * Predicate：断言型接口
     * @param str 字符串
     * @param predicate 断言型接口
     * @return
     */
    private static boolean testPredicate(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }
}
