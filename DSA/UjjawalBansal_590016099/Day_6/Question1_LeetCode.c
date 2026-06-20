int rob1(int* nums, int start, int end) {
    int now, a=0, b=0;
    for (int i=start; i<end; i++) {
        now = MAX(nums[i]+a, b);
        a = b;
        b = now;
    }
    return b;
}
int rob(int* nums, int numsSize) {
    if (numsSize == 1) return nums[0];
    return MAX(rob1(nums, 0, numsSize-1), rob1(nums, 1, numsSize));
}