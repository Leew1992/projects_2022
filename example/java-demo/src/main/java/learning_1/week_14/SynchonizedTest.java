package learning_1.week_14;

public class SynchonizedTest {

    // 静态方法
    public synchronized static void classMethod() {

    }

    // 实例方法
    public synchronized void intanceMethod() {

    }

    // 代码块
    public void test() {

        // 类锁
        synchronized (Object.class) {

        }

        // 对象锁
        synchronized(this) {

        }


    }

}
