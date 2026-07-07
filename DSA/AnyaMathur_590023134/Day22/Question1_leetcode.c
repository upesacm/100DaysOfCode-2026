// Leetcode Problem 283
// Move Zeroes 

void moveZeroes(int* nums, int numsSize) {
    int position = 0;
    for (int current = 0; current < numsSize; current++) {
        if (nums[current] != 0) {
            int temp = nums[position];
            nums[position] = nums[current];
            nums[current] = temp;
            position++;
        }
    }
}