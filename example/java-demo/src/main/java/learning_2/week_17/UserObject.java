package learning_2.week_17;

public class UserObject {
    private boolean a_boolean = true;
    private byte a_type = 0;
    private char a_char = 1;
    private short a_short = 2;
    private final int a_int = 3;
    private long a_long = 4;
    private float a_float = 5;
    private double a_double = 6;
    private Object obj = new Object();

    /*private Integer a_int = 33333;
    private Long a_long = 4L;
    private Float a_float = 5.0f;
    private Double a_double = 6.0;

    private void test() {
        System.out.println(a_int);
    }*/

    private void test1() {
        int b = test2(1);
        System.out.println(b);
    }

    public int test2(int a) {
        try {
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    private void test3() {
        System.out.println(1);
        int b = test4();
        System.out.println(b);
    }

    private int test4() {
        return 3;
    }

    private void test5() {
        int a = 4;
        int b = 5;
        int c = test6(a, b);
        System.out.println(c);
    }

    private int test6(int a, int b) {
        return a;
    }
}
