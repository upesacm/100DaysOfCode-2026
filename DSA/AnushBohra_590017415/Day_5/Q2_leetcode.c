#include <stdio.h>
#include <stdbool.h>

bool canJump(int* nums, int numsSize) {

    int farthest = 0;

    for (int i = 0; i < numsSize; i++) {

        if (i > farthest) {
            return false;
        }

        if (i + nums[i] > farthest) {
            farthest = i + nums[i];
        }
    }

    return true;
}

int main() {

    int nums[] = {2, 3, 1, 1, 4};
    int size = sizeof(nums) / sizeof(nums[0]);

    if (canJump(nums, size))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}