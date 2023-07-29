package learning_1.week_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 整数反转
public class _7_IntegerReverse {
    public static void main(String[] args) {
        int x = 10200;
        int result = new _7_IntegerReverse().reverse(x);
        System.out.println(result);
    }

    public int reverse(int x) {
        String sign = x < 0 ? "-" : "";
        String xStr = String.valueOf(x).replace("-", "");
        char[] chars = xStr.toCharArray();
        for (int i = 0; i < chars.length / 2; i ++) {
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        String absValue = new String(chars);
        absValue = absValue.length() > 1 ? matchRegexData(absValue) : absValue;
        if (Long.valueOf(absValue) > Integer.MAX_VALUE) {
            return 0;
        }
        return Integer.valueOf(sign + absValue);
    }

    public String matchRegexData(String data) {
        String pattern = "^(0+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(data);
        return m.replaceAll("");
    }
}
