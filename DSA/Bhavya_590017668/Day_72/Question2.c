
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int u, v, w;
} Edge;

int parent[3005];

int find(int x) {
    if (parent[x] != x)
        parent[x] = find(parent[x]);
    return parent[x];
}

void unite(int a, int b) {
    parent[find(a)] = find(b);
}

int cmp(const void *a, const void *b) {
    return ((Edge *)a)->w - ((Edge *)b)->w;
}

int kruskals(int g_nodes, int g_edges, Edge edges[]) {
    qsort(edges, g_edges, sizeof(Edge), cmp);

    for (int i = 1; i <= g_nodes; i++)
        parent[i] = i;

    int total = 0;

    for (int i = 0; i < g_edges; i++) {
        if (find(edges[i].u) != find(edges[i].v)) {
            unite(edges[i].u, edges[i].v);
            total += edges[i].w;
        }
    }

    return total;
}

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    Edge edges[m];

    for (int i = 0; i < m; i++)
        scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].w);

    printf("%d\n", kruskals(n, m, edges));
    return 0;
}