#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int u, v, w;
} Edge;

int cmp(const void *a, const void *b) {
    return ((Edge *)a)->w - ((Edge *)b)->w;
}

int find(int parent[], int x) {
    while (parent[x] != x)
        x = parent[x];
    return x;
}

void unite(int parent[], int rank[], int x, int y) {
    int rx = find(parent, x);
    int ry = find(parent, y);

    if (rx == ry)
        return;

    if (rank[rx] < rank[ry])
        parent[rx] = ry;
    else if (rank[rx] > rank[ry])
        parent[ry] = rx;
    else {
        parent[ry] = rx;
        rank[rx]++;
    }
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    Edge *edges = malloc(m * sizeof(Edge));

    for (int i = 0; i < m; i++)
        scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].w);

    qsort(edges, m, sizeof(Edge), cmp);

    int *parent = malloc((n + 1) * sizeof(int));
    int *rank = calloc(n + 1, sizeof(int));

    for (int i = 1; i <= n; i++)
        parent[i] = i;

    long long total = 0;
    int taken = 0;

    for (int i = 0; i < m; i++) {
        if (find(parent, edges[i].u) != find(parent, edges[i].v)) {
            unite(parent, rank, edges[i].u, edges[i].v);
            total += edges[i].w;
            taken++;

            if (taken == n - 1)
                break;
        }
    }

    if (taken == n - 1)
        printf("%lld\n", total);
    else
        printf("-1\n");

    free(edges);
    free(parent);
    free(rank);

    return 0;
}