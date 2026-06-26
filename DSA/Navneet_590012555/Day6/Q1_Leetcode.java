class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(f(nums, 0, n - 2), f(nums, 1, n - 1));
    }

    private int f(int[] a, int l, int r) {
        int p = 0, q = 0;
        for (int i = l; i <= r; i++) 
        {
            int c = Math.max(q, p + a[i]);
            p = q;
            q = c;
        }
        return q;
    }
}