class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // farthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;  // stuck, can't move forward
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true; // we can reach the end
    }
}