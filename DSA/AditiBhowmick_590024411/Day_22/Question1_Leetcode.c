#include <stdio.h>
void moveZeroes(int nums[], int n) {
    int j = 0;

    // Move all non-zero elements to the front
    for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
}

int main() {
    int n;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter the elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    moveZeroes(nums, n);

    printf("Array after moving zeroes:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", nums[i]);
    }

    printf("\n");
    return 0;
}