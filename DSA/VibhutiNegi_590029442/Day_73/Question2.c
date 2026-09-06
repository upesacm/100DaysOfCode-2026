#include <stdio.h>
#include <stdlib.h>
int main() {
    int n, m, s;
    scanf("%d %d %d", &n, &m, &s);
    int **adj = malloc((n + 1) * sizeof(int *));
    for (int i = 1; i <= n; i++) {
        adj[i] = calloc(n + 1, sizeof(int));
    }
    for (int i = 0; i < m; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        adj[u][v] = 1;
        adj[v][u] = 1;
    }
    int *dist = malloc((n + 1) * sizeof(int));
    int *queue = malloc((n + 1) * sizeof(int));
    for (int i = 1; i <= n; i++) {
        dist[i] = -1;
    }
    int front = 0;
    int rear = 0;
    dist[s] = 0;
    queue[rear++] = s;
    while (front < rear) {
        int u = queue[front++];
        for (int v = 1; v <= n; v++) {
            if (u != v && adj[u][v] == 0 && dist[v] == -1) {
                dist[v] = dist[u] + 1;
                queue[rear++] = v;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        printf("%d ", dist[i]);
    }
    for (int i = 1; i <= n; i++) {
        free(adj[i]);
    }
    free(adj);
    free(dist);
    free(queue);
    return 0;
}