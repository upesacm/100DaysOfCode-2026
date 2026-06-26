#include <stdio.h>

void rotate(int nums[], int n, int k) {
    int temp[n];

    k = k % n;

    for (int i = 0; i < n; i++) {
        temp[(i + k) % n] = nums[i];
    }

    for (int i = 0; i < n; i++) {
        nums[i] = temp[i];
    }
}

int main() {
    int nums[] = {1, 2, 3, 4};
    int n = sizeof(nums) / sizeof(nums[0]);
    int k = 3;

    rotate(nums, n, k);

    for (int i = 0; i < n; i++) {
        printf("%d ", nums[i]);
    }

    return 0;
}
