#include <stdio.h>
#include <stdlib.h>

void dfs(int node, int n, int **adj, int *visited, int *size) {
    visited[node] = 1;
    (*size)++;

    for (int i = 1; i <= n; i++) {
        if (adj[node][i] && !visited[i]) {
            dfs(i, n, adj, visited, size);
        }
    }
}

void detectiveChase(int n, int m, int roads[][2]) {
    int **adj = malloc((n + 1) * sizeof(int *));

    for (int i = 0; i <= n; i++)
        adj[i] = calloc(n + 1, sizeof(int));

    for (int i = 0; i < m; i++) {
        int u = roads[i][0];
        int v = roads[i][1];

        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    int *visited = calloc(n + 1, sizeof(int));
    int clusters = 0;
    int largest = 0;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            int size = 0;
            clusters++;

            dfs(i, n, adj, visited, &size);

            if (size > largest)
                largest = size;
        }
    }

    printf("%d %d\n", clusters, largest);

    for (int i = 0; i <= n; i++)
        free(adj[i]);

    free(adj);
    free(visited);
}