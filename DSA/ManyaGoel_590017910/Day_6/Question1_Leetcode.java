public class Question1_Leetcode {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(Houses(nums,1,n-1),Houses(nums,0,n-2));    
    }
    static int Houses(int[] nums, int start,int end){
        int last=0;
        int secondlast=0;
        int maxprofit=0;
        for(int i=start;i<=end;i++){
            maxprofit=Math.max(last,nums[i]+secondlast);
            secondlast=last;
            last=maxprofit;
        }
        return maxprofit;
    }
}
