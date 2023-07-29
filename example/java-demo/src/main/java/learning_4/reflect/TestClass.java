package learning_4.reflect;

import java.lang.reflect.Field;

public class TestClass {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("learning_4.reflect.ObjClass");
        Object object = aClass.newInstance();
        Field nameField = aClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(object, "123");
        System.out.println(object);
    }
}
