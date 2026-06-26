
// import java.util.*;
class Solution {
    int[] memo = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        Arrays.fill(memo, -1);
        int case1 = solve(nums, 0, n - 2);
        Arrays.fill(memo, -1);
        int case2 = solve(nums, 1, n - 1);
        return Math.max(case1, case2);
    }
    private int solve(int[] nums, int ind, int end) {
        if(ind > end) {
            return 0;
        }
        if(memo[ind] != -1) {
            return memo[ind];
        }
        int skipped = solve(nums, ind + 1, end);
        int robbed = nums[ind] + solve(nums, ind + 2, end);
        return memo[ind] = Math.max(skipped, robbed);
    }
}