package learning_1.week_8;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> tt = new ThreadLocal<>();

        Thread t = new Thread(() -> {
            // tt.set("123");
            System.out.println(tt.get());
        });

        t.start();

        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
