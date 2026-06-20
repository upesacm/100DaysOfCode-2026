// LeetCode Problem 213: House Robber II

class Solution {
    public int rob(int[] nums) {
        int count = nums.length;
        
        if (count == 1) {
            return nums[0];
        }
        if (count == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int rob1 = 0;
        int rob2 = 0;
        for (int i = 0; i < count - 1; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int max1 = rob2;
        
        rob1 = 0;
        rob2 = 0;
        for (int i = 1; i < count; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int max2 = rob2;
        
        return Math.max(max1, max2);
    }
}
