int missingNumber(int* nums, int numsSize) {
    int expected = numsSize * (numsSize + 1) / 2;
    
    int actual = 0;
    for (int i = 0; i < numsSize; i++)
        actual += nums[i];
    
    return expected - actual;
}