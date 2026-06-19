#include <stdio.h>
#include <stdbool.h>

bool canJump(int nums[], int n) {
    int reach = 0;

    for (int i = 0; i < n; i++) {
        if (i > reach)
            return false;

        if (i + nums[i] > reach)
            reach = i + nums[i];
    }

    return true;
}

int main() {
    int nums[] = {2,3,1,1,4};
    int n = sizeof(nums) / sizeof(nums[0]);

    printf("%s\n", canJump(nums, n) ? "true" : "false");

    return 0;
}