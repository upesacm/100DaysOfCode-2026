package DSA.Sudhanshu_Ranjan_590018435.Day_6;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));        
    }

    private int getMax(int[] nums, int start, int end) {
        int prevRob = 0, maxRob = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(maxRob, prevRob + nums[i]);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }    
}