package Day_6;

import java.util.Scanner;

import Day_5.d5question1_leetcode;

public class d6question1_leetcode {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: rob from 0 to n-2
        int prev1 = 0, curr1 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curr1;
            curr1 = Math.max(curr1, prev1 + nums[i]);
            prev1 = temp;
        }

        // Case 2: rob from 1 to n-1
        int prev2 = 0, curr2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curr2;
            curr2 = Math.max(curr2, prev2 + nums[i]);
            prev2 = temp;
        }

        return Math.max(curr1, curr2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // size of the input array
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
            Arr[i] = sc.nextInt();     // elements of the array
        }

        d6question1_leetcode obj = new d6question1_leetcode();
        System.out.println(obj.rob(Arr));
    }
}
