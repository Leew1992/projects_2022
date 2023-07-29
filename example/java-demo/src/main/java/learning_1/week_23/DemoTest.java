package learning_1.week_23;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class DemoTest {
    public static void main(String[] args) {
        // testMethodRef();
        // testConstructorRef();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers.contains(new Integer(1)));
    }

    /**
     * 方法引用（定义方法）
     */
    private static void testMethodRef() {
        // Consumer（有参，没返回值）
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(1);

        // Function（有参，有返回值）
        Function<Integer,Integer> function = x -> x + 1;
        Integer result = function.apply(1);
        System.out.println(result);
    }

    /**
     * 构造器引用（定义构造器）
     */
    private static void testConstructorRef() {
        // Supplier（单个，无参）
        Supplier<ObjDto> objSup = ObjDto::new;
        objSup.get().sayHello();

        // Function（单个，有参）
        Function<String, ObjDto> objFun = ObjDto::new;
        System.out.println(objFun.apply("bob").getName());

        // Stream（多个，无参）
        List<String> list = Arrays.asList("a");
        Stream<ObjDto> objDtoStream = list.stream().filter(x -> x != null).map(ObjDto::new);
        objDtoStream.findFirst().get().sayHello();
    }
}
