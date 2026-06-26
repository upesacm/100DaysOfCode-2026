#include <stdio.h>

int robLinear(int nums[], int l, int r) {
    int prev1 = 0, prev2 = 0;

    for (int i = l; i <= r; i++) {
        int temp = prev1;
        prev1 = (prev2 + nums[i] > prev1) ? prev2 + nums[i] : prev1;
        prev2 = temp;
    }
    return prev1;
}

int rob(int nums[], int n) {
    if (n == 1) return nums[0];

    int case1 = robLinear(nums, 0, n - 2);
    int case2 = robLinear(nums, 1, n - 1);

    return (case1 > case2) ? case1 : case2;
}

int main() {
    int nums[] = {1, 2, 3, 1};
    int n = sizeof(nums) / sizeof(nums[0]);

    printf("%d\n", rob(nums, n));
    return 0;
}