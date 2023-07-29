package learning_2.week_17;

public class ObjectTest {
    public static void main(String[] args) {
        int result = test(22, 33);
        System.out.println(result);
    }

    private static int test(int a, int b) {
        return a + b;
    }

    private static void test2() {
        int a = 3;
        System.out.println(a);
        int b = 4;
        System.out.println(b);
    }

    public void test3(String param) {
        System.out.println(param);
    }
}
