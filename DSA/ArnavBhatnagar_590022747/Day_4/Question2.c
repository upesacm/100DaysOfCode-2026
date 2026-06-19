#include <stdio.h>

void rotateArray(int arr[], int n, int k) {
    k = k % n;

    int temp[n];

    for (int i = 0; i < n; i++) {
        temp[(i + k) % n] = arr[i];
    }

    for (int i = 0; i < n; i++) {
        arr[i] = temp[i];
    }
}

int main() {
    int n, k;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter number of rotations (k): ");
    scanf("%d", &k);

    rotateArray(arr, n, k);

    printf("Array after rotation: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    printf("\n");

    return 0;
}