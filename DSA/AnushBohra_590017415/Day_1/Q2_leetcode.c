#include <stdio.h>

int missingNumber(int* nums, int numsSize) {
    int expectedSum = numsSize * (numsSize + 1) / 2;
    int actualSum = 0;

    for (int i = 0; i < numsSize; i++) {
        actualSum += nums[i];
    }

    return expectedSum - actualSum;
}

int main() {
    int nums[] = {3, 0, 1};
    int n = sizeof(nums) / sizeof(nums[0]);

    printf("%d\n", missingNumber(nums, n));

    return 0;
}