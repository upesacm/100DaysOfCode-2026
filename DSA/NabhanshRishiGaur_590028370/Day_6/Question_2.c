#include <stdio.h>

void unionArrays(int a[], int n, int b[], int m) {
    int freq[100001] = {0};

    for (int i = 0; i < n; i++)
        freq[a[i]] = 1;

    for (int i = 0; i < m; i++)
        freq[b[i]] = 1;

    printf("[");

    int first = 1;
    for (int i = 0; i <= 100000; i++) {
        if (freq[i]) {
            if (!first)
                printf(",");
            printf("%d", i);
            first = 0;
        }
    }

    printf("]");
}

int main() {
    int a[] = {2,2,3,4,5};
    int b[] = {1,1,2,3,4};

    unionArrays(a, 5, b, 5);

    return 0;
}
