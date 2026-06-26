#include <stdio.h>

int arraySum(int arr[], int n) {
    int sum = 0;

    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }

    return sum;
}

int main() {
    int arr[] = {3, 8, 2, 9, 1};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d\n", arraySum(arr, n));

    return 0;
}
