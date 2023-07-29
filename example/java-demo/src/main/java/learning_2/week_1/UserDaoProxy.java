package learning_2.week_1;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxy {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();
        // classLoader 加载生成的proxy.class
        // interfaces 实现对接口的代理
        // invocationHandler 增强类
        UserDao dao = (UserDao)Proxy.newProxyInstance(UserDaoProxy.class.getClassLoader(), new Class[]{UserDao.class}, new MethodProxy(userDao));
        /**
         * 已经是一个生成好的代理类 UserDaoProxy@fdsfd.class
         * public void add() {
         *      // method 是通过反射拿到的
         *      // Class.forName("com.example.demo_week1.UserDao").getMethod("add", Class.forName(Objects.Class));
         *     super.h.invoke(this, mehtod, args);
         * }
         */
        dao.add();
    }
}

class MethodProxy implements InvocationHandler {
    private UserDao userDao;

    public MethodProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        saveObject(proxy);
        System.out.println("before proxy...");
        method.invoke(userDao, args);
        System.out.println("after proxy...");
        return null;
    }

    private void saveObject(Object object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/111.java")));) {
            oos.writeObject(object);
            oos.flush();
        } catch (Exception e) {

        }
    }
}
