#include <stdio.h>

void findUnion(int arr1[], int n1, int arr2[], int n2) {
    int i = 0, j = 0;

    while (i < n1 && j < n2) {
        // Skip duplicates in arr1
        if (i > 0 && arr1[i] == arr1[i - 1]) {
            i++;
            continue;
        }

        // Skip duplicates in arr2
        if (j > 0 && arr2[j] == arr2[j - 1]) {
            j++;
            continue;
        }

        if (arr1[i] < arr2[j]) {
            printf("%d ", arr1[i]);
            i++;
        } else if (arr1[i] > arr2[j]) {
            printf("%d ", arr2[j]);
            j++;
        } else {
            printf("%d ", arr1[i]);
            i++;
            j++;
        }
    }

    // Print remaining elements of arr1
    while (i < n1) {
        if (i == 0 || arr1[i] != arr1[i - 1])
            printf("%d ", arr1[i]);
        i++;
    }

    // Print remaining elements of arr2
    while (j < n2) {
        if (j == 0 || arr2[j] != arr2[j - 1])
            printf("%d ", arr2[j]);
        j++;
    }
}

int main() {
    int arr1[] = {1, 2};
    int arr2[] = {2, 3};

    int n1 = sizeof(arr1) / sizeof(arr1[0]);
    int n2 = sizeof(arr2) / sizeof(arr2[0]);

    printf("Union: ");
    findUnion(arr1, n1, arr2, n2);

    return 0;
}
