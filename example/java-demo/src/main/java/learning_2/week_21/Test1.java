package learning_2.week_21;

public class Test1 {
    public static void main(String[] args) {
        test();
    }

    /**
     * idc
     * astore_0
     * return
     */
    public static void test() {
        String aa = "aa";
    }

    /**
     * idc
     * astore_1
     *
     * new
     * dup（构造函数this）
     * ldc
     * invokespecial（String.init）
     * astore_1
     * return
     */
    public static void test1() {
        String aa = "bb";
        String bb = new String("bb");
    }
}
