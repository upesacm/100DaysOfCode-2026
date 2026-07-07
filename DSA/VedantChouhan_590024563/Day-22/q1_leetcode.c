#include <stdio.h>

void moveZeroes(int arr[], int n) {

    int j = 0;

    for (int i = 0; i < n; i++) {

        if (arr[i] != 0) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            j++;
        }
    }
}

void printArray(int arr[], int n) {

    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);

    printf("\n");
}

int main() {

    int arr[] = {0, 1, 0, 3, 12};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original Array: ");
    printArray(arr, n);

    moveZeroes(arr, n);

    printf("After Moving Zeroes: ");
    printArray(arr, n);

    return 0;
}