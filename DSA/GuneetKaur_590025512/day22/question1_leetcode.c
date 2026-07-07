#include<stdio.h>

int move(int* nums , int* numsize)
{
    int k=0;
    for (int i=0;i<numsize;i++)
    {
        if (nums[i]!=0)
        {
            nums[k]=nums[i];
            k++;
        }
    }
    for (int i=k;i<numsize;i++)
    {
        nums[i]=0;
    }

    return k;
}
int main()
{
    int nums[] = {0, 1, 0, 3, 12};
    int numsize = sizeof(nums)/sizeof(nums[0]);
    move(nums, numsize);
    for (int i=0;i<numsize;i++)
    {
        printf("%d ", nums[i]);
    }
}