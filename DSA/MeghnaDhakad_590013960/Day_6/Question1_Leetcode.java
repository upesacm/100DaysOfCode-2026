package DSA.MeghnaDhakad_590013960.Day_6;
import java.util.Arrays;
public class Question1_Leetcode {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int case1 = f(nums, n - 2, 0, dp1);
        int case2 = f(nums, n - 1, 1, dp2);

        return Math.max(case1, case2);
    }

    public int f(int[] nums, int i, int start, int[] dp) {
        if (i < start) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob = nums[i] + f(nums, i - 2, start, dp);
        int notRob = f(nums, i - 1, start, dp);

        return dp[i] = Math.max(rob, notRob);
    }
    public static void main(String[] args){
        Question1_Leetcode obj = new Question1_Leetcode();
        int[] nums = {1,2,3,1};
        System.out.println(obj.rob(nums));
    }
}
