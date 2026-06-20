int robLinear(int* nums, int start, int end) {
    int prev1 = 0, prev2 = 0;
    for (int i = start; i <= end; i++) {
        int pick = prev2 + nums[i];
        int skip = prev1;
        int curr = (pick > skip) ? pick : skip;
        prev2 = prev1;
        prev1 = curr;
    }
    return prev1;
}

int rob(int* nums, int numsSize) {
    if (numsSize == 1) return nums[0];
    int case1 = robLinear(nums, 0, numsSize - 2);
    int case2 = robLinear(nums, 1, numsSize - 1);
    return (case1 > case2) ? case1 : case2;
}
