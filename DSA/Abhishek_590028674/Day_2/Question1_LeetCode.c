int removeElement(int* nums, int numsSize, int val) {
    int i, j;
    i = 0;
    while(i<numsSize && nums[i]!=val) i++;
    for(j = i+1; j<numsSize; j++){
        if(nums[j] != val)
            nums[i++] = nums[j];
    }
    return i;
}