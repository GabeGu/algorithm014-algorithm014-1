/**
 * Main
 */
public class TestMain {

    public static void main(String[] args) {
        RemoveDuplicate solutions = new RemoveDuplicate();
        int[] nums = {0, 1, 1, 3, 4};
        int len = solutions.removeDuplicates(nums);
        for (int i = 0x00; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}