#include <stdio.h>


int robbb (int* nums, int start, int end) 
{
    int prev2 = 0; 
    int prev1 = 0; 
    
    for (int i = start; i <= end; i++) 
    {
    
        int current = nums[i] + prev2;

        if (prev1 > current) 
        {
            current = prev1;
        }
        
        
        prev2 = prev1;
        prev1 = current;
    }
    
    return prev1;
}



int rob(int* nums, int numsSize) 
{
    
    if (numsSize == 1) 
    {
        return nums[0];
    }
    
    
    int A = robbb(nums, 0, numsSize - 2);
    

    int B = robbb(nums, 1, numsSize - 1);
    
    
    if (A > B) 
    {
        return A;
    } 
    
    else 
    {
        return B;
    }

    
}
