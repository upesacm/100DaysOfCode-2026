/* House Robber II
Explanation
Given an array where each element represents the amount of money in a house arranged in a circle, determine the maximum amount of money that can be robbed without robbing two adjacent houses*/

class Solution{

    private int find(int[] nums){
        int i;
        
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }
        
        int[] maximums = new int[nums.length];
        maximums[0] = nums[0];
        maximums[1] = Math.max(nums[0], nums[1]);
        for(i = 2; i < nums.length; i++){
            maximums[i] = Math.max(maximums[i - 2] + nums[i], maximums[i - 1]);
        }
        
        return maximums[nums.length - 1];
    }

    public int rob(int[] nums){
        int i;
        int[] skipLast = new int[nums.length - 1];
        int[] skipFirst = new int[nums.length - 1];

        if(nums.length == 1){
            return nums[0];
        }
        
        for(i = 0; i < nums.length - 1; i++){
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i + 1];
        }

        int robSkipLast = find(skipLast);
        int robSkipFirst = find(skipFirst);

        return Math.max(robSkipLast, robSkipFirst);
  }

}

