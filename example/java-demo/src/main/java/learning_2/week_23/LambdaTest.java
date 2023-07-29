package learning_2.week_23;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {

    public static void main(String[] args) {

    }

    /**
     * 方法引用
     * Runnable是一个函数式接口，加了@FunctionInterface注解
     */
    public static void methodRef() {
        new Thread(() -> System.out.println("OK"));
    }

    /**
     * 构造器引用
     *
     */
    public void constructorRef() {
        ArrayList<Object> objects = Lists.newArrayList();
        objects.add(1);
        // 无参+有参，都支持
        Supplier<ObjTest> supplier1 = ObjTest::new;
        ObjTest objTest = supplier1.get();
        // 无参抽象方法
        InterfaceTest inter1 = ObjTest::new;
    }

    public void testFunction() {
        Supplier<Obj2Test> obj1 = Obj2Test::new; // 为支持参数
        Function<String, Obj2Test> obj2 = Obj2Test::new; // 支持一个参数
        obj2.apply("12343");
    }
}
