package learning_1.week_5;

import java.io.*;

public class MyUtil {
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }

    public static void main(String[] args) throws Exception {
        TestUser user = new TestUser();
        TestUser user1 = clone(user);
        System.out.println(user);
        System.out.println(user1);
    }
}
