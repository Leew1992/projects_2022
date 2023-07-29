package learning_1.week_9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class UserDaoProxy {

    /**
     * 传入一个对象，对对象作代理
     */
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        // 会构建一个继承了UserDaoImpl的代理类（已实现方法的增强）
        UserDao dao = (UserDao) Proxy.newProxyInstance(
                // 加载器 - 通过加载器拿到对象类的class字节码
                userDao.getClass().getClassLoader(),
                // 接口 - 通过接口构建所有接口的代理
                userDao.getClass().getInterfaces(),
                // 对象处理 - 通过代理实现功能的增强
                new UserDaoInvocationHandler(userDao));

        dao.add();

        System.out.println("===================");

        dao.update();
    }
}

// 对象代理器
class UserDaoInvocationHandler implements InvocationHandler {

    private Object target;

    public UserDaoInvocationHandler(Object obj) {
        this.target = obj;
    }

    @Override
    // 代理对象调用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " before execute....");
        // 目标对象调用
        Object result = method.invoke(target, args);
        System.out.println(method.getName() + " after execute...");
        return result;
    }
}
