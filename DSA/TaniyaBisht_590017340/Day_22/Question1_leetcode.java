
class Solution {
    public void moveZeroes(int[] nums) {
        int ind= 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[ind] = nums[i];
                ind++;
            }
        }
        for(int i=ind; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}