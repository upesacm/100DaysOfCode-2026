int missingNumber(int* nums, int numsSize) {
    int asum = (numsSize *(numsSize+1))/2;
    int msum =0;
    for(int i=0;i<numsSize;i++){
        msum = msum+nums[i];
    }
    return asum - msum;
}