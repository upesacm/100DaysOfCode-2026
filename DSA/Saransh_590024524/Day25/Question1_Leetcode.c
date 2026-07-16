int triangleNumber(int nums[], int numsSize) {
    qsort(nums, numsSize, sizeof(int), compare);

    int count = 0;

    for (int k = numsSize - 1; k >= 2; k--) {
        int i = 0;
        int j = k - 1;

        while (i < j) {
            if (nums[i] + nums[j] > nums[k]) {
                count += (j - i);
                j--;
            } else {
                i++;
            }
        }
    }

    return count;
}