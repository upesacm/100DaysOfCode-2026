#include <stdio.h>

int singleNumber(int* nums, int numsSize)
{
    int result = 0;

    for (int i = 0; i < numsSize; i++)
        result ^= nums[i];

    return result;
}

int main()
{
    int n;

    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    printf("%d\n", singleNumber(nums, n));

    return 0;
}