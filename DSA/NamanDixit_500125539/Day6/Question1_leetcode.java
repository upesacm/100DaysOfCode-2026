/*House Robber II
Given an array where each element represents the
amount of money in a house arranged in a circle,
determine the maximum amount of money that can be robbed 
without robbing two adjacent houses */


class Question1_leetcode {

    private int maximumNonAdjacentSum(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if (i > 1) {
                take += prev2;
            }

            int notTake = prev;

            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] temp1 = new int[n - 1]; // exclude first
        int[] temp2 = new int[n - 1]; // exclude last

        for (int i = 1; i < n; i++) {
            temp1[i - 1] = nums[i];
        }

        for (int i = 0; i < n - 1; i++) {
            temp2[i] = nums[i];
        }

        int ans1 = maximumNonAdjacentSum(temp1);
        int ans2 = maximumNonAdjacentSum(temp2);

        return Math.max(ans1, ans2);
    }
}