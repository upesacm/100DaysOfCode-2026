#include <stdio.h>
int main() {
    int n;
    scanf("%d", &n);
    int cost1 = 0;
    int cost2 = 0;
    int a[100], b[100], c[100];
    for (int i = 0; i < n; i++) {
        scanf("%d %d %d", &a[i], &b[i], &c[i]);
    }
    int order[101];
    order[0] = 1;
    int current = 1;
    int previous = -1;
    for (int k = 1; k < n; k++) {
        int nextCity = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == current && b[i] != previous) {
                nextCity = b[i];
                break;
            }
            if (b[i] == current && a[i] != previous) {
                nextCity = a[i];
                break;
            }
        }
        order[k] = nextCity;
        previous = current;
        current = nextCity;
    }
    for (int i = 0; i < n; i++) {
        int u = order[i];
        int v = order[(i + 1) % n];
        for (int j = 0; j < n; j++) {
            if (a[j] == u && b[j] == v) {
                break;
            }
            if (a[j] == v && b[j] == u) {
                cost1 += c[j];
                break;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        int u = order[i];
        int v = order[(i - 1 + n) % n];
        for (int j = 0; j < n; j++) {
            if (a[j] == u && b[j] == v) {
                break;
            }
            if (a[j] == v && b[j] == u) {
                cost2 += c[j];
                break;
            }
        }
    }
    printf("%d\n", cost1 < cost2 ? cost1 : cost2);
    return 0;
}