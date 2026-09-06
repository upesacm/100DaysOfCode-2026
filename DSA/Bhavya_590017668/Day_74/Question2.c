#include <stdio.h>
#include <stdlib.h>

int crabGraph(int n, int T, int** edges, int edgesSize, int* edgesColSize) {
    int* degree = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        degree[edges[i][0]]++;
        degree[edges[i][1]]++;
    }

    int** adj = malloc(n * sizeof(int*));

    for (int i = 0; i < n; i++)
        adj[i] = malloc(degree[i] * sizeof(int));

    int* pos = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        adj[u][pos[u]++] = v;
        adj[v][pos[v]++] = u;
    }

    int* used = calloc(n, sizeof(int));
    int result = 0;

    for (int i = 0; i < n; i++) {
        if (used[i])
            continue;

        int feet = 0;

        for (int j = 0; j < degree[i] && feet < T; j++) {
            int v = adj[i][j];

            if (!used[v]) {
                used[v] = 1;
                feet++;
            }
        }

        if (feet > 0) {
            used[i] = 1;
            result += feet + 1;
        }
    }

    for (int i = 0; i < n; i++)
        free(adj[i]);

    free(adj);
    free(degree);
    free(pos);
    free(used);

    return result;
}