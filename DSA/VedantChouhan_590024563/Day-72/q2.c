#include <stdio.h>
#include <stdlib.h>

struct Edge {
    int u;
    int v;
    int weight;
};

/* Compare edges by weight */
int compare(const void *a, const void *b) {
    struct Edge *e1 = (struct Edge *)a;
    struct Edge *e2 = (struct Edge *)b;

    return e1->weight - e2->weight;
}

/* Find the parent of a node */
int find(int parent[], int x) {
    if (parent[x] == x)
        return x;

    return parent[x] = find(parent, parent[x]);
}

/* Join two sets */
void unite(int parent[], int rank[], int a, int b) {
    int rootA = find(parent, a);
    int rootB = find(parent, b);

    if (rootA == rootB)
        return;

    if (rank[rootA] < rank[rootB]) {
        parent[rootA] = rootB;
    }
    else if (rank[rootA] > rank[rootB]) {
        parent[rootB] = rootA;
    }
    else {
        parent[rootB] = rootA;
        rank[rootA]++;
    }
}

int main() {
    int n, m;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &m);

    struct Edge edges[m];

    printf("Enter edges (u v weight):\n");

    for (int i = 0; i < m; i++) {
        scanf("%d %d %d",
              &edges[i].u,
              &edges[i].v,
              &edges[i].weight);
    }

    /* Sort edges by weight */
    qsort(edges, m, sizeof(struct Edge), compare);

    int parent[n + 1];
    int rank[n + 1];

    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        rank[i] = 0;
    }

    int totalWeight = 0;
    int edgesUsed = 0;

    /* Kruskal's Algorithm */
    for (int i = 0; i < m && edgesUsed < n - 1; i++) {

        int u = edges[i].u;
        int v = edges[i].v;

        if (find(parent, u) != find(parent, v)) {

            unite(parent, rank, u, v);

            totalWeight += edges[i].weight;
            edgesUsed++;
        }
    }

    printf("Minimum Spanning Tree Weight: %d\n", totalWeight);

    return 0;
}