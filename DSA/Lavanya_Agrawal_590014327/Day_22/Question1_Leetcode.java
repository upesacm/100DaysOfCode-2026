import java.util.*;

public class Question1_Leetcode {

    public static void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i != n - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}