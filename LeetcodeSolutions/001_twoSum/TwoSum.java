import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public TwoSum() {}

    /** 
     * 解法1：双循环暴力法 
     * 思路：数组里的两个数相加等于目标值，那么循环遍历数组的每个元素，与剩下的每个元素依次相加来判断是否等于目标值即排列组合
     *      所有可能的情况最终找出满足的组合，由于假设每种输入只会对应一个答案，那么找到即可返回
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

    /**
     * 解法2：哈希表
     * 思路：满足的条件是a+b=t，变换一下公式即满足条件a=t-b，其中t是已知的，那么当b也是已知的时候，问题即转变为t-b也就是a
     *      是否也在数组中。其中b同样通过遍历的方式获取(此时b的索引是已知的)，所以只要让“判断a是否也在数组”这一操作能够
     *      更加快速地实现，那么时间复杂度就比解法1更优。实现这一方式就是实现建立好数组元素与其索引的一张哈希表，然后通过
     *      哈希表是否包含a这个key来判断。
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int searchValue = target - nums[j];

            if (map.containsKey(searchValue)) {// 一个元素不能使用两遍
                if (map.get(searchValue) != j) {
                    int[] arr = {j, map.get(searchValue)};
                    return arr;
                }
            }
        }
        throw new IllegalArgumentException("no two numbers that sum of which are equal to the target!");
    }

    /**
     * 解法3：哈希表优化版
     * 思路：由于题解假设每种输入只会对应一个答案，那么在构造哈希表的过程中即可判断a是否在当前的哈希表中。
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int searchValue = target - nums[i];
            /**
             * !!!当添加已存在的key时，哈希表会更新成新的value，如此当[3, 3, 6], t=6情况时,
             * 在添加第二个3之前应该先进行判断，否则会因丢失第一3的键值信息而找不到答案
             */
            if (map.containsKey(searchValue)) {             
                if (map.get(searchValue) != i) {            // 不能使用同一个元素
                    int[] arr = {map.get(searchValue), i};  // 先添加的索引在前
                    return arr;
                }
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two numbers that sum of which are equal to the target!");
    }
}