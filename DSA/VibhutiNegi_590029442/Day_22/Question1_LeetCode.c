void moveZeroes(int* nums, int numsSize) {
    int insertPos = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != 0) {
            nums[insertPos] = nums[i];
            insertPos++;
        }
    }
    for (int i = insertPos; i < numsSize; i++) {
        nums[i] = 0;
    }
}