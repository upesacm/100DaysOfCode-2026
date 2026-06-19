#include <stdio.h>

int numberOfOccurence(int * nums, int numsSize, int target ){
    int count=0;
    for(int i=0; i<numsSize; i++){
        if(nums[i]==target){
            count+=1;
        }
    }
    return count;
}

