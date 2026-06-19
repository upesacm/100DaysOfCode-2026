bool canJump(int* nums, int numsSize) {
    int max = 0;
    for (int i = 0; i<numsSize; i++) {
        if (i>max) return false;
        if (max<i+nums[i]) max = i+nums[i];
        if (max>=numsSize) return true;
    }
    return true;
}