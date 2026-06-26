public class HouseRobber {

    // Function for normal House Robber
    static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    static int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int case1 = robLinear(nums, 0, n - 2); // Exclude last house
        int case2 = robLinear(nums, 1, n - 1); // Exclude first house

        return Math.max(case1, case2);
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};   // Change test case here

        System.out.println(rob(nums));
    }
}