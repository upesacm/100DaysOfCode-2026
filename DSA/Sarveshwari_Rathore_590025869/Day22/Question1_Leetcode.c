void moveZeroes(int* nums, int numsSize) {
    int k = 0,i=0;  
    while (i < numsSize) {
        if (nums[i] != 0) {
            nums[k++] = nums[i];
        }    
        i++;
    }
    while (k < numsSize) {
        nums[k++] = 0;
    }
}