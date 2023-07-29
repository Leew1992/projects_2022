package learning_1.week_11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        setValue(User.class, "name", "aa");
    }

    private static void setValue(Class clazz, String name, String value) throws Exception {
        Field field = clazz.getDeclaredField(name);
        if (field == null) {
            System.out.println("not exists the filed " + name);
            return;
        }
        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        Method method = clazz.getMethod(methodName, String.class);
        method.setAccessible(true);
        Object instance = clazz.newInstance();
        method.invoke(instance, value);

        System.out.println(instance);
    }
}
