int maxRob(int* nums, int start, int end) {
    int prev1 = 0;
    int prev2 = 0;

    for (int i = start; i <= end; i++) {
        int take = nums[i] + prev2;
        int skip = prev1;

        int curr = (take > skip) ? take : skip;

        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}

int rob(int* nums, int numsSize) {
    if (numsSize == 1)
        return nums[0];

    int case1 = maxRob(nums, 0, numsSize - 2);
    int case2 = maxRob(nums, 1, numsSize - 1);

    return (case1 > case2) ? case1 : case2;
}