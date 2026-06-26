int robRange(int* nums, int left, int right) {
    int prev1 = 0, prev2 = 0;

    for (int i = left; i <= right; i++) {
        int curr = (prev2 + nums[i] > prev1) ? prev2 + nums[i] : prev1;
        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}

int rob(int* nums, int numsSize) {
    if (numsSize == 1)
        return nums[0];

    int excludeLast = robRange(nums, 0, numsSize - 2);
    int excludeFirst = robRange(nums, 1, numsSize - 1);

    return (excludeLast > excludeFirst) ? excludeLast : excludeFirst;
}
