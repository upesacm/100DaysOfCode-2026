#include <stdlib.h>

int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize) {
    *returnSize = numsSize - k + 1;
    int* ans = (int*)malloc((*returnSize) * sizeof(int));

    int* deque = (int*)malloc(numsSize * sizeof(int));
    int front = 0, rear = -1;
    int idx = 0;

    for (int i = 0; i < numsSize; i++) {

        // Remove indices outside the current window
        if (front <= rear && deque[front] <= i - k)
            front++;

        // Remove smaller elements from the back
        while (front <= rear && nums[deque[rear]] <= nums[i])
            rear--;

        // Add current index
        deque[++rear] = i;

        // Record maximum once first window is formed
        if (i >= k - 1)
            ans[idx++] = nums[deque[front]];
    }

    free(deque);
    return ans;
}