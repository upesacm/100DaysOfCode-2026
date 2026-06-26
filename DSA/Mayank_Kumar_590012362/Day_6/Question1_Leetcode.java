class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(r(nums, 0, n - 2), r(nums, 1, n - 1));
    }
    private int r(int[] nums, int s, int e) {
        int p2 = 0, p1 = 0;
        for (int i = s; i <= e; i++) {
            int c = Math.max(p1, p2 + nums[i]);
            p2 = p1; p1 = c;
        }
        return p1;
    }
}