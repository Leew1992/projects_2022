package learning_2.week_6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {

    private Semaphore sp = null;
    private String name = null;

    public Student(Semaphore sp, String name) {
        this.sp = sp;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            sp.acquire();
            System.out.println( name + " 拿到了许可证");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println( name + " 打好了饭，释放了这个窗口");
            sp.release();
        }
    }
}
