package learning_1.week_14;

public class OuterClass {

    private static String A = "";
    private String B = "";

    static String C = "";
    String D = "";

    static class InnerClass{
        public void test() {
            System.out.println(A + C);
        }
    }

    class GeneralClass {
        public void test() {
            System.out.println(A + B + C + D);
        }
    }
}
