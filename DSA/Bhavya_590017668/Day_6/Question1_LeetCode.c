int rob(int* nums, int numsSize){
    if(numsSize==1) return nums[0];
    int prev1=0,prev2=0;
    for(int i=0;i<numsSize-1;i++){
        int temp=prev1;
        prev1=(prev2+nums[i]>prev1)?prev2+nums[i]:prev1;
        prev2=temp;
    }
    int a=prev1;
    prev1=0;
    prev2=0;
    for(int i=1;i<numsSize;i++){
        int temp=prev1;
        prev1=(prev2+nums[i]>prev1)?prev2+nums[i]:prev1;
        prev2=temp;
    }
    return a>prev1?a:prev1;
}