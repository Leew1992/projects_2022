package learning_1.week_18;

public class InternTest2 {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);
    }
}
