#include <stdio.h>

int solve(int nums[], int start, int end) {
    int prev1 = 0, prev2 = 0;

    for (int i = start; i <= end; i++) {
        int take = nums[i] + prev2;
        int notTake = prev1;

        int curr = (take > notTake) ? take : notTake;

        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}

int rob(int nums[], int n) {
    if (n == 1)
        return nums[0];

    int case1 = solve(nums, 0, n - 2);
    int case2 = solve(nums, 1, n - 1);

    return (case1 > case2) ? case1 : case2;
}

int main() {
    int n;
    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    printf("%d\n", rob(nums, n));

    return 0;
}