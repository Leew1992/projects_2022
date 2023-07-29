package learning_2.week_17;

public class ParentObj {
    public static int a = 1;
    public static final int aa = 1;

    static {
        System.out.println("Parent static block");
    }

    public ParentObj() {
        super();
        System.out.println("Parent init");
    }
}
