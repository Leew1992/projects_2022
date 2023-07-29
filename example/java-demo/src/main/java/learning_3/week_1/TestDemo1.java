package learning_3.week_1;

import org.springframework.util.ObjectUtils;

public class TestDemo1 {

    public static void main(String[] args) {
        // testNull();
        testString();
    }

    private static void testNull() {
        String a = null;
        String b = null;
        System.out.println(a + b);
    }

    private static void testString() {
        // String a = new String("abc"); // 栈中的引用，指向new出来的对象
        String a = "abc"; // 栈中的引用 等于 常量池中的引用
        String b = a.intern(); // 栈中的引用 等于 常量池中的引用
        System.out.println(ObjectUtils.getIdentityHexString(a));
        System.out.println(ObjectUtils.getIdentityHexString(b));
    }
}
