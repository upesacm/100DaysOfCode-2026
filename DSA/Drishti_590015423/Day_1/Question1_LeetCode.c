#include <stdio.h>

int main() {
    int n, i, sum = 0;

    // Input the size of the array
    scanf("%d", &n);

    int arr[n];

    // Input array elements
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Calculate the sum
    for (i = 0; i < n; i++) {
        sum += arr[i];
    }

    // Print the sum
    printf("%d", sum);

    return 0;
}