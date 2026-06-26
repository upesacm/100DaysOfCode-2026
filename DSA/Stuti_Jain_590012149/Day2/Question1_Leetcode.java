class Solution {
    public int removeElement(int[] nums, int val) {

        int comp = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[comp] = nums[i];
                comp++;
            }
        }

        return comp;
    }
}
