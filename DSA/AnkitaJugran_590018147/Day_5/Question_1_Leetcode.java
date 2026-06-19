class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int i = 0;
        while( i < nums.length) {
            if ( i > farthest ){
                return false;
            }

            farthest = Math.max( farthest , i+nums[i]);
            i++;
        }
        return true;
    }
}