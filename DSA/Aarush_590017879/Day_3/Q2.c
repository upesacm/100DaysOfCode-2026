#include <stdio.h>

int firstOccurrence(int arr[], int n, int target) {
    int left = 0, right = n - 1, result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            result = mid;
            right = mid - 1;  
        }
        else if (arr[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return result;
}

int lastOccurrence(int arr[], int n, int target) {
    int left = 0, right = n - 1, result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            result = mid;
            left = mid + 1;  
        }
        else if (arr[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return result;
}

int countOccurrences(int arr[], int n, int target) {
    int first = firstOccurrence(arr, n, target);

    if (first == -1)
        return 0;

    int last = lastOccurrence(arr, n, target);

    return last - first + 1;
}

int main() {
    int arr[] = {1, 2, 2, 2, 3, 4, 5};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 2;

    printf("Occurrences of %d = %d\n", target,
           countOccurrences(arr, n, target));

    return 0;
}