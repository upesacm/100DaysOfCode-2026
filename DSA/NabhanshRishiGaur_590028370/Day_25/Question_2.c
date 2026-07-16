#include <stdbool.h>

bool binarySearch(int* arr, int left, int right, int target) {
    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return true;
        }

        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return false;
}

bool hasPairWithSum(int* arr, int arrSize, int target) {
    for (int i = 0; i < arrSize - 1; i++) {
        int required = target - arr[i];

        if (binarySearch(arr, i + 1, arrSize - 1, required)) {
            return true;
        }
    }

    return false;
}
