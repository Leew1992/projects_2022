package learning_1.week_4;

public class ThreadTest {

    private static Object obj = new Object();

    public static void main(String[] args) {
        synchronized (obj) {
            System.out.println(Thread.holdsLock(obj));
        }
    }
}
