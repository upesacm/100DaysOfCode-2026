int robhouse(int* nums,int start,int end) {
    int rh1 = 0,rh2 = 0;
    for (int i = start;i <= end;i++){
        int curr;
        if(nums[i] + rh2 > rh1){
            curr = nums[i] + rh2;
        } else{
            curr = rh1;
        }
        rh2 = rh1;
        rh1 = curr;
    }
    return rh1;
}
int rob(int* nums, int numsSize) {
    if (numsSize == 1)
        return nums[0];
    int case1 = robhouse(nums, 0,numsSize - 2);
    int case2 = robhouse(nums, 1,numsSize - 1);
    if (case1 > case2)
        return case1;
    else
        return case2;
}