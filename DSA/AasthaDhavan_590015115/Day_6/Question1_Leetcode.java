class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return Math.max(robsol(nums,0,n-2),robsol(nums,1,n-1));
    }
    int robsol(int[] nums,int s,int e){
        int temp1=0;
        int temp2=0;
        for(int i=s;i<=e;i++){
            int curr=Math.max(temp1,temp2+nums[i]);
            temp2=temp1;
            temp1=curr;
        }
        return temp1;
    }
}