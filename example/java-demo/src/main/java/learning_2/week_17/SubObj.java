package learning_2.week_17;

public class SubObj extends ParentObj {
    public static int b = 2;

    static {
        System.out.println("Sub static block");
    }

    public SubObj() {
        super();
    }

    public static int getStatic() {
        return b;
    }

    public static void setStatic(int b) {
        SubObj.b = b;
    }
}
