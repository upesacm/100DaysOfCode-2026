#include <stdio.h>

int singleNumber(int arr[], int n) {
    int ones = 0;
    int twos = 0;

    for (int i = 0; i < n; i++) {
        // Bits appearing once
        ones = (ones ^ arr[i]) & ~twos;

        // Bits appearing twice
        twos = (twos ^ arr[i]) & ~ones;
    }

    return ones;
}

int main() {
    int n;

    printf("Enter array size: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Unique number: %d\n", singleNumber(arr, n));

    return 0;
}