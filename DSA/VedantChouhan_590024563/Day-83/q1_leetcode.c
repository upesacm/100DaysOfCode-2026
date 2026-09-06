#include <stdio.h>

int singleNumber(int nums[], int numsSize) {
    int ones = 0;
    int twos = 0;

    for (int i = 0; i < numsSize; i++) {
        ones = (ones ^ nums[i]) & ~twos;
        twos = (twos ^ nums[i]) & ~ones;
    }

    return ones;
}

int main() {
    int n;

    printf("Enter array size: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Single element: %d\n", singleNumber(nums, n));

    return 0;
}