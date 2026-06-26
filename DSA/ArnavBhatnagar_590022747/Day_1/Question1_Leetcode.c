#include <stdio.h>

int missingNumber(int nums[], int size) {
    int expectedSum = size * (size + 1) / 2;
    int actualSum = 0;

    for (int i = 0; i < size; i++) {
        actualSum += nums[i];
    }

    return expectedSum - actualSum;
}

int main() {
    int nums[] = {3, 0, 1};
    int size = sizeof(nums) / sizeof(nums[0]);

    printf("%d\n", missingNumber(nums, size));

    return 0;
}