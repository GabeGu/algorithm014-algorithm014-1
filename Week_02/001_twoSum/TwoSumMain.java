public class TwoSumMain {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new int[2];

        result = twoSum.solution1(nums, target);
        for (int t : result) {
            System.out.println(t);
        }
    }    
}