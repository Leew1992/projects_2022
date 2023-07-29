package learning_1.week_18;

public class InternTest {
    public static void main(String[] args) {
        /*String s = new String("1"); // 返回堆中"1"的引用，将"1"放到常量池中
        s = s.intern(); // 指定常量池中的"1", 将 s 指向 "1"
        String s2 = "1";
        System.out.println(s == s2);*/

        // 指向堆中的"1"；常量池中的"1"（有两份）
        String s = new String("1");
        // 指向常量池中的"1"
        String s2 = "1";
        // 返回常量池中的"1"
        s.intern();
        System.out.println(s == s2);

        // 指向堆中的"11"；常量池中的"1"
        String s3 = new String("1") + new String("1");
        // 将堆中的"11"放到常量池（只有一份）
        s3.intern();
        // 指向堆中的"11"
        String s4 = "11";
        System.out.println(s3 == s4); // true
    }
}
