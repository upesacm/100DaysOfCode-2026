#include <stdio.h>

int numSubarrayBoundedMax(int* arr, int size, int l, int r) {
    int count = 0;
    int start = -1;
    int valid = -1;

    for (int i = 0; i < size; i++) {
        if (arr[i] > r) {
            start = i;
            valid = i;
        } else if (arr[i] >= l) {
            valid = i;
        }
        count += (valid - start);
    }

    return count;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);
    int l = 2;
    int r = 5;

    int result = numSubarrayBoundedMax(arr, size, l, r);
    printf("%d\n", result);

    return 0;
}