#include <stdio.h>
#include <stdbool.h>

bool canJump(int* nums, int numsSize) 
{
    int temp=0;

    for (int i=0; i< numsSize; i++)
    {
        if ( i> temp)
        {
            return false;
        }

        if (i + nums[i] > temp)
        {
            temp = i+ nums[i];
        }

        if (temp >= numsSize-1)
        {
            return true;
        }
        
    }  
    return false;
}