// Find the Largest Element in an Array

#include<stdio.h>
int main()
{
    int numsSize;
    printf("Enter arraay size");
    scanf("%d",&numsSize);
    int nums[100];
    for(int i=0;i<numsSize;i++)
    {
        printf("Enter the %d element\n",(i+1));
        scanf("%d",&nums[i]);
    }
    int lg=nums[0];
    for(int i=0;i<numsSize;i++)
    {
        if(nums[i] > lg)
        {
            lg=nums[i];
        }
    }
    printf("The largest number in the array is %d\n",lg);
    return 0;

}