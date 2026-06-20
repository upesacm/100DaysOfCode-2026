class Solution {

    private int robLinear(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int curr = Math.max(prev1, prev2 + nums[i]); // Choose rob or skip

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) { // Only one house
            return nums[0];
        }

        return Math.max(
            robLinear(nums, 0, n - 2), // Exclude last house
            robLinear(nums, 1, n - 1)  // Exclude first house
        );
    }
}

//logic: first and last house are adjacent because houses form a circle.
//Solve two cases:
//1. Rob from first to second-last.
//2. Rob from second to last.
//Maximum of both answers is the result.