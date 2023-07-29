package learning_4.string;

public class _1790_AreAlmostEqual {

    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        boolean equal = new _1790_AreAlmostEqual().areAlmostEqual(s1, s2);
        System.out.println(equal);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null || s1 == "" || s2 == null || s2 == "") {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int pos = -1;
        byte diff = 0;

        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff ++;
                if (diff > 2) {
                    return false;
                }
                if (pos == -1) {
                    pos = i;
                    continue;
                }
                if ((s1.charAt(pos) != s2.charAt(i)) || (s2.charAt(pos) != s1.charAt(i))) {
                    return false;
                }
            }
        }

        return diff == 0 || diff == 2;
    }
}
