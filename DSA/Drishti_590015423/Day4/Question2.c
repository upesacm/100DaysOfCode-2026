#include <stdio.h>

void rotate(int nums[], int n, int k) {
    int temp[n];

    k = k % n;   // Handles cases where k > n

    // Copy last k elements to front
    for (int i = 0; i < k; i++) {
        temp[i] = nums[n - k + i];
    }

    // Copy remaining elements
    for (int i = k; i < n; i++) {
        temp[i] = nums[i - k];
    }

    // Copy temp back to original array
    for (int i = 0; i < n; i++) {
        nums[i] = temp[i];
    }
}

int main() {
    int nums[] = {1, 2, 3, 4};
    int n = 4;
    int k = 3;

    rotate(nums, n, k);

    for (int i = 0; i < n; i++) {
        printf("%d ", nums[i]);
    }

    return 0;
}
