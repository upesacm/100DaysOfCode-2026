class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int far=0;
        for(int i=0;i<n;i++){
            if(i>far){
                return false;
            }
            far=Math.max(far,i+nums[i]);

        }
        return true;
    }
}