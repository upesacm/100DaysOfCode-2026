#include <stdio.h>
#include <stdbool.h>
bool canJump(int* nums, int numsSize) {
    int x  = 0;
    for (int i = 0; i < numsSize; i++) {
        if (i > x) {
            return false;
        }

        if (i + nums[i] >x) {
            x = i + nums[i];
        }

        if (x >= numsSize - 1) {
            return true;
        }
    }

    return true;
}