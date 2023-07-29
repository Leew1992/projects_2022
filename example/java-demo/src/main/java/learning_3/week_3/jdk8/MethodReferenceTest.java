package learning_3.week_3.jdk8;

import learning_3.week_3.UserObject;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        testMethodReference();
    }

    private static void testMethodReference() {
        testMethodRef();
        testConstructRef();
        testArrayRef();
    }

    /**
     * 《方法引用》
     *
     * 定义：Lambda体中的内容有方法已经实现了，那么可以使用"方法引用"，
     * 可以理解为，方法引用是Lambda的另一种表现形式，并且语法比Lambda表达式更新简单。
     *
     * 三种表现形式：
     * 对象::实例方法名
     * 类::表态方法名
     * 类::实例方法名
     *
     */
    private static void testMethodRef() {
        // 对象::实例方法
        // Consumer<Integer> consumer = (x) -> System.out.println(x);
        Consumer<Integer> consumer2 = System.out::println;
        consumer2.accept(10);

        // 类名::静态方法名
        // BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> Integer.compare(x, y);
        BiFunction<Integer, Integer, Integer> biFunction2 = Integer::compare;
        Integer apply = biFunction2.apply(100, 200);
        System.out.println(apply);

        // 类名::实例方法名
        // Lambda 参数列表中第一个参数是实例方法的调用者（str1），第二个参数是实例方法的参数（str2）；即可以用类::实例方法名。
        // BiFunction<String, String, Boolean> function1 = (str1, str2) -> str1.equals(str2);
        BiFunction<String, String, Boolean> function2 = String::equals;
        Boolean apply1 = function2.apply("hello", "world");
        System.out.println(apply1);
    }

    /**
     * 《构造器引用》
     * 格式：ClassName::new
     */
    private static void testConstructRef() {
        // 构造方法引用 类名::new
        // Supplier<Object> supplier = () -> new Object();
        // System.out.println(supplier.get());
        Supplier<Object> supplier2 = Object::new;
        System.out.println(supplier2.get());

        // 构造方法引用 类名::new （带一个参数）
        // Function<String, UserObject> supplier3 = (x) -> new UserObject(x);
        Function<String, UserObject> supplier4 = UserObject::new;
        System.out.println(supplier4.apply("abc"));
    }

    /**
     * 《数组引用》
     * 格式：Type[]::new
     */
    private static void testArrayRef() {
        Function<Integer, String[]> function = (x) -> new String[x];
        Function<Integer, String[]> function2 = String[]::new;
        String[] apply = function2.apply(10);
        System.out.println(apply.length);
    }
}
