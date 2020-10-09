public class IntReverse {
    /**
     * 循环取余法
     * -- 判断溢出的方式：
     *      1. 反转的结果暂存在范围更大的long类型(此题中有限制)
     *      2. 在获取一个余数之之后累加之前先判断是否将要溢出
     *      3. 溢出后反算的结果与上一次结果不应相等(需证明且运行环境允许溢出)
     * @param x
     * @return
     */
    public static int solution(int x) {
        int y = 0;

        while (x != 0) {
            int remainder = x % 10;
            if ((y > Integer.MAX_VALUE / 10) || (y == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if ((y < Integer.MIN_VALUE / 10) || (y == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            y = y * 10 + remainder;
            x /= 10;
        }
        return y;
    }
}
