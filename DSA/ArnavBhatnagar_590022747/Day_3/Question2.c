#include <stdio.h>

int countOccurrences(int arr[], int size, int target) {
    int count = 0;

    for (int i = 0; i < size; i++) {
        if (arr[i] == target) {
            count++;
        }
    }

    return count;
}

int main() {
    int n, target;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter sorted array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter target element: ");
    scanf("%d", &target);

    int count = countOccurrences(arr, n, target);

    printf("Occurrences of %d = %d\n", target, count);

    return 0;
}