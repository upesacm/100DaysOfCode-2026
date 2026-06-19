bool canJump(int* nums, int numsSize) {
    int far=0;
    for(int i=0;i<numsSize;i++){
        if(i>far) return 0;

        if(i+nums[i]>far)
        far=i+nums[i];

        if(far>=numsSize-1)
        return 1;
    }
    return 1;
}
