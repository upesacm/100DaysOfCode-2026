int singleNumber(int* nums, int numsSize) {
    int a=numsSize;
    for(int i=0;i<a;i++) {
        int twice=0;
        for(int j=0;j<a;j++) {
            if(nums[j]==nums[i]) twice++;
        }
        if(twice==1) return nums[i];
    }
    return 0;
}
