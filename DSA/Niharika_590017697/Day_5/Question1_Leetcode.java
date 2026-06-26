class Solution {
    public boolean canJump(int[] nums) 
    {
        int f = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            if (i > f) 
            {
                return false;
            }
            f = Math.max(f, i + nums[i]);
            if (f >= nums.length - 1) 
            {
                return true;
            }
        }
        return true;
    }
}
