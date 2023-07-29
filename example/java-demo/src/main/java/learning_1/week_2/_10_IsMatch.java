package learning_1.week_2;

// 正则表达式匹配
public class _10_IsMatch {
    public static void main(String[] args) {
        String s = "abcdefg";
        String p = "ab*c.*d.e*fg";
        boolean result = new _10_IsMatch().isMatch(s, p);
        System.out.println(result);
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() &&

                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
