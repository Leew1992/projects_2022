package test;

/**
 * 1、任意一个偶数（大于2）都可以由2个素数组成，而且组合情况有多种，编程实现输入一个偶数输出两个素数差值最小的素数对 ****
 * 备注：质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）。
 * 举例：输入：10；有2个素数对：3,7 以及 5 5；；；输出：5 - 5 = 0
 *
 * 2、用2种方式 实现 单例
 *
 * 3、启动4个线程，2个线程对变量i加一，2个线程对变量i减一 ；只要执行一次，不要求前后顺序。
 *
 * 联系人：13913542184 顾
 */
public class Test_02_02 {
    private static volatile Object singletonObject;

    private Test_02_02() {

    }

    /**
     * 懒汉模式
     */
    public static Object getInstance() {
        if (singletonObject == null) {
            synchronized (singletonObject) {
                if (singletonObject == null) {
                    singletonObject = new Object();
                }
            }
        }
        return singletonObject;
    }
}
