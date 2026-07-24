#include <stdio.h>

int maxVisiblePeople(int arr[], int n) {
    int maxVisible = 1;

    for (int i = 0; i < n; i++) {
        int visible = 1;

        for (int j = 0; j < n; j++) {
            if (i == j)
                continue;

            int blocked = 0;

            if (j > i) {
                for (int k = i + 1; k < j; k++) {
                    double lineHeight = arr[i] + (double)(arr[j] - arr[i]) * (k - i) / (j - i);
                    if (arr[k] >= lineHeight) {
                        blocked = 1;
                        break;
                    }
                }
            } else {
                for (int k = j + 1; k < i; k++) {
                    double lineHeight = arr[j] + (double)(arr[i] - arr[j]) * (k - j) / (i - j);
                    if (arr[k] >= lineHeight) {
                        blocked = 1;
                        break;
                    }
                }
            }

            if (!blocked)
                visible++;
        }

        if (visible > maxVisible)
            maxVisible = visible;
    }

    return maxVisible;
}

int main() {
    int arr[] = {6, 2, 5, 4, 5, 1, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("%d\n", maxVisiblePeople(arr, n));

    return 0;
}