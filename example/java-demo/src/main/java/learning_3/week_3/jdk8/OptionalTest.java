package learning_3.week_3.jdk8;

import java.util.Optional;

/**
 * Optional.of(T t) // 创建一个Optional实例
 * Optional.empty() // 创建一个空的Optional实例
 * Optional.ofNullable(T t) // 若T不为null，创建一个Optional实例，否则创建一个空实例
 * isPresent() // 判断是否包含值
 * orElse(T t) // 如果调用包含值，则返回值；否则返回 t
 * orElseGet(Supplier s) // 如果调用对象包含值，返回该值；否则返回 s 中获取的值
 * map(Function f) // 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
 * flatMap(Function mapper) // 与map类似。返回值是Optional
 */
public class OptionalTest {

    public static void main(String[] args) {
        testOptional();
    }

    private static void testOptional() {
        // Optional.of(T t); 如果 value 值为null，则抛出npe异常
        Integer integer = Optional.of(2).get();
        System.out.println(integer);

        // Optional.empty(); 不能调用get()方法，会抛出npe异常
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());

        // Optional.ofNullable(T t); 如果 value 值为null，则可以执行orElse方法
        // Optional.ofNullable(null); 等价于 Optional.empty()
        Object o = Optional.ofNullable(null).orElse(0);
        System.out.println(o);

        // orElseGet 返回 Supplier 的 get 结果
        Object o1 = Optional.ofNullable(null).orElseGet(() -> 3);
        System.out.println(o1);

        // map 数据转换
        Optional<String> s = Optional.ofNullable(3).map(x -> x + "-");
        System.out.println(s.get());

        // flatMap 数据转换
        Optional<Integer> s1 = Optional.ofNullable(3).flatMap(x -> Optional.of(4));
        System.out.println(s1);
    }

    private static void testDefaultOrStaticMethod() {

    }
}
