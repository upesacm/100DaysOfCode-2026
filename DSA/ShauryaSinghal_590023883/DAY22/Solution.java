class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0 ; i < nums.length - 1 ; i++){
            if(nums[i] == 0){
                for(int j = i ; j < nums.length - 1 - i ; j++){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp; 
                }
            }
        }
    }
}