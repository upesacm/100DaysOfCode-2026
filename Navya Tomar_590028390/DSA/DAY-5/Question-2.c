#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int cmp(const void *a, const void *b) {
    return *(int *)a - *(int *)b;
}

bool checkEqualArrays(int a[], int b[], int n) {
    qsort(a, n, sizeof(int), cmp);
    qsort(b, n, sizeof(int), cmp);

    for (int i = 0; i < n; i++)
        if (a[i] != b[i]) return false;

    return true;
}

int main() {
    int a[] = {1, 2, 3, 4};
    int b[] = {4, 3, 2, 1};

    printf("%s", checkEqualArrays(a, b, 4) ? "true" : "false");
    return 0;
}
