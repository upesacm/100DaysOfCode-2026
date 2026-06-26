package DSA.Mugdha_590015431.Day_6;
import java.util.*;

public class Question1_LeetCode {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of houses
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = rob(nums);
        System.out.println(result);

        sc.close();
    }

    public static int rob(int nums[]) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1)
        );
    }

    public static int robLinear(int nums[], int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int pick = nums[i] + prev2;
            int notPick = prev1;

            int curr = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}