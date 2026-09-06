#include <stdio.h>

#define MAX 1000

int graph[MAX][MAX];
int visited[MAX];
int N, M;

int dfs(int node) {
    visited[node] = 1;

    int size = 1;

    for (int i = 1; i <= N; i++) {
        if (graph[node][i] && !visited[i]) {
            size += dfs(i);
        }
    }

    return size;
}

int main() {
    scanf("%d %d", &N, &M);

    // Build the undirected graph
    for (int i = 0; i < M; i++) {
        int u, v;
        scanf("%d %d", &u, &v);

        graph[u][v] = 1;
        graph[v][u] = 1;
    }

    int clusters = 0;
    int largestCluster = 0;

    // Find every connected component
    for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
            int size = dfs(i);

            clusters++;

            if (size > largestCluster) {
                largestCluster = size;
            }
        }
    }

    printf("%d %d\n", clusters, largestCluster);

    return 0;
}