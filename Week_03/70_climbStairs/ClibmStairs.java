public class ClibmStairs {
    /** 
     * 解法1：递归法
     * 思路：一次只能爬1步或2步，那么：
     *      当n=1时，就只有1种方法即爬1步
     *      当n=2时，可以直接爬2步到达或者先爬1步到1级再爬1步到达即2种方法。
     *      当n=3时，由于最多一次只能爬2步，所以不能一次爬到第三台阶，只能从第1级台阶或第2级台阶开始爬，如果从第2级台阶开始爬只需
     *      再爬1步即可到达，而爬到第2级有2种方法，那么此情况就有2种(等于爬到第2级台阶的方法)；如果从第1级台阶开始爬到第3级台阶有
     *      2种即爬1步到第2级再爬1步到达，此情况其实已经包含在上述从第2级台阶开始爬的情况，所以不算，那么另外一种即从第1级台阶直接
     *      爬2步到达，而爬到第1级有1种方法，那么此情况就有1种(等于爬到第1级台阶的方法)。所以爬到第3级台阶的方法就是到第1级和第2级
     *      的方法和。
     *      当n=4时，同理只能从第2级开始爬2步或者从第3级开始爬1步，即爬到第2级和第3级的方法和。以此类推
     *      当为n时，同理只能从第n-2级开始爬2步或者从n-1级爬1步到达，即爬到n-2和n-1级的方法和，即求第n个斐波那契数列的值
     *      f(n) = f(n-1) + f(n-2) (n>=3)
     * 
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(1)
     */
    public static int solution1(int n) {
        if (n <= 2) return n;

        return solution1(n - 1) + solution1(n - 2);
    }

    /**
     * 解法2：缓存法
     * 思路：解法1的递归操作由于有大量的重复计算导致时间复杂度为指数级别，根据斐波那契序列的特性，后续序列的值是基于前2个序列值之和
     *      递推得到，那么求第n个序列的值就可以从第1和第2个序列做为最近的2个值a和b开始，逐步计算下一个序列的值，每求得一个新的序列
     *      值就将a和b同步更新，依次类推知道求的第n个序列的值。
     *      
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int solution2(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2;               // 序列起点
        int res = 0;                    // 最新序列值
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;                      // 更新最近2个序列值
            b = res;
        }
        return res;
    }
}