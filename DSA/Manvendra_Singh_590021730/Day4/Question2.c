// This function rotates an array to the right by k steps. It first reverses the entire array, then reverses the first k elements, and finally reverses the remaining elements to achieve the desired rotation.
void reverse(int* nums, int left, int right) {
    while (left < right) {
        int temp = nums[left];
        nums[left++] = nums[right];
        nums[right--] = temp;
    }
}
// This function rotates an array to the right by k steps using the reverse approach.
void rotateReverse(int* nums, int numsSize, int k) {
    k = k % numsSize;
    reverse(nums, 0, numsSize - 1);   // step 1: reverse all
    reverse(nums, 0, k - 1);          // step 2: reverse first k
    reverse(nums, k, numsSize - 1);   // step 3: reverse rest
}