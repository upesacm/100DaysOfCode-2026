package Day_22;

import java.util.*;

public class d22question1_leetcode {
    
    public static class Solution {
        public int[] moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) if (nums[i] != 0) nums[j++] = nums[i];
            for (int i = j; i < nums.length; i++) nums[i] = 0;
            return nums;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        int[] zero = sol.moveZeroes(digits);
        System.out.println(Arrays.toString(zero));

        sc.close();
    }
}
