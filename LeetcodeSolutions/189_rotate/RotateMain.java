/**
 * Main
 */
public class RotateMain {

    public static void main(String[] args) {
        Rotate solutions = new Rotate();
        int[] nums = {0, 1, 1, 3, 4};
        solutions.rotate(nums, 501);
        for (int i = 0x00; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}