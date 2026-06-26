#include <stdio.h>

void unionArray(int arr1[], int n, int arr2[], int m) {
    int i = 0, j = 0;
    int last = -1;

    while (i < n && j < m) {
        if (arr1[i] < arr2[j]) {
            if (arr1[i] != last) {
                printf("%d ", arr1[i]);
                last = arr1[i];
            }
            i++;
        }
        else if (arr1[i] > arr2[j]) {
            if (arr2[j] != last) {
                printf("%d ", arr2[j]);
                last = arr2[j];
            }
            j++;
        }
        else {
            if (arr1[i] != last) {
                printf("%d ", arr1[i]);
                last = arr1[i];
            }
            i++;
            j++;
        }
    }

    while (i < n) {
        if (arr1[i] != last) {
            printf("%d ", arr1[i]);
            last = arr1[i];
        }
        i++;
    }

    while (j < m) {
        if (arr2[j] != last) {
            printf("%d ", arr2[j]);
            last = arr2[j];
        }
        j++;
    }
}

int main() {
    int arr1[] = {1, 2};
    int arr2[] = {2, 3};

    unionArray(arr1, 2, arr2, 2);

    return 0;
}