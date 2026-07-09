package DSA.Mugdha_590015431.Day_25;

import java.util.*;

public class Question1_LeetCode {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int count = 0;

        for (int k = nums.length - 1; k >= 2; k--) {
            int left = 0;
            int right = k - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(triangleNumber(nums));

        sc.close();
    }
}