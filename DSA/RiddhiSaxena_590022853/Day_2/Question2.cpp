#include <stdio.h>

int findLargest(int arr[], int n) {
    int largest = arr[0];

    for (int i = 1; i < n; i++) {
        if (arr[i] > largest) {
            largest = arr[i];
        }
    }

    return largest;
}

int main() {
    int arr[] = {3,7,9,2,5};
    int n = sizeof(arr) / sizeof(arr[0]);

    int largest = findLargest(arr, n);

    printf("Largest element: %d\n", largest);

    return 0;
}