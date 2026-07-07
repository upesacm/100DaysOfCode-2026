#include <stdio.h>

void moveZeroes(int nums[], int n) {
    int index = 0;

    // Move non-zero elements
    for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
            nums[index] = nums[i];
            index++;
        }
    }

    // Fill remaining positions with 0
    while (index < n) {
        nums[index] = 0;
        index++;
    }
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    moveZeroes(nums, n);

    printf("Array after moving zeroes: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", nums[i]);
    }

    return 0;
}