#include <stdio.h>

int missingNumber(int* nums, int numsSize) {
    int missing = numsSize;
    for (int i = 0; i < numsSize; i++) {
        missing ^= i ^ nums[i];
    }
    return missing;
}

int main() {
    int nums[] = {3, 0, 1};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    
    int result = missingNumber(nums, numsSize);
    
    printf("Missing number: %d\n", result);
    
    return 0;
}