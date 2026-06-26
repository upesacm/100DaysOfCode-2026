int solve(int* nums, int start, int end) {
    int prev2=0, prev1=0;

    for (int i=start;i<=end;i++) {
        int curr = (prev2 + nums[i] > prev1) ? prev2 + nums[i] : prev1;

        prev2=prev1;
        prev1=curr;
    }

    return prev1;
}

int rob(int* nums, int numsSize) {
    if (numsSize==1)
        return nums[0];

    int case1=solve(nums, 0, numsSize - 2);
    int case2=solve(nums, 1, numsSize - 1);

    return (case1 > case2) ? case1 : case2;
}
