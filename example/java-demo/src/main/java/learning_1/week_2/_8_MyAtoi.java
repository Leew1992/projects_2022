package learning_1.week_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 字符串转整数
public class _8_MyAtoi {
    public static void main(String[] args) {
        String str = "-200000000000000000000000000000000000";
        int result = new _8_MyAtoi().myAtoi(str);
        System.out.println(result);
    }

    public int myAtoi(String str) {
        str = str.trim();
        String pattern = "^([+,-]{0,1}(\\d+))(.*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            String digit = m.group(1);
            int sign = matchRegexSign(digit);
            String unSignDigit = digit.replace("+", "")
                    .replace("-", "");
            String formatDigit = matchRegexData(unSignDigit);
            int value = compareDigitStr(formatDigit);
            if (value == 1 && sign == -1) {
                return Integer.MIN_VALUE;
            }
            if (value == 1 && sign == 1) {
                return Integer.MAX_VALUE;
            }
            return Integer.valueOf(digit);
        }
        return 0;
    }

    public int matchRegexSign(String data) {
        if (data.startsWith("-")) {
            return -1;
        }
        return 1;
    }

    public String matchRegexData(String data) {
        String pattern = "^(0+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(data);
        return m.replaceAll("");
    }

    public int compareDigitStr(String str) {
        String maxIntegerStr = String.valueOf(Integer.MAX_VALUE);
        if (str.length() < maxIntegerStr.length()) {
            return 0;
        }
        if (str.length() > maxIntegerStr.length()) {
            return 1;
        }
        if (Long.valueOf(str) > Integer.MAX_VALUE) {
            return 1;
        }
        if (Long.valueOf(str) < Integer.MIN_VALUE) {
            return 1;
        }
        return 0;
    }
}
