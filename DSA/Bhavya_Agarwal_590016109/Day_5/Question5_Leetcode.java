public class Question5_Leetcode {
    class Solution {
    public boolean canJump(int[] nums) {
        int max_reach = 0;

        for(int i = 0; i<nums.length; i++){
            if(i > max_reach){
                return false;
            }

            max_reach = Math.max(max_reach, i+nums[i]);
        }

        return true ;
    }
}
}
