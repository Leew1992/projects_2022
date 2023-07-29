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
public class Test_01 {

    public static void main(String[] args) {
        getMinDiffZs(120);
    }

    public static void getMinDiffZs(int num) {
        if (num <= 2) {
            System.out.println("error");
            return;
        }

        int first = 0;
        int second = 0;
        int diff = 0;
        for (int i = 2; i < num/2+1; i ++) {
            if (!isZs(i) || !isZs(num-i)) {
                continue;
            }
            if (diff == 0 || Math.abs(num-i-i) < diff) {
                first = i;
                second = num - i;
                diff = Math.abs(num-i-i);
            }
        }

        if (first == 0) {
            System.out.println("no result");
            return;
        }

        System.out.println(second + " - " + first + " = " + diff);
    }

    public static boolean isZs(int num) {
        if (num <= 2) {
            return false;
        }
        for (int i = 2; i < num/2+1; i ++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
