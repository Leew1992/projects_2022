package learning_2.week_21;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    private static int count = 0;
    static final int SIZE = 2 * 1024 * 1024;
    public static void main(String[] args) {
        String aa = "43142314214214234214234241231234234132443432";
        String bb = "43142314214214234214234241231234234132443433";
//        testStackOverFlow(aa, bb);
        testOOM();
    }

    private static void testStackOverFlow(String aa, String bb) {
        System.out.println(count++);
        testStackOverFlow(aa, bb);
    }

    private static void testOOM() {
        int[] i = new int[SIZE];
    }
}
