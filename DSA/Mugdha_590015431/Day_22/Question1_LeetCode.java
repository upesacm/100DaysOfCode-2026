package DSA.Mugdha_590015431.Day_22;
import java.util.*;

public class Question1_LeetCode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;

        // Move non-zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill remaining positions with zeros
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}