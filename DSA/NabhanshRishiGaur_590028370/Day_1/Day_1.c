int missingNumber(int* nums, int numsSize) {
    long long expected = (long long)numsSize * (numsSize + 1) / 2;
    long long actual = 0;

    for (int i = 0; i < numsSize; i++) {
        actual += nums[i];
    }

    return (int)(expected - actual);
}
