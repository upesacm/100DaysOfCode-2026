package Day_6;

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int prob1=moneyRob(nums,0,nums.length-2);
        int prob2=moneyRob(nums,1,nums.length-1);
        return Math.max(prob1,prob2);
    }
    public int moneyRob(int[] nums,int start, int end ){
        int p1=0,p2=0;
        for (int i=start; i<=end; i++){
            int curr=Math.max(p1,p2+nums[i]);
            p2=p1;
            p1=curr;
        }
        return p1;
    }
}

