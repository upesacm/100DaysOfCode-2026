#include <stdio.h>

void reverse(int a[], int l, int r) {
    while(l < r) {
        int t = a[l];
        a[l++] = a[r];
        a[r--] = t;
    }
}

int main() {
    int n, k;
    scanf("%d", &n);

    int a[n];

    for(int i = 0; i < n; i++)
        scanf("%d", &a[i]);

    scanf("%d", &k);

    k %= n;

    reverse(a, 0, n - 1);
    reverse(a, 0, k - 1);
    reverse(a, k, n - 1);

    for(int i = 0; i < n; i++)
        printf("%d ", a[i]);

    return 0;
}