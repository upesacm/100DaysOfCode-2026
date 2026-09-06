int findMaximumXOR(int* nums, int numsSize) {
    int max = 0;

    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            int value = nums[i] ^ nums[j];

            if (value > max)
                max = value;
        }
    }

    return max;
}