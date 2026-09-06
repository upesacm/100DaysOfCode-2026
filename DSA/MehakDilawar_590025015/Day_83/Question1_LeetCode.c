int singleNumber(int* nums, int numsSize) {
    unsigned int result = 0;
    for (int bit = 0; bit < 32; bit++) {
        int count = 0;
        for (int i = 0; i < numsSize; i++) {
            if (((unsigned int)nums[i] >> bit) & 1U) {
                count++;
            }
        }
        if (count % 3 != 0) {
            result |= (1U << bit);
        }
    }
    return (int)result;
}
