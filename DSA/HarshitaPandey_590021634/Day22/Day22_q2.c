//Move Zeros to End of Array

#include <stdio.h>

void moveZeroes(int* nums, int numsSize) 
{
    int i=0, j=numsSize-1;

    int position=0;

    for (int i=0; i<numsSize; i++)
    {
        if (nums[i] != 0)
        {
            nums[position] = nums[i];
            position++;
        }
    }

    for (int i=position; i<numsSize; i++)
        {
            nums[i]=0;
        }
}



int main()
{
    int n,i,j=0;
    printf("Enter the size of the array: ");
    scanf("%d",&n);

    int arr[n];

    printf("Enter the elements of the array: ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }


    moveZeroes(arr, n);
    printf("Array: ");
    for(i=0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }

    return 0;
}