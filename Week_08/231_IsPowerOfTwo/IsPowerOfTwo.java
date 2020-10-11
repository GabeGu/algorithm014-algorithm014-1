public class IsPowerOfTwo {
    public static boolean solution(int n) {
        if (n <= 0) return false;
        n &= n - 1;
        return n == 0 ? true : false;
    }

    public static boolean solution2(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
