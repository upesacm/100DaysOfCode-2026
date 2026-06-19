#include <stdio.h>

int main() {
    int nums[] = {3, 2, 2, 3};
    int val = 3;

    int n = sizeof(nums) / sizeof(nums[0]);
    int k = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }

    printf("Remaining count: %d\n", k);

    printf("Remaining array: ");
    for (int i = 0; i < k; i++) {
        printf("%d ", nums[i]);
    }

    return 0;
}