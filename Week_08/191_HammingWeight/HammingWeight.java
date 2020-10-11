public class HammingWeight {
    /**
     * 循环右移计数
     * 时间复杂度：固定循环32次(有局限：运行环境的Int类型是32位)
     * @param n
     * @return
     */
    public static int solution1(int n) {
        int cnt = 0;

        for (int shift = 0; shift < 32; shift++) {
            if ((n & 1) == 1) cnt++;
            n >>= 1;
        }
        return cnt;
    }

    /**
     * 利用x&(x-1)来循环消除最低位1直到n为0
     * 时间复杂度：整数二进制1的个数次
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int cnt = 0;

        while (n != 0) {
            cnt++;
            n &= n - 1;
        }
        return cnt;
    }
}
