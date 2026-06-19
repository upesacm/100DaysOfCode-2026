bool canJump(int* nums, int numsSize) {
    int next=0;
    for(int i=0;i<numsSize;i++) {
        if(i>next) {
            return false;
        }
        if(i+nums[i]>next) {
            next=i+nums[i];
        }
    }
    return true;
}