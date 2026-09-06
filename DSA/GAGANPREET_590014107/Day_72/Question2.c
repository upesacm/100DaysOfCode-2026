#include <stdlib.h>

int parent[100005];

int find(int x) {
    if (parent[x] != x)
        parent[x] = find(parent[x]);

    return parent[x];
}

void unionSet(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b)
        parent[b] = a;
}

int compare(const void* a, const void* b) {
    int* e1 = *(int**)a;
    int* e2 = *(int**)b;

    return e1[2] - e2[2];
}

int minimumCost(int n, int** edges, int m) {

    // Initialize DSU
    for (int i = 1; i <= n; i++)
        parent[i] = i;

    // Sort edges by weight
    qsort(edges, m, sizeof(int*), compare);

    int totalWeight = 0;
    int edgesUsed = 0;

    for (int i = 0; i < m; i++) {

        int u = edges[i][0];
        int v = edges[i][1];
        int weight = edges[i][2];

        // If they belong to different components
        if (find(u) != find(v)) {

            unionSet(u, v);

            totalWeight += weight;
            edgesUsed++;

            // MST needs exactly n-1 edges
            if (edgesUsed == n - 1)
                break;
        }
    }

    return totalWeight;
}
