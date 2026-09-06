#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int u, v, w;
} Edge;

int cmp(const void *a, const void *b) {
    const Edge *e1 = (const Edge *)a;
    const Edge *e2 = (const Edge *)b;

    if (e1->w < e2->w) return 1;
    if (e1->w > e2->w) return -1;
    return 0;
}

int find(int parent[], int x) {
    if (parent[x] != x)
        parent[x] = find(parent, parent[x]);

    return parent[x];
}

void unite(int parent[], int rank[], int x, int y) {
    int rx = find(parent, x);
    int ry = find(parent, y);

    if (rx == ry)
        return;

    if (rank[rx] < rank[ry]) {
        parent[rx] = ry;
    }
    else if (rank[rx] > rank[ry]) {
        parent[ry] = rx;
    }
    else {
        parent[ry] = rx;
        rank[rx]++;
    }
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    Edge *edges = malloc(m * sizeof(Edge));

    for (int i = 0; i < m; i++) {
        scanf("%d %d %d",
              &edges[i].u,
              &edges[i].v,
              &edges[i].w);
    }

    // Sort edges in descending order
    qsort(edges, m, sizeof(Edge), cmp);

    int *parent = malloc((n + 1) * sizeof(int));
    int *rank = calloc(n + 1, sizeof(int));

    // IMPORTANT: <= n
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
    }

    long long total = 0;
    int taken = 0;

    for (int i = 0; i < m && taken < n - 1; i++) {

        int u = edges[i].u;
        int v = edges[i].v;

        if (find(parent, u) != find(parent, v)) {

            unite(parent, rank, u, v);

            total += edges[i].w;
            taken++;
        }
    }

    // A spanning tree must contain exactly n-1 edges
    if (taken == n - 1)
        printf("%lld\n", total);
    else
        printf("-1\n");

    free(edges);
    free(parent);
    free(rank);

    return 0;
}