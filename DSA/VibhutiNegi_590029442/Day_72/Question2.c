#include <stdio.h>
#include <stdlib.h>
struct Edge {
    int u, v, w;
};
int compare(const void *a, const void *b) {
    struct Edge *e1 = (struct Edge *)a;
    struct Edge *e2 = (struct Edge *)b;
    if (e1->w != e2->w)
        return e1->w - e2->w;
    return (e1->u + e1->v + e1->w) -
           (e2->u + e2->v + e2->w);
}
int dfs(int graph[][3001], int visited[], int current, int target, int n) {
    if (current == target)
        return 1;
    visited[current] = 1;
    for (int i = 1; i <= n; i++) {
        if (graph[current][i] == 1 && !visited[i]) {
            if (dfs(graph, visited, i, target, n))
                return 1;
        }
    }
    return 0;
}
int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    struct Edge edges[m];
    for (int i = 0; i < m; i++) {
        scanf("%d %d %d",
              &edges[i].u,
              &edges[i].v,
              &edges[i].w);
    }
    qsort(edges, m, sizeof(struct Edge), compare);
    int graph[3001][3001] = {0};
    int total = 0;
    int count = 0;
    for (int i = 0; i < m; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        int w = edges[i].w;
        int visited[3001] = {0};
        if (!dfs(graph, visited, u, v, n)) {
            graph[u][v] = 1;
            graph[v][u] = 1;
            total += w;
            count++;
            printf("Added edge: %d - %d (weight %d)\n",
                   u, v, w);
            if (count == n - 1)
                break;
        }
    }
    printf("Total weight = %d\n", total);
    return 0;
}