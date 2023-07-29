package learning_1.week_1;

import java.util.ArrayList;
import java.util.List;

// 无重复字符串的最长子串
public class _3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = new _3_LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longest = 0;
        List<Character> temps = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i ++) {
            if (chars.length - i <= longest) {
                break;
            }
            temps.add(chars[i]);
            for (int j = i + 1; j < chars.length; j ++) {
                if (temps.contains(chars[j])) {
                    break;
                }
                temps.add(chars[j]);
            }
            longest = Math.max(temps.size(), longest);
            temps.clear();
        }
        return longest;
    }
}
