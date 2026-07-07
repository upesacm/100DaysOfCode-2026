#include <stdio.h>

// Your optimized solution
void moveZeroes(int* nums, int numsSize) {
    int lastNonZeroFoundAt = 0;
    
    // Move all non-zero elements to the front of the array
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != 0) {
            // Swap elements
            int temp = nums[lastNonZeroFoundAt];
            nums[lastNonZeroFoundAt] = nums[i];
            nums[i] = temp;
            
            lastNonZeroFoundAt++;
        }
    }
}

// Helper function to print the array
void printArray(int* nums, int numsSize) {
    printf("[");
    for (int i = 0; i < numsSize; i++) {
        printf("%d", nums[i]);
        if (i < numsSize - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}

int main() {
    // Test Case: LeetCode Example 1
    int nums[] = {0, 1, 0, 3, 12};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    printf("Original Array: ");
    printArray(nums, numsSize);

    // Execute the function
    moveZeroes(nums, numsSize);

    printf("Modified Array: ");
    printArray(nums, numsSize);

    return 0;
}