int rob(int* nums, int numsSize) {
    if (numsSize == 1) return nums[0];

    int prev1 = 0, prev2 = 0, curr;

    for (int i = 0; i < numsSize - 1; i++) {
        curr = (nums[i] + prev2 > prev1) ? nums[i] + prev2 : prev1;
        prev2 = prev1;
        prev1 = curr;
    }
    int case1 = prev1;

    prev1 = prev2 = 0;

    for (int i = 1; i < numsSize; i++) {
        curr = (nums[i] + prev2 > prev1) ? nums[i] + prev2 : prev1;
        prev2 = prev1;
        prev1 = curr;
    }
    int case2 = prev1;

    return (case1 > case2) ? case1 : case2;
}
