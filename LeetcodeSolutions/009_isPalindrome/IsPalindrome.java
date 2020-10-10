public class IsPalindrome {
    /**
     * 根据回文数的定义将整数反转与原数进行判断，使用现成的整数反转接口
     * @param x
     * @return
     */
    public static boolean solution(int x) {
        if (x >= 0 && x == intReverse(x)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int intReverse(int x) {
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

    /**
     * 利用回文数的轴对称特性，如果是回文数，在循环取余过半即可判断出
     * @param x
     * @return
     */
    public static boolean solution2(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;
        int y = 0;

        while (x != 0) {
            int remainder = x % 10;
            if ((y > Integer.MAX_VALUE / 10) || (y == Integer.MAX_VALUE / 10 && remainder > 7)) return false;
            if ((y < Integer.MIN_VALUE / 10) || (y == Integer.MIN_VALUE / 10 && remainder < -8)) return false;
            y = y * 10 + remainder;
            if (x == y) return true;
            x /= 10;
            if (x == y) return true;
        }
        return false;
    }

    /**
     * 如果不是回文数，在循环取余过半后反转的数大于被取余的原数时即可退出
     * @param x
     * @return
     */
    public static boolean solution3(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int y = 0;

        while (y < x) {
            int remainder = x % 10;
            y = y * 10 + remainder;
            if (x == y) return true;
            x /= 10;
            if (x == y) return true;
        }
        return false;
    }

    /**
     * 官方题解：反转一半数字
     * @param x
     * @return
     */
    public static boolean solution4(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int reverseX = 0; 

        while (reverseX < x) {
            reverseX = reverseX * 10 + x % 10;
            x /= 10;
        }
        return x == reverseX || x == reverseX / 10;
    }
}
