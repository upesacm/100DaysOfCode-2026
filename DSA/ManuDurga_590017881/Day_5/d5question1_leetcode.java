package Day_5;

import java.util.Scanner;

public class d5question1_leetcode {
    public boolean canJump(int[] nums) {
        return canReach(nums, 0);
    }

    private boolean canReach(int[] nums, int pos) {
        if (pos >= nums.length - 1) return true;
        for (int step = 1; step <= nums[pos]; step++) {
            if (canReach(nums, pos + step)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // size of the input array
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
            Arr[i] = sc.nextInt();     // elements of the array
        }

        d5question1_leetcode obj = new d5question1_leetcode();
        System.out.println(obj.canJump(Arr));
    }
}
