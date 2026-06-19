#include <stdio.h>

int main() {
    int n, target, count = 0;

    // Input size of array
    scanf("%d", &n);

    int arr[n];

    // Input array elements
    for(int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Input target value
    scanf("%d", &target);

    // Count occurrences
    for(int i = 0; i < n; i++) {
        if(arr[i] == target) {
            count++;
        }
    }

    printf("%d\n", count);

    return 0;
}