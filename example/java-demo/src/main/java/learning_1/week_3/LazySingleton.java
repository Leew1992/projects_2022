package learning_1.week_3;

/**
 * 懒汉式单例
 */
public class LazySingleton {

    private LazySingleton() {}

    private static LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
