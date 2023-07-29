package learning_2.week_6;

import java.util.concurrent.Semaphore;

/**
 * 限流：一次只允许n个线程通过
 * 方法：acquire, release
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore sp = new Semaphore(3);
        for (int i = 1; i <= 10; i ++) {
            new Student(sp, "student-" + i).start();
        }
    }
}
