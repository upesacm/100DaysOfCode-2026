
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int lastIn = nums.length - 1;
        int maxReach = nums[0];
        for(int i=1; maxReach >=i; i++){
            if(maxReach >= lastIn){
                return true;
            }
            else{
                maxReach = Math.max(maxReach, nums[i]+i);
            }
        }
        return false;
    }
}