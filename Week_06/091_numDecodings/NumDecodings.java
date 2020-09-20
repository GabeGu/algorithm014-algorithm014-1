public class NumDecodings {
    /** 
     * 自底向上即从字符串s的末尾往前开始计算
     * c1 c2 c3 ... ci ci+1 ci+2 ... cn-1 cn
     *                                  <---
     * ci的方法总数为：
     *   1. 如果ci非'0'，则算上ci+1的方法总数；否则为0
     *   2. 如果ci和ci+1合并为合法字符，则再算上ci+2的方法总数，否则再算上0
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int solutin(String s) {
        if (s.length() <= 0) return s.length();

        int num_i = 0, num_i_1 = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                num_i = num_i_1 = s.charAt(i) != '0' ? 1 : 0;
            }
            else if (i == len - 2) {
                num_i = s.charAt(i) != '0' ? num_i_1 : 0;
                num_i += isValidChar(s.charAt(i), s.charAt(i + 1)) ? 1 : 0;
            }
            else {
                int tmp = num_i;
                num_i = s.charAt(i) != '0' ? num_i : 0;
                num_i += isValidChar(s.charAt(i), s.charAt(i + 1)) ? num_i_1 : 0;
                num_i_1 = tmp;
            }
        }
        return num_i;
    }
    public static boolean isValidChar(char i, char i_1) {
        if (i == '0') return false;

        int v_i = i - '0';
        int v_i_1 = i_1 - '0';
        int v = v_i * 10 + v_i_1;
        if (v >= 1 && v <= 26) {
            return true;
        }
        else {
            return false;
        }
    }
}
