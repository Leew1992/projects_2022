package learning_1.week_14;

import java.security.SecureRandom;
import java.util.stream.IntStream;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();

        SecureRandom random = new SecureRandom();

        IntStream.range(0, 5).forEach(x -> {
            local.set(x + "   " + random.nextInt(10));
            System.out.println(local.get());
        });
    }
}
