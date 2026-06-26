#include<stdio.h>
int removeElement(int* nums, int numsSize, int val) {
    int k = 0; // number of elements not equal to val
    
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i]; // place non-val element at position k
            k++;
        }
    }
    return k;
}