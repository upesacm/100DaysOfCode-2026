#include <stdio.h>

void unionArray(int *a, int n, int *b, int m) {
    int i = 0, j = 0;

    while (i < n && j < m) {
        if (a[i] < b[j])
            printf("%d ", a[i++]);
        else if (a[i] > b[j])
            printf("%d ", b[j++]);
        else {
            printf("%d ", a[i]);
            i++;
            j++;
        }
    }

    while (i < n) printf("%d ", a[i++]);
    while (j < m) printf("%d ", b[j++]);
}

int main() {
    int a[] = {1, 2};
    int b[] = {2, 3};

    unionArray(a, 2, b, 2);

    return 0;
}