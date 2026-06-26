#include <stdio.h>

void unionArrays(int arr1[], int n1, int arr2[], int n2) {
    int i = 0, j = 0, last = -1;
    while (i < n1 && j < n2) {
        if (arr1[i] < arr2[j]) {
            if (last != arr1[i]) {
                printf("%d ", arr1[i]);
                last = arr1[i];
            }
            i++;
        } else if (arr2[j] < arr1[i]) {
            if (last != arr2[j]) {
                printf("%d ", arr2[j]);
                last = arr2[j];
            }
            j++;
        } else {
            if (last != arr1[i]) {
                printf("%d ", arr1[i]);
                last = arr1[i];
            }
            i++;
            j++;
        }
    }
    while (i < n1) {
        if (last != arr1[i]) {
            printf("%d ", arr1[i]);
            last = arr1[i];
        }
        i++;
    }
    while (j < n2) {
        if (last != arr2[j]) {
            printf("%d ", arr2[j]);
            last = arr2[j];
        }
        j++;
    }
}

int main() {
    int arr1[] = {1, 2, 4, 5};
    int arr2[] = {2, 3, 5, 6};
    unionArrays(arr1, 4, arr2, 4);
    return 0;
}
