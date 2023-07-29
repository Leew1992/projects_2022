package learning_1.week_2;

// 回文数
// 注：数字处理比字符串处理要快一些
public class _9_IsPalindrome {
    public static void main(String[] args) {
        int x = 121;
        boolean result = new _9_IsPalindrome().isPalindrome(x);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int mod = x % 10;
        int y = x / 10;
        int reverse = 0;
        while (y > 0) {
            reverse = (reverse + mod) * 10;
            mod = y % 10;
            y = y / 10;
        }
        reverse =  reverse + mod;

        if (x != reverse) {
            return false;
        }
        return true;
    }
}
