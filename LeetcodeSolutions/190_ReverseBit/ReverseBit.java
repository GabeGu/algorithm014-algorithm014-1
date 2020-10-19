public class ReverseBit {
    /**
     * 循环取余
     * @param n
     * @return
     */
    public static int solution(int n) {
        int reverseX = 0;
        for (int i = 0; i < 32; i++) {
            reverseX = (reverseX << 1) + (n & 0x01);
            n >>>= 1;
        }
        return reverseX;
    }

    /**
     * 利用颠倒前后的位位置是轴对称特性，同时控制n和以最高位为起点的msk右移，只对值为1
     * 的位进行颠倒处理，直到n为0
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int reverseX = 0;
        int msk = 0x80000000;
        while (n != 0) {
            if ((n & 1) != 0) {
                reverseX |= msk;        
            }
            n >>>= 1;
            msk >>>= 1;
        }
        return reverseX;
    }
}
