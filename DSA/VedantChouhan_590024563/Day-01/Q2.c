#include <stdio.h>

int missingNumber(int nums[], int n) {
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;

    for(int i = 0; i < n; i++) {
        actualSum += nums[i];
    }

    return expectedSum - actualSum;
}

int main() {
    int nums[] = {3, 0, 1};
    int n = sizeof(nums) / sizeof(nums[0]);

    printf("Missing Number: %d\n", missingNumber(nums, n));

    return 0;
}