class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int take_first = rob(nums,0,n-2);
        int take_last = rob(nums,1,n-1);
        return Math.max(take_first,take_last);
    }
    private int rob(int[] nums,int start,int end){
        int prevPrev = 0;
        int prev = 0;
        for(int i = start; i <= end ;i++){
            int take = nums[i] + prevPrev;
            int not_take = prev;

            int temp = Math.max(take,not_take);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}