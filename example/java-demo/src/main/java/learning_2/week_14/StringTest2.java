package learning_2.week_14;

import java.lang.reflect.Field;

public class StringTest2 {
    public static void main(String[] args) throws Exception {
        test5();
    }

    private static void test1() throws Exception {
        String s="Hydra";
        /**
         * 1、生成了hashCode
         */
        System.out.println(s+":  "+s.hashCode());

        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        /**
         * 1、修改了 char[]
         * 2、但 hashCode 因为有值，所以hashCode()方法不会用新的char[]，去生成新的hashCode
         */
        field.set(s,new char[]{'T','r','u','n','k','s'});
        System.out.println(s+": "+s.hashCode());
    }

    public static void test2() {
        /**
         * ldc #2 - 查询 #2 对应的字符串，是否在常量池中，
         * 如果存在，则返回常量池中的 String对象 的引用，
         * 如果没有，则在堆中创建一个 String 对象（有内容），然后在 StringTable 驻留这个对象引用，最后将引用压入到栈中
         * astore_1 - 弹出栈顶元素，将元素保存到 局部变量表1 中
         * return - 执行void函数返回
         */
        String s = "Hydra";
    }

    private static void test3() {
        /**
         * new #2 - 在堆上创建一个 String 对象 StringObject1（空壳），并将对象的引用，压入到栈中（s1）
         * dup - 复制栈顶元素（s1），再压入栈中（用于初始化）
         * ldc #3 - 在堆上创建 String 对象 StringObject2（有内容），驻留到字符串常量池，并将引用压入到栈中（s2）
         * invokespecial #4 - 执行 String 对象的构造方法，弹出栈中s2，s1，将s1.value指向s2.value，完成初始化
         */
        String s = new String("Hydra");
    }

    private static void test4() {
        /**
         * 1、会在堆中创建 "Hy" 和 "dra" 的字符串对象，并驻留到字符串常量池
         * 2、编译器会把拼接，优化成 StrinbUilder 的 append 方法，
         *    调用 toString 返回一个 String 对象（等同于 new String("Hydra")）
         * 3、在堆中创建一个 String 对象（有内容），驻留到字符串常量池中，并将引用压入栈中，
         * 4、最将弹栈将栈顶元素写入到局部变量表中
         */
        String s1 = new String("Hy") + new String("dra");
        /**
         * 1、在常量池中创建一个HashTableEntry对象，value 指向 StringObject1
         */
        s1.intern();
        /**
         * 1、在栈中创建一个s2引用
         * 2、s2引用指向 StringObject1（常量池指向的String对象）
         */
        String s2 = "Hydra";
        /**
         * 1、s1和s2都指向 StringObject1，所有两者相等
         */
        // System.out.println(s1 == s2);
    }

    private static void test5() {
        /**
         * 在堆中创建了一个String对象
         */
        String s = "a" + "b" + "c";
        System.out.println(s);
    }
}
