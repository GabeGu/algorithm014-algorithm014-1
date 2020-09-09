public class TwoSumMain {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        int[] result = new int[2];

        result = twoSum.solution3(nums, target);
        for (int t : result) {
            System.out.println(t);
        }
    }    
}