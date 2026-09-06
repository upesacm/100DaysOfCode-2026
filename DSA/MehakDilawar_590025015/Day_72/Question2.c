//Write an efficient function that uses Kruskal's Algorithm to build a minimum spanning tree from a weighted undirected graph
//and returns its total weight.
//Input: n = 4, m = 6, edges = [[1,2,5],[1,3,3],[4,1,6],[2,4,7],[3,2,4],[3,4,5]]. Output: 12.
#include <stdio.h>
#include <stdlib.h>
typedef struct {
    int u, v, weight;
} Edge;

int find(int parent[], int x) {
    if (parent[x] != x)
        parent[x] = find(parent, parent[x]);

    return parent[x];
}

int unionSets(int parent[], int rank[], int a, int b) {
    a = find(parent, a);
    b = find(parent, b);
    if (a == b)
        return 0;  
    if (rank[a] < rank[b]) {
        parent[a] = b;
    } else if (rank[a] > rank[b]) {
        parent[b] = a;
    } else {
        parent[b] = a;
        rank[a]++;
    }
    return 1;
}

int compareEdges(const void *a, const void *b) {
    Edge *e1 = (Edge *)a;
    Edge *e2 = (Edge *)b;
    return e1->weight - e2->weight;
}

int kruskal(int n, int m, Edge edges[]) {
    int parent[n + 1];
    int rank[n + 1];
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        rank[i] = 0;
    }
    qsort(edges, m, sizeof(Edge), compareEdges);
    int totalWeight = 0;
    int edgesUsed = 0;
    for (int i = 0; i < m && edgesUsed < n - 1; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        if (unionSets(parent, rank, u, v)) {
            totalWeight += edges[i].weight;
            edgesUsed++;
        }
    }
    if (edgesUsed != n - 1)
        return -1;
    return totalWeight;
}

int main() {
    int n, m;
    printf("Enter number of vertices: ");
    scanf("%d", &n);
    printf("Enter number of edges: ");
    scanf("%d", &m);
    Edge edges[m];
    printf("Enter edges (u v weight):\n");
    for (int i = 0; i < m; i++) {
        scanf("%d %d %d",
              &edges[i].u,
              &edges[i].v,
              &edges[i].weight);
    }
    int result = kruskal(n, m, edges);
    if (result == -1)
        printf("Minimum Spanning Tree does not exist.\n");
    else
        printf("Total weight of MST = %d\n", result);
return 0;
}