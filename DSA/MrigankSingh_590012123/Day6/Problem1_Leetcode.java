public class Problem1_Leetcode {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int take = prev2 + nums[i];
            int skip = prev1;
            int current = Math.max(take, skip);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}