#include <stdio.h>

void moveZeroes(int nums[], int n) {
    int j = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
        }
    }
}

void printArray(int nums[], int n) {
    for (int i = 0; i < n; i++)
        printf("%d ", nums[i]);
    printf("\n");
}

int main() {
    int n;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    moveZeroes(nums, n);

    printf("Array after moving zeroes: ");
    printArray(nums, n);

    return 0;
}