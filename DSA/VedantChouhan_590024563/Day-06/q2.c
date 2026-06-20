#include <stdio.h>

int main() {
    int a[] = {1, 2, 2, 3, 4};
    int b[] = {2, 3, 5, 5, 6};

    int n = sizeof(a) / sizeof(a[0]);
    int m = sizeof(b) / sizeof(b[0]);

    int i = 0, j = 0;

    printf("Union: ");

    while (i < n && j < m) {

        if (i > 0 && a[i] == a[i - 1]) {
            i++;
            continue;
        }

        if (j > 0 && b[j] == b[j - 1]) {
            j++;
            continue;
        }

        if (a[i] < b[j]) {
            printf("%d ", a[i]);
            i++;
        }
        else if (a[i] > b[j]) {
            printf("%d ", b[j]);
            j++;
        }
        else {
            printf("%d ", a[i]);
            i++;
            j++;
        }
    }

    while (i < n) {
        if (i == 0 || a[i] != a[i - 1])
            printf("%d ", a[i]);
        i++;
    }

    while (j < m) {
        if (j == 0 || b[j] != b[j - 1])
            printf("%d ", b[j]);
        j++;
    }

    printf("\n");

    return 0;
}