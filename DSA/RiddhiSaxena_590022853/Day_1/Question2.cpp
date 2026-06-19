#include <stdio.h>

int arraySum(int arr[], int size) {
    int sum = 0;

    for (int i = 0; i < size; i++) {
        sum += arr[i];
    }

    return sum;
}

int main() {
    int arr[] = {3,8,2,9,1};
    int size = sizeof(arr) / sizeof(arr[0]);

    int result = arraySum(arr, size);

    printf("Sum of array elements = %d\n", result);

    return 0;
}