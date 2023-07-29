package learning_2.week_21;

public class Test {
    public static void main(String[] args) throws Exception {
        // Class<?> aClass = Class.forName("");
        String aa = new String("aa");
        String bb = "aa";
        String cc = "aa";
        System.out.println(System.identityHashCode(aa));
        System.out.println(System.identityHashCode(bb));
        System.out.println(System.identityHashCode(cc));
    }
}
