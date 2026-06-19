#include <stdio.h>

int main() {
    int n, i;
    scanf("%d", &n);

    int arr[n];
    int actualSum = 0;

    // Input array elements
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        actualSum += arr[i];
    }

    // Calculate expected sum
    int expectedSum = n * (n + 1) / 2;

    // Find missing number
    int missing = expectedSum - actualSum;

    printf("%d", missing);

    return 0;
}