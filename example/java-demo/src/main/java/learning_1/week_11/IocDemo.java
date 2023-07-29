package learning_1.week_11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class IocDemo {

    public static void main(String[] args) throws Exception {
        setValue(Book.class);
    }

    private static void setValue(Class clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if (annotation == null) {
                continue;
            }
            Object fieldObj = field.getType().newInstance();
            String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1, field.getName().length());
            Method method = clazz.getMethod(methodName, field.getType());
            if (method == null) {
                continue;
            }
            Object classObj = clazz.newInstance();
            method.invoke(classObj, fieldObj);

            System.out.println(classObj);
        }
    }
}
