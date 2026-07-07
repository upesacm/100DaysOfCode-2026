#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int findContentChildren(int g[], int gSize, int s[], int sSize) {
    qsort(g, gSize, sizeof(int), compare);
    qsort(s, sSize, sizeof(int), compare);

    int i = 0, j = 0;

    while (i < gSize && j < sSize) {
        if (s[j] >= g[i])
            i++;
        j++;
    }

    return i;
}

int main() {
    int n, m;

    printf("Enter number of children: ");
    scanf("%d", &n);

    int g[n];

    printf("Enter greed factors:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &g[i]);

    printf("Enter number of cookies: ");
    scanf("%d", &m);

    int s[m];

    printf("Enter cookie sizes:\n");
    for (int i = 0; i < m; i++)
        scanf("%d", &s[i]);

    int result = findContentChildren(g, n, s, m);

    printf("Maximum satisfied children: %d\n", result);

    return 0;
}