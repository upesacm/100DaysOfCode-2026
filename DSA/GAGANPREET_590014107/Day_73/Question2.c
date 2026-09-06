#include <stdio.h>
#include <stdlib.h>

int main() {
    int N, M, S;

    scanf("%d %d", &N, &M);

    int adj[N + 1][N + 1];

    for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
            adj[i][j] = 0;

    for (int i = 0; i < M; i++) {
        int u, v;
        scanf("%d %d", &u, &v);

        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    scanf("%d", &S);

    int dist[N + 1];

    for (int i = 1; i <= N; i++)
        dist[i] = -1;

    int queue[N + 1];
    int front = 0, rear = 0;

    queue[rear++] = S;
    dist[S] = 0;

    while (front < rear) {
        int current = queue[front++];

        for (int i = 1; i <= N; i++) {
            if (adj[current][i] && dist[i] == -1) {
                dist[i] = dist[current] + 1;
                queue[rear++] = i;
            }
        }
    }

    for (int i = 1; i <= N; i++) {
        printf("Village %d: %d\n", i, dist[i]);
    }

    return 0;
}
