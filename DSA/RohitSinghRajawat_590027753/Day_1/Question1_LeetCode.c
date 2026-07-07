//Q1. Write an efficient function to find the missing number in an array containing n distinct numbers from the range [0,n].
//(LEET CODE PROBLEM-268)
int missingNumber(int* nums, int numsSize) {
    int expectedsum = numsSize*(numsSize+1)/2;
    int actualsum = 0;
    for(int i=0;i<numsSize;i++){
        actualsum += nums[i];
    }
    return expectedsum - actualsum;
    
}