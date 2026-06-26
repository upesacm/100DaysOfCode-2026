// Two Pointer Approach: We can use two pointers to solve this problem. One pointer (k) will keep track of the position of the next non-val element, while the other pointer (i) will iterate through the array. Whenever we encounter an element that is not equal to val, we will copy it to the position pointed by k and increment k. Finally, we will return k as the new length of the array.
int removeElement(int* nums, int numsSize, int val) {
    int k = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}