package learning_3.week_3.interf;

/**
 * 包含 test() 方法的接口，都可以执行 test() 方法
 */
public class Impl1 implements Interface1, Interface2 {

    @Override
    public void test() {
        System.out.println("aa");
    }
}
