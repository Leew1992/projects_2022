package learning_2.week_19;

public class FucClass {
    public static void main(String[] args) {
        FucInterface fuc = () -> System.out.println("FucInterface");
        test(fuc);
    }

    public static void test(FucInterface fucInterface) {
        fucInterface.test();
    }
}
