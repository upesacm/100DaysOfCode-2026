class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(
            robLinear(nums, 0, nums.length - 2), 
            robLinear(nums, 1, nums.length - 1)
        );
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}