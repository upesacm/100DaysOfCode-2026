#include <stdio.h>

int main()
{
    int n;
    scanf("%d", &n);

    int nums[n];

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &nums[i]);
    }

    int maxreach = 0;

    for(int i = 0; i < n; i++)
    {
        if(i > maxReach)
        {
            printf("false");
            return 0;
        }

        if(i + nums[i] > maxreach)
        {
            maxreach = i + nums[i];
        }
    }

    printf("true");

    return 0;
}
