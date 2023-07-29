package learning_3.week_3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    private static final ThreadLocalRandom RANDOM =
            ThreadLocalRandom.current();

    public static void main(String[] args) {
        // test();
        // test2();
        test3();
    }

    private static void test() {
        Random random = new Random();
        System.out.println(random.nextDouble());
    }

    private static void test2() {
        System.out.println(Math.random());
    }

    private static void test3() {
        // ThreadLocalRandom current = ThreadLocalRandom.current();
        System.out.println(RANDOM.nextDouble());
    }
}
