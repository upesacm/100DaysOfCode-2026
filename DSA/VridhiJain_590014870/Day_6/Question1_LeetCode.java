package DSA.VridhiJain_590014870.Day_6;

class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int first = robRange(nums, 0, n - 2);
        int last = robRange(nums, 1, n - 1);

        return Math.max(first, last);
    }

    private int robRange(int[] nums, int start, int end) {

        int[] dp = new int[end - start + 1];

        dp[0] = nums[start];

        if (dp.length == 1) {
            return dp[0];
        }

        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < dp.length; i++) {

            int take = dp[i - 2] + nums[start + i];
            int skip = dp[i - 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[dp.length - 1];
    }
}