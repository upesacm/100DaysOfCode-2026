#include <stdio.h>

int robLine(int* nums, int start, int end)
{
    int prev1 = 0;
    int prev2 = 0;

    for(int i = start; i <= end; i++)
    {
        int temp = prev1;
        prev1 = (prev2 + nums[i] > prev1) ? prev2 + nums[i] : prev1;
        prev2 = temp;
    }

    return prev1;
}

int rob(int* nums, int numsSize)
{
    if(numsSize == 1)
        return nums[0];

    int case1 = robLine(nums, 0, numsSize - 2);
    int case2 = robLine(nums, 1, numsSize - 1);

    return (case1 > case2) ? case1 : case2;
}

int main()
{
    int nums[] = {1, 2, 3, 1};
    int size = sizeof(nums) / sizeof(nums[0]);

    printf("Maximum money robbed = %d\n", rob(nums, size));

    return 0;
}