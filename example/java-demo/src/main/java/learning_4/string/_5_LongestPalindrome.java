package learning_4.string;

public class _5_LongestPalindrome {
    public static void main(String[] args) {
        // babad cbbd aacabdkacaa bacabab
        String s = "bacabab";
        String result = new _5_LongestPalindrome().longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s == null || s == "" || s.length() == 1) {
            return s;
        }

        String s1 = new StringBuffer(s).reverse().toString();
        if (s.equals(s1)) {
            return s;
        }

        int maxStart = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length() - 1; i ++) {
            String c = s.substring(i, i + 1);
            int start = s1.indexOf(c);
            int indexStart = start;
            while (indexStart != -1) {
                int index = i;
                int length = 0;
                while (index < s.length() && start < s.length()
                        && s.charAt(index++) == s1.charAt(start++)) {
                    length ++;
                    if (length > maxLength) {
                        String sub1 = s.substring(index - length, index);
                        String sub2 = new StringBuilder(sub1).reverse().toString();
                        if (sub1.equals(sub2)) {
                            maxStart = start;
                            maxLength = length;
                        }
                    }
                }
                start = s1.indexOf(c, indexStart + 1);
                indexStart = start;
            }
        }

        return s1.substring(maxStart-maxLength, maxStart);
    }
}
