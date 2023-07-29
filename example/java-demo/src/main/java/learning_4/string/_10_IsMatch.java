package learning_4.string;

import com.alibaba.dubbo.common.utils.StringUtils;

public class _10_IsMatch {

    public static void main(String[] args) {
        String s = "ssipp";
        String p = "s*p*";
        System.out.println(new _10_IsMatch().isMatch2(s, p));
    }

    /**
     * 递归回溯
     */
    public boolean isMatch(String s, String p) {
        if (p == null || "".equals(p)) {
            return (s == null || "".equals(s));
        }
        boolean firstMatch = s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)))
                    || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * 动态规划
     * 注：找到最优子结构，直到得到最终结果
     */
    public boolean isMatch2(String s, String p) {
        // 默认值都是false
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 都为空，匹配
        dp[0][0] = true;

        // s为空，p能正确匹配的情况
        for (int j = 2; j <= p.length(); j ++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j-2];
        }

        for (int i = 0; i < s.length(); i ++) {
            for (int j = 0; j < p.length(); j ++) {
                if (p.charAt(j) == '*') {
                    // 剪除p的前两位 || 剪除s的前一位
                    dp[i+1][j+1] = dp[i+1][j-1] || firstMatch(s, p, i, j-1) && dp[i][j+1];
                } else {
                    // 剪除s和p的前一位
                    dp[i+1][j+1] = firstMatch(s, p, i, j) && dp[i][j];
                }
            }
        }

        // 最后一位为true，则表示通过子结构堆叠，能完成匹配。
        return dp[s.length()][p.length()];
    }

    public boolean firstMatch(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
}
