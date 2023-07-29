package learning_2.week_12;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;

public class BigDecimalTest {
    public static void main(String[] args) {
        test3();
        /*test();
        test0();
        test1();
        test2();*/
    }

    public static void test3() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("OK");
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000L,1000L); // 创建一个1s后执行的任务

        System.out.println("main method end...");
    }

    public static void test() {
        /*BigDecimal bd1 = new BigDecimal(new BigInteger("10101"), 2);
        System.out.println(bd1);*/
        BigDecimal bd1 = new BigDecimal("-123.45");
        System.out.println(bd1.unscaledValue());
        System.out.println(bd1.scale());
    }

    public static void test0() {
        System.out.println(1.0f / 3.0f);
        System.out.println(1.0d / 3.0d);
        float m=1243.45566778465651454545f;
        System.out.println(m);
    }

    public static void test1() {
        /*BigDecimal bd1 = new BigDecimal("759.48");
        BigDecimal bd2 = new BigDecimal("3000.0");*/

        BigDecimal bd1 = new BigDecimal(759.48);
//        BigDecimal bd2 = new BigDecimal(3000.0);

        System.out.println(bd1);

        // BigDecimal result = bd1.divide(bd2, 2, RoundingMode.HALF_UP);
        /*BigDecimal result = bd1.divide(bd2);

        // double result = 759.48 / 3000;
        System.out.println(result);

        System.out.println("111");*/
    }

    public static void test2() {
        System.out.println(0.2 + 0.1);
        System.out.println(0.3 - 0.1);
        System.out.println(0.2 * 0.1);
        System.out.println(0.3 / 0.1);
    }
}
