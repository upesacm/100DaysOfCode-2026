#include <stdio.h>
#include <stdlib.h>

int main() {
    int C, N, T, M;
    scanf("%d", &C);

    while (C--) {
        scanf("%d %d %d", &N, &T, &M);

        int **adj = (int **)malloc(N * sizeof(int *));
        int *degree = (int *)calloc(N, sizeof(int));

        for (int i = 0; i < N; i++) {
            adj[i] = NULL;
        }

        for (int i = 0; i < M; i++) {
            int u, v;
            scanf("%d %d", &u, &v);
            u--;
            v--;

            degree[u]++;
            degree[v]++;

            adj[u] = realloc(adj[u], degree[u] * sizeof(int));
            adj[v] = realloc(adj[v], degree[v] * sizeof(int));

            adj[u][degree[u] - 1] = v;
            adj[v][degree[v] - 1] = u;
        }

        int *used = (int *)calloc(N, sizeof(int));
        int covered = 0;

        /*
         * Try every vertex as a head.
         * Choose up to T unused neighbours as feet.
         */
        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;

            int feet = 0;

            for (int j = 0; j < degree[i] && feet < T; j++) {
                int v = adj[i][j];

                if (!used[v]) {
                    used[v] = 1;
                    feet++;
                    covered++;
                }
            }

            if (feet > 0) {
                used[i] = 1;
                covered++;
            }
        }

        printf("%d\n", covered);

        for (int i = 0; i < N; i++)
            free(adj[i]);

        free(adj);
        free(degree);
        free(used);
    }

    return 0;
}
