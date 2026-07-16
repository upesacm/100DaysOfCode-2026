#include <stdlib.h>

int compare(const void* a, const void* b) {
    int x = *(const int*)a;
    int y = *(const int*)b;

    return (x > y) - (x < y);
}

int* sortedSquares(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));

    // Square every element
    for (int i = 0; i < numsSize; i++) {
        result[i] = nums[i] * nums[i];
    }

    // Sort the squared elements
    qsort(result, numsSize, sizeof(int), compare);

    *returnSize = numsSize;
    return result;
}
