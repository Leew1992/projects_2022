package learning_4.aaa;

public class _10_IsMatch_BK {

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new _10_IsMatch_BK().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || s == "" || p == null || p == "") {
            return false;
        }
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < s.length() && pIndex < p.length()) {
            if (s.charAt(sIndex) == p.charAt(pIndex)) {
                sIndex ++; pIndex ++;
                continue;
            }
            if (p.charAt(pIndex) == '.') {
                sIndex ++; pIndex ++;
                continue;
            }
            if (p.charAt(pIndex) == '*') {
                if (pIndex + 1 == p.length()) {
                    return true;
                }
                pIndex = getPCharButNotMark(p, pIndex);
                if (pIndex == -1) {
                    return true;
                }
                int sPosition = getSPosition(s, sIndex, p.charAt(pIndex));
                if (sPosition == -1) {
                    return false;
                }
                while (sPosition != -1) {
                    sIndex = sPosition;
                    boolean match = isMatch(s.substring(sIndex), p.substring(pIndex));
                    if (!match) {
                        sIndex ++;
                        sPosition = getSPosition(s, sIndex, p.charAt(pIndex));
                        if (sPosition == -1) {
                            return false;
                        }
                    }
                    if (s.substring(sIndex).equals(p.substring(pIndex))) {
                        return true;
                    }
                }
            }
            if (s.charAt(sIndex) != p.charAt(pIndex)) {
                sIndex ++; pIndex ++;
                return false;
            }
        }
        pIndex = getPCharButNotMark(p, pIndex);
        if (sIndex >= s.length() && (pIndex >= p.length() || pIndex == -1)) {
            return true;
        }
        return false;
    }

    private int getSPosition(String s, int sIndex, char c) {
        while (sIndex < s.length()) {
            if (s.charAt(sIndex) == c) {
                return sIndex;
            }
            sIndex ++;
        }
        return -1;
    }

    private int getPCharButNotMark(String p, int pIndex) {
        if (pIndex >= p.length()) {
            return -1;
        }
        while (p.charAt(pIndex) == '*' || p.charAt(pIndex) == '.') {
            pIndex ++;
            if (pIndex == p.length()) {
                return -1;
            }
        }
        return pIndex;
    }
}
