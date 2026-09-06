#include <stdio.h>

int singleNumber(int* nums, int numsSize)
{
    int result = 0;

    for (int bit = 0; bit < 32; bit++)
    {
        int count = 0;

        for (int i = 0; i < numsSize; i++)
        {
            if ((nums[i] >> bit) & 1)
                count++;
        }

        if (count % 3 != 0)
            result |= (1 << bit);
    }

    return result;
}

int main()
{
    int nums[] = {2, 2, 2, 5, 5, 5, 9};
    int n = sizeof(nums) / sizeof(nums[0]);

    printf("%d\n", singleNumber(nums, n));

    return 0;
}