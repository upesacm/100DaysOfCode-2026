#include <stdio.h>

int firstOccurrence(int arr[], int n, int target) {
    int low = 0, high = n - 1;
    int ans = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            ans = mid;
            high = mid - 1;   // search left side
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}

int lastOccurrence(int arr[], int n, int target) {
    int low = 0, high = n - 1;
    int ans = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            ans = mid;
            low = mid + 1;    // search right side
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}

int countOccurrences(int arr[], int n, int target) {
    int first = firstOccurrence(arr, n, target);

    if (first == -1)
        return 0;

    int last = lastOccurrence(arr, n, target);

    return last - first + 1;
}

int main() {
    int arr[] = {1, 1, 2, 2, 2, 2, 3};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 2;

    printf("%d\n", countOccurrences(arr, n, target));

    return 0;
}