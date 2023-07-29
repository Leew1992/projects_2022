package learning_3.week_3;

public class ConditionTest {

    public static void main(String[] args) {
        // test();
        // System.out.println(Math.pow(2, 63));
        int i = test3();
        System.out.println(i);
    }

    /**
     * switch 的 condition 为null，会抛出空指针
     * 注：可以switch直接拿condition与case后的值equals，导致npe异常
     */
    private static void test() {
        String condition = null;
        /*
           测试一下
           测试一下
         */
        switch (condition) {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            default:
                System.out.println(condition);
        }
    }

    /**
     * long的最大值2^64-1，最多20个有效位
     * double的尾数52，最多17个有效位（15～17）
     * 所以超过17个有效位的long转成double，可能会导致有效位的丢失
     */
    private static void test2() {
        /// 业务方通知活动暂停
        System.out.println(Math.pow(2, 63));
    }

    private static int test3() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
