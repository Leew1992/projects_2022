package learning_1.week_1;

// Z字形变换
public class _6_ZConvert {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String result = new _6_ZConvert().convert(s, 4);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int usedLength = s.length() - 1;
        int usedRowNum = numRows - 1;
        int index = 1 + (usedLength-((usedLength/usedRowNum+1)/2)*usedRowNum);
        char[][] result = new char[numRows][index];
        char[] chars = s.toCharArray();
        // 首位
        result[0][0] = chars[0];
        // 拆分
        String[] subStrs = splitSubStr(s, usedRowNum);
        // 画图
        for (int i = 0; i < subStrs.length; i ++) {
            if (i%2==0) {
                drawVerticalLines(result, 0, usedRowNum*(i/2), subStrs[i]);
            } else {
                drawSlash(result, usedRowNum, usedRowNum*(i/2), subStrs[i]);
            }
        }
        // 输出
        return geneZImage(result);
    }

    // 拆分n的子串
    private String[] splitSubStr(String str, int n) {
        String[] result = new String[(str.length()-2)/n+1];
        for (int i = 0; i < result.length; i ++) {
            int start = 1+n*i;
            int end = 1+n+n*i < str.length() ? 1+n+n*i : str.length();
            result[i] = str.substring(start, end);
        }
        return result;
    }

    // 填补竖线
    private void drawVerticalLines(char[][] axis, int x, int y, String part) {
        char[] parts = part.toCharArray();
        for (int i = 1; i <= part.length(); i ++) {
            axis[x+i][y] = parts[i-1];
        }
    }

    // 填补斜线
    private void drawSlash(char[][] axis, int x, int y, String part) {
        char[] parts = part.toCharArray();
        for (int i = 1; i <= part.length(); i ++) {
            axis[x-i][y+i] = parts[i-1];
        }
    }

    // 生成Z字图
    private String geneZImage(char[][] axis) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < axis.length; i ++) {
            for (int j = 0; j < axis[i].length; j ++) {
                sb.append(axis[i][j] == '\u0000' ? "" : axis[i][j]);
            }
        }
        return sb.toString();
    }
}
