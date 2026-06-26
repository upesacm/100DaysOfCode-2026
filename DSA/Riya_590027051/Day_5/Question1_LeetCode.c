#include <stdio.h>
#include <stdbool.h>

bool canJump(int nums[], int numsSize) {
    int farthest = 0;

    for (int i = 0; i < numsSize; i++) {
        // If current position cannot be reached
        if (i > farthest) {
            return false;
        }

        // Update farthest reachable position
        if (i + nums[i] > farthest) {
            farthest = i + nums[i];
        }

        // If last index can be reached
        if (farthest >= numsSize - 1) {
            return true;
        }
    }

    return true;
}

int main() {
    int nums[] = {2, 3, 1, 1, 4};
    int n = sizeof(nums) / sizeof(nums[0]);

    if (canJump(nums, n)) {
        printf("true\n");
    } else {
        printf("false\n");
    }

    return 0;
}