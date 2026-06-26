int rob(int* nums, int numsSize){
    if(numsSize==1)return nums[0];
    int robRange(int* arr,int start,int end){
        int prev1=0,prev2=0;
        for(int i=start;i<=end;i++){
            int temp=prev1;
            if(prev2+arr[i]>prev1)prev1=prev2+arr[i];
            prev2=temp;
        }
        return prev1;
    }
    int a=robRange(nums,0,numsSize-2);
    int b=robRange(nums,1,numsSize-1);
    return a>b?a:b;
}
