package learning_4.aaa;

import java.io.FileInputStream;
import java.security.SecureRandom;

public class TestMain {

    public static void main(String[] args) throws Exception {
        sleep();
        wait2();
    }

    public void test() {
        Thread thread = new Thread();
        thread.setDaemon(true);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        try (FileInputStream fis = new FileInputStream("111.txt")) {

        } catch (Exception e) {

        }
    }

    public static void yield() throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1");
        });
        t1.start();
        // t1.join();
        Thread.yield();

        System.out.println("yield");
    }

    public static void daemon() {
        Thread daemonThread = new Thread(new Runnable() {

            public void run() {

                while (true) {
                    System.out.println("守护线程正在运行!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        System.out.println("主线程结束!");
    }

    public static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        System.out.println("sleep");
    }

    public static void wait2() {
        Object obj = new Object();
        synchronized (obj){
            try {
                obj.wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("wait2");
            }
        }
    }

    final int random = new SecureRandom().nextInt(1);
}
