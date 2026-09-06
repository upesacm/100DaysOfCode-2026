#include <stdio.h>

int maxVisible(int arr[], int n) {
    int maxCount = 1;

    for (int i = 0; i < n; i++) {
        int count = 1;
        int maxHeight = 0;

        // Check people on the left
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] >= maxHeight) {
                count++;
                if (arr[j] > maxHeight)
                    maxHeight = arr[j];
            }
        }

        // Check people on the right
        maxHeight = 0;

        for (int j = i + 1; j < n; j++) {
            if (arr[j] >= maxHeight) {
                count++;
                if (arr[j] > maxHeight)
                    maxHeight = arr[j];
            }
        }

        if (count > maxCount)
            maxCount = count;
    }

    return maxCount;
}

int main() {
    int arr[] = {6, 2, 5, 4, 5, 1, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d", maxVisible(arr, n));

    return 0;
}