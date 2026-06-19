#include <stdio.h>

int countOccurrences(int arr[], int n, int target) {
    int count = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] == target)
            count++;
    }

    return count;
}

int main() {
    int arr[] = {1, 1, 2, 2, 2, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target = 2;

    printf("%d\n", countOccurrences(arr, n, target));

    return 0;
}
