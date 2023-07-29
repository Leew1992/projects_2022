package learning_2.week_14;

public class StringTest1 {
    private static String s1;
    private static String s2;

    /**
     * s1+s2 相加，底层是通过 StringBuilder的append()方法来实现的，
     * 如果 value 是null，appendNull()会返回一个"null"字符串。
     */
    public static void main(String[] args) {
        String s= s1+s2;
        System.out.println(s);
    }
}