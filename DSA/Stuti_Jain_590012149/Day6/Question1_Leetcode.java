import java.util.Scanner;

class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int prev1 = 0;
        int prev2 = 0;

        for (int i = 0; i<n - 1; i++) {

            int curr = Math.max(prev1, nums[i] + prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        int ans1 = prev1;

        prev1 = 0;
        prev2 = 0;

        for (int i = 1; i<n; i++) {

            int curr = Math.max(prev1, nums[i] + prev2);

            prev2 = prev1;
            prev1 = curr;
        }

        int ans2 = prev1;

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i<n; i++) {
            nums[i] = s.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.rob(nums));
    }
}
