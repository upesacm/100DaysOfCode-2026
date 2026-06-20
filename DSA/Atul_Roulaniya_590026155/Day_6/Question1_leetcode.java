class Solution {
    public int rob(int[] nums) 
    {
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        if(nums.length==2)
        {
            return Math.max(nums[0],nums[1]);
        }
        int n=nums.length;
        int dp[]= new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2; i < n-1; i++)
        {
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        int max=dp[n-2];

        int dp1[]=new int[n];
        dp1[1]=nums[1];
        dp1[2]=Math.max(nums[1],nums[2]);

        for(int i=3 ; i < n ;  i++)
        {
            dp1[i]=Math.max(dp1[i-1],nums[i]+dp1[i-2]);
        }
        int max1= (n>3)?dp1[n-1]:dp1[2];

        return Math.max(max,max1);
    }
}