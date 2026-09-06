#include <stdio.h>
#include <limits.h>

#define MAXN 100005
#define MAXE 4

typedef struct {
    int to;
    int cost;
} Edge;

Edge graph[MAXN][MAXE];
int degree[MAXN];

int minCost(int n, int roads[][3], int m) {
    int i, j;

    // Initialize degree
    for (i = 1; i <= n; i++) {
        degree[i] = 0;
    }

    // Build graph
    for (i = 0; i < m; i++) {
        int u = roads[i][0];
        int v = roads[i][1];
        int cost = roads[i][2];

        // Original direction: cost = 0
        graph[u][degree[u]].to = v;
        graph[u][degree[u]].cost = 0;
        degree[u]++;

        // Reverse direction: cost = given cost
        graph[v][degree[v]].to = u;
        graph[v][degree[v]].cost = cost;
        degree[v]++;
    }

    int dist[MAXN];
    int visited[MAXN];

    // Initialize distances
    for (i = 1; i <= n; i++) {
        dist[i] = INT_MAX;
        visited[i] = 0;
    }

    dist[1] = 0;

    // Dijkstra's algorithm
    for (i = 1; i <= n; i++) {
        int u = -1;

        // Find unvisited node with minimum distance
        int k;
        for (k = 1; k <= n; k++) {
            if (!visited[k] &&
                dist[k] != INT_MAX &&
                (u == -1 || dist[k] < dist[u])) {
                u = k;
            }
        }

        if (u == -1) {
            break;
        }

        visited[u] = 1;

        // Relax edges
        for (j = 0; j < degree[u]; j++) {
            int v = graph[u][j].to;
            int w = graph[u][j].cost;

            if (dist[v] > dist[u] + w) {
                dist[v] = dist[u] + w;
            }
        }
    }

    return dist[n];
}

int main() {
    int n = 3;

    int roads[][3] = {
        {1, 3, 1},
        {1, 2, 1},
        {3, 2, 1}
    };

    int m = 3;

    printf("%d\n", minCost(n, roads, m));

    return 0;
}
