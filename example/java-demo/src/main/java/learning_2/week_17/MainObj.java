package learning_2.week_17;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MainObj {

    /*static {
        // main方法所在类
//        System.out.println("mainObj static block");
    }*/

    public static void main(String[] args) throws Exception, Throwable {
        // new, putstatic, getstatic, invokestatic
//        ParentObj parentObj = new ParentObj();
//        System.out.println(SubObj.getStatic());
//        SubObj.setStatic(3);
//        System.out.println(SubObj.a);

        // 反射
//        Class<?> aClass = Class.forName("com.example.demo.week_17.SubObj");

        // 继承
//        SubObj subObj = new SubObj();

        // main方法所在类，如上

        // 被动引用
        // 静态变量，子类不初始化，父类初始化
//        System.out.println(SubObj.a);
        // 数组/集合
//        System.out.println(new SubObj[1]);
        // 静态常量，父类不初始化
//        System.out.println(SubObj.aa);


        /**
         * 反射获取的信息比MethodHandle要多。
         * 反射是模拟java代码层面的调用，MethodHandle是模拟字节码层面的调用。
         */
        ObjectTest test = new ObjectTest();
        ObjectTest test2 = new ObjectTest();

        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle printHandle = MethodHandles.lookup().findVirtual(test.getClass(), "test3", methodType);
        MethodHandle methodHandle = printHandle.bindTo(test);
        methodHandle.invokeExact("123");
        printHandle.invokeExact(test2, "123");
    }

}
