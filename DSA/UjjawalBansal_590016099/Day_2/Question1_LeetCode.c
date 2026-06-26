int removeElement(int* nums, int numsSize, int val) {
    int i = 0;
    while (i<numsSize) {
        if (nums[i] !=val) i++;
        else {
            numsSize--;
            nums[i]= nums[i] + nums[numsSize]; 
            nums[numsSize]= nums[i] - nums[numsSize];
            nums[i]= nums[i] - nums[numsSize];
        }
    }
    return numsSize;
}