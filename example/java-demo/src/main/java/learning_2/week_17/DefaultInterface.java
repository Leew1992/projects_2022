package learning_2.week_17;

public interface DefaultInterface {

    void test1();

    default void test2() {
        System.out.println("test2 execute ...");
    }
}
