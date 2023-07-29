package learning_3.week_3.jdk8;

/**
 * JDK8的接口新特性
 *
 * 1、当一个类继承父类又实现接口时，若后两者方法名相同，则优先继承父类中的同名方法。（优先继承类中的同名方法-类优先）
 * 2、如果实现两个同名方法的接口，则要求实现类必须手动声明，默认实现哪个接口中的方法
 */
public interface Jdk8Interface {

    void test();

    // 允许有default方法实现
    default void test1() {
        System.out.println("aa");
    }

    // 允许有static方法实现
    static void test2() {
        System.out.println("aa");
    }
}
