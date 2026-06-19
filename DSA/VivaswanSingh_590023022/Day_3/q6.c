#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int countOccurrences(int* nums, int numsSize, int target) {
    int first = -1, last = -1;
    
    int low = 0, high = numsSize - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            first = mid;
            high = mid - 1;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
    if (first == -1) {
        return 0;
    }
    
    low = 0, high = numsSize - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            last = mid;
            low = mid + 1;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    
    return last - first + 1;
}

int main() {
    int size, target;

    printf("Enter the number of elements in the array: ");
    if (scanf("%d", &size) != 1 || size <= 0) {
        return 1;
    }

    int arr[size];
    printf("Enter %d integers (in any order):\n", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    qsort(arr, size, sizeof(int), compare);

    printf("Enter the target value to count: ");
    scanf("%d", &target);

    int result = countOccurrences(arr, size, target);
    printf("Output: %d\n", result);

    return 0;
}