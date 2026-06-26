#include <stdio.h>

int robLinear(int nums[], int start, int end) {
    int prev1 = 0, prev2 = 0;

    for (int i = start; i <= end; i++) {
        int temp = prev1;
        prev1 = (prev2 + nums[i] > prev1) ? prev2 + nums[i] : prev1;
        prev2 = temp;
    }

    return prev1;
}

int rob(int nums[], int numsSize) {
    if (numsSize == 1)
        return nums[0];

    int option1 = robLinear(nums, 0, numsSize - 2); // Exclude last house
    int option2 = robLinear(nums, 1, numsSize - 1); // Exclude first house

    return (option1 > option2) ? option1 : option2;
}

int main() {
    int nums[] = {1, 2, 3, 1};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    printf("Maximum amount robbed: %d\n", rob(nums, numsSize));

    return 0;
}