int robLinear(int* arr, int size) {
    int prev = 0, curr = 0;
    for (int i = 0; i < size; i++) {
        int temp = curr;
        curr = (curr > prev + arr[i]) ? curr : prev + arr[i];
        prev = temp;
    }
    return curr;
}

int rob(int* nums, int numsSize) {
    if (numsSize == 1) return nums[0];
    int case1 = robLinear(nums, numsSize - 1);
    int case2 = robLinear(nums + 1, numsSize - 1);
    return (case1 > case2) ? case1 : case2;
}
