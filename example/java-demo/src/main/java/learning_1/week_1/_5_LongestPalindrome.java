package learning_1.week_1;

import java.util.HashMap;
import java.util.Map;

// 最长回文字串
public class _5_LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String result = new _5_LongestPalindrome().longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s == null || s == "") {
            return s;
        }
        String maxOddPalindrome = getMaxOddPalindrome(s);
        String maxEvenPalindrome = getMaxEvenPalindrome(s);
        String maxSymmetryPalindrome = getMaxSymmetryPalindrome(s);
        String maxPalindrome = maxOddPalindrome.length() > maxEvenPalindrome.length() ? maxOddPalindrome : maxEvenPalindrome;
        return maxPalindrome.length() > maxSymmetryPalindrome.length() ? maxPalindrome : maxSymmetryPalindrome;
    }

    // 获取最大奇回文
    private static String getMaxOddPalindrome(String str) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length() - 1; i ++) {
            // 奇回文
            int oddInterval = recursiveOddPalindrome(str, i, 1);
            map.put(i, oddInterval);
        }

        // 求最大Interval
        int[] indexs = getMaxPalindromIndex(map);

        // 取回文子串
        int start = indexs[0] - indexs[1] < 0 ? 0 : indexs[0] - indexs[1];
        int end = indexs[0] + indexs[1] + 1 < str.length() ? indexs[0] + indexs[1] + 1 : str.length();
        return str.substring(start, end);
    }

    // 获取最大偶回文
    private static String getMaxEvenPalindrome(String str) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length(); i ++) {
            // 偶回文
            int evenInterval = recursiveEvenPalindrome(str, i, 1);
            map.put(i, evenInterval);
        }

        // 求最大Interval
        int[] indexs = getMaxPalindromIndex(map);

        // 取回文子串
        int start = indexs[0] - indexs[1] < 0 ? 0 : indexs[0] - indexs[1];
        int end = indexs[0] + 1 < str.length() ? indexs[0] + 1 : str.length();
        return str.substring(start, end);
    }

    // 获取最大对称回文
    private static String getMaxSymmetryPalindrome(String str) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length(); i ++) {
            // 偶回文
            int symmetryInterval = recursiveSymmetryPalindrome(str, i, 1);
            map.put(i, symmetryInterval);
        }

        // 求最大Interval
        int[] indexs = getMaxPalindromIndex(map);

        // 取回文子串
        int start = indexs[0] - indexs[1] < 0 ? 0 : indexs[0] - indexs[1];
        int end = indexs[0] + indexs[1] < str.length() ? indexs[0] + indexs[1] : str.length();
        return str.substring(start, end);
    }

    // 获取奇回文（两边延伸）
    private static int recursiveOddPalindrome(String str, int index, int interval) {
        while (index - interval >= 0 && index + interval <= str.length() - 1) {
            if (str.charAt(index - interval) == str.charAt(index + interval)) {
                return recursiveOddPalindrome(str, index, interval + 1);
            }
            return interval - 1;
        }
        return interval - 1;
    }

    // 获取偶回文（左延伸）
    private static int recursiveEvenPalindrome(String str, int index, int interval) {
        while (index - interval >= 0) {
            if (str.charAt(index - interval) == str.charAt(index)) {
                return recursiveEvenPalindrome(str, index, interval + 1);
            }
            return interval - 1;
        }
        return interval - 1;
    }

    // 获取对称回文（两边延伸）
    private static int recursiveSymmetryPalindrome(String str, int index, int interval) {
        while (index - interval >= 0 && index + interval - 1 < str.length()) {
            if (str.charAt(index + interval - 1) == str.charAt(index - interval)) {
                return recursiveSymmetryPalindrome(str, index, interval + 1);
            }
            return interval - 1;
        }
        return interval - 1;
    }

    // 获取最大的回文下标
    private static int[] getMaxPalindromIndex(Map<Integer, Integer> map) {
        int[] result = new int[2];
        int index = 0, maxInterval = 0;
        for (int key : map.keySet()) {
            if (maxInterval < map.get(key)) {
                index = key;
                maxInterval = map.get(key);
            }
        }
        result[0] = index;
        result[1] = maxInterval;
        return result;
    }
}
