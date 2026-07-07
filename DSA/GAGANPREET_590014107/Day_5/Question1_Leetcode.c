#include <stdio.h>
#include <stdbool.h>

bool canJump(int nums[], int n) {
    int farthest = 0;

    for (int i = 0; i < n; i++) {

        if (i > farthest)
            return false;

        if (i + nums[i] > farthest)
            farthest = i + nums[i];

        if (farthest >= n - 1)
            return true;
    }

    return true;
}

int main() {
    int n;
    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    if (canJump(nums, n))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}
