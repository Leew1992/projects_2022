package learning_1.week_14;

public class TestClass {

    OuterClass.InnerClass inner;

    public static void main(String[] args) {
        AppClass app = new AppClass();
        System.out.println(app.outer);
        System.out.println(app.inner);
    }
}
