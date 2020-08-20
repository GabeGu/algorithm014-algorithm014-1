public class RemoveDuplicate {
    public RemoveDuplicate() {}
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int j = 0x00;
        for (int i = 0x00; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}