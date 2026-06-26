#include <stdio.h>

void unionArrays(int a[], int n, int b[], int m) {
    int i = 0, j = 0;
    int last = -1000000001; 

    while (i < n && j < m) {
        int val;

        if (a[i] < b[j])
            val = a[i++];
        else if (a[i] > b[j])
            val = b[j++];
        else {
            val = a[i];
            i++;
            j++;
        }

        if (val != last) {
            printf("%d ", val);
            last = val;
        }
    }

    while (i < n) {
        if (a[i] != last) {
            printf("%d ", a[i]);
            last = a[i];
        }
        i++;
    }

    while (j < m) {
        if (b[j] != last) {
            printf("%d ", b[j]);
            last = b[j];
        }
        j++;
    }
}

int main() {
    int a[] = {1, 2, 3, 4, 5};
    int b[] = {1, 2, 3, 6, 7};

    int n = sizeof(a) / sizeof(a[0]);
    int m = sizeof(b) / sizeof(b[0]);

    unionArrays(a, n, b, m);
    return 0;
}