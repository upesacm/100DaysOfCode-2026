int max(int a,int b)
{
    return(a>b)?a:b;
}
int helper(int* nums,int start,int end)
{
    int prev1=0,prev2=0;

    for(int i=start;i<=end;i++)
    {
        int temp=prev1;
        prev1=max(prev2+nums[i],prev1);
        prev2=temp;
    }
    return prev1;
}
int rob(int* nums, int numsSize) {
    if(numsSize==1)
        return nums[0];

    return max(helper(nums,0,numsSize-2),helper(nums,1,numsSize-1));
}
