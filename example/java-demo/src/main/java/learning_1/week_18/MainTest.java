package learning_1.week_18;

public class MainTest {

    /**
     * 3、静态内部类可以脱离外部类存在。
     */
    public static void main(String[] args) {
        OutClass.InnerClass ic = new OutClass.InnerClass();
        ic.test();

        String aa = null;
        System.out.println(aa.equalsIgnoreCase(null));
    }

}
