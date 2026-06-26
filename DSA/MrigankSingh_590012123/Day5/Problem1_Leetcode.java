public class Problem1_Leetcode {
    public boolean Jump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable >= nums.length - 1) {
                return true;
            }
        }
        return reachable >= nums.length - 1;
    }
}
