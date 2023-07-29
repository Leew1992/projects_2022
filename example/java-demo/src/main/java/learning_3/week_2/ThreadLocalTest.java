package learning_3.week_2;

public class ThreadLocalTest {

    private static InheritableThreadLocal pThreadLocal = new InheritableThreadLocal();
    // private static ThreadLocal sThreadLocal = new ThreadLocal();

    public static void main(String[] args) {
        Thread pt = new Thread(() -> {
            System.out.println("parent thread...");
            pThreadLocal.set("a");
            Thread st = new Thread(() -> {
                System.out.println("sub thread...");
                System.out.println(pThreadLocal.get());
            });
            st.start();
        });
        pt.start();
    }
}
