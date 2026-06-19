import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;

        for(int i = 0; i<nums.length; i++) {
            if(i > reach) {
                return false;
            }

            if(i+nums[i] > reach) {
                reach = i + nums[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int(n);

        for(int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.canJump(nums));
    }
}
