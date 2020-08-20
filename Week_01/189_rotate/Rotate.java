public class Rotate {
    public Rotate() {}
    public void rotate(int[] nums, int k) {
        if ((nums.length <= 1) || (k % nums.length == 0)) return;

        k %= nums.length;                         // 取余，去除k>n时重复循环的移动
        arrReverse(nums, 0, nums.length - 1);     // 先整体反转
        arrReverse(nums, 0, k - 1);               // 再前k个反转
        arrReverse(nums, k, nums.length - 1);     // 再后k-n个反转
    }

    /**
     * 对指定的数组元素进行反转倒置
     * @param nums:指定的数组
     * @param s:数组起始索引
     * @param e:数组末尾索引
     */
    public static void arrReverse(int[] nums, int s, int e) {
        /* 
        for (int i = 0; i < (e - s + 1) / 2; i++) {
            int tmp = nums[s + i];
            nums[s + i] = nums[e - i];
            nums[e - i] = tmp;
        }
        */
        while (s < e) {
            int tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
    }
}