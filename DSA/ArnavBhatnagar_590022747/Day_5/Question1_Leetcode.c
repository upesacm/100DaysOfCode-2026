#include <stdbool.h>

bool canJump(int* nums, int numsSize) {
    int farthest = 0;
    for (int i = 0; i < numsSize; i++) {
        if (i > farthest) return false;
        if (i + nums[i] > farthest) {
            farthest = i + nums[i];
        }
    }
    return true;
}
