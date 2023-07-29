package learning_1.week_3;

/**
 * 饿汉式单例
 */
public class HungerSingleton {

    private HungerSingleton() {}

    private static HungerSingleton instance = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return instance;
    }
}
