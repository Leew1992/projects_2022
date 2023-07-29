package learning_1.week_3;

/**
 * 懒汉式单例（加锁）
 */
public class DoubleLockSingleton {

    private DoubleLockSingleton() {}

    private static DoubleLockSingleton instance;

    public static DoubleLockSingleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                if (null == instance) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
