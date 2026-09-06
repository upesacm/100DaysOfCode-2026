#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int u;
    int v;
    int weight;
} Edge;

int parent[1000];

int compare(const void *a, const void *b)
{
    Edge *x = (Edge *)a;
    Edge *y = (Edge *)b;

    return x->weight - y->weight;
}

int find(int x)
{
    if (parent[x] != x)
        parent[x] = find(parent[x]);

    return parent[x];
}

int unite(int a, int b)
{
    int rootA = find(a);
    int rootB = find(b);

    if (rootA == rootB)
        return 0;

    parent[rootB] = rootA;
    return 1;
}

int kruskal(int n, int m, Edge edges[])
{
    for (int i = 1; i <= n; i++)
        parent[i] = i;

    qsort(edges, m, sizeof(Edge), compare);

    int totalWeight = 0;
    int edgesUsed = 0;

    for (int i = 0; i < m && edgesUsed < n - 1; i++)
    {
        if (unite(edges[i].u, edges[i].v))
        {
            totalWeight += edges[i].weight;
            edgesUsed++;
        }
    }

    return totalWeight;
}

int main()
{
    int n = 4;
    int m = 6;

    Edge edges[] = {
        {1, 2, 5},
        {1, 3, 3},
        {4, 1, 6},
        {2, 4, 7},
        {3, 2, 4},
        {3, 4, 5}
    };

    printf("%d\n", kruskal(n, m, edges));

    return 0;
}