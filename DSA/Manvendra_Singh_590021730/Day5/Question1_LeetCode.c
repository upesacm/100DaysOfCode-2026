// LeetCode Question 55: Jump Game

#include <stdbool.h>
#include <stdlib.h>

bool canJump(int* nums, int numsSize) {
    // 0 = bad, 1 = good
    int* dp = (int*)calloc(numsSize, sizeof(int));
    dp[numsSize - 1] = 1;   // last index is always Good

    for (int i = numsSize - 2; i >= 0; i--) {
        int maxReach = i + nums[i];
        if (maxReach >= numsSize - 1) {
            dp[i] = 1;      // can jump directly to end
            continue;
        }
        // check if any reachable index is Good
        for (int j = i + 1; j <= maxReach; j++) {
            if (dp[j]) { dp[i] = 1; break; }
        }
    }

    bool result = dp[0] == 1;
    free(dp);
    return result;
}