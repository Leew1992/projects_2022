package learning_4.aaa;

public interface Interface2 extends Inteface1 {

    default void test() {
        Inteface1.test();
        System.out.println("Interface2 test");
    }
}
