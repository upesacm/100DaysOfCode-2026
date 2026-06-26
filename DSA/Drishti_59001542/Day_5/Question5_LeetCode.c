#include <stdio.h>
#include <stdbool.h>

bool canJump(int nums[], int size) {
    int maxReach = 0;

    for (int i = 0; i < size; i++) {
        // If the current index is not reachable
        if (i > maxReach) {
            return false;
        }

        // Update the farthest reachable index
        if (i + nums[i] > maxReach) {
            maxReach = i + nums[i];
        }
    }

    return true;
}

int main() {
    int nums[] = {2, 3, 1, 1, 4};
    int size = sizeof(nums) / sizeof(nums[0]);

    if (canJump(nums, size)) {
        printf("True\n");
    } else {
        printf("False\n");
    }

    return 0;
}
