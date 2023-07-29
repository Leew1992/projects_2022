package learning_2.week_22;

public class ClassTest {

    static {
        System.out.println("static");
    }

    public ClassTest() {
        System.out.println("init");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }
}
