#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int u, v, w;
} Edge;

int cmp(const void *a, const void *b) {
    // FIX 1: Kruskal's algorithm requires edges in ascending order of weight
    if (((Edge *)a)->w < ((Edge *)b)->w) return -1;
    if (((Edge *)a)->w > ((Edge *)b)->w) return 1;
    return 0;
}
int find(int parent[], int x) {
    while (parent[x] != x)
        x = parent[x];
    return x;
}

void unite(int parent[], int rank[], int x, int y) {
    int rx = find(parent, x);
    int ry = find(parent, y);

    if (rx == ry) return;

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

    // FIX 2: Initialize parent for all portals from 1 to n, Original loop stopped at n-1, leaving parent[n] uninitialized
    for (int i = 1; i<= n; i++)
        parent[i] = i;

    long long total = 0;
    int taken = 0;

    // FIX 3: Stop once n-1 edges have been selected, An MST of n vertices always contains exactly n-1 edges
    for (int i = 0; i < m && taken < n - 1; i++) {
        if (find(parent, edges[i].u) != find(parent, edges[i].v)) {
            unite(parent, rank, edges[i].u, edges[i].v);
            total += edges[i].w;
            taken++;
        }
    }

    // FIX 4: The graph is connected only when exactly n-1 edges are taken, Original condition "taken > n-1" could never be true for an MST
    if (taken == n - 1)
        printf("%lld\n", total);
    else
        printf("-1\n");

    free(edges);
    free(parent);
    free(rank);

    return 0;
}