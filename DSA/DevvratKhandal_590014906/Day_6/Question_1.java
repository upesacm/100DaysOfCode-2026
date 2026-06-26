import java.util.Scanner;

public class Question_1 {

    static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter money in each house:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }

        int ans = Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1)
        );

        System.out.println(ans);
    }
}