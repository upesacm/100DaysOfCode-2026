// LeetCode Problem 55: Jump Game

class Solution {
    public boolean canJump(int[] nums) {
        int count = nums.length;
        int maxReach = 0;
        
        for (int i = 0; i < count; i++) {
            if (i > maxReach) {
                return false;
            }
            
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
            
            if (maxReach >= count - 1) {
                return true;
            }
        }
        
        return true;
    }
}
