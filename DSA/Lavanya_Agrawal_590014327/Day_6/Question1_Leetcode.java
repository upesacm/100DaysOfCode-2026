import java.util.*;

public class Question1_Leetcode  {

    public static int robLinear(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;

        for(int i = start; i <= end; i++) {

            int pick = nums[i] + prev2;
            int notPick = prev1;

            int current = Math.max(pick, notPick);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if(n == 1) {
            System.out.println(nums[0]);
            sc.close();
            return;
        }

        int option1 = robLinear(nums, 0, n - 2);
        int option2 = robLinear(nums, 1, n - 1);

        System.out.println(Math.max(option1, option2));

        sc.close();
    }
}