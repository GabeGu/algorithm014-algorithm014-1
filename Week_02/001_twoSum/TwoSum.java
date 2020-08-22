public class TwoSum {
    public TwoSum() {}

    /** 
     * 解法1：双循环暴力法 
     * 思路：数组里的两个数相加等于目标值，那么循环遍历数组的每个元素，与剩下的每个元素依次相加来判断是否等于目标值
     * 
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * */
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {         // 遍历每个元素
            for (int j = i + 1; j < nums.length; j++) { // 遍历剩下的每个元素
                if (nums[i] + nums[j] == target) {      // 找到即返回
                    int[] arr = {i ,j};
                    return arr;
                }
            }
        }
        /** 如果给定的数组和目标值找不到答案，在C语言中一般返回NULL即空指针用于指代无结果。而Java语言好像不能使用NULL，
         *  需使用报异常的方式来处理。
         *  对于C，程序把NULL当作一种预期的结果处理，故程序能够继续正常执行
         *  而对于报异常方式的Java来看，此情况会终止程序
         * */ 
        throw new IllegalArgumentException("no two numbers that sum of which are equal to the target!");
    }
}