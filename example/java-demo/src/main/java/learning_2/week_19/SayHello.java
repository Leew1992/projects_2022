package learning_2.week_19;

public interface SayHello {

    default String getDefault() {
        return "default";
    }

    static String getStatic() {
        return "static";
    }
}
