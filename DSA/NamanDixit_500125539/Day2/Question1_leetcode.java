//Remove Element
//Explanation
//Given an integer array nums and an integer val, remove all occurrences of val in-place and return the number of remaining elements.

class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;        
    }
}
