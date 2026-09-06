#include <stdio.h>
#include <stdlib.h>
int main() {
    int n, m, k;
    printf("Enter number of vertices (n): ");
    scanf("%d", &n);
    printf("Enter number of edges: ");
    scanf("%d", &m);
    int degree[200005] = {0};
    int u, v;
    printf("Enter %d edges (u v):\n", m);
    for (int i = 0; i < m; i++) {
        scanf("%d %d", &u, &v);
        degree[u]++;
        degree[v]++;
    }
    printf("Enter k: ");
    scanf("%d", &k);
    int oddCount = 0;
    for (int i = 1; i <= n; i++) {
        if (degree[i] % 2 != 0) {
            oddCount++;
        }
    }
    if (oddCount == 0) {
        printf("true\n");
    } else {
        printf("false\n");
    }
    return 0;
}