class Solution {
    public boolean canJump(int[] nums) {
        int m = 0, n = nums.length;
        for (int i = 0; i <= m && i < n; i++) {
            m = Math.max(m, i + nums[i]);
            if (m >= n - 1) return true;
        } return false;
    }
}