//used the two pointers and compare for better time complexity.
#include<stdlib.h>
int* sortedSquares(int* nums, int numsSize, int* returnSize)
{
    *returnSize = numsSize;

    int *result = (int *)malloc(numsSize * sizeof(int));

    int left = 0;
    int right = numsSize - 1;
    int index = numsSize - 1;

    while (left <= right)
    {
        if (abs(nums[left]) > abs(nums[right]))
        {
            result[index] = nums[left] * nums[left];
            left++;
        }
        else
        {
            result[index] = nums[right] * nums[right];
            right--;
        }

        index--;
    }

    return result;
}